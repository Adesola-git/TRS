package Airlines.Old;
import java.math.BigDecimal;

import Modify.Flight;

public class AirCanadaAirlines implements Airlines {

    @Override
    public String getAirlineName() {
        return "Air Canada";
    }

    public String getAirlineCode() {
        return "AC";
    }

    @Override
    public String getFlightDetails(Flight flight, Passenger passenger) {
        return "Flight " + flight.getFlightNo() + " operated by Air Canada from " + flight.getOriginAirport() + " to " + flight.getDestAirport();
    }

    public String getCheckInOptions() {
        return "Passengers can check-in online, on mobile devices or at the airport.";
    }

    public boolean hasAvailableSeats(Flight flight, Passenger passenger) {
        // Check if the number of available seats on the flight is greater than zero
        return flight.getNoOfSeat().compareTo(BigDecimal.ZERO) > 0;
    }
    

    @Override
    public boolean reserveSeat(Flight flight, Passenger passenger) {
        // Check if there are available seats on the flight
        if (!hasAvailableSeats(flight,passenger)) {
            return false;
        }
        
        // Reserve the seat for the passenger
        flight.setNoOfSeat(flight.getNoOfSeat().subtract(BigDecimal.ONE));
        passenger.setFlight(flight);
        
        return true;
    }


    @Override
    public BigDecimal calculatePrice(BigDecimal basePrice, Flight flight) {// Calculate the price of the flight based on the base price and the flight details
        // Air Canada's pricing strategy
        BigDecimal price = basePrice.add(flight.getPrice());
        if (flight.getDate().getMonthValue() == 12 || flight.getDate().getMonthValue() == 1 || flight.getDate().getMonthValue() == 2) {
            price = price.multiply(BigDecimal.valueOf(1.1));
        }
        return price;
    }

    public String getInFlightServices() {
        return "Complimentary meals and beverages, in-flight entertainment, and Wi-Fi are offered on all flights.";
    }

    @Override
    public String getBaggagePolicy() {
        return "Passengers are allowed one carry-on bag and one personal item. Checked baggage allowance varies depending on the fare class and destination.";
    }

    public void displayAirlinesInfo() {
        System.out.println("Airline Code: " + getAirlineCode());
        System.out.println("In-flight Services: " + getInFlightServices());
        System.out.println("Baggage Policy: " + getBaggagePolicy());
        System.out.println("Check-in Options: " + getCheckInOptions());
    }
}
