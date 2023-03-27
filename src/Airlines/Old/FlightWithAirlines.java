package Airlines.Old;
import Modify.Flight;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class FlightWithAirlines extends Flight implements Airlines {
    private Airlines airlines;

    public FlightWithAirlines(String flightNumber, String originAirport, String source, String destination, LocalDate date, LocalTime departureTime, LocalTime arrivalTime, Integer duration, BigDecimal noOfSeat, BigDecimal price, Airlines airlines) {
        super(flightNumber, originAirport, source, destination, date, departureTime, arrivalTime, duration, noOfSeat, price);
        this.airlines = airlines;
    }
    

    // Use the Airlines interface methods to provide additional functionality to the Flight class
    public void displayFlightDetails() {
        super.displayFlightDetails(); // Display basic flight details
        airlines.displayAirlinesInfo(); // Display airline specific details using the Airlines interface
    }

    public void setAirline(Airlines airlines) {
        this.airlines = airlines;
    }

    public Airlines getAirline() {
        return airlines;
    }

    @Override
    public String getAirlineName() {
        return airlines.getAirlineName();
    }

    @Override
    public String getFlightDetails(Flight flight, Passenger passenger) {
        return airlines.getFlightDetails(flight, passenger);
    }

    @Override
    public boolean hasAvailableSeats(Flight flight, Passenger passenger) {
        return airlines.hasAvailableSeats(flight, passenger);
    }

    @Override
    public boolean reserveSeat(Flight flight, Passenger passenger) {
        return airlines.reserveSeat(flight, passenger);
    }

    @Override
    public BigDecimal calculatePrice(BigDecimal basePrice, Flight flight) {
        return airlines.calculatePrice(basePrice, flight);
    }

    @Override
    public String getAirlineCode() {
        return airlines.getAirlineCode();
    }

    @Override
    public String getBaggagePolicy() {
        return airlines.getBaggagePolicy();
    }

    @Override
    public String getCheckInOptions() {
        return airlines.getCheckInOptions();
    }

    @Override
    public String getInFlightServices() {
        return airlines.getInFlightServices();
    }

    @Override
    public void displayAirlinesInfo() {
        airlines.displayAirlinesInfo();
    }
}
