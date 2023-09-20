
package mstart.clientdavid;

import java.util.Scanner;
import java.util.Random;

class SavingsAccountDavid extends BankAccountDavid {
    Scanner scanner = new Scanner(System.in);
    private String accountNumber; 
    private double balance;
    private double interestRate = 0.05;
    private boolean initialDeposit = true;
    //array
    public SavingsAccountDavid(String name, String addr, String num, String bday){
        super(name, addr, num, bday);
        this.setAccountNumber();
    }
    //getter
    public String getAccountNumber() {
        return this.accountNumber;
    }
    //setter
    public void setAccountNumber() {
        Random random = new Random();
        //generates a random account number
        //%04d makes the number 0 appear before another number
        String accountNumber = String.format("%04d", random.nextInt(10000));
        this.accountNumber = accountNumber;
    }
    //getter
    public double getBalance() {
        return this.balance;
    }
    //setter
    public void setBalance(double balance) {
        this.balance = balance;
    }
    //getter
    public double getInterestRate() {
        return this.interestRate;
    }
    //setter
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    //balance inquiry method
    public void balanceInquiry (String accountNumber) {
        if (this.validateAcctNumber(accountNumber)) { 
//            System.out.print("\n\n==========Balance==========");
            System.out.printf("Name\t\t\t\t: %s", super.getAccountName());
            System.out.printf("\nCurrent Balance\t\t\t: %s", this.getBalance());
        }
    }
   //deposit method 
    public boolean deposit (String accountNumber) {
        boolean successful = false;
        if (this.validateAcctNumber(accountNumber)) {
//            System.out.print("\n\n==========Deposit==========");
            //if it is the users first deposit
            if (initialDeposit) {
                System.out.print("\nEnter amount of initial deposit\t: ");
                double amount = scanner.nextDouble();
                if (amount < 5000) {
                    System.out.print("\nInitial deposit should not be less than Php 5,000");
                }
                else if (amount >= 5000) {
                    this.setBalance(amount);
                    successful = true;
                    this.initialDeposit = false;
                }
            }
            // if it is NOT the users first deposit
            else if (!initialDeposit) {
                System.out.print("Enter amount of deposit\t\t: ");
                double amount = scanner.nextDouble();
                if (amount < 100) {
                    System.out.print("\nDeposit an amount of not less than Php 100.");
                }
                else if (amount >= 100) {
                    this.balance += amount;
                    double interest = this.interestRate * this.balance;
                    this.balance += interest;
                    System.out.print("\nDeposit successful.");
                    System.out.printf("\nCurrent Balance\t\t\t: %s", this.getBalance());
                    successful = true;
                }
            }
        }
        return successful;
    }
    //withdraw method
    public void withdraw (String accountNumber) {
        if (this.validateAcctNumber(accountNumber)) {
//            System.out.print("\n\n==========Withdraw==========");
            System.out.print("Enter withdraw amount\t\t: ");
            double amount = scanner.nextDouble();
            //amount to withdraw should not be less than 100
            if (amount < 100) {
                System.out.print("\nWithdraw an amount of not less than Php 100.");
            }
            //amount is more than 100 but the balance after withdrawal will be less than 5000
            else if (amount >= 100 && this.balance - amount < 5000) {
                System.out.print("\nAn amount of Php 5,000 should be maintained.");
                System.out.println("\nWithdraw Cancelled.");
                System.out.println("Redirecting to Main Menu");
            }
            //amount is more than 100 and total balance after withdrawal is 5000 or more
            else if (amount >= 100 && this.balance - amount >= 5000) {
                this.balance -= amount;
                System.out.print("\nWithdraw successful.");
                System.out.printf("\nCurrent Balance\t\t\t: %s", this.getBalance());
//                this.balanceInquiry(accountNumber);
            }
        }
    }
    // client details method
    public void getClientDetails (String accountNumber) {
        if (this.validateAcctNumber(accountNumber)) {
            super.getClientDetails();
            System.out.printf("\nCurrent Balance\t\t\t: %s", this.getBalance());
        }
    }
    // validate acc number method
    public boolean validateAcctNumber (String accountNumber) {
        return accountNumber.equals(this.accountNumber);
    }
   //close account method    
    //deletes the array of the found account number
    public void closeAccount (String accoountNumber) {
        if (this.validateAcctNumber(accountNumber)) {
            String prompt;
            scanner.nextLine();
            System.out.print("\nAre you sure you want to close your account? (Y/N) ");
            prompt = scanner.nextLine();
            if (prompt.toLowerCase().equals("y")) {
                this.setBalance(0);
                System.out.print("\nAccount closed.");
            }
//            System.out.print("\nAccount closed.");
        }
    }
}


