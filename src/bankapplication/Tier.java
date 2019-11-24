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
public interface Tier {

    int fee = 0;

    public abstract void changeTier(Customer customer);

    public abstract int getFee();
}

