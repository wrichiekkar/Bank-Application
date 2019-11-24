/*
 * Wrichiek Kar
 * 500830125
 * COE528
 */
package bankapplication;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author karwr
 */
/**
 * Customer class is responsible for filling customer object with required
 * fields which is used to maintain login throughout controllers and change
 * mutable parameters such as tier and balance
 *
 * Mutable fields = Tier, balance 
 * Immutable fields = File, username, password
 *
 * AF(c) = customer has mutable fields-tier and balance, immutable fields File,
 * username, password
 *
 * Rep Invariant: Customer object must have a username is not null or empty,
 * must have balance greater than or equal to 0 and tier fields.
 */
public class Customer {

    private Tier tier;
    public double balance;
    private String password;
    String username;

    /**
     * Effects: Builds the customer object from file Requires: The name of the
     * user
     */
    public Customer(String name) {
        String file = name + ".txt";
        BufferedReader reader;
        username = name;

        try {
            reader = new BufferedReader(new FileReader(file));
            password = reader.readLine();
            balance = Double.parseDouble(reader.readLine());
            String CurTier = reader.readLine();

            if (CurTier.toLowerCase().equals("silver")) {
                tier = new Silver();
            } else if (CurTier.toLowerCase().equals("gold")) {
                tier = new Gold();
            } else if (CurTier.toLowerCase().equals("platinum")) {
                tier = new Platinum();
            } else {
                System.out.println("Invalid Tier");
            }

        } catch (Exception e) {
            System.out.println("Error with customer file");
        }
    }

    /**
     * Effects: returns current balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Effects: Changes the balance Requires: The new balance as double
     * Modifies: balance of object customer
     */
    public void setBalance(double value) {
        this.balance = value;
    }

    /**
     * Effects: Changes the tier Requires: The new tier as an object of tier
     * Modifies: tier of object customer
     */
    public void setTier(Tier t) {
        this.tier = t;
    }

    /**
     * Effects: Returns the current tier
     */
    public Tier getTier() {
        return tier;
    }

    /**
     * Effects: Returns the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Effects: Updates the file with new password, balance, tier Requires: The
     * new tier as an object of tier Modifies: tier of object customer
     */
    public void updateFile(String name) {
        String file = name + ".txt";
        try {
            tier.changeTier(this);
            PrintWriter writer = new PrintWriter(file, "UTF-8");
            writer.println(password);
            writer.println(balance);
            writer.println(tier);
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            System.out.println("Error updating file");
        }
    }

    /**
     * Effects: Returns true if the customer object is valid, else false.
     * Requires: An object of type customer
     */
    public Boolean repOK(Customer customer) {
        String Name = customer.getUsername();
        Tier tier = customer.getTier();
        if (Name.isEmpty() || Name.equals("") || !tier.equals("Silver") || !tier.equals("Gold") || !tier.equals("Platinum")) {
            return false;
        } else {
            return true;
        }
    }
    /**
     * Effects: Returns Username, Tier, Balance.
     */
    @Override
    public String toString() {
        return "Username: " + getUsername()
                + " Tier: " + tier
                + " Balance: $" + getBalance();
    }
}
