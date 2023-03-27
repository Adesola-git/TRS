package Flight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.sql.*;

public class FlightCollection {

    private static FlightCollection singleton_flightcollection=null;
    private Map<String, Flight> flight_storage = new HashMap<>();
    private FlightCollection(){ }
    private static Statement statement=null;
    private static Connection connection;

    public static FlightCollection getInstance()
    {
        if(singleton_flightcollection==null)
        {
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/reservations";
                connection = DriverManager.getConnection(url, "root", "");
                statement = connection.createStatement();
                singleton_flightcollection = new FlightCollection();
                singleton_flightcollection.populate();
                return singleton_flightcollection;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else
        {
            return singleton_flightcollection;
        }
        return null;
    }
    private void populate()
    {
        if (flight_storage.isEmpty())
        {
            try {
                ResultSet r1= statement.executeQuery("select * from flights");
                while(r1.next())
                {
                    //changed to be able add observer to flight collection
                    String flightNo = r1.getString("Flight_Number")+"_"+r1.getInt("Day");
                    Flight newFlight = new Flight(r1.getString("Flight_Number"), r1.getString("Origin_Airport"), r1.getString("Destination_Airport"), r1.getInt("Departure_Time"), r1.getInt("Arrival_Time"), r1.getInt("Duration"), r1.getInt("Day"),r1.getInt("Economy_Seats"),r1.getInt("Premium_Economy_Seats"),r1.getInt("Business_Seats"),r1.getInt("FirstClass_Seats"));
                    flight_storage.put(flightNo,newFlight);
                    //flight_storage.put(r1.getString("Flight_Number")+"_"+r1.getInt("Day"),(new Flight(r1.getString("Flight_Number"), r1.getString("Origin_Airport"), r1.getString("Destination_Airport"), r1.getInt("Departure_Time"), r1.getInt("Arrival_Time"), r1.getInt("Duration"), r1.getInt("Day"),r1.getInt("Economy_Seats"),r1.getInt("Premium_Economy_Seats"),r1.getInt("Business_Seats"),r1.getInt("FirstClass_Seats"))));
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    public void refresh(String flightid, int day_of_week)
    {
        try {
            ResultSet r1= statement.executeQuery("select * from flights where Flight_Number='"+flightid+"' AND Day='"+day_of_week+"'");
            if(r1.next())
            {
                flight_storage.put(flightid+"_"+day_of_week,(new Flight(r1.getString("Flight_Number"), r1.getString("Origin_Airport"), r1.getString("Destination_Airport"), r1.getInt("Departure_Time"), r1.getInt("Arrival_Time"), r1.getInt("Duration"), r1.getInt("Day"),r1.getInt("Economy_Seats"),r1.getInt("Premium_Economy_Seats"),r1.getInt("Business_Seats"),r1.getInt("FirstClass_Seats"))));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean verify(String flightid, int day_of_week)
    {
        if (flight_storage.containsKey(flightid+"_"+day_of_week))
        {
            return true;
        }else{
            return false;
        }
    }
    public Flight getObject(String flightid, int day_of_week)
    {
        if (flight_storage.containsKey(flightid+"_"+day_of_week))
        {
            return flight_storage.get(flightid+"_"+day_of_week);
        }else{
            return null;
        }
    }
}