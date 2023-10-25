package rentacar.vehicles;

abstract class Car implements RentalCostCalculator{
    private double pricePerDay;
    private String classCar;
    private String brand;
    private String model;
    private boolean gearBox; //Manuala-0 , automata-1
    private String Traction;
    private String fuelType;
    private boolean oneYearExperience; // true/false
    public Car(String classCar,String brand,String model, boolean gearBox,String Traction,String fuelType,double pricePerDay,boolean oneYearExperience){
        this.classCar = classCar;
        this.brand = brand;
        this.model = model;
        this.gearBox = gearBox;
        this.Traction = Traction;
        this.fuelType = fuelType;
        this.pricePerDay = pricePerDay;
        this.oneYearExperience = oneYearExperience;
    }
    public boolean getOneYearExperience(){
        return oneYearExperience;
    }
    public double getPricePerDay(){
        return pricePerDay;
    }
    public void setPricePerDay(double newPrice){
        this.pricePerDay=newPrice;
    }
    public abstract double calculateRentalCost(int days);
}
