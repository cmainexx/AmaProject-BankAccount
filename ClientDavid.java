
package mstart.clientdavid;
import java.util.Random;
import java.util.Scanner;

public class ClientDavid {
    static SavingsAccountDavid[] savingsAccounts = new SavingsAccountDavid[100];
    static Scanner scanner = new Scanner(System.in);
    static boolean accountCreated = false;
    
    public static void main(String[] args) {
        //only display main menu
        displayMainMenu();
    }
    //display main menu method
    public static void displayMainMenu() {
        boolean exit = false; //program will end IF and only IF number 7 is chosen.
        do {
            System.out.println("\n\nBank Main Menu");
            System.out.println("[1] New Account");
            System.out.println("[2] Balance Inquiry");
            System.out.println("[3] Deposit");
            System.out.println("[4] Withdraw");
            System.out.println("[5] Client Profile");
            System.out.println("[6] Close Account");
            System.out.println("[7] Exit");
            System.out.print("\nEnter a number\t\t\t: ");

            int chooseNum = scanner.nextInt();
            scanner.nextLine();
            switch (chooseNum) {
                case 1://calls new account method
                        newAccount();
                    break;
                case 2:
                    if (accountCreated) { //checks if account created is set to true before proceeding
                        balanceInquiry(); //calls balance inquiry method
                    }
                    else {
                        System.out.print("\nCreate an account first.");
                    }
                    break;
                case 3:
                    if (accountCreated) {//checks if account created is set to true before proceeding
                        deposit(); //calls deposit method
                    }
                    else {
                        System.out.print("\nCreate an account first.");
                    }
                    break;
                case 4:
                    if (accountCreated) {//checks if account created is set to true before proceeding
                        withdraw(); //calls withdraw method
                    }
                    else {
                        System.out.print("\nCreate an account first.");
                    }
                    break;
                case 5:
                    if (accountCreated) {//checks if account created is set to true before proceeding
                        clientProfile(); //calls clientprofile method
                    }
                    else {
                        System.out.print("\nCreate an account first.");
                    }
                    break;
                case 6:
                    if (accountCreated) {//checks if account created is set to true before proceeding
                        closeAccount();//calls close account method
                    }
                    else {
                        System.out.print("\nCreate an account first.");
                    }
                    break;
                case 7:
                    exit = true; //while loop will end, program will end
                    break;
            }
        }
        while (!exit);
    }
    //new account method
    public static void newAccount(){
        System.out.print("\n\n==========New Account==========");
        System.out.print("\nBank Form");
        System.out.print("\nEnter your Name\t\t\t: ");
        String cosName = scanner.nextLine();
        System.out.print("Enter your Address\t\t: ");
        String cosAddress = scanner.nextLine();
        System.out.print("Enter your Birthday\t\t: ");
        String cosBirthday = scanner.nextLine();
        System.out.print("Enter your Contact Number\t: ");
        String cosContactNum = scanner.nextLine();
        SavingsAccountDavid account = new SavingsAccountDavid(cosName, cosAddress, cosBirthday, cosContactNum);
        String accountNo = account.getAccountNumber();
        //generates a new account number if account number is already taken
        while (hasDuplicate(accountNo)){
            account.setAccountNumber();
        }
        while (!account.deposit(accountNo)) {
            account.deposit(accountNo);
        }
        int index = findBlank();
        if (index >= 0) {
            savingsAccounts[index] = account;
            accountCreated = true;//will only become true if the user creates an account first
            System.out.print("\nAccount created successfully.");
            System.out.printf("\nYour Account Number\t\t: %s", accountNo);
        }
    }
    //balance inquiry method
    public static void balanceInquiry() {
        System.out.print("\n\n==========Balance Inquiry==========");
        System.out.print("\nEnter your Account Number\t: ");
        String accountNumber = scanner.nextLine();
        int index = findAccountNumber(accountNumber);
        if (index >= 0) {
            //if index is a postive number
            //will find if index value is stored
            savingsAccounts[index].balanceInquiry(accountNumber);
        }
        else {
            //if index is not found
            System.out.print("\nAccount number does not exist.");
        }
    }
    //deposit method
    public static void deposit() {
        System.out.print("\n\n==========Deposit==========");
        System.out.print("\nEnter your Account Number\t: ");
        String accountNumber = scanner.nextLine();
        int index = findAccountNumber(accountNumber);
        if (index >= 0) {
            //if index is a postive number
            //will find if index value is stored
            savingsAccounts[index].deposit(accountNumber);
        }
        else {
            //if index is not found
            System.out.print("\nAccount number does not exist.");
        }
    }
    //withdraw method
    public static void withdraw() {
        System.out.print("\n\n==========Withdraw==========");
        System.out.print("\nEnter your Account Number\t: ");
        String accountNumber = scanner.nextLine();
        int index = findAccountNumber(accountNumber);
        if (index >= 0) {
            //if index is a postive number
            //will find if index value is stored
            savingsAccounts[index].withdraw(accountNumber);
        }
        else {
            //if index is not found
            System.out.print("\nAccount number does not exist.");
        }
    }
    //client profile method
    public static void clientProfile() {
        System.out.print("\n\n==========Client Profile==========");
        System.out.print("\nEnter your Account Number\t: ");
        String accountNumber = scanner.nextLine();
        int index = findAccountNumber(accountNumber);
        if (index >= 0) {
            //if index is a postive number
            //will find if index value is stored
            savingsAccounts[index].getClientDetails(accountNumber);
        }
        else {
            //if index is not found
            System.out.print("\nAccount number does not exist.");
        }
    }
    //close account method
    public static void closeAccount() {
        System.out.print("\n\n==========Close Account==========");
        System.out.print("\nEnter your Account Number\t: ");
        String accountNumber = scanner.nextLine();
        int index = findAccountNumber(accountNumber);
        if (index >= 0) {
            //if index is a postive number
            //will find if index value is stored
            savingsAccounts[index].closeAccount(accountNumber);
        }
        else {
            //if index is not found
            System.out.print("\nAccount number does not exist.");
        }
    }
    //find blank method
    public static int findBlank(){
        int index = -1;
        for (int i = 0; i<100; ++i){
            if (savingsAccounts[i] == null){
                index = i;
                break;
            }
        }
        return index;
    }
    //find account number    
    public static int findAccountNumber(String accountNumber) {
        int index = -1;
        for (int i = 0; i < 100; ++i) {
            if (savingsAccounts[i] != null) {
                if (savingsAccounts[i].getAccountNumber().equals(accountNumber)) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }
    //has dupliacte method
    //checks if account number to be generated is already taken
    public static boolean hasDuplicate(String accountNumber){
    boolean hasDuplicate = false;
        for (int i = 0; i < 100; ++i){
            if (savingsAccounts[i] != null){
                if(savingsAccounts[i].getAccountNumber().equals(accountNumber)){
                    hasDuplicate = true;
                    break;
                }
            }

        }
        return hasDuplicate;
    }
}
