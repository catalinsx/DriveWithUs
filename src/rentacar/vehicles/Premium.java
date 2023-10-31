package rentacar.vehicles;

import java.io.Serializable;

public class Premium extends Car implements Serializable {
    private String features;
    private String imageLink;
    public Premium(String classCar,String brand,String model, String gearBox,String traction,String fuelType,double pricePerDay,
                   String imageLink,String features) {
        super(classCar, brand, model, gearBox, traction, fuelType, pricePerDay);
        this.imageLink = imageLink;
        this.features = features;
    }
    public Premium(String classCar,String brand,String model, String gearBox,String traction,String fuelType,double pricePerDay, String imageLink) {
        super(classCar, brand, model, gearBox, traction, fuelType, pricePerDay);
        this.features = "fara dotari";
        this.imageLink = imageLink;
    }
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
    public String getImageLink() {
        return imageLink;
    }
    @Override
    public double calculateRentalCost(int days){
        if(!getOneYearExperience())
            return days*getPricePerDay()+getPricePerDay()*0.2;
        else
            return days*getPricePerDay();
    }
}
