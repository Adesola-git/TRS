package AirportPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String error = "Invalid input, try again";


        Airport airportA = new Airport("DAC","Dhaka","Bangladesh",600);
        Airport airportB = new Airport("LOS","Muritala M","Nigeria",100);

        Terminal terminalA1 = new Terminal("A1");
        Terminal terminalA2 = new Terminal("A2");
        Terminal terminalB1 = new Terminal("B1");

        airportA.add(terminalA1);
        airportA.add(terminalA2);
        airportB.add(terminalB1);

        airportA.display();
        airportB.display();

//        String url = "jdbc:mysql://localhost:3306/reservations";
//        String username = "adwoa";
//        String password = "lalala";
//
//
//        System.out.println("Connecting database...");
//
//        try (Connection connection = DriverManager.getConnection(url, username, password)) {
//            System.out.println("Database connected!");
//        } catch (SQLException e) {
//            throw new IllegalStateException("Cannot connect the database!", e);
//        }
    }
}