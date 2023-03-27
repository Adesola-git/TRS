package AirportPack;

public class Terminal extends Component {
    private String id;

    public Terminal(String id) {
        this.id = id;
    }

    public void add(Component component) {
        System.out.println("Cannot add to a terminal");
    }

    public void remove(Component component) {
        System.out.println("Cannot remove from a terminal");
    }

    public void display() {
        System.out.println("Terminal " + id);
    }
    public String getId() {
        return this.id;
    }

    @Override
    public void dbInsert() {
        System.out.println("Terminal " + id);

    }



}
