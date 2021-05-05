package comp603_cui_whowantstobeamillionaire;

import java.util.Random;

/**
 *
 * Displays potential answers based on the chosen lifeline
 *
 * @author Charles Monaghan & Jona Stevenson
 */
public class Lifeline {

    private QuestionManager qm;
    private int currentQuestionIndex;

    public Lifeline(QuestionManager qm, int currentQuestionIndex) {
        this.qm = qm;
        this.currentQuestionIndex = currentQuestionIndex;
    }

    /**
     * Gets the current question in play
     */
    public void getCurrentQuestion() {
        qm.getQuestions().get(currentQuestionIndex);
    }

    /**
     * Removes 50% of the questions, leaving one correct answer and one wrong
     * answer
     */
    public void fiftyFifty() {
        int randomNumOne;
        int randomNumTwo;

        while (true) {
            // Generates 2 random numbers between 1-4
            randomNumOne = 1 + (int) (Math.random() * ((4 - 1) + 1));
            randomNumTwo = 1 + (int) (Math.random() * ((4 - 1) + 1));

            // Checks that at least 1 number is the correct answer, and one is a random answer that isn't equal to number 1
            if ((randomNumOne == qm.getQuestions().get(currentQuestionIndex).getAnswerIndex()
                    || randomNumTwo == qm.getQuestions().get(currentQuestionIndex).getAnswerIndex()) && (randomNumOne != randomNumTwo)) {
                break;
            }
        }

        System.out.println("Possible answers:");

        // Assigns each random number generated to it's applicable answer and prints it
        if (randomNumOne == 1 || randomNumTwo == 1) {
            System.out.println(qm.getQuestions().get(currentQuestionIndex).getAnswerOne());
        }
        if (randomNumOne == 2 || randomNumTwo == 2) {
            System.out.println(qm.getQuestions().get(currentQuestionIndex).getAnswerTwo());
        }
        if (randomNumOne == 3 || randomNumTwo == 3) {
            System.out.println(qm.getQuestions().get(currentQuestionIndex).getAnswerThree());
        }
        if (randomNumOne == 4 || randomNumTwo == 4) {
            System.out.println(qm.getQuestions().get(currentQuestionIndex).getAnswerFour());
        }
    }

    /**
     * Returns what the audience believes is the correct answer
     */
    public void askAudience() {

        int randomNumOne;
        int randomNumTwo;

        while (true) {
            // Generates 2 random numbers between 1-4
            randomNumOne = 1 + (int) (Math.random() * ((4 - 1) + 1));
            randomNumTwo = 1 + (int) (Math.random() * ((4 - 1) + 1));

            // Checks that at least 1 number is the correct answer, and one is a random answer that isn't equal to number 1
            if ((randomNumOne == qm.getQuestions().get(currentQuestionIndex).getAnswerIndex()
                    || randomNumTwo == qm.getQuestions().get(currentQuestionIndex).getAnswerIndex()) && (randomNumOne != randomNumTwo)) {
                break;
            }
        }

        // Assigns each random number generated to it's applicable answer and prints it
        boolean answerOne = false;
        boolean answerTwo = false;
        boolean answerThree = false;
        boolean answerFour = false;

        if (randomNumOne == 1 || randomNumTwo == 1) {
            answerOne = true;
        }
        if (randomNumOne == 2 || randomNumTwo == 2) {
            answerTwo = true;
        }
        if (randomNumOne == 3 || randomNumTwo == 3) {
            answerThree = true;
        }
        if (randomNumOne == 4 || randomNumTwo == 4) {
            answerFour = true;
        }

        // random number
        Random rng = new Random();
        int randomPercentage = rng.nextInt(80 - 40) + 40;

        System.out.println("=======================================================");
        System.out.println(randomPercentage + "% of the audience believes it is: ");
        while (true) {
            if (answerOne == true) {
                System.out.println(qm.getQuestions().get(currentQuestionIndex).getAnswerOne());
                System.out.println("=======================================================");
                break;
            }
            if (answerTwo == true) {
                System.out.println(qm.getQuestions().get(currentQuestionIndex).getAnswerTwo());
                System.out.println("=======================================================");
                break;
            }
            if (answerThree == true) {
                System.out.println(qm.getQuestions().get(currentQuestionIndex).getAnswerThree());
                System.out.println("=======================================================");
                break;
            }
            if (answerFour == true) {
                System.out.println(qm.getQuestions().get(currentQuestionIndex).getAnswerFour());
                System.out.println("=======================================================");
                break;
            }
        }

        System.out.println(qm.getQuestions().get(currentQuestionIndex).getAnswerOne());
        System.out.println(qm.getQuestions().get(currentQuestionIndex).getAnswerTwo());
        System.out.println(qm.getQuestions().get(currentQuestionIndex).getAnswerThree());
        System.out.println(qm.getQuestions().get(currentQuestionIndex).getAnswerFour());
    }
}
