package rentacar.vehicles;

import java.io.Serializable;

public class Premium extends Car implements Serializable {
    private String features;
    public Premium(String classCar,String brand,String model, String gearBox,String traction,String fuelType,double pricePerDay) {
        super(classCar, brand, model, gearBox, traction, fuelType, pricePerDay);
     //   this.features = features; // am scos feature pt moment
    }
//    public Premium(String classCar,String brand,String model, boolean gearBox,String Traction,String fuelType,double pricePerDay,boolean oneYearExperience) {
//        super(classCar, brand, model, gearBox, Traction, fuelType, pricePerDay,oneYearExperience);
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
            return days*getPricePerDay()+getPricePerDay()*0.2;
        else
            return days*getPricePerDay();
    }
}
