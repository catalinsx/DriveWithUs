package rentacar.vehicles;
//S:Clasa abstracta Vehicle
public abstract class Vehicle {
    private String registrationNumber;
    private String brand;
    private String model;
    private int year;
    private double dailyPrice;
//S:constructor public explicit
    public Vehicle(String registrationNumber, String brand, String model, int year, double dailyPrice)
    {
        this.registrationNumber = registrationNumber;
        this.brand=brand;
        this.model=model;
        this.year=year;
        this.dailyPrice=dailyPrice;
    }

    public String getRegistrationNumber(){
        return this.registrationNumber;
    }
    public void setRegistrationNumber(String registrationNumber){
        this.registrationNumber = registrationNumber;
    }
    public String getbrand(){
        return this.brand;
    }

    public String getModel(){
        return this.model;
    }

    public int getYear() {
        return this.year;
    }

    public double getDailyPrice(){
        return this.dailyPrice;
    }

    //S: metoda abstracta pentru calcularea chiriei
    public abstract double calculateRentalCost(int days);

    @Override
    public String toString(){
        return "Registration Number: " + registrationNumber + "\nbrand: " + brand + "\nModel: " + model + "\nYear: " + year + "\nDaily Price: " + dailyPrice;
    }
}
