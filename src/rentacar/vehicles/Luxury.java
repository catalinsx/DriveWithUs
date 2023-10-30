package rentacar.vehicles;

import java.io.Serializable;

public class Luxury extends Car implements Serializable {
    private String features;
    public Luxury(String classCar,String brand,String model, String gearBox,String traction,String fuelType,double pricePerDay) {
        super(classCar, brand, model, gearBox, traction, fuelType, pricePerDay);
     //   this.features = features; am scos features pt moment
    }
//    public Luxury(String classCar,String brand,String model, String gearBox,String Traction,String fuelType,double pricePerDay) {
//        super(classCar, brand, model, gearBox, Traction, fuelType, pricePerDay);
//        this.features = "fara dotari";
//    }
    @Override
    public String getBrand() {
        return super.getBrand();
    }
    @Override
    public String getModel(){
        return super.getModel();
    }
    @Override
    public String getGearBox(){
        return super.getGearBox();
    }
    @Override
    public String getTraction(){
        return super.getTraction();
    }
    @Override
    public String getFuelType(){
        return super.getFuelType();
    }
    @Override
    public String getClassCar(){
        return super.getClassCar();
    }
    public String getFeatures() {
        return features;
    }
    @Override
    public double calculateRentalCost(int days){
        if(!getOneYearExperience())
            return days*getPricePerDay()+getPricePerDay()*0.3;
        else
            return days*getPricePerDay();
    }
}
