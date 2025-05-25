public class Account extends Customer {
    private int balance;
    private int accountNumber;

    public Account(String FName, String LName, int accNum,int accBal) {
        setFirstName(FName);
        setLastName(LName);
        this.balance = accBal;
        this.accountNumber = accNum;
    }

    public int getBalance() {
        return balance;
    }

    public int getAccountNum() {
        return accountNumber;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }
}
