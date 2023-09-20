
package mstart.clientdavid;


public class BankAccountDavid {
    private String accountName, address, birthday, contactNumber;


    public BankAccountDavid (String name, String addr, String bday, String num) {
        this.setAccountName(name);
        this.setAddress(addr);
        this.setBirthday(bday);
        this.setContactNumber(num);
    }
    //getter
    public String getAccountName () {
        return this.accountName;
    }
    //setter
    public void setAccountName (String accountName) {
        this.accountName = accountName;
    }
    //getter
    public String getAddress () {
        return this.address;
    }
    //setter
    public void setAddress(String address) {
        this.address = address;
    }
    //getter
    public String getBirthday () {
        return this.birthday;
    }
    //setter
    public void setBirthday (String birthday) {
        this.birthday = birthday;
    }
    //getter
    public String getContactNumber() {
        return this.contactNumber;
    }
    //setter
    public void setContactNumber (String contactNumber) {
        this.contactNumber = contactNumber;
    } 
    //getClient Method
    public void getClientDetails (){
//        System.out.print("\n\n==========Client Details==========");
        System.out.printf("Name\t\t\t\t: %s", getAccountName());
        System.out.printf("\nAddress\t\t\t\t: %s", getAddress());
        System.out.printf("\nBirthday\t\t\t: %s", getBirthday());
        System.out.printf("\nContact Number\t\t\t: %s", getContactNumber());
    }
}
