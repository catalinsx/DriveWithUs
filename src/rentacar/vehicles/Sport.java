package rentacar.vehicles;

public class Sport extends Car {
    private String features;
    public Sport(String classCar,String brand,String model, boolean gearBox,String Traction,String fuelType,double pricePerDay,boolean oneYearExperience,String features) {
        super(classCar, brand, model, gearBox, Traction, fuelType, pricePerDay,oneYearExperience);
        this.features = features;
    }
    public Sport(String classCar,String brand, String model, boolean gearBox,String Traction,String fuelType,double pricePerDay,boolean oneYearExperience) {
        super(classCar, brand, model, gearBox, Traction, fuelType, pricePerDay,oneYearExperience);
        this.features = "fara dotari";
    }
    public String getFeatures() {
        return features;
    }
    @Override
    public double calculateRentalCost(int days){
        if(!getOneYearExperience())
            return days*getPricePerDay()+getPricePerDay()*0.25;
        else
            return days*getPricePerDay();
    }
}
