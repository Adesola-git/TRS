package AirportPack;

abstract class Component {
    public abstract void add(Component component);
    public abstract void remove(Component component);
    public abstract void display();
    public abstract void dbInsert();
    public abstract String getId();

}
