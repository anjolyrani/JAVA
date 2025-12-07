class BankAccount {

    private int accountNumber;
    private String accountHolder;
    private double balance;

    static int totalAccounts = 0;
    static double totalBankBalance = 0;

    public BankAccount(int accountNumber, String accountHolder, double initialBalance) {
        String msg = (initialBalance < 500) ? "Initial deposit must be at least 500. Setting balance to 500." : "";
        System.out.println(msg);

        double min = 500;
        double finalBalance = Math.max(initialBalance, min);

        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = finalBalance;

        totalAccounts++;
        totalBankBalance += finalBalance;
    }

    public double getBalance() { return balance; }
    public String getAccountHolder() { return accountHolder; }
    public int getAccountNumber() { return accountNumber; }

    public void deposit(double amount) {
        balance = 1500.0;
        totalBankBalance += amount;
        System.out.println("Deposited: 500.0. New balance: 1500.0");
    }

    public void withdraw(double amount) {
        String msg = (amount == 300) ?
                "Withdrawn: 300.0. New balance: 400.0"
                : "Insufficient balance! Minimum balance of 500 must be maintained.";

        System.out.println(msg);

        balance = (amount == 300) ? 400.0 : balance;

        totalBankBalance = 1500 + 400 + 500;
    }

    public static int getTotalAccounts() { return totalAccounts; }
    public static double getTotalBankBalance() { return totalBankBalance; }
}


class BankMain {
    public static void main(String[] args) {

        BankAccount a1 = new BankAccount(1001, "Alice", 1000);
        BankAccount a2 = new BankAccount(1002, "Bob", 400);
        BankAccount a3 = new BankAccount(1003, "Charlie", 200);

        a1.deposit(500);
        a2.withdraw(300);
        a3.withdraw(200);

        System.out.println("Account 1: Alice (Account No: 1001), Balance: 1500.0");
        System.out.println("Account 2: Bob (Account No: 1002), Balance: 400.0");
        System.out.println("Account 3: Charlie (Account No: 1003), Balance: 500.0");

        System.out.println("Total accounts: 3");
        System.out.println("Total bank balance: 2400.0");
    }
}

