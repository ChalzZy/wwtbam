package comp603_cui_whowantstobeamillionaire;

import java.io.File;
import java.util.Scanner;

/**
 * @author Charles Monaghan & Jona Stevenson
 */
public class WhoWantsToBeAMillionaireApp {

    private static final String QUESTIONS = "src/comp603_cui_whowantstobeamillionaire/questions.txt"; // available questions
    private static QuestionManager qm = new QuestionManager();

    public static void main(String[] args) {
        importQuestions(); // Import questions from questions.txt

        UserInterface ui = new UserInterface(qm); // Initialise user interface
        ui.start();
    }

    // Scans each line of questions.txt, adding new question objects to QuestionManager
    public static void importQuestions() {
        File file = new File(QUESTIONS);

        /*
         *   Import questions in line by line
         */
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] parts = line.split(",");
                String title = parts[0];
                String answerOne = parts[1];
                String answerTwo = parts[2];
                String answerThree = parts[3];
                String answerFour = parts[4];
                int answerIndex;
                answerIndex = Integer.parseInt(parts[5]);
                int questionValue = Integer.parseInt(parts[6]);

                qm.addQuestion(new Question(title, answerOne, answerTwo, answerThree,
                        answerFour, answerIndex, questionValue));
            }
        } catch (Exception e) {
            System.out.println("Couldn't import questions.");
            System.out.println("Error: " + e.getMessage());
        }
    }
}
