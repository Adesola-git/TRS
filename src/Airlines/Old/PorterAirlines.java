package Airlines.Old;

import Modify.Flight;


import java.math.BigDecimal;

public class PorterAirlines implements Airlines {
    @Override
    public String getAirlineName() {
        return "Porter Airlines";
    }

    @Override
    public String getAirlineCode() {
        return "PD";
    }

    @Override
    public String getBaggagePolicy() {
        return "Passengers are allowed one carry-on bag and one personal item. Checked baggage allowance varies depending on the fare class and destination.";
    }

    @Override
    public String getCheckInOptions() {
        return "Passengers can check-in online, on mobile devices or at the airport.";
    }

    public String getFlightDetails(Flight flight, Passenger passenger) {
        return "Flight " + flight.getFlightNo() + " operated by Porter Airlines from " + flight.getOriginAirport() + " to " + flight.getDestAirport();
    }

    @Override
    public String getInFlightServices() {
        return "Complimentary snacks and beverages are offered on all flights, as well as free access to Porter's lounge at select airports.";
    }

    public boolean reserveSeat(Flight flight, Passenger passenger) {
        // Check if there are available seats on the flight
        if (!hasAvailableSeats(flight, passenger)) {
            return false;
        }

        // Reserve the seat for the passenger
        flight.setNoOfSeat(flight.getNoOfSeat().subtract(BigDecimal.ONE));
        passenger.setFlight(flight);

        return true;
    }

    @Override
    public boolean hasAvailableSeats(Flight flight, Passenger passenger) {
        // Check if the number of available seats on the flight is greater than zero
        return flight.getNoOfSeat().compareTo(BigDecimal.ZERO) > 0;
    }

    public BigDecimal calculatePrice(BigDecimal basePrice, Flight flight) {
        // Calculate the price of the flight based on the base price and the flight details
        // Porter Airlines' pricing strategy
        BigDecimal price = basePrice.add(flight.getPrice());
        if (flight.getDate().getMonthValue() == 6 || flight.getDate().getMonthValue() == 7 || flight.getDate().getMonthValue() == 8) {
            price = price.multiply(BigDecimal.valueOf(1.2));
        }
        return price;
    }

    public void displayAirlinesInfo() {
        System.out.println("Airline Code: " + getAirlineCode());
        System.out.println("In-flight Services: " + getInFlightServices());
        System.out.println("Baggage Policy: " + getBaggagePolicy());
    }
    
}
