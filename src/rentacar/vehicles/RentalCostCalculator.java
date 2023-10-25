package rentacar.vehicles;

public interface RentalCostCalculator {
    double calculateRentalCost(int days);

//    default void displayRentalInfo() {
//        System.out.println("Rental Cost: $" + calculateRentalCost());
//    }
}
