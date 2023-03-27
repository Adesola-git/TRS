package Flight;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

public class Flight implements Cloneable{

    private String flightNo;
    private String originAirport;
    private String destAirport;
    private String status;
    private Integer depatureTime;
    private Integer arrivalTime;
    private LocalDate date;
    private Integer duration;
    private BigDecimal noOfSeat;
    private Integer noOfSeatE;
    private Integer noOfSeatPE;
    private Integer noOfSeatB;
    private Integer noOfSeatF;
    //private BigDecimal price;
    private Integer dow;

    public Flight(String flightNo, String originAirport, String destAirport,
                  Integer depatureTime, Integer arrivalTime,
                  Integer duration,Integer dow, Integer noOfSeatE,Integer noOfSeatPE,
                  Integer noOfSeatB, Integer noOfSeatF) {
        this.flightNo = flightNo;
        this.originAirport = originAirport;
        this.destAirport = destAirport;
        //this.status = status;
        //this.date = date;
        this.depatureTime = depatureTime;
        this.arrivalTime = arrivalTime;
        this.duration = duration;
        this.noOfSeatE = noOfSeatE;
        this.noOfSeatPE = noOfSeatPE;
        this.noOfSeatB = noOfSeatB;
        this.noOfSeatF = noOfSeatF;
        //this.price = price;
        //System.out.println(date.getDayOfWeek());
        this.dow = dow;
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


    public Integer getDepatureTime() {
        return depatureTime;
    }

    public void setDepatureTime(Integer depatureTime) {
        this.depatureTime = depatureTime;
    }

    public Integer getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Integer arrivalTime) {
        this.arrivalTime = arrivalTime;
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
    public Integer getDow() {
        return dow;
    }

    public Integer getNoOfSeatE() {
        return noOfSeatE;
    }

    public void setNoOfSeatE(Integer noOfSeatE) {
        this.noOfSeatE = noOfSeatE;
    }
    public Integer getNoOfSeatPE() {
        return noOfSeatPE;
    }
    public void setNoOfSeatPE(Integer noOfSeatPE) {
        this.noOfSeatPE = noOfSeatPE;
    }
    public Integer getNoOfSeatB() {
        return noOfSeatB;
    }

    public void setNoOfSeatB(Integer noOfSeatB) {
        this.noOfSeatB = noOfSeatB;
    }
    public Integer getNoOfSeatF() {
        return noOfSeatF;
    }

    public void setNoOfSeatF(Integer noOfSeatF) {
        this.noOfSeatF = noOfSeatF;
    }

    public String toString() {
        return "Flight{" +
                "flightNo='" + flightNo + '\'' +
                ", originAirport='" + originAirport + '\'' +
                ", destAirport='" + destAirport + '\'' +
                //", status='" + status + '\'' +
                ", depatureTime=" + depatureTime +
                ", arrivalTime=" + arrivalTime +
               // ", date=" + date +
                ", duration=" + duration +
                ", noOfSeatF=" + noOfSeatF +
                ", noOfSeatB=" + noOfSeatB +
                ", noOfSeatPE=" + noOfSeatPE +
                ", noOfSeatE=" + noOfSeatE +
                '}';
    }

    public void displayFlightDetails() {
        System.out.println("Flight Number: " + flightNo);
        System.out.println("Origin Airport: " + originAirport);
        System.out.println("Destination Airport: " + destAirport);
        //System.out.println("Status: " + status);
        //System.out.println("Date: " + date);
        System.out.println("Departure Time: " + depatureTime);
        System.out.println("Arrival Time: " + arrivalTime);
        System.out.println("Duration: " + duration+ " hours");
        System.out.println("Number of Available Seats First Class: " + noOfSeatF);
        System.out.println("Number of Available Seats Economy Class: $" + noOfSeatE);
        System.out.println("Number of Available Seats Premium Economy Class: $" + noOfSeatPE);
        System.out.println("Number of Available Seats Business Class: $" + noOfSeatB);
    }
   //Implement Clone starts
    public Flight clone(String newOriginAirport, String newDestAirport,
                        LocalDate newDate, Integer newDepatureTime,
                        Integer newArrivalTime, Integer newDuration, BigDecimal newNoOfSeat) {
        Flight newFlight = new Flight(this.flightNo, this.originAirport, this.destAirport,
                 this.depatureTime,this.arrivalTime, this.duration,this.dow,this.noOfSeatE,this.noOfSeatPE,this.noOfSeatB,this.noOfSeatF);
        if(newOriginAirport !=null){
            newFlight.originAirport = newOriginAirport;
        }
        if(newDestAirport !=null){
            newFlight.destAirport = newDestAirport;
        }
        if(newDepatureTime !=null){
            newFlight.depatureTime = newDepatureTime;
        }
        if(newArrivalTime !=null){
            newFlight.arrivalTime = newArrivalTime;
        }
        if(newDuration !=null){
            newFlight.duration = newDuration;
        }
        if(newNoOfSeat !=null){
            newFlight.noOfSeat = newNoOfSeat;
        }
        return newFlight;
    }
    public Flight clone(LocalDate newDate, Integer newDepatureTime,
                        Integer newArrivalTime, Integer newDuration, BigDecimal newNoOfSeat) {
        Flight newFlight = new Flight(this.flightNo, this.originAirport, this.destAirport,
                this.depatureTime, this.arrivalTime, this.duration,this.dow,this.noOfSeatE,this.noOfSeatPE,this.noOfSeatB,this.noOfSeatF);
        if(newDepatureTime !=null){
            newFlight.depatureTime = newDepatureTime;
        }
        if(newArrivalTime !=null){
            newFlight.arrivalTime = newArrivalTime;
        }
        if(newDuration !=null){
            newFlight.duration = newDuration;
        }
        if(newNoOfSeat !=null){
            newFlight.noOfSeat = newNoOfSeat;
        }
        return newFlight;
    }
    public Flight clone(Integer newDow) {
        return new Flight(this.flightNo, this.originAirport, this.destAirport
                ,this.depatureTime, this.arrivalTime, this.duration,newDow, this.noOfSeatE,this.noOfSeatPE,this.noOfSeatB,this.noOfSeatF);
    }
}
