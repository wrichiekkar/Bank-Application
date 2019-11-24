/*
 * Wrichiek Kar
 * 500830125
 * COE528
 */
package bankapplication;

/**
 *
 * @author karwr
 */
public class Gold implements Tier {

    int fee = 10;
    //Change tier object if balance changes
    @Override
    public void changeTier(Customer customer) {
        double balance = customer.getBalance();
        if (balance < 10000) {
            customer.setTier(new Silver());
        } else if (balance < 20000) {
            customer.setTier(new Gold());
        } else {
            customer.setTier(new Platinum());
        }
    }

    @Override
    public int getFee() {
        return fee;
    }

    @Override
    public String toString() {
        return "gold";
    }
}
