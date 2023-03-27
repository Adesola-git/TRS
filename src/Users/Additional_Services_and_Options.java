package Users;

interface Additional_Services_and_Options            //1BridgePatterImplementation_2CompositePatternComponent
{
}


class Services_and_Options implements Additional_Services_and_Options //1BridgePatternConcreteImplementation_2CompositePattern
{
    private Additional_Services_and_Options list_of_children[] ;
    public void cost(){}
    void add_service() {}
    void remove_service() {}

}
class meals implements Additional_Services_and_Options //CompositePatternComponent
{
    public void cost(){}
}
class seat_selection implements Additional_Services_and_Options //CompositePatternComponent
{
    public void cost(){}
}

