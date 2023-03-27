package Flight;

import DbConnect.DatabaseConnection;

import java.io.IOException;
import java.sql.*;

public class DbInsert {
    //private FlightData flight;
    private static Statement statement=null;
    private static Connection connection;
    DatabaseConnection dbCon;
    public DbInsert(){
        try {
            dbCon = DatabaseConnection.getInstance();
            connection = dbCon.getConnection();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public boolean AddFlight(Flight nflight){
        try {
            String sql = " insert into flights (Flight_Number, Origin_Airport, Destination_Airport,"
                    + " Departure_Time, Arrival_Time,Duration,Day,Economy_Seats,Premium_Economy_Seats,Business_Seats,FirstClass_Seats)"
                    + " values (?, ?, ?,?,?,?, ?, ?,?,?,?)";
            PreparedStatement preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setString (1, nflight.getFlightNo());
            preparedStmt.setString (2, nflight.getOriginAirport());
            preparedStmt.setString   (3, nflight.getDestAirport());
            preparedStmt.setInt   (4, nflight.getDepatureTime());
            preparedStmt.setInt   (5, nflight.getArrivalTime());
            preparedStmt.setInt   (6, nflight.getDuration());
            preparedStmt.setInt   (7, nflight.getDow());
            preparedStmt.setInt   (8, nflight.getNoOfSeatE());
            preparedStmt.setInt   (9, nflight.getNoOfSeatPE());
            preparedStmt.setInt   (10, nflight.getNoOfSeatB());
            preparedStmt.setInt   (11, nflight.getNoOfSeatF());
            //preparedStmt.setBigDecimal   (10, this.price);
            boolean rowsAffected= preparedStmt.execute();
            return rowsAffected;
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }
        return false;
    }
    public boolean RemoveFlight(String flightid, int day_of_week)
    {
        try {
            statement = connection.createStatement();
            int rowsAffected= statement.executeUpdate("delete from flights where Flight_Number='"+flightid+"' AND Day='"+day_of_week+"'");
            System.out.println(rowsAffected);
            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

}
