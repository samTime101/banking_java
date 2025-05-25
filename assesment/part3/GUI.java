import javax.swing.*;
import java.awt.event.*;
import java.util.LinkedList;

public class GUI extends JFrame {

    private Transaction transferObject = new Transaction();
    private StringBuilder sbAllData = new StringBuilder();
    private LinkedList<Account> globalAccounts;

    private JLabel showAllData;
    private JButton showAllButton, depositButton , withdrawButton , transferButton;
    private JTextField accDeposit, accWithdraw, acc1Transfer, acc2Transfer,depositInput, withdrawInput, transferAmount;

    
   
    public GUI(LinkedList<Account> accounts) {
    
        super("Banking System");
        setLayout(null);    
        globalAccounts = accounts;
        sbAllData.append("<html>Account Information:<br><br>");
        for (Account acc : globalAccounts) {
            sbAllData.append("Account Number: ").append(acc.getAccountNum()).append("<br>")
                     .append("Name: ").append(acc.getFirstName()).append(" ").append(acc.getLastName()).append("<br>")
                     .append("Balance: $").append(acc.getBalance()).append("<br><br>");
        }
        sbAllData.append("</html>");
        
        showAllButton = new JButton("Show All");
        showAllButton.setBounds(50, 50, 100, 30);
        
        depositButton = new JButton("Deposit");
        depositButton.setBounds(50, 100, 100, 30);
        
        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(50, 150, 100, 30);
        
        transferButton = new JButton("Transfer");
        transferButton.setBounds(50, 200, 100, 30);
        
        showAllData = new JLabel("<html>Click 'Show All' to display account information</html>");
        showAllData.setBounds(50, 300, 900, 300);

        accDeposit = new JTextField("Account Number");
        accDeposit.setBounds(160, 100, 120, 30);
        
        depositInput = new JTextField("Amount");
        depositInput.setBounds(290, 100, 120, 30);
        
        accWithdraw = new JTextField("Account Number");
        accWithdraw.setBounds(160, 150, 120, 30);
        
        withdrawInput = new JTextField("Amount");
        withdrawInput.setBounds(290, 150, 120, 30);
        
        acc1Transfer = new JTextField("From Account");
        acc1Transfer.setBounds(160, 200, 120, 30);
        
        acc2Transfer = new JTextField("To Account");
        acc2Transfer.setBounds(290, 200, 120, 30);
        
        transferAmount = new JTextField("Amount");
        transferAmount.setBounds(420, 200, 120, 30);
        
        add(showAllData);
        add(showAllButton);
        add(depositButton);
        add(withdrawButton);
        add(transferButton);
        add(accDeposit);
        add(depositInput);
        add(accWithdraw);
        add(withdrawInput);
        add(acc1Transfer);
        add(acc2Transfer);
        add(transferAmount);
        
        HandlerClass handler = new HandlerClass();
        
        showAllButton.addActionListener(handler);
        depositButton.addActionListener(handler);
        withdrawButton.addActionListener(handler);
        transferButton.addActionListener(handler);
    
    }
    
    private class HandlerClass implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        if (e.getSource() == showAllButton) {
            sbAllData.setLength(0);
            sbAllData.append("<html>Account Information:<br><br>");
            for (Account acc : globalAccounts) {
                sbAllData.append("Account Number: ").append(acc.getAccountNum()).append("<br>")
                         .append("Name: ").append(acc.getFirstName()).append(" ").append(acc.getLastName()).append("<br>")
                         .append("Balance: $").append(acc.getBalance()).append("<br><br>");
            }
            sbAllData.append("</html>");
            showAllData.setText(sbAllData.toString());
}

            
            if (e.getSource() == depositButton) {
                try {
                    int accountNum = Integer.parseInt(accDeposit.getText());
                    int amount = Integer.parseInt(depositInput.getText());
                    Account targetAccount = null;
                    
                    for (Account account : globalAccounts) {
                        if (account.getAccountNum() == accountNum) {
                            targetAccount = account;
                            break;
                        }
                    }
                    if (targetAccount != null && amount > 0) {
                        targetAccount.deposit(amount);
                        JOptionPane.showMessageDialog(null, 
                            "Successfully deposited $" + amount + " into account " + accountNum + 
                            ". New balance: $" + targetAccount.getBalance());
                            showAllButton.doClick(); 
                    } 
                    else if (amount <= 0) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid amount!");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Account not found!");
                    }
            
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers!");
                }
            }
            
            if (e.getSource() == withdrawButton) {
                try {
                    int accountNum = Integer.parseInt(accWithdraw.getText());
                    int amount = Integer.parseInt(withdrawInput.getText());
                    Account targetAccount = null;
                    for (Account account : globalAccounts) {
                        if (account.getAccountNum() == accountNum) {
                            targetAccount = account;
                            break;
                        }
                    }
                    if (targetAccount != null && targetAccount.getBalance() >= amount && amount > 0) {
                        targetAccount.withdraw(amount);
                        JOptionPane.showMessageDialog(null, 
                            "Successfully withdrew $" + amount + " from account " + accountNum + 
                            ". New balance: $" + targetAccount.getBalance());
                            showAllButton.doClick(); 
                    } else if (targetAccount == null) {
                        JOptionPane.showMessageDialog(null, "Account not found!");
                    } 
                    else if (amount <= 0) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid amount!");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Insufficient funds!");
                    }                    
                    

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers!");
                }
            }
            
            if (e.getSource() == transferButton) {
                try {

                    int fromAccountNum = Integer.parseInt(acc1Transfer.getText());
                    int toAccountNum = Integer.parseInt(acc2Transfer.getText());
                    int amount = Integer.parseInt(transferAmount.getText());
                    
                    Account fromAccount = null;
                    Account toAccount = null;

                    for (Account account : globalAccounts) {
                        if (account.getAccountNum() == fromAccountNum) {
                            fromAccount = account;
                        }
                        if (account.getAccountNum() == toAccountNum) {
                            toAccount = account;
                        }
                    }
                    if (fromAccount == null ){
                        JOptionPane.showMessageDialog(null, "From account not found!");
                        return;
                    }
                    if (toAccount == null ){
                        JOptionPane.showMessageDialog(null, "To account not found!");
                        return;
                    }
                    if (fromAccount.getBalance() < amount) {
                        JOptionPane.showMessageDialog(null, "Insufficient funds in account " + fromAccountNum + "!");
                        return;
                    }
                    if (amount <= 0) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid amount!");
                        return;
                    }
                    if (fromAccount == toAccount) {
                        JOptionPane.showMessageDialog(null, "Cannot transfer to the same account!");
                        return;
                    }

                        transferObject.transfer(fromAccount, toAccount, amount);
                        JOptionPane.showMessageDialog(null, 
                            "Successfully transferred $" + amount + " from account " + fromAccountNum + 
                            " to account " + toAccountNum + 
                            ".\nNew balances: Account " + fromAccountNum + ": $" + fromAccount.getBalance() + 
                            ", Account " + toAccountNum + ": $" + toAccount.getBalance());
                    
                            showAllButton.doClick();

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers!");
                }
            }
        }
    }
}