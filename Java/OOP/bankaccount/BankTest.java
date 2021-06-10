package OOP.bankaccount;

public class BankTest {
    public static void main(String[] args) {

        BankAccount b1 = new BankAccount();
        BankAccount b2 = new BankAccount();
        b2.depositToSavingAccount(1000);
        b1.depositToSavingAccount(350.0);

        //Account Number
        System.out.println("Account Number is : " + b1.getAccountNumber());

        //Deposit/Withdraw on Checking Account Tests
        System.out.println("Deposit/Withdraw on Checking Account Tests");
        b1.depositToCheckingAccount(5000.5);
        b1.withdrawFromCheckingAccount(100);
        System.out.println(b1.getCheckingBalance());

        //Deposit Withdraw on Saving Account Tests
        System.out.println("Deposit Withdraw on Saving Account Tests");
        b1.depositToSavingAccount(100);
        b1.withdrawFromSavingAccount(5500);
        System.out.println(b1.getSavingBalance());

        //Number Of BankAccounts
        System.out.println("Number of BankAccounts: " + BankAccount.getNumberOfAccounts());

        //Bank Account Balances
        BankAccount.displayTotalBalances();
    }
}
