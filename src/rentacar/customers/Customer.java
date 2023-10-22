package rentacar.customers;

public class Customer {
    private long CNP;
    private String name;
    private String prename;
    private long phoneNumber;
    private String eMail;
     private boolean oneYearExperience;

     public Customer(long CNP,String name,String prename,long phoneNumber,String eMail,boolean oneYearExperience)
     {
         this.CNP=CNP;
         this.name=name;
         this.prename=prename;
         this.phoneNumber=phoneNumber;
         this.eMail=eMail;
         this.oneYearExperience=oneYearExperience;
     }

    public long getCNP() {
        return CNP;
    }

    public String getName() {
        return name;
    }

    public String getPrename() {
        return prename;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String geteMail() {
        return eMail;
    }

    public boolean isOneYearExperience() {
        return oneYearExperience;
    }
}
