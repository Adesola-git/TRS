package Airlines;

import AirportPack.Airport;
import AirportPack.AirportDataCollnIterator;
import Flight.Flight;
import Flight.FlightCollection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
public class AirlineCollection {

    private static AirlineCollection singleton_Airlinecollection=null;
    private List<Airline> Airline_storage = new ArrayList<>();

    private AirlineCollection(){
        //this.Airline_storage = new HashMap<>();
    }
    private static Statement statement=null;
    private static Connection connection;


    public static AirlineCollection getInstance()
    {
        if(singleton_Airlinecollection==null)
        {
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/reservations";
                connection = DriverManager.getConnection(url, "root", "");
                statement = connection.createStatement();
                singleton_Airlinecollection = new AirlineCollection();
                singleton_Airlinecollection.populate();
                return singleton_Airlinecollection;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else
        {
            return singleton_Airlinecollection;
        }
        return null;
    }
    private void populate()
    {
        if (Airline_storage.isEmpty())
        {
            try {
                ResultSet r1= statement.executeQuery("select * from Airlines");
                while(r1.next())
                {
                    //changed to be able add observer to flight collection
                    String AirlineId = r1.getString("Airline_ID");
                    Airline newAirline = new Airline(r1.getString("Airline_ID"),
                            r1.getString("Airlines"),r1.getFloat("hourly_fare_business_class"),
                            r1.getFloat("hourly_fare_prem_economy"),r1.getFloat("hourly_fare_economy_class"),
                            r1.getFloat("hourly_fare_first_class"));
                    Airline_storage.add(newAirline);
                    //System.out.println(Airline_storage);
                }
            } catch (Exception e) {
                System.out.println(e);
            }

//            System.out.println(Airline_storage.keySet());
        }
    }
    public void refresh(String AirlineId)
    {
        try {
            Airline_storage.remove(AirlineId);
            ResultSet r1= statement.executeQuery("select * from flights where  Airline_ID='"+AirlineId+"'");
            if(r1.next())
            {
                Airline newAirline = new Airline(r1.getString("Airline_ID"),
                        r1.getString("Airlines"),r1.getFloat("hourly_fare_business_class"),
                        r1.getFloat("hourly_fare_prem_economy"),r1.getFloat("hourly_fare_economy_class"),
                        r1.getFloat("hourly_fare_first_class"));
                Airline_storage.add(newAirline);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean verify(String AirlineId)
    {
        for (Airline airline : Airline_storage) {
            if (airline.getAirlineId().equals(AirlineId)) {
                return true;
            }
        }
        return false;
    }
    public Airline getObject(String AirlineId)
    {
        for (Airline airline : Airline_storage) {
            if (airline.getAirlineId().equals(AirlineId)) {
                return airline;
            }
        }
        return null;
    }
    public AirlineIterator createIterator() {
        return new AirlineCollnIterator(Airline_storage);
//        return new AirlineCollnIterator(Airline_storage);
    }
//    public void displayValue() {
//        //Airline_storage.forEach(key,value)->;
//        //String coll ="";
//        Airline_storage.forEach((key, value) -> {
//            //coll = coll +"\n"+ key + ": " + value + " ";
//            System.out.println(key + ": " + value + " ");
//        });
//    }

}
