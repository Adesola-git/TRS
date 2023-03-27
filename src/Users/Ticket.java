package Users;

import java.util.Calendar;

abstract class Seat_Class implements Final_fare_with_special_fares_and_discounts //BridgePatternAbstraction, concrete component
{
 public Additional_Services_and_Options  selected_Services_and_Options =new Services_and_Options();
    private String user_id;
    private String customer_id;
    private String flight_number;
    private Calendar date;

    protected String getUser_id(){return user_id;}
    protected String getflight_number(){return flight_number;}
    Seat_Class(String user_id, String flight_number,Calendar date)
    {
        this.user_id=user_id;
        this.flight_number=flight_number;
        this.date=date;
    }
}
class Business extends Seat_Class //BridgePatternRefinedAbstraction
{
    public void cost(){}
    public String book(){return " ";}
    Business(String user_id, String flight_number,Calendar date)
    {
        super(user_id, flight_number,date);
    }
}
class First_Class extends Seat_Class //BridgePatternRefinedAbstraction
{
    public void cost(){}
    First_Class(String user_id, String flight_number,Calendar date)
    {
        super(user_id, flight_number,date);
    }
}
class Premium_Economy extends Seat_Class //BridgePatternRefinedAbstraction
{
    public void cost(){}
    Premium_Economy (String user_id, String flight_number,Calendar date)
    {
        super(user_id, flight_number,date);
    }
}
class Economy extends Seat_Class //BridgePatternRefinedAbstraction
{
    public void cost(){}
    Economy (String user_id, String flight_number,Calendar date)
    {
        super(user_id, flight_number,date);
    }
}


interface Final_fare_with_special_fares_and_discounts
{
    void cost();
//    String book();
}

abstract class discount_base_decorator implements Final_fare_with_special_fares_and_discounts
{
    protected Final_fare_with_special_fares_and_discounts decorated_by_this_object ;
        @Override
        public void cost() {};
    discount_base_decorator (Final_fare_with_special_fares_and_discounts object_for_decoration)
    {
        this.decorated_by_this_object=object_for_decoration;
    }
}
class student_fare extends discount_base_decorator
{
    student_fare(Final_fare_with_special_fares_and_discounts object_for_decoration)
    {
        super(object_for_decoration);
    }
    public void cost()
    {
      decorated_by_this_object.cost();
    }
}




