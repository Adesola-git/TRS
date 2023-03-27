package Airlines;

import Flight.FlightData;

import java.util.*;

public class AirlineCollnIterator implements AirlineIterator{
    private int position;
    private List<Airline> Airline_storage = new ArrayList<>();

    //private Iterator Airline_storage ;

    //Neel i can hear you not sure why you cant hear me
    //I'm saying we should leave the flight collection the way it is. i can find another way to iterate through it
    //Instead of using iterator
    //I have something in mind for flightcollection and I have made the
    public AirlineCollnIterator(List<Airline> sentAirline){
        //this.position=0;
        this.Airline_storage = sentAirline;
    }
    @Override
    public boolean hasNext() {
        //System.out.println(Airline_storage.get(position));
        if(position >= Airline_storage.size()|| Airline_storage.get(position)==null){
            return false;
        }else{
            return true;
        }
    }
// it seems like with java's iterator we do not need AirlineCollnIterator
    //yeah
    @Override
    public Airline next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException("No more elements");
        }
        //Map.Entry<String, Integer> entry = iterator.next();
        Airline A= Airline_storage.get(position);
        position++;
        return A;
    }
//    public void displayValue() {
//        Airline_storage.forEach((key, value) -> {
//            //coll = coll +"\n"+ key + ": " + value + " ";
//            System.out.println(key + ": " + value + " ");
//        });
//    }
}
