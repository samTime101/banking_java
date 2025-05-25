import java.util.LinkedList;
import javax.swing.JFrame;

public class Main {
    
    public static String file = "Accounts.csv";
    public static ReadAccounts readAccounts = new ReadAccounts(file);
    public static LinkedList<String> firstNames = readAccounts.getFirstNames();
    public static LinkedList<String> lastNames = readAccounts.getLastNames();
    public static LinkedList<Integer> accountList = readAccounts.getAccounts(); 
    public static LinkedList<Integer> balanceList = readAccounts.getBalances(); 
    public static LinkedList<Account> accounts = new LinkedList<>();
    public static GUI gui;

    public static void main(String[] args) {
        for (int i = 0; i < firstNames.size(); i++) {
            accounts.add(new Account(
                firstNames.get(i),
                lastNames.get(i),
                accountList.get(i),
                balanceList.get(i)
            ));
        }

        gui = new GUI(accounts);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(1000, 1000);
        gui.setVisible(true);
    }
}
