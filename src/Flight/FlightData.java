package Flight;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class FlightData{

    protected Flight flight;
    private Integer availSeatsBusiness;
    private Integer availSeatsPremiumEconomy;
    private Integer availSeatsEconomy;
    private Integer availSeatsFirst;

    //Create Observer
    private List<Observer> observers = new ArrayList<>();

    //private static final Map<String, Flight> flightSeatData = new HashMap<>();
    public FlightData(Flight nflight, Integer nAvlFirst, Integer nAvlBusiness, Integer nAvlPremiumEconomy, Integer nAvlEconomy) {
        this.flight =nflight;
        this.availSeatsEconomy = nAvlEconomy;
        this.availSeatsBusiness = nAvlBusiness;
        this.availSeatsFirst = nAvlFirst;
        this.availSeatsPremiumEconomy=nAvlPremiumEconomy;
    }

    public Integer getAvailSeatsBusiness() {
        return availSeatsBusiness;
    }
    public void setAvailSeatsBusiness(Integer newAvailSeatBusiness) {
        this.availSeatsBusiness =newAvailSeatBusiness ;
        notifyAllObservers();
    }

    public Integer getAvailSeatsPremiumEconomyEconomy() {
        return availSeatsEconomy;
    }
    public void setAvailSeatsPremiumEconomyEconomy(Integer newAvailSeatsPremiumEconomy) {
        this.availSeatsPremiumEconomy =newAvailSeatsPremiumEconomy ;
        notifyAllObservers();
    }

    public Integer getAvailSeatsEconomy() {
        return availSeatsEconomy;
    }
    public void setAvailSeatsEconomy(Integer newAvailSeatsEconomy) {
        this.availSeatsEconomy =newAvailSeatsEconomy ;
        notifyAllObservers();
    }

    public Integer getAvailSeatsFirst() { return availSeatsFirst; }
    public void setAvailSeatsFirst(Integer newAvailSeatsFirst) {
        this.availSeatsFirst =newAvailSeatsFirst ;
    }

    //Observer methods start
    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }
    private void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
    //Observer methods end

}
