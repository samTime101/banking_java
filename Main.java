
public class Main {
    public static void main(String[] args) {
        Account account1 = new Account("Jeffrey", "Ting", 2000, 1);
        Account account2 = new Account("Hiran", "Patel", 1000, 2);

        System.out.println("Initial Balance of Account " + account1.getAccountNum() + ": $" + account1.getBalance());
        System.out.println("Initial Balance of Account " + account2.getAccountNum() + ": $" + account2.getBalance());

        account1.deposit(250);

        System.out.println("Balance after deposit in Account " + account1.getAccountNum() + ": $" + account1.getBalance());

        account2.withdraw(500);

        System.out.println("Balance after withdraw in Account " + account2.getAccountNum() + ": $" + account2.getBalance());

        Transaction t  = new Transaction();
        t.transfer(account1,account2,250);

        System.out.println("Balance after transfer in Account " + account1.getAccountNum() + ": $" + account1.getBalance());
        System.out.println("Balance after transfer in Account " + account2.getAccountNum() + ": $" + account2.getBalance());

    }
}
