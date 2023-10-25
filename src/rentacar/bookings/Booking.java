package rentacar.bookings;
import rentacar.vehicles.*;
import rentacar.customers.Customer;

public class Booking {
    private String pickUpDate;
    private String dropDownDate;
    private Vehicle vehicle;
    private double price;
    private int days;
    private Customer customer;
    public Booking(String pickUpDate, String dropDownDate, Vehicle vehicle,int days,Customer customer) {
        this.pickUpDate = pickUpDate;
        this.dropDownDate = dropDownDate;
        this.vehicle = vehicle;
        this.days=days;
        this.customer = customer;
        this.price = vehicle.calculateRentalCost(days);
    }
    public String getPickUpDate() {
        return pickUpDate;
    }
    public String getDropDownDate() {
        return dropDownDate;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public double getPrice() {
        return price;
    }
    public int getDays() {
        return days;
    }
    public void setPrice()
    {
    }
}
