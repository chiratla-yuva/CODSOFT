import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// BankAccount class to store account details and provide methods to modify balance
class BankAccount {
    private String accountHolder;
    private int pin;
    private double balance;
    private double dailyWithdrawalLimit = 5000; // Daily withdrawal limit
    private double amountWithdrawnToday = 0;

    // Constructor to initialize account details
    public BankAccount(String accountHolder, int pin, double balance) {
        this.accountHolder = accountHolder;
        this.pin = pin;
        this.balance = balance;
    }

    // PIN verification method
    public boolean verifyPin(int enteredPin) {
        return this.pin == enteredPin;
    }

    // Method to deposit amount
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Amount deposited successfully. New balance: $" + balance);
        } else {
            System.out.println("❌ Invalid deposit amount.");
        }
    }

    // Method to withdraw amount
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("❌ Insufficient balance.");
        } else if (amount > dailyWithdrawalLimit) {
            System.out.println("❌ Withdrawal amount exceeds the daily limit of $" + dailyWithdrawalLimit);
        } else if (amount + amountWithdrawnToday > dailyWithdrawalLimit) {
            System.out.println("❌ You've reached your daily withdrawal limit.");
        } else {
            balance -= amount;
            amountWithdrawnToday += amount;
            System.out.println("✅ Amount withdrawn successfully. Remaining balance: $" + balance);
        }
    }

    // Method to check balance
    public void checkBalance() {
        System.out.println("💰 Current balance: $" + balance);
    }

    // Method to reset daily withdrawal limit at the end of the day
    public void resetDailyWithdrawalLimit() {
        amountWithdrawnToday = 0;
    }

    // Getters for account holder name and balance
    public String getAccountHolder() {
        return accountHolder;
    }
}

public class ATMInterface {
    private static Map<Integer, BankAccount> accounts = new HashMap<>(); // Store multiple accounts
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Create sample accounts
        accounts.put(1234, new BankAccount("John Doe", 1111, 10000));
        accounts.put(5678, new BankAccount("Jane Smith", 2222, 20000));

        System.out.println("🏦 Welcome to the ATM!");

        // Ask for account number
        System.out.print("👉 Enter your account number: ");
        int accountNumber = sc.nextInt();

        // Check if account exists
        if (!accounts.containsKey(accountNumber)) {
            System.out.println("❌ Invalid account number.");
            return;
        }

        BankAccount currentAccount = accounts.get(accountNumber);

        // PIN verification
        System.out.print("🔑 Enter your PIN: ");
        int enteredPin = sc.nextInt();

        if (!currentAccount.verifyPin(enteredPin)) {
            System.out.println("❌ Incorrect PIN. Access denied!");
            return;
        }

        System.out.println("\n✅ Welcome, " + currentAccount.getAccountHolder() + "!");

        // Main menu loop
        boolean running = true;
        while (running) {
            System.out.println("\n📋 ATM MENU:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("👉 Choose an option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // Deposit option
                    System.out.print("💵 Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    currentAccount.deposit(depositAmount);
                    break;

                case 2:
                    // Withdraw option
                    System.out.print("💳 Enter withdrawal amount: ");
                    double withdrawAmount = sc.nextDouble();
                    currentAccount.withdraw(withdrawAmount);
                    break;

                case 3:
                    // Check balance option
                    currentAccount.checkBalance();
                    break;

                case 4:
                    // Exit
                    System.out.println("\n👋 Thank you for using the ATM. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("❌ Invalid option. Try again.");
                    break;
            }
        }

        // Close the scanner to avoid memory leaks
        sc.close();
    }
}
