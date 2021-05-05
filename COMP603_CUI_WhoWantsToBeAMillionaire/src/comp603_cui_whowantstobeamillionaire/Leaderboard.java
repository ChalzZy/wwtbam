package comp603_cui_whowantstobeamillionaire;

import java.io.FileWriter;

/**
 * initializes the Leaderboard class. Allows to append scores to Leaderboard.
 *
 * @author Charles Monaghan & Jona Stevenson
 */
public class Leaderboard {

    /**
     * Constructor for Leaderboard class.
     */
    public Leaderboard() {
    }

    /**
     * Add player to the leaderboard.
     *
     * @param name
     * @param bank
     */
    public void appendLeaderboard(String name, int bank) {
        // Open file in append mode
        try {
            FileWriter fw = new FileWriter("src/comp603_cui_whowantstobeamillionaire/leaderboard.txt", true);

            // Append item
            fw.append("\n" + name + "," + bank);

            // Close the file
            fw.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
