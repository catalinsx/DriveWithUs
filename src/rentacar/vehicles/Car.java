package rentacar.vehicles;

public abstract class Car implements RentalCostCalculator{
    private double pricePerDay;
    private String classCar;
    private String brand;
    private String model;
    private boolean gearBox; //Manuala-0 , automata-1
    private String Traction;
    private String fuelType;
    public static boolean oneYearExperience; // true/false
    public Car(String classCar,String brand,String model, boolean gearBox,String Traction,String fuelType,double pricePerDay){
        this.classCar = classCar;
        this.brand = brand;
        this.model = model;
        this.gearBox = gearBox;
        this.Traction = Traction;
        this.fuelType = fuelType;
        this.pricePerDay = pricePerDay;
    }
    /*
    public boolean getOneYearExperience(){
        return oneYearExperience;
    }

    public void setOneYearExperience(boolean oneYearExperience){
        this.oneYearExperience=oneYearExperience;
    }
    */


    public double getPricePerDay(){
        return pricePerDay;
    }
    public void setPricePerDay(double newPrice){
        this.pricePerDay=newPrice;
    }
    public abstract double calculateRentalCost(int days);
}
