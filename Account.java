// File: AccountDemo.java

// Abstract class
abstract class Account {
    String accountHolder;
    double balance;

    Account(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Abstract method
    abstract void displayAccountType();

    // Concrete method
    void displayBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
}

// SavingsAccount class
class SavingsAccount extends Account {
    double interestRate;

    SavingsAccount(String accountHolder, double balance, double interestRate) {
        super(accountHolder, balance);
        this.interestRate = interestRate;
    }

    @Override
    void displayAccountType() {
        System.out.println("This is a Savings Account.");
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// CurrentAccount class
class CurrentAccount extends Account {
    double overdraftLimit;

    CurrentAccount(String accountHolder, double balance, double overdraftLimit) {
        super(accountHolder, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    void displayAccountType() {
        System.out.println("This is a Current Account.");
        System.out.println("Overdraft Limit: " + overdraftLimit);
    }
}

// Main class to test polymorphism
public class AccountDemo {
    public static void main(String[] args) {
        // Polymorphism: base class reference → derived class object
        Account acc1 = new SavingsAccount("Abhishek", 5000.0, 4.5);
        Account acc2 = new CurrentAccount("Ravi", 10000.0, 2000.0);

        System.out.println("--- Savings Account Details ---");
        acc1.displayAccountType();
        acc1.displayBalance();

        System.out.println("\n--- Current Account Details ---");
        acc2.displayAccountType();
        acc2.displayBalance();
    }
}
