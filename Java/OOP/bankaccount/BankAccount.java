package OOP.bankaccount;


import java.util.Random;

public class BankAccount {


    private static int numberOfAccounts = 0;
    private static double totalSavingAccountsBalance = 0;
    private static double totalCheckingAccountsBalance = 0;
    private String accountNumber;
    private double checkingBalance;
    private double savingBalance;

    public BankAccount() {
        accountNumber = generateRandom10();
        numberOfAccounts++;
    }

    public BankAccount(String accountNumber, double checkingBalance, double savingBalance) {
        this.accountNumber = accountNumber;
        this.checkingBalance = checkingBalance;
        this.savingBalance = savingBalance;
        numberOfAccounts++;
    }

    public static int getNumberOfAccounts() {
        return numberOfAccounts;
    }

    public static void setNumberOfAccounts(int numberOfAccounts) {
        BankAccount.numberOfAccounts = numberOfAccounts;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    private void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    private void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    private void setSavingBalance(double savingBalance) {
        this.savingBalance = savingBalance;
    }


    public void depositToSavingAccount(double amount) {
        setSavingBalance(getSavingBalance() + amount);
        totalSavingAccountsBalance += amount;
    }

    public void depositToCheckingAccount(double amount) {
        setCheckingBalance(getCheckingBalance() + amount);
        totalCheckingAccountsBalance += amount;
    }

    public void withdrawFromSavingAccount(double amount) {
        if (amount < getSavingBalance()) {
            setSavingBalance(getSavingBalance() - amount);
            totalSavingAccountsBalance -= amount;
        } else {
            System.out.println("Not Enough Credit in Saving Account to Make Deposit");
        }
    }

    public void withdrawFromCheckingAccount(double amount) {
        if (amount < getCheckingBalance()) {
            setCheckingBalance(getCheckingBalance() - amount);
            totalCheckingAccountsBalance -= amount;
        } else {
            System.out.println("Not Enough Credit in Checking Account to Make Deposit");
        }
    }

    private static String generateRandom10() {
        Random r = new Random();
        StringBuilder sb = new StringBuilder(10);
        int val = 0;
        for (int i = 0; i < 10; i++) {
            val = r.nextInt(10);
            sb.append(val);
        }
        return sb.toString();
    }

    public static double getTotalSavingAccountsBalance() {
        return totalSavingAccountsBalance;
    }

    public static double getTotalCheckingAccountsBalance() {
        return totalCheckingAccountsBalance;
    }

    public static void displayTotalBalances() {
        System.out.println("Saving Accounts Total Balance is: " + getTotalSavingAccountsBalance());
        System.out.println("Checking Accounts Total Balance is: " + getTotalCheckingAccountsBalance());
    }
}
