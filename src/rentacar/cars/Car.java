package rentacar.cars;

public class Car extends Vehicle{
    private int numberOfSeats;
    private boolean isAutomatic;
    public Car(String registrationNumber, String brand, String model, int year, double dailyPrice, int numberOfSeats, boolean isAutomatic) {
        super(registrationNumber, brand, model, year, dailyPrice);
        this.numberOfSeats = numberOfSeats;
        this.isAutomatic = isAutomatic;
    }
    @Override
    public double calculateRentalCost(int days){
        return days*getDailyPrice();
    }
}
