// File: BankDemo.java

import java.util.Scanner;

// Custom Exception
class LowBalanceException extends Exception {
    public LowBalanceException(String message) {
        super(message);
    }
}

// BankAccount class
class BankAccount {
    String accountHolder;
    double balance;

    BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Withdraw method with custom exception
    void withdraw(double amount) throws LowBalanceException {
        if (amount > balance) {
            throw new LowBalanceException("Withdrawal failed: Insufficient balance!");
        }
        balance -= amount;
        System.out.println("Withdrawal successful! Remaining balance: " + balance);
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful! Current balance: " + balance);
    }
}

// Main class
public class BankDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Creating a bank account
        BankAccount account = new BankAccount("Abhishek", 5000.0);

        System.out.println("Welcome " + account.accountHolder + "! Your balance is: " + account.balance);

        // Deposit money
        System.out.print("Enter amount to deposit: ");
        double depositAmount = sc.nextDouble();
        account.deposit(depositAmount);

        // Withdraw money with exception handling
        System.out.print("Enter amount to withdraw: ");
        double withdrawAmount = sc.nextDouble();
        try {
            account.withdraw(withdrawAmount);
        } catch (LowBalanceException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Transaction completed. Thank you!");
        }

        sc.close();
    }
}
