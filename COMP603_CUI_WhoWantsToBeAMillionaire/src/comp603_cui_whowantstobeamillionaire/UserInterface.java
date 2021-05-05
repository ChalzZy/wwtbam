package comp603_cui_whowantstobeamillionaire;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Displays the user interface for main menu, leaderboard and exit game.
 *
 * @author Jona Stevenson & Charles Monaghan
 */
public class UserInterface {

    private Scanner scanner;
    private QuestionManager qm;
    private Leaderboard lb;
    private Bank bank;
    private static String name;
    private Player newPlayer;
    private static final String LEADERBOARD = "src/comp603_cui_whowantstobeamillionaire/leaderboard.txt";

    /**
     * Constructor for UserInferface
     *
     * @param qm Pass in QuestionManager
     */
    public UserInterface(QuestionManager qm) {
        this.scanner = new Scanner(System.in);
        this.qm = qm;
        this.lb = lb = new Leaderboard();
        this.bank = new Bank();
    }

    // Starts the User Interface
    public void start() {
        System.out.println(" __          __ _         __          __            _      _______      ____                   __  __  _  _  _  _                                 ");
        System.out.println(" \\ \\        / /| |        \\ \\        / /           | |    |__   __|    |  _ \\           /\\    |  \\/  |(_)| || |(_)                                ");
        System.out.println("  \\ \\  /\\  / / | |__    ___\\ \\  /\\  / /__ _  _ __  | |_  ___ | |  ___  | |_) |  ___    /  \\   | \\  / | _ | || | _   ___   _ __    __ _  _ __  ___ ");
        System.out.println("   \\ \\/  \\/ /  | '_ \\  / _ \\\\ \\/  \\/ // _` || '_ \\ | __|/ __|| | / _ \\ |  _ <  / _ \\  / /\\ \\  | |\\/| || || || || | / _ \\ | '_ \\  / _` || '__|/ _ \\");
        System.out.println("    \\  /\\  /   | | | || (_) |\\  /\\  /| (_| || | | || |_ \\__ \\| || (_) || |_) ||  __/ / ____ \\ | |  | || || || || || (_) || | | || (_| || |  |  __/");
        System.out.println("     \\/  \\/    |_| |_| \\___/  \\/  \\/  \\__,_||_| |_| \\__||___/|_| \\___/ |____/  \\___|/_/    \\_\\|_|  |_||_||_||_||_| \\___/ |_| |_| \\__,_||_|   \\___|");
        System.out.println("                                                                                                                                                  ");
        this.menu(); // Main menu
    }

    /*
     *   Main game menu which fetches user input to navigate game menu
     */
    public void menu() {
        OUTER:
        while (true) {
            System.out.println("----MAIN MENU: WHO WANTS TO BE A MILLIONAIRE----");
            System.out.println("Please choose from the following options:");
            System.out.println("1: New Game");
            System.out.println("2: View Leaderboard");
            System.out.println("3: Exit");

            try {
                int userInput = Integer.valueOf(scanner.nextLine());

                switch (userInput) {
                    case 1:
                        this.signIn();
                        break OUTER;
                    case 2:
                        importLeaderboard();
                        break OUTER;
                    case 3:
                        System.exit(0);
                    default:
                        System.out.println("Invalid input. Please try again.\n");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter an integer number. Please try again.\n");
            }
        }
    }

    /*
     *  Method which collects users name & then starts game
     */
    public void signIn() {
        System.out.println("To continue, please enter your first name: "); // Requests uers name
        name = scanner.nextLine();

        // Regex which checks to ensure first name input only matches a String
        while (!name.matches("^[a-zA-Z]+$")) {
            System.out.println("Please enter only your first name:"); // Requests uers name
            name = scanner.nextLine();
        }

        System.out.println("Thank you, " + name);
        newPlayer = new Player(name, 0); // Creates a new player object with a default score of 0

        // Create new game object run it with the start method
        Game game = new Game(newPlayer, lb, qm, scanner);
        game.start();

        backToMenu();
    }

    /*
     *   Import leaderboard.txt into Player objects stored in playerScore List
     */
    public void importLeaderboard() {
        ArrayList<Player> playerScores = new ArrayList<>();
        File file = new File(LEADERBOARD);

        // Read each line of leaderboard.txt and split "," into name & score
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] parts = line.split(",");
                String lbName = parts[0];
                int score = Integer.parseInt(parts[1]);

                playerScores.add(new Player(lbName, score));
            }
        } catch (Exception e) {
            System.out.println("Couldn't import questions.");
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nCurrent Leaderboard:");

        // Sorts list by player scores high -> low
        playerScores
                .sort(Comparator.comparingInt(Player::getScore).reversed());

        // Prints each player
        int leaderboardCount = 1;
        for (Player i : playerScores) {
            System.out.println(leaderboardCount + ") " + i);
            leaderboardCount++;
        }

        backToMenu(); // Prints back to menu UI
    }

    // Displays options & queries user to either return back to menu or exit
    public void backToMenu() {
        OUTER:
        while (true) {
            System.out.println("\n1: Back to Menu");
            System.out.println("2: Exit");
            try {
                int userInput = Integer.valueOf(scanner.nextLine());

                switch (userInput) {
                    case 1:
                        this.menu();
                        break OUTER;
                    case 2:
                        System.exit(0);
                    default:
                        System.out.println("Invalid input. Please try again.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter an integer number. Please try again.");
            }
        }
    }
}
