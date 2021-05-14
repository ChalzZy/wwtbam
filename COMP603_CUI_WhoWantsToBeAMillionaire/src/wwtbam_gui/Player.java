package wwtbam_gui;

/**
 * Creates a new player for the game.
 *
 * @author Charles Monaghan & Jona Stevenson
 */
public class Player extends Bank {

    private String name;    // player name
    private int score;      // current score

    /**
     * Constructor for player.
     *
     * @param name player name
     * @param score initial score (set to 0)
     */
    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /**
     * @return name of current player
     */
    public String getName() {
        return name;
    }

    /**
     * Set name for player
     *
     * @param name current player name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return current score of player
     */
    public int getScore() {
        return score;
    }

    /**
     * Set score for player
     *
     * @param score current score
     */
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Player name: " + name + ", Score: " + score;
    }
}
