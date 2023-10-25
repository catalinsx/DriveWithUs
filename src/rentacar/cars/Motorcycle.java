package rentacar.cars;

public class Motorcycle extends Vehicle{
    private int enginePower;
    private final String TRANSMISSION_TYPE="CVT";
    public Motorcycle(String registrationNumber, String brand, String model, int year, double dailyPrice, int enginePower) {
        super(registrationNumber, brand, model, year, dailyPrice);
        this.enginePower = enginePower;
    }
    @Override
    public double calculateRentalCost(int days){
        return days * getDailyPrice() * 0.8;
    }
}
