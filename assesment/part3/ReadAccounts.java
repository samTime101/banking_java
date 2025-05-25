import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class ReadAccounts {
    public  BufferedReader reader;
    public  String url;
    
    public ReadAccounts(String URL) {
        this.url = URL;
        try {
            this.reader = new BufferedReader(new FileReader(URL));
        } catch (IOException e) {
            System.out.println("Error opening file: " + e.getMessage());
        }
    }

    public LinkedList<String> getFirstNames() {
        LinkedList<String> firstNames = new LinkedList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(url))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                firstNames.add(values[0].trim());
            }
        } catch (IOException e) {
            System.out.println("Error reading first names: " + e.getMessage());
        }
        
        return firstNames;
    }
    
    public LinkedList<String> getLastNames() {
        LinkedList<String> lastNames = new LinkedList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(url))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                lastNames.add(values[1].trim());
            }
        } catch (IOException e) {
            System.out.println("Error reading last names: " + e.getMessage());
        }
        
        return lastNames;
    }
    
    public LinkedList<Integer> getAccounts() {
        LinkedList<Integer> accounts = new LinkedList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(url))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                accounts.add(Integer.parseInt(values[2].trim()));
            }
        } catch (IOException e) {
            System.out.println("Error reading account numbers: " + e.getMessage());
        }
        
        return accounts;
    }
    
    public LinkedList<Integer> getBalances() {
        LinkedList<Integer> balances = new LinkedList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(url))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                balances.add(Integer.parseInt(values[3].trim()));
            }
        } catch (IOException e) {
            System.out.println("Error reading balances: " + e.getMessage());
        }
        
        return balances;
    }
}