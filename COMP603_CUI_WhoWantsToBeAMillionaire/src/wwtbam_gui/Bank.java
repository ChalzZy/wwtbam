package wwtbam_gui;

/**
 * Create the bank for the player.
 *
 * @author Charles Monaghan & Jona Stevenson
 */
public class Bank {

    private int AvaiBank = 0;   // current bank balance

    /**
     * Constructor for bank class
     */
    public Bank() {
    }

    /**
     *
     * @return current bank balance.
     */
    public int getAvaiBank() {
        return AvaiBank;
    }

    /**
     * Add money to player bank
     *
     * @param moneyAmount
     */
    public void setMoney(int moneyAmount) {
        AvaiBank = moneyAmount;
    }
}
