abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }

    public abstract double calculateInterest();
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }
}

class CurrentAccount extends BankAccount {
    private double monthlyBonusRate;

    public CurrentAccount(String accountNumber, String holderName, double balance, double monthlyBonusRate) {
        super(accountNumber, holderName, balance);
        this.monthlyBonusRate = monthlyBonusRate;
    }

    public double getMonthlyBonusRate() {
        return monthlyBonusRate;
    }

    public void setMonthlyBonusRate(double monthlyBonusRate) {
        this.monthlyBonusRate = monthlyBonusRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * monthlyBonusRate / 100;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount("SB101", "Neha", 20000, 4.5);
        CurrentAccount currentAccount = new CurrentAccount("CA202", "Rahul", 15000, 2.0);

        savingsAccount.deposit(5000);
        savingsAccount.withdraw(2000);

        currentAccount.deposit(3000);
        currentAccount.withdraw(1000);

        System.out.println("Savings Account Details");
        savingsAccount.displayAccountDetails();
        System.out.println("Calculated Interest: " + savingsAccount.calculateInterest());

        System.out.println();

        System.out.println("Current Account Details");
        currentAccount.displayAccountDetails();
        System.out.println("Calculated Interest: " + currentAccount.calculateInterest());
    }
}
