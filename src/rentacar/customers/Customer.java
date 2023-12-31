package rentacar.customers;

import java.io.Serializable;

public class Customer implements Serializable {
    private String cnp;
    private String lastName;
    private String firstName;
    private String address;
    private String phoneNumber;
    private String eMail;
    
    public Customer(String firstName, String lastName, String cnp, String address, String phoneNumber, String eMail)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cnp = cnp;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
    }
    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName + ", CNP: " + cnp + ", Adresa: " + address + ", Numar de telefon: " +
                phoneNumber + ", E-mail: " + eMail;
    }

}
