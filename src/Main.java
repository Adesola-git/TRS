import Airlines.*;
import AirportPack.*;
//import Modify.Flight;
import Modify.FlightBuilder;
import Flight.*;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    //Add Airport
    static String id;
    static String name;
    static String country;
    static Integer timeZone;

    //Add Flight
    static String flightNo;
    static String Airline;
    static String originAirport;
    static String destAirport;
    static String status;
    static String dateString;
    static LocalDate date;
    static String depTimeString;

    static Integer depatureTime;
    static String arrTimeString;

    static Integer arrivalTime;
    static Integer duration;
    //static Integer noOfSeat;
    static Integer noOfSeatE;
    static Integer noOfSeatF;
    static Integer noOfSeatB;
    static Integer noOfSeatPE;

    static String termAns;

    static Integer option;
    static Integer ModOption;
    static Integer dow;
    static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {
        Flight flight;
        FlightData flightData;

        //Populate flight details
        FlightCollection newFile = FlightCollection.getInstance();
        //Populate Airline details
        AirlineCollection newAirlineColln = AirlineCollection.getInstance();
        AirportDataColln newAirportColln = AirportDataColln.getInstance();
        //Get list of available airline
        AirlineIterator airlns = newAirlineColln.createIterator();
        //get list of available airports
        AirportIterator arprtite = newAirportColln.createIterator();
        //newAirlineColln.displayValue();
        //DB Insert instance to update record in the db
        DbInsert newDb = new DbInsert();

        //Main Page
        option=0;
        while(option !=5) {
            DisplayMainPage();
            Main:
            switch (option) {
                case 1:
                    System.out.println("Enter The Airport ID: ");
                    id = scan.next();
                    System.out.println("Enter Airport Code: ");
                    name = scan.next();
                    System.out.println("Enter Country of Airport: ");
                    country = scan.next();
                    System.out.println("Enter Timezone of Airport: ");
                    timeZone = scan.nextInt();

                    Airport airportA = new Airport(id, name, country, timeZone);
                    airportA.dbInsert();

                    System.out.println("Would You Like To Add A Terminal? Y/N");
                    termAns = scan.next();


                    if (termAns.toUpperCase().equals("Y")) {
                        System.out.println("How Many? : ");
                        int termNo = scan.nextInt();
                        while (termNo > 0) {
                            System.out.println("Enter Terminal ID: ");
                            String termID = scan.next();
                            Terminal terminal = new Terminal(termID);

                            airportA.add(terminal);

                            termNo = termNo - 1;

                            System.out.println("Terminal Added Successfully");
                            System.out.println("Airport Added Successfully");


                        }
                    } else {
                        System.out.println("Airport Added Successfully");
                    }

                    break;

                case 2:
                    System.out.println("Flight Details");
                    System.out.println();
                    System.out.println("Enter Airline Code: ");
                    airlns = newAirlineColln.createIterator();
                    while(airlns.hasNext()){
                        Airline p = airlns.next();
                        System.out.println(p.getAirlineId()+" "+p.getAirlineName());
                    }
                    Airline = scan.next();
                    System.out.println("Enter Flight Number: ");
                    flightNo = scan.next();
                    //Add Airline code to entered flight number
                    flightNo = Airline + flightNo;
                    System.out.println("Enter The Day of the week: ");
                    System.out.println("1 Sunday");
                    System.out.println("2 Monday");
                    System.out.println("3 Tuesday");
                    System.out.println("4 Wednesday");
                    System.out.println("5 Thursday");
                    System.out.println("6 Friday");
                    System.out.println("7 Saturday\n");
                    dow = scan.nextInt();
                    //Validate flight detail entry
                    //FlightDetValidation valFlight = new FlightDetValidation();
                    //while(valFlight.valFlightdetails(flightNo,dow)){
                    while (newFile.verify(flightNo, dow)) {
                        System.out.println("Flight details exist already for the day provided");
                        System.out.println("Enter The Day of the week: ");
                        System.out.println("1 Sunday");
                        System.out.println("2 Monday");
                        System.out.println("3 Tuesday");
                        System.out.println("4 Wednesday");
                        System.out.println("5 Thursday");
                        System.out.println("6 Friday");
                        System.out.println("7 Saturday\n");
                        dow = scan.nextInt();
                    }
                    //if validate is true
                    //                scan.nextLine();
                    //List available airports
                    System.out.println("Enter Origin Airport Code: ");
                    arprtite = newAirportColln.createIterator();
                    while(arprtite.hasNext()){
                        Airport p = arprtite.next();
                        System.out.println(p.getId ()+" "+p.getName());
                    }
                    originAirport = scan.next();
                    //List available airports
                    System.out.println("Enter Destination Airport Code: ");
                    arprtite = newAirportColln.createIterator();
                    while(arprtite.hasNext()){
                        Airport p = arprtite.next();
                        System.out.println(p.getId ()+" "+p.getName());
                    }
                    destAirport = scan.next();
                    System.out.println("Enter Departure Time In format h:mm ");
                    depatureTime = scan.nextInt();
                    System.out.println("Enter Arrival Time In format h:mm ");
                    arrivalTime = scan.nextInt();
                    //arrivalTime = LocalTime.parse(arrTimeString, timeformatter);
                    System.out.println("Enter Flight duration ");
                    duration = scan.nextInt();
                    System.out.println("Enter Number Of Seats Available: First Business Premium-Economy Economy ");
                    noOfSeatF = scan.nextInt();
                    noOfSeatB = scan.nextInt();
                    noOfSeatPE = scan.nextInt();
                    noOfSeatE = scan.nextInt();
                    //System.out.println("Enter Ticket Price: ");
                    //price = scan.nextBigDecimal();

                    flight = new Flight(flightNo, originAirport, destAirport,
                            depatureTime, arrivalTime, duration, dow, noOfSeatE, noOfSeatPE, noOfSeatB, noOfSeatF);
                    //newFile.refresh();
                    //if(newDb.AddFlight(flight)){
                    newDb.AddFlight(flight);
                    System.out.println("===========================");
                    System.out.println("Flight created successfully");
                    System.out.println("===========================");

                    break;

                case (4):
                    Modify:
                    System.out.println("Modify Flight Details");
                    System.out.println("======================");
                    System.out.println("Select Airline: ");
                    //Get list of available airline
                    airlns = newAirlineColln.createIterator();
                    while(airlns.hasNext()){
                        Airline p = (Airline) airlns.next();
                        System.out.println(p.getAirlineId()+" "+p.getAirlineName());
                    }
                    Airline = scan.next();
                    System.out.println("Enter Flight Number: ");
                    flightNo = scan.next();
                    System.out.println("Enter The Day of the week: ");
                    System.out.println("1 Sunday");
                    System.out.println("2 Monday");
                    System.out.println("3 Tuesday");
                    System.out.println("4 Wednesday");
                    System.out.println("5 Thursday");
                    System.out.println("6 Friday");
                    System.out.println("7 Saturday\n");
                    dow = scan.nextInt();
                    //Validate flight detail entry
                    //FlightDetValidation valFlight = new FlightDetValidation();
                    //while(valFlight.valFlightdetails(flightNo,dow)){
                    while (!newFile.verify(flightNo, dow) && dow !=8) {
                        System.out.println("Flight details does not exist for the day provided");
                        System.out.println("Enter The Day of the week you will like to modify: ");
                        System.out.println("1 Sunday");
                        System.out.println("2 Monday");
                        System.out.println("3 Tuesday");
                        System.out.println("4 Wednesday");
                        System.out.println("5 Thursday");
                        System.out.println("6 Friday");
                        System.out.println("7 Saturday");
                        System.out.println("8 Exit\n");
                        dow = scan.nextInt();

                    }
                    //Exit Modify Case, Go to main display
                    if(dow == 8){
                        break;
                    }
                    //flight = (dow);
                    flight = newFile.getObject(flightNo, dow);
                    //Flight modFlight = flight.clone(dow);
                    ModOption = 0;
                    while (ModOption != 11) {
                        System.out.println("What detail will you like to modify ");
                        System.out.println("1   Originating Airport: " + flight.getOriginAirport());
                        System.out.println("2   Destination Airport: " + flight.getDestAirport());
                        System.out.println("3   Departure Time: " + flight.getDepatureTime());
                        System.out.println("4   Arrival Time: " + flight.getArrivalTime());
                        System.out.println("5   Duration: " + flight.getDuration());
                        System.out.println("6   No of Available seat (Economy) " + flight.getNoOfSeatE());
                        System.out.println("7   No of Available seat (Premium Economy) " + flight.getNoOfSeatPE());
                        System.out.println("8   No of Available seat (Business) " + flight.getNoOfSeatB());
                        System.out.println("9   No of Available seat (First) " + flight.getNoOfSeatF());
                        System.out.println("10  Save Modification ");
                        System.out.println("11  Exit Modification, i'm done \n");
                        ModOption = scan.nextInt();
                        Modification:
                        switch (ModOption) {
                            case (1):
                                System.out.println("Enter Origin Airport Code: ");
                                //originAirport = scan.next();
                                arprtite = newAirportColln.createIterator();
                                while(arprtite.hasNext()){
                                    Airport p = (Airport) arprtite.next();
                                    System.out.println(p.getId ()+" "+p.getName());
                                }
                                flight.setOriginAirport(scan.next());
                                break;
                            case (2):
                                System.out.println("Enter Destination Airport Code: ");
                                //destAirport = scan.next();
                                arprtite = newAirportColln.createIterator();
                                while(arprtite.hasNext()){
                                    Airport p = (Airport) arprtite.next();
                                    System.out.println(p.getId ()+" "+p.getName());
                                }
                                flight.setDestAirport(scan.next());
                                break;
                            case (3):
                                System.out.println("Enter Departure Time In format h:mm: ");
                                //depatureTime = scan.nextInt();
                                flight.setDepatureTime(scan.nextInt());
                                break;
                            case (4):
                                System.out.println("Enter Arrival Time In format h:mm: ");
                                //arrivalTime = scan.nextInt();
                                flight.setArrivalTime(scan.nextInt());
                                break;
                            case (5):
                                System.out.println("Enter Flight duration: ");
                                //duration = scan.nextInt();
                                flight.setDuration(scan.nextInt());
                                break;
                            case (6):
                                System.out.println("No of Available seat (Economy): ");
                                // noOfSeatE = scan.nextInt();
                                flight.setNoOfSeatE(scan.nextInt());
                                break;
                            case (7):
                                System.out.println("No of Available seat (Premium Economy): ");
                                //noOfSeatPE = scan.nextInt();
                                flight.setNoOfSeatPE(scan.nextInt());
                                break;
                            case (8):
                                System.out.println("No of Available seat (Business): ");
                                //noOfSeatB = scan.nextInt();
                                flight.setNoOfSeatB(scan.nextInt());
                                break;
                            case (9):
                                System.out.println("No of Available seat (First): ");
                                //noOfSeatF = scan.nextInt();
                                flight.setNoOfSeatF(scan.nextInt());
                                break;
                            case (10):
                                //Remove existing record from db
                                newDb.RemoveFlight(flightNo, dow);
                                //Create new flight detail
                                /*flight = new Flight(flightNo,originAirport,destAirport,
                                        depatureTime,arrivalTime,duration,dow,noOfSeatE,noOfSeatPE,noOfSeatB,noOfSeatF);*/
                                //Insert to db
                                newDb.AddFlight(flight);
                                //if(newDb.AddFlight(flight)){
                                    System.out.println("===========================");
                                    System.out.println("Flight Modified successfully");
                                    System.out.println("===========================");
                                //}
                                break;
                            case (11):
                                break;
                            default:
                                System.out.println("Enter a valid value");
                        }
                    }
                    //DisplayMainPage();
                    break;

                default:
                    System.out.println("error");

            }

        }
    }

    public static void DisplayMainPage() {
        //Main Page
        System.out.println("Welcome To Flight Reservation Admin Page");
        System.out.println("---------------------------------");
        System.out.println("Enter Option Number");
        System.out.println("1. Add Airport Details ");
        System.out.println("2. Add Flight Details");
        System.out.println("3. Modify Airport Details");
        System.out.println("4. Modify Flight Details");
        System.out.println("5. Exit Admin Page\n");
        option = scan.nextInt();


    }

    public static Integer nextInt(Scanner scan, String error) {
        // loop forever
        for (; ; ) {
            try {
                int v = scan.nextInt();
                return v;
            } catch (InputMismatchException ie) {
                scan.nextLine(); // clear input buffer
                System.out.print(error);

            }

        }

    }

    public static BigDecimal nextBigDecimal(Scanner scan, String error) {
        // loop forever
        for (; ; ) {
            try {
                BigDecimal v = scan.nextBigDecimal();
                return v;
            } catch (InputMismatchException ie) {
                scan.nextLine(); // clear input buffer
                System.out.print(error);

            }

        }

    }
}