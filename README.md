# AmaProject-BankAccount

Write a Java program with the following specifications:
1. Define the following attributes and methods of the BankAccount class:
      Attributes: accountName, address, birthday, contactNumber
      Constructor
      Setter and Getter methods
      getClientDetails method

2. Define the following attributes and methods of the SavingsAccount class:
      Attribute: accountNo, balance, interestRate
      Constructor
      Setter and Getter methods
      balanceInquiry method
      deposit method
      withdraw method
      validateAcctNumber method
      closeAccount method

3. Note that the SavingsAccount class will be inherited from the BankAccount class.

4. Define the following methods in the Client class:
      main method
      displayMainMenu method
      other applicable methods

5.Note that the object to be instantiated in the main method is an object array.  
      For example: SavingsAccount[ ] sa = new SavingsAccount[100];

6. The program should have the main menu as shown below and will always loop back to the main menu after each transaction.
      JBank Main Menu
      [1] New Account
      [2] Balance Inquiry
      [3] Deposit
      [4] Withdraw
      [5] Client Profile
      [6] Close Account
      [7] Exit

7. The New Account option should implement the following:
      Input client details: name, address, birthday, and contact number
      Input the initial deposit of not less than PhP 5,000
      Generate a four-digit account number randomly

8. The Balance Inquiry option should implement the following:
      Input the account number and validate
      If the account number is valid, display the client name and current balance
   
9. The Deposit option should implement the following:
      Input the account number and validate
      If the account number is valid, input the amount of deposit of not less than Php 100
      Compute and update the current balance as follows:
            Balance+=amount of deposit
            Interest=5% of balance
            Balance+=interest

10. The Withdraw option should implement the following:
      Input the account number and validate
      If the account number is valid, input the amount to be withdrawn, not less than Php 100, not greater than the balance, and an amount of Php 5,000 should be maintained (maintaining balance)
      Compute and update the balance as follows: 
            Balance-=amount withdrawn

11. The Client Profile option should implement the following:
      Input the account number and validate
      If account number is valid, display the client details including the current balance.

12. The Close Account option should implement the following:
      Input the account number and validate
      If account number is valid, confirm if the user closes the account then set the balance to zero
      Otherwise, go back to the main menu

13. The Exit option terminates the program.

14. The following Main Menu validations should be implemented:
      Validate the transaction code by the user
      The user should not be allowed to perform transactions 2 to 5, unless a new account has been created
      Apply all input validations.

