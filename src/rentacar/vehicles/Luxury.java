package rentacar.vehicles;

public class Luxury extends Car {
    private String features;
    public Luxury(String classCar,String brand,String model, boolean gearBox,String Traction,String fuelType,double pricePerDay,String features) {
        super(classCar, brand, model, gearBox, Traction, fuelType, pricePerDay);
        this.features = features;
    }
    public Luxury(String classCar,String brand,String model, boolean gearBox,String Traction,String fuelType,double pricePerDay) {
        super(classCar, brand, model, gearBox, Traction, fuelType, pricePerDay);
        this.features = "fara dotari";
    }
    public String getFeatures() {
        return features;
    }
    @Override
    public double calculateRentalCost(int days){
        if(!oneYearExperience)
            return days*getPricePerDay()+getPricePerDay()*0.3;
        else
            return days*getPricePerDay();
    }
}
