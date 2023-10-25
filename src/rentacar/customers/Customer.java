package rentacar.customers;

public class Customer {
    private long cnp;
    private String lastName;
    private String firstName;
    private String adress;
    private long phoneNumber;
    private String eMail;
    
    public Customer(String firstName, String lastName, long cnp, String adress, long phoneNumber, String eMail)
    {
        this.firstName=firstName;
        this.lastName=lastName;
        this.cnp=cnp;
        this.adress=adress;
        this.phoneNumber=phoneNumber;
        this.eMail=eMail;
    }
    public long getCnp() {
        return this.cnp;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public long getPhoneNumber() {
        return this.phoneNumber;
    }

    public String geteMail() {
        return this.eMail;
    }
    public String getAdress()
    {
        return this.adress;
    }
}