public class Customer {

    private String firstName;
    private String lastName;

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}


class Account extends Customer {

    int balance;
    int accountNumber;

    public Account(String fName, String lName, int balance, int accountNumber) {
        setFirstName(fName);
        setLastName(lName);
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return this.balance;
    }

    public int getAccountNum() {
        return this.accountNumber;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("amount shall be positivee");
        }
    }

    public void withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else if (amount > balance) {
            System.out.println("The requested amount is fucking more than your balance");
            //requested amt is > than the fucking balance
        } else {
            System.out.println("negative balance error");
            //positive balance only
        }
    }
}

class Transaction {

    public void transfer(
        Account source,
        Account destination,
        int amountToTransfer
    ) {
        if (amountToTransfer > 0 && source.getBalance() >= amountToTransfer) {
            source.withdraw(amountToTransfer);
            destination.deposit(amountToTransfer);
            System.out.println(
                "Transfer Successful: $" +
                amountToTransfer +
                " from Account " +
                source.getAccountNum() +
                " to Account " +
                destination.getAccountNum()
            );
        } else if (amountToTransfer <= 0) {
            System.out.println("Transfer amount must be positive.");
        } else {
            System.out.println(
                "Insufficient funds in Account " +
                source.getAccountNum() +
                " to transfer $" +
                amountToTransfer
            );
        }
    }
}
