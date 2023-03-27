package Modify;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class Flight {
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

    public Flight(String flightNo, String originAirport, String destAirport, String status, LocalDate date, LocalTime depatureTime, LocalTime arrivalTime, Integer duration, BigDecimal noOfSeat, BigDecimal price) {
        this.flightNo = flightNo;
        this.originAirport = originAirport;
        this.destAirport = destAirport;
        this.status = status;
        this.date = date;
        this.depatureTime = depatureTime;
        this.arrivalTime = arrivalTime;
        this.duration = duration;
        this.noOfSeat = noOfSeat;
        this.price = price;
    }


    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getOriginAirport() {
        return originAirport;
    }

    public void setOriginAirport(String originAirport) {
        this.originAirport = originAirport;
    }

    public String getDestAirport() {
        return destAirport;
    }

    public void setDestAirport(String destAirport) {
        this.destAirport = destAirport;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalTime getDepatureTime() {
        return depatureTime;
    }

    public void setDepatureTime(LocalTime depatureTime) {
        this.depatureTime = depatureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public BigDecimal getNoOfSeat() {
        return noOfSeat;
    }

    public void setNoOfSeat(BigDecimal noOfSeat) {
        this.noOfSeat = noOfSeat;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNo='" + flightNo + '\'' +
                ", originAirport='" + originAirport + '\'' +
                ", destAirport='" + destAirport + '\'' +
                ", status='" + status + '\'' +
                ", depatureTime=" + depatureTime +
                ", arrivalTime=" + arrivalTime +
                ", date=" + date +
                ", duration=" + duration +
                ", noOfSeat=" + noOfSeat +
                ", price=" + price +
                '}';
    }

    public void displayFlightDetails() {
        System.out.println("Flight Number: " + flightNo);
        System.out.println("Origin Airport: " + originAirport);
        System.out.println("Destination Airport: " + destAirport);
        System.out.println("Status: " + status);
        System.out.println("Date: " + date);
        System.out.println("Departure Time: " + depatureTime);
        System.out.println("Arrival Time: " + arrivalTime);
        System.out.println("Duration: " + duration+ " hours");
        System.out.println("Number of Available Seats: " + noOfSeat);
        System.out.println("Price: $" + price);
    }

}
