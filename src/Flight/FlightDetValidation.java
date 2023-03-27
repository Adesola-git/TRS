package Flight;

import DbConnect.DatabaseConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class FlightDetValidation {

    public boolean valFlightdetails(String FlightNo, int flightDay){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            DatabaseConnection dbCon = DatabaseConnection.getInstance();
            Connection connection = dbCon.getConnection();
            String sql = "select count(*) from flights where Flight_Number=? and Day=?";
            PreparedStatement preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setString (1, FlightNo);
            preparedStmt.setInt (2, flightDay);
            ResultSet resultSet = preparedStmt.executeQuery();
            while (resultSet.next()) {
                int cnt = resultSet.getInt(1);
                if(cnt >0){
                    return true;
                }
            }
            resultSet.close();
            preparedStmt.close();
            //(r1.getString("Flight_Number"), r1.getString("Origin_Airport"), r1.getString("Destination_Airport"), r1.getInt("Departure_Time"), r1.getInt("Arrival_Time"), r1.getInt("Duration"), r1.getInt("Day"),Integer noOfSeatE,r1.getInt("Economy_Seats"),r1.getInt("Premium_Economy_Seats"),r1.getInt("Business_Seats"),r1.getInt("FirstClass_Seats"));
//this will be the signature for flight constructor
            //ok
        }catch (Exception ex) {
            System.out.println("SQLException: " + ex.getMessage());
            return false;
        }
        return false;
    }
}
