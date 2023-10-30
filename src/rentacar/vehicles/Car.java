package rentacar.vehicles;

import java.io.Serializable;

public abstract class Car implements RentalCostCalculator, Serializable {
    private double pricePerDay;
    private String classCar;
    private String brand;
    private String model;
    private String gearBox;
    private String traction;
    private String fuelType;
    private boolean oneYearExperience; // true/false
    public Car(String classCar,String brand,String model, String gearBox,String traction,String fuelType,double pricePerDay){
        this.classCar = classCar;
        this.brand = brand;
        this.model = model;
        this.gearBox = gearBox;
        this.traction = traction;
        this.fuelType = fuelType;
        this.pricePerDay = pricePerDay;
    }
    public String getBrand(){
        return brand;
    }
    public String getModel(){
        return model;
    }
    public String getGearBox(){
        return gearBox;
    }
    public String getTraction(){
        return traction;
    }
    public String getFuelType(){
        return fuelType;
    }
    public String getClassCar(){
        return classCar;
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
