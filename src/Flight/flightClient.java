package Flight;
import Modify.Flight;
import Modify.FlightBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
public class flightClient {
    public static void main(String[] args) {
        Modify.Flight flight = new FlightBuilder()
                .setFlightNo("BD001")
                .setOriginAirport("LOS")
                .setDestAirport("YYZ")
                .setDate(LocalDate.of(2023, 3, 15))
                .setdepatureTime(LocalTime.of(05, 30))
                .setArrivalTime(LocalTime.of(20, 30))
                .setDuration(2)
                .setnoOfSeat(BigDecimal.valueOf(600))
                .setPrice(BigDecimal.valueOf(500))
                .build();
    }
    Day_calculation newday= new Day_calculation();
}
