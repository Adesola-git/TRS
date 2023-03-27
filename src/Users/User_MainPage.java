package Users;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Scanner;
import java.sql.*;

public class User_MainPage {
    private String userid;
    private Scanner in = new Scanner(System.in);

    User_MainPage(String userid) {
        this.userid = userid;
        this.show_page();
    }

    void show_page() {
        Day_calculation.d();
        System.out.println("select from the following options");
        System.out.println("1-search flight");
        System.out.println("2-flight history");
        System.out.println("3-logout");

        System.out.print("Enter input:-");
        int selection = in.nextInt();
        switch (selection) {
            case 1:
                int timezones[];
                HashMap<String,Integer> Airports = new HashMap<String,Integer>();
                try {
                    ResultSet r1;
                    Statement s1 = DB_Statement_Singleton.get_DB_Statement();
                    String query = "SELECT * FROM airports";
                    r1 = s1.executeQuery (query);
                    while ( r1.next() ) {
                        Airports.put(r1.getString ("Airport_ID"), r1.getInt ("Time_Zone"));
                    }
                    in = new Scanner(System.in);

                    String origin = null; //Airport Entry
                    do {
                        System.out.print("Enter Origin Airport Code:-");
                        origin = in.nextLine().trim().toUpperCase();
                    } while (!Airports.containsKey(origin));

                    String destination = null;
                    do {
                        System.out.print("Enter Destination Airport Code:-");
                        destination = in.nextLine().trim().toUpperCase();
                        if(Airports.containsKey(destination) && !origin.equals(destination))
                        {
                            query = "SELECT COUNT(*) FROM flights where Origin_Airport='"+origin+"' AND Destination_Airport='"+destination+"'";
                            r1 = s1.executeQuery (query);
                            r1.next();
                            if (r1.getInt(1)>0)
                            {
                                System.out.println("Flights are available between these Airports");
                                break;
                            }else
                            {
                                System.out.println("Currently No Flights are available between these Airports");
                            }
                        }
                    } while (true);

                    GregorianCalendar date; //Date Entry
                    String date_selection = null;
                    int dd, mm, yy, day;
                    do {
                        System.out.print("Enter DATE in DDMMYY:-");
                        date_selection = in.nextLine().trim();
                        if (date_selection.length() != 6) {
                            continue;
                        }
                        try {
                            Integer.valueOf(date_selection);
                        }catch (NumberFormatException e){
                            continue;
                        }
                        dd = Integer.valueOf(date_selection.substring(0, 2));
                        mm = Integer.valueOf(date_selection.substring(2, 4)) - 1;
                        yy = Integer.valueOf(date_selection.substring(4, 6));
                        date = new GregorianCalendar(yy + 2000, mm, dd);

                        //Ask for Class of Travel and search flights accordingly
                        String Class_of_travel="Economy_Seats";
//                        String Class_of_travel="Premium_Economy_Seats";
//                        String Class_of_travel="Business_Seats";
//                        String Class_of_travel="FirstClass_Seats";

                        query = "SELECT * FROM flights where Origin_Airport='"+origin+"' AND Destination_Airport='"+destination+"'AND Day='"+date.get(Calendar.DAY_OF_WEEK)+"' AND "+Class_of_travel+" IS NOT NULL";
                        r1 = s1.executeQuery (query);
                        if(r1.next())
                        {
                            System.out.println("select from the following options");
                            int temp=1;
                            int Price=500;
                            do
                            {
                                System.out.println(temp+++"-"+r1.getString("Flight_Number")+"  "+r1.getInt("Departure_Time")+"  "+r1.getInt("Arrival_Time")+" "+Price);
                            }while(r1.next());
                            Seat_Class seat_object;
                            do {
                                System.out.print("Enter Number Associated with the selected flight:-");
                                int flight_selection = in.nextInt();
                                if (flight_selection < temp)
                                {
                                    r1.absolute(flight_selection);
                                    System.out.println();
                                    seat_object=new Economy(userid, r1.getString("Flight_Number"),date);
                                    break;
                                }
                            }while(true);
                            System.out.println(seat_object.getflight_number());
                            break;
                        }
                        else{
                            System.out.println("No Flights are available on the entered date");
                        }
                    } while (true);
                }catch (Exception e){
                    System.out.println(e);
                }

//                String date = null;
//                do {
//                    System.out.println("Enter DATE:-");
//                    date = in.nextLine().trim();
//                    if (date.length()!=6)
//                    {
//                        continue;
//                    }
//
//                    for (int i = 0; i < Airports.length; i++) {
//                        if (Airports[i].equals(destination) && i != origin_index) {
//                            destination_index = i;
//                            break;
//                        }
//                    }
//                } while (destination_index==-1);


//                ask for date in ddmmyy format
//                Search_for_flight();
                break;
            case 2:
                System.out.print("Option not Available");
                break;
            case 3:
                System.out.print("Logged out");
                Login.login();
                break;
            default:
                break;
        }
    }
}
//         Search_for_flight(){
//    if(origin airport is not in airports OR destination airport not in airports) airports is the table in database
//    {
//        warning
//      --|chain of responsibility|-- can be implemented for this purpose as it will allow addition of other conditions in future without modifying the code
//    }
//    else()
//    {
//     Final_fare_with_special_fares_and_discounts list of flights[]=search_flight(origin,destination,date,class); here class is first,business,etc.
//          if the flights do not exist than show a warning
//          --|Iterator pattern|-- User can be asked for a way of listing the flights. for example the list flights in ascending order based on duration. the requested listing can be implemented using iterator pattern
//        list all the flights and ask the user to select one
//      1.    AI000 DEL to DOH first Class Duration-3hr 30 minutes ticket price 300
//      2.    AI000 DEL to DOH first Class Duration-8hr 30 minutes ticket price 290 one stop in DEX
             //getinput from user
//            selected_flight= list of flights[number selected by user]
//            ask for additional services one by one
//                do you want additional baggage?Y or N; if(Yes) {selected_flight.services_obejct.add_service(new baggage(1 piece))}
//            ask if user is a student,Senior Citizen if(student) {selected_flight= new student(selected_flight)
//            ask if user is has a promocode if(valid_promocode) {selected_flight= new valid_promocode(selected_flight)
//              please pay Y or N selcted_flight.book(user_id)
//    }
        //Final_fare_with_special_fares_and_discounts[]  Search_flight(){}

//    }
//}
//                int origin_index = -1, destination_index = -1;
//
//                String origin = null;
//                do {
//                    System.out.print("Enter Origin Airport Code:-");
//                    origin = in.nextLine().trim().toUpperCase();
//                    for (int i = 0; i < Airports.length; i++) {
//                        if (Airports[i].equals(origin)) {
//                            origin_index = i;
//                            break;
//                        }
//                    }
//                } while (origin_index==-1);
//
//                String destination = null;
//                do {
//                    System.out.print("Enter Destination Airport Code:-");
//                    destination = in.nextLine().trim().toUpperCase();
//                    for (int i = 0; i < Airports.length; i++) {
//                        if (Airports[i].equals(destination) && i != origin_index) {
//                            destination_index = i;
//                            break;
//                        }
//                    }
//                } while (destination_index==-1);
