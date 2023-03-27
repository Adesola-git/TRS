package Flight;

import java.util.HashMap;
import java.util.Map;

public class FlightDataCollectionIterator implements FlightDataIterator{
    private int position;
    private Map<String, FlightData> flightSeatData = new HashMap<>();
    public FlightDataCollectionIterator(Map<String, FlightData> sentFlightSeatData){
        this.position=0;
        this.flightSeatData = sentFlightSeatData;
    }
    @Override
    public boolean hasNext() {
        if(position >= flightSeatData.size()|| flightSeatData.get(position)==null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public FlightData next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException("No more elements");
        }
        return flightSeatData.get(position);
    }
}
