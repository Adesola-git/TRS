package Modify;
import DbConnect.DatabaseConnection;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
public class FlightBuilder {
    private String flightNo;
    private String originAirport;
    private String destAirport;
    private String status;
    private LocalTime depatureTime;
    private LocalTime arrivalTime;
    private LocalDate date;
    private Integer duration;
    private BigDecimal noOfSeat;
    private BigDecimal price;

    public FlightBuilder setFlightNo(String flightNo) {
        this.flightNo = flightNo;
        return this;
    }
    public FlightBuilder setOriginAirport(String originAirport) {
        this.originAirport = originAirport;
        return this;
    }

    public FlightBuilder setDestAirport(String destAirport) {
        this.destAirport = destAirport;
        return this;
    }
    public FlightBuilder setStatus(String status) {
            this.status = status;
            return this;
        }

    public FlightBuilder setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public FlightBuilder setdepatureTime(LocalTime depatureTime) {
        this.depatureTime = depatureTime;
        return this;
    }
    public FlightBuilder setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
        return this;
    }

    public FlightBuilder setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public FlightBuilder setnoOfSeat(BigDecimal noOfSeat) {
        this.noOfSeat = noOfSeat;
        return this;
    }
    public FlightBuilder setPrice(BigDecimal price) {
            this.price = price;
            return this;
    }

    public Flight build() {
        try {
            DatabaseConnection dbCon = DatabaseConnection.getInstance();
            Connection connection = dbCon.getConnection();
            String sql = " insert into flights (Flight_Number, Origin_Airport, Destination_Airport, status,"
            + " Date, Departure_Time, Arrival_Time,Duration,Number_of_Seats,Price)"
                    + " values (?, ?, ?,?,?,?, ?, ?,?,?)";
            PreparedStatement preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setString (1, this.flightNo);
            preparedStmt.setString (2, this.originAirport);
            preparedStmt.setString   (3, this.destAirport);
            preparedStmt.setString   (4, this.status);
            preparedStmt.setDate   (5, Date.valueOf(this.date));
            preparedStmt.setTime   (6, Time.valueOf(this.depatureTime));
            preparedStmt.setTime   (7, Time.valueOf(this.arrivalTime));
            preparedStmt.setInt   (8, this.duration);
            preparedStmt.setBigDecimal   (9, this.noOfSeat);
            preparedStmt.setBigDecimal   (10, this.price);
            preparedStmt.execute();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new Flight(flightNo,originAirport,destAirport,status, date, depatureTime,arrivalTime, duration,noOfSeat, price);
    }
}
