package AirportPack;
import DbConnect.DatabaseConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Airport extends Component {
    private String id;
    private String name;
    private String country;
    private Integer timeZone;
    private List<Component> terminals;

    public Airport(String id, String name, String country, Integer timeZone) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.timeZone = timeZone;
        this.terminals = new ArrayList<>();
    }

    public void add(Component component) {
        terminals.add(component);
        try {
            DatabaseConnection dbCon = DatabaseConnection.getInstance();
            Connection connection = dbCon.getConnection();
            String sql = " insert into terminal (Aiport_ID, terminal_id, del_flg)"
                    + " values (?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setString (1, this.id);
            preparedStmt.setString (2, component.getId());
            preparedStmt.setString   (3, "N");
            preparedStmt.execute();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getDetails(String airportId) {
        //terminals.add(component);
        try {
            DatabaseConnection dbCon = DatabaseConnection.getInstance();
            Connection connection = dbCon.getConnection();
            String sql = "Select Airport, Country, Time_Zone from airports where "
                    + " Aiport_ID = ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setString (1, airportId);
            ResultSet rs =preparedStmt.executeQuery();
            //String [] result = new String[]
            while(rs.next()){
                this.name = rs.getString("Airport");
                this.country = rs.getString("Country");
                this.timeZone = rs.getInt("Time_Zone");
            }
            connection.close();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void remove(Component component) {
        terminals.remove(component);
    }

    public void display() {
        System.out.println("Airport " + id);
        for (Component terminal : terminals) {
            terminal.display();
        }
    }

    @Override
    public void dbInsert() {
        System.out.println("Airport " + id);
        try {
            DatabaseConnection dbCon = DatabaseConnection.getInstance();
            Connection connection = dbCon.getConnection();
            String sql = " insert into airports (Aiport_ID, Airport, Country, Time_Zone)"
                    + " values (?, ?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setString (1, this.id);
            preparedStmt.setString (2, this.name);
            preparedStmt.setString   (3, this.country);
            preparedStmt.setInt(4, this.timeZone);
            preparedStmt.execute();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
