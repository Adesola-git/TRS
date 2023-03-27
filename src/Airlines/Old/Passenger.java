package Airlines.Old;
import Modify.Flight;
public class Passenger {
    private String name;
    private int age;
    private Flight flight;
    public Passenger(String name, int age) {
        this.name = name;
        this.age = age;
        
    }
    
    // Getters and setters for the attributes
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

}
