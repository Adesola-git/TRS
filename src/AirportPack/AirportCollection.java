package AirportPack;


import Flight.FlightDataIterator;

public interface AirportCollection {



    void add(Airport c);

    AirportIterator createIterator();

}
