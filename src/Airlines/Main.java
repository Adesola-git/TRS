package Airlines;
import Airlines.Old.AirCanadaAirlines;
import Airlines.Old.Airlines;
import Airlines.Old.FlightWithAirlines;
import Airlines.Old.PorterAirlines;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        // create AirCanada Airlines and Porter Airlines objects
        Airlines airCanada = new AirCanadaAirlines();
        Airlines porter = new PorterAirlines();
    
        // create a FlightWithAirlines object with AirCanada Airlines
        FlightWithAirlines flight1 = new FlightWithAirlines("AC100","Pearson", "Toronto", "Vancouver", LocalDate.now(), LocalTime.of(8, 0), LocalTime.of(11, 30), Integer.valueOf(2), BigDecimal.valueOf(100), BigDecimal.valueOf(500), airCanada);
    
        // call the methods of Flight and Airlines interfaces
        flight1.displayFlightDetails();
        flight1.displayAirlinesInfo();
    
        // create another FlightWithAirlines object with Porter Airlines
        FlightWithAirlines flight2 = new FlightWithAirlines("PO200", "Kotoka","Vancouver", "Calgary", LocalDate.now(), LocalTime.of(13, 0), LocalTime.of(15, 30), Integer.valueOf(2), BigDecimal.valueOf(50), BigDecimal.valueOf(300), porter);
    
        // call the methods of Flight and Airlines interfaces
        flight2.displayFlightDetails();
        flight2.displayAirlinesInfo();
    }
    
}
