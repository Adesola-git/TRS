package Airlines.Old;
import Modify.Flight;
import java.math.BigDecimal;


public interface Airlines {
    
    public String getAirlineName();
    
    public String getFlightDetails(Flight flight, Passenger passenger);
    
    public boolean hasAvailableSeats(Flight flight, Passenger passenger);
    
    public boolean reserveSeat(Flight flight, Passenger passenger);
    
    BigDecimal calculatePrice(BigDecimal basePrice, Flight flight);

    public String getAirlineCode();
    
    public String getBaggagePolicy();
    
    public String getCheckInOptions();
    
    public String getInFlightServices();

    public void displayAirlinesInfo();
    
}
