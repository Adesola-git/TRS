package Flight;

import java.util.GregorianCalendar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class FlightDataCollection  {
    private FlightData flightdata;
    private static FlightDataCollection singleton_flightdatacollection=null;
    private Map<String, FlightData> flightData_storage = new HashMap<>();
    private FlightDataCollection(){    }// in singleton we restrict anyone from calling the constructor
    private static Statement statement=null;
    private static Connection connection;

    public void add(String id,FlightData c) {
        flightData_storage.put(id,c);
        //DbInsert newDb = new DbInsert();
        //newDb.Flight(c);
    }


    public FlightDataIterator createIterator() {
        return new FlightDataCollectionIterator(flightData_storage);
    }
    private void FlightDataCollection(){}
    public static FlightDataCollection getInstance()
    {
        if(singleton_flightdatacollection==null)
        {
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/reservations";
                connection = DriverManager.getConnection(url, "root", "");
                statement = connection.createStatement();
            } catch (Exception e) {
                System.out.println(e);
            }
            singleton_flightdatacollection = new FlightDataCollection();
            return singleton_flightdatacollection;
        }
        else
        {
            return singleton_flightdatacollection;
        }
    }
    void populate(String date,String Origin, String Destination)
    {
        if (flightData_storage.isEmpty())
        {

        }
    }
        public void results (ArrayList flights, String date, int class_of_travel)
    {
        Iterator iterate_flights=flights.iterator();
        if (!flightData_storage.containsKey(flights.get(0)+"_"+date))
        {
// calculate the count from bookings table and populate seat count variable of FlightData object
            GregorianCalendar date_object;
            int dd, mm, yy, day;
            dd = Integer.valueOf(date.substring(0, 2));
            mm = Integer.valueOf(date.substring(2, 4)) - 1;
            yy = Integer.valueOf(date.substring(4, 6));
            date_object = new GregorianCalendar(yy + 2000, mm, dd);

            FlightCollection flightcollection=FlightCollection.getInstance();
            Flight flight;
            FlightData flightdata;
            String flightno;
            int availSeatsEconomy, availSeatsBusiness, availSeatsFirst, availSeatsPremiumEconomy;
            ResultSet r1;
            try{
                while(iterate_flights.hasNext())
                {
                    flight=flightcollection.getObject((String) iterate_flights.next(),date_object.get(Calendar.DAY_OF_WEEK));
                    flightno=flight.getFlightNo();
                    //First Class is 1
                    //Business is 2
                    //Premium economy is 3
                    //Economy is 4
                    availSeatsFirst=flight.getNoOfSeatF();
                    availSeatsBusiness=flight.getNoOfSeatB();
                    availSeatsPremiumEconomy=flight.getNoOfSeatPE();
                    availSeatsEconomy= flight.getNoOfSeatE();
                    r1 = statement.executeQuery("select COUNT(Ticket_Number) from bookings where Flight_Number='" + flightno + "' AND Flight_Departure_Date='" + date + "' AND Status='BOOKED' AND Booking_Class=1");
                    if (r1.next()) { availSeatsFirst-=r1.getInt(1); }
                    r1 = statement.executeQuery("select COUNT(Ticket_Number) from bookings where Flight_Number='" + flightno + "' AND Flight_Departure_Date='" + date + "' AND Status='BOOKED' AND Booking_Class=2");
                    if (r1.next()) { availSeatsBusiness-=r1.getInt(1); }
                    r1 = statement.executeQuery("select COUNT(Ticket_Number) from bookings where Flight_Number='" + flightno + "' AND Flight_Departure_Date='" + date + "' AND Status='BOOKED' AND Booking_Class=3");
                    if (r1.next()) { availSeatsPremiumEconomy-=r1.getInt(1); }
                    r1 = statement.executeQuery("select COUNT(Ticket_Number) from bookings where Flight_Number='" + flightno + "' AND Flight_Departure_Date='" + date + "' AND Status='BOOKED' AND Booking_Class=4");
                    if (r1.next()) { availSeatsEconomy-=r1.getInt(1); }
                    r1.close();
                    flightdata=new FlightData(flight,availSeatsFirst,availSeatsBusiness,availSeatsPremiumEconomy,availSeatsEconomy);
                    flightData_storage.put(flightno+"_"+date,flightdata);
                }
           } catch (Exception e) {
               System.out.println(e);
           }
        }

        flightData_storage.get(flights.get(0)+"_"+date);

    }

    void refresh(String flightid)
    {

        //remove the existing instance of the flightid from flightSeatData create a new one from database and include add it in the database
    }
}
class SearchFlightCollection
{
    private static SearchFlightCollection singleton_searchflightcollection=null;
    private Map<String, ArrayList<String>> searchflight_storage = new HashMap<>();
    private static Statement statement=null;
    private static Connection connection;
//ORGDESd
    private SearchFlightCollection(){}
    public static SearchFlightCollection getInstance()
    {
        if(singleton_searchflightcollection==null)
        {
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/reservations";
                connection = DriverManager.getConnection(url, "root", "");
                statement = connection.createStatement();
            } catch (Exception e) {
                System.out.println(e);
            }
            singleton_searchflightcollection = new SearchFlightCollection();
            return singleton_searchflightcollection;
        }
        else
        {
            return singleton_searchflightcollection;
        }
    }
    public ArrayList Searchflight(String origin, String destination,int day_of_week)
    {
        if (!searchflight_storage.containsKey(origin+destination+day_of_week))
        {
            try
            {
                ArrayList<String> flightlist=new ArrayList<String>();
                searchflight_storage.put(origin+destination+day_of_week,flightlist);
                ResultSet r1= statement.executeQuery("select Flight_Number from flights where Origin_Airport='"+origin+"' AND Destination_Airport='"+destination+"' AND Day='"+day_of_week+"'");
                while(r1.next())
                {
                    flightlist.add(r1.getString("Flight_Number"));
                }
                r1.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return searchflight_storage.get(origin+destination+day_of_week);
    }
    void refresh(String flightid)
    {

        //remove the existing instance of the flightid from flightSeatData create a new one from database and include add it in the database
    }

}