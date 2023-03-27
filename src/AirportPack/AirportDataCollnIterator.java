package AirportPack;

import Airlines.Airline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AirportDataCollnIterator implements AirportIterator {
    private int position;
//    private Map<String, Airport> airportData_storage = new HashMap<>();
    private List<Airport> airportData_storage = new ArrayList<>();
//    private List<Airport> airportData_storage = new ArrayList<>();

    public AirportDataCollnIterator( List<Airport> sentAirport){
        this.airportData_storage = sentAirport;
    }
    @Override
    public boolean hasNext() {
       // System.out.println(airportData_storage.size());
        if(position >= airportData_storage.size()|| airportData_storage.get(position)==null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public Airport next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException("No more elements");
        }
        Airport A=airportData_storage.get(position);
        position++;
        return A ;
    }

}
