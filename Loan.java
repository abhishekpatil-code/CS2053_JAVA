// File: LoanDemo.java

// Interface
interface Loan {
    void getInterestRate(double rate);
    void calculateLoan(double amount, int years);
}

// HomeLoan class implementing Loan
class HomeLoan implements Loan {
    double interestRate;

    @Override
    public void getInterestRate(double rate) {
        this.interestRate = rate;
    }

    @Override
    public void calculateLoan(double amount, int years) {
        double total = amount + (amount * interestRate * years) / 100;
        System.out.println("Home Loan Amount: " + amount);
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("Total Payable after " + years + " years: " + total);
    }
}

// CarLoan class implementing Loan
class CarLoan implements Loan {
    double interestRate;

    @Override
    public void getInterestRate(double rate) {
        this.interestRate = rate;
    }

    @Override
    public void calculateLoan(double amount, int years) {
        double total = amount + (amount * interestRate * years) / 100;
        System.out.println("Car Loan Amount: " + amount);
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("Total Payable after " + years + " years: " + total);
    }
}

// Main class
public class LoanDemo {
    public static void main(String[] args) {
        Loan home = new HomeLoan();
        home.getInterestRate(6.5);
        home.calculateLoan(500000, 10);

        System.out.println();

        Loan car = new CarLoan();
        car.getInterestRate(8.0);
        car.calculateLoan(300000, 5);
    }
}
