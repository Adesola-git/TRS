package Airlines;

public class Airline {
    private String airlinesName;
    private String airlinesID;
    private float hourlyFairBusinessClassType;
    private float hourlyFairEconomyClassType;
    private float hourlyFairPremiumEconomyType;
    private float hourlyPremiumfirstClassType;

    public Airline(String airlinesID,String airlinesName, float hourlyFairBusinessClassType,float hourlyFairPremiumEconomyType,float hourlyFairEconomyClassType,float hourlyPremiumfirstClassType){
        this.airlinesID=airlinesID;
        this.airlinesName=airlinesName;

        this.hourlyFairBusinessClassType=hourlyFairBusinessClassType;
        this.hourlyFairEconomyClassType=hourlyFairEconomyClassType;
        this.hourlyFairPremiumEconomyType=hourlyFairPremiumEconomyType;
        this.hourlyPremiumfirstClassType=hourlyPremiumfirstClassType;
    }
    public String getAirlineName(){
        return(this.airlinesName);
    }
    public void setAirlineName(String name){
        this.airlinesName=name;
    }

    public String getAirlineId(){
        return(this.airlinesID);
    }
    public void setAirlineId(String id){
        this.airlinesID=airlinesID;
    }

    public void displayAirlineInfo(){
        System.out.println(this.airlinesName+"\t"+this.airlinesID+"\t");
        //+this.hourlyFair
    }

}
