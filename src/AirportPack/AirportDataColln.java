package AirportPack;

import Airlines.AirlineCollnIterator;
import Airlines.AirlineIterator;
import Flight.*;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class AirportDataColln{
    private static AirportDataColln singleton_airportdatacollection=null;

    private List<Airport> airportData_storage = new ArrayList<>();
    private AirportDataColln(){   }// in singleton we restrict anyone from calling the constructor
    private static Statement statement=null;
    private static Connection connection;



    public static AirportDataColln getInstance()

    {
        if(singleton_airportdatacollection==null)
        {
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/reservations";
                connection = DriverManager.getConnection(url, "root", "");
                statement = connection.createStatement();
                singleton_airportdatacollection = new AirportDataColln();
                singleton_airportdatacollection.populate();
                return singleton_airportdatacollection;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else
        {
            return singleton_airportdatacollection;
        }
        return null;
    }

    private void populate() {
        if (airportData_storage.isEmpty())
        {
            try {
                ResultSet r1= statement.executeQuery("select * from airports");
                while(r1.next())
                {
                    String airportId = r1.getString("Airport_ID");
                    //System.out.println(airportId);
                    Airport newAirport = new Airport(r1.getString("Airport_ID"), r1.getString("Airport"), r1.getString("Country"), r1.getInt("Time_Zone"));
                    airportData_storage.add(newAirport);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    public void refresh(String airportid)
    {
        try {
            Airport airport = getObject(airportid);
            if (airport != null) {
                airportData_storage.remove(airport);
                ResultSet r1 = statement.executeQuery("select * from flights where Aiport_ID=" + airportid);
                if (r1.next()) {
                    Airport newAirport = new Airport(r1.getString("Aiport_ID"), r1.getString("Airport"), r1.getString("Country"), r1.getInt("Time_Zone"));
                    airportData_storage.add(newAirport);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean verify(String airportid, int day_of_week)
    {
        for (Airport airport : airportData_storage) {
            if (airport.getId().equals(airportid)) {
                return true;
            }
        }
        return false;
    }

    public Airport getObject(String airportid)
    {
        for (Airport airport : airportData_storage) {
            if (airport.getId().equals(airportid)) {
                return airport;
            }
        }
        return null;
    }


    public AirportIterator createIterator() {
        return new AirportDataCollnIterator(airportData_storage);
    }

}

