package comp603_cui_whowantstobeamillionaire;

import java.util.Scanner;

/**
 * Displays questions, lifelines and keeps track of game progress
 *
 * @author Jona Stevenson & Charles Monaghan
 */
public class Game {

    private Player newPlayer;
    private Leaderboard lb;
    private QuestionManager qm;
    private Bank bank;
    private Scanner scanner;
    private int questionCount;

    public Game(Player newPlayer, Leaderboard lb, QuestionManager qm, Scanner scanner) {
        this.newPlayer = newPlayer;
        this.lb = lb;
        this.qm = qm;
        this.bank = new Bank();
        this.scanner = scanner;
    }

    public void start() {
        questionCount = 0;
        boolean fiftyAvai = true; // set to false once 50/50 lifeline is used
        boolean audienceAvai = true; // set to false once Ask the Audience lifeline is used

        // Pull questions from QuestionManager at index of the for loop and takes user input
        for (int i = 0; i < qm.getQuestions().size(); i++) {
            // Set the correct answer's character each round
            this.setAnswerChar(i);

            // -GENERATE USER INTERFACE----------------------------------------------------------------
            nextRoundUI(i); // next round UI

            AvailableLifelines(fiftyAvai, audienceAvai); // Prints available lifelines to the player

            //----------------------------------------------------------------------------------------------
            System.out.println("Answer: ");

            char answer = scanner.next().charAt(0); // Records users answer as a char
            answer = Character.toUpperCase(answer);
            if (fiftyAvai == true && audienceAvai == false) {
                while (!Character.toString(answer).matches("^[a-eA-E]*$")) {
                    System.out.println("Ask the Audience lifeline is already used, please try again!");

                    answer = scanner.next().charAt(0);
                    answer = Character.toUpperCase(answer);
                }
            } else if (fiftyAvai == false && audienceAvai == true) {
                while (!Character.toString(answer).matches("^[a-dA-DfF]*$")) {
                    System.out.println("50/50 lifeline is already used, please try again!");
                    answer = scanner.next().charAt(0);
                    answer = Character.toUpperCase(answer);
                }
            } else if (fiftyAvai == false && audienceAvai == false) {
                while (!Character.toString(answer).matches("^[a-dA-D]*$")) {
                    System.out.println("No lifelines available, please try again!");
                    answer = scanner.next().charAt(0);
                    answer = Character.toUpperCase(answer);
                }
            } else {
                while (!Character.toString(answer).matches("^[a-fA-F]*$")) {
                    System.out.println("Invalid answer, please try again (e.g. A):");
                    answer = scanner.next().charAt(0);
                    answer = Character.toUpperCase(answer);
                }
            }

            scanner.nextLine();

            /*
             *   50/50 lifeline
             */
            if (answer == 'E') {
                Lifeline lifeline = new Lifeline(qm, questionCount); // Creates new lifeline object with the qm and current question
                lifeline.fiftyFifty();

                // Asks for new answer after fiftyFifty result is printed
                System.out.println("\nAnswer: ");
                char secondAnswer = scanner.next().charAt(0); // Records users answer as a char
                secondAnswer = Character.toUpperCase(secondAnswer);
                scanner.nextLine(); // Reads the enter key following the users answer input to prevent bugs

                while (!Character.toString(secondAnswer).matches("^[a-dA-D]*$")) {
                    System.out.println("Invalid answer, please try again (e.g. A):"); // Requests uers name
                    secondAnswer = scanner.next().charAt(0);
                    secondAnswer = Character.toUpperCase(secondAnswer);
                    scanner.nextLine();
                }

                if (secondAnswer == qm.getQuestions().get(i).getAnswerChar()) { // Checks if users new answer matches the char of the correct answer
                    this.correctAnswer(i);
                    fiftyAvai = false;
                } else {
                    gameOver();
                    break;
                }
            } else if (answer == 'F') { // Ask the audience lifeline
                Lifeline lifeline = new Lifeline(qm, questionCount);
                lifeline.askAudience();

                System.out.println("\nAnswer: ");
                char secondAnswer = scanner.next().charAt(0);
                secondAnswer = Character.toUpperCase(secondAnswer);
                scanner.nextLine(); // Reads the enter key following the users answer input to prevent bugs

                while (!Character.toString(secondAnswer).matches("^[a-dA-D]*$")) {
                    System.out.println("Invalid answer, please try again (e.g. A):");
                    secondAnswer = scanner.next().charAt(0);
                    secondAnswer = Character.toUpperCase(secondAnswer);
                    scanner.nextLine();
                }

                if (secondAnswer == qm.getQuestions().get(i).getAnswerChar()) { // Checks if users new answer matches the char of the correct answer
                    this.correctAnswer(i);
                    audienceAvai = false;
                } else {
                    gameOver();
                    break;
                }
            } else if (answer == qm.getQuestions().get(i).getAnswerChar()) { // Check whether users answer char matches the correct answers char
                    this.correctAnswer(i);
            } else {
                gameOver();
                break;
            }
        }

        // Once game is over, the Player objects score is set via setScore
        this.newPlayer.setScore(bank.getAvaiBank());

        // If Player score is greater than 0, add player score to leaderboard
        if (newPlayer.getScore() > 0) {
            try {
                System.out.println("Well done, you got " + questionCount + " questions correct.");
                System.out.println("You earned $" + bank.getAvaiBank() + ".00, your score has been recorded.");

                lb.appendLeaderboard(newPlayer.getName(), newPlayer.getScore());
            } catch (Exception e) {
                System.out.println("Couldn't register score to leaderboard.");
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("You got all of the questions wrong, and you still have $0, you suck!");
        }
    }

    /**
     * Prints the current available Lifelines
     *
     * @param fiftyFifityAvailable set to false once lifeline is used
     * @param askAudienceAvailable set to false once lifeline is used
     */
    private void AvailableLifelines(boolean fiftyFifityAvailable, boolean askAudienceAvailable) {
        boolean fiftyAvailable = fiftyFifityAvailable;
        boolean audienceAvailable = askAudienceAvailable;

        if (fiftyAvailable == true && audienceAvailable == true) {
            System.out.println("-------------------");
            System.out.println("Lifelines:");
            System.out.println("E: 50/50");
            System.out.println("F: Ask The Audience");
            System.out.println("-------------------");
        } else if (fiftyAvailable == true && audienceAvailable == false) {
            System.out.println("-------------------");
            System.out.println("Lifelines:");
            System.out.println("E: 50/50");
            System.out.println("-------------------");
        } else if (fiftyAvailable == false && audienceAvailable == true) {
            System.out.println("-------------------");
            System.out.println("Lifelines:");
            System.out.println("F: Ask The Audience");
            System.out.println("-------------------");
        } else {
            System.out.println("-------------------");
            System.out.println("Lifeline: No Life Lines Avaiable");
            System.out.println("-------------------");
        }
    }

    /**
     * Displays round, bank and the value of the next question
     *
     * @param current round
     */
    private void nextRoundUI(int i) {
        System.out.println("\n===================");
        System.out.println("Round " + (i + 1));
        System.out.println("My Bank: $" + bank.getAvaiBank()); // Prints current balance of bank 
        System.out.println("Question Value: $" + qm.getQuestions().get(i).getQuestionValue()); // Prints value of question at index i
        System.out.println("===================");
        System.out.println(qm.getQuestions().get(i)); // Prints current questions toString at index i
    }

    /**
     * Reads the answer index from each question and assigns it to the
     * corresponding char value.
     */
    public void setAnswerChar(int i) {
        if (this.qm.getQuestions().get(i).getAnswerIndex() == 1) {
            this.qm.getQuestions().get(i).setAnswerChar('A');
        } else if (this.qm.getQuestions().get(i).getAnswerIndex() == 2) {
            this.qm.getQuestions().get(i).setAnswerChar('B');
        } else if (this.qm.getQuestions().get(i).getAnswerIndex() == 3) {
            this.qm.getQuestions().get(i).setAnswerChar('C');
        } else if (this.qm.getQuestions().get(i).getAnswerIndex() == 4) {
            this.qm.getQuestions().get(i).setAnswerChar('D');
        }
    }

    /**
     * Prints game over text.
     */
    public void gameOver() {
        System.out.println("Unlucky, that was incorrect.");
        System.out.println("===================");
        System.out.println("GAME OVER");
        System.out.println("===================\n");
    }
    
    /**
     * Prints correct answer text and sets player's bank corresponding with the question value.
     */
    public void correctAnswer(int i) {
        System.out.println("=======================================================");
        System.out.println("\nWell done! That's correct.");
        // If correct, add question value to player's bank and increase question count by 1
        this.bank.setMoney(qm.getQuestions().get(i).getQuestionValue());
        this.questionCount++;
    }
}
