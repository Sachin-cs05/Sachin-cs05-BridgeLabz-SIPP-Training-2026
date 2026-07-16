class BankAccount {
    private String accountNumber;
    private String holder;
    private double balance;
    private static int totalAccountsCreated = 0;

    public BankAccount(String accountNumber, String holder, double balance) {
        this.accountNumber = accountNumber;
        this.holder = holder;
        this.balance = balance;
        totalAccountsCreated++;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(holder + " deposited " + amount + ". Balance: " + balance);
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            return;
        }

        if (amount <= balance) {
            balance -= amount;
            System.out.println(holder + " withdrew " + amount + ". Balance: " + balance);
        } else {
            System.out.println("Withdrawal failed for " + holder + ". Insufficient balance.");
        }
    }

    public void getStatement() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holder);
        System.out.println("Current Balance: " + balance);
        System.out.println();
    }

    public static int getTotalAccountsCreated() {
        return totalAccountsCreated;
    }
}

public class BankAccountSimulation {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("ACC101", "Rahul", 5000);

        account.deposit(1000);
        account.withdraw(1500);
        account.deposit(700);
        account.withdraw(6000);
        account.deposit(500);


        System.out.println();
        account.getStatement();

        System.out.println("Total Accounts Created: " + BankAccount.getTotalAccountsCreated());
    }
}
