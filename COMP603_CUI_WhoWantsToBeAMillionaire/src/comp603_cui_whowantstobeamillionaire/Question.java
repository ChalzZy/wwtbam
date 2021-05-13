package comp603_cui_whowantstobeamillionaire;

/**
 * Controls all attributes of a question, such as title, answers, correct answer and value
 *
 * @author Jona Stevenson & Charles Monaghan
 */
public class Question {

    private String title;
    private String answerOne;
    private String answerTwo;
    private String answerThree;
    private String answerFour;
    private int answerIndex;
    private int questionValue;
    private char answerChar;

    /**
     * @param title Question
     * @param answerOne First potential answer
     * @param answerTwo Second potential answer
     * @param answerThree Third potential answer
     * @param answerFour Fourth potential answer
     * @param answerIndex correct answer
     * @param questionValue value of question
     */
    public Question(String title, String answerOne, String answerTwo, String answerThree,
            String answerFour, int answerIndex, int questionValue) {
        this.title = title;
        this.answerOne = answerOne;
        this.answerTwo = answerTwo;
        this.answerThree = answerThree;
        this.answerFour = answerFour;
        this.answerIndex = answerIndex;
        this.questionValue = questionValue;
    }

    /**
     * @return question
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return first potential answer
     */
    public String getAnswerOne() {
        return answerOne;
    }

    /**
     * @return second potential answer
     */
    public String getAnswerTwo() {
        return answerTwo;
    }
    
    /**
     * @return third potential answer
     */
    public String getAnswerThree() {
        return answerThree;
    }

    /**
     * @return fourth potential answer
     */
    public String getAnswerFour() {
        return answerFour;
    }

    /**
     * @return dollar value of the question
     */
    public int getQuestionValue() {
        return questionValue;
    }

    /**
     * @return integer of correct answer. E.g. 3 = C; Hence C is the correct answer. 
     */
    public int getAnswerIndex() {
        return answerIndex;
    }

    public char getAnswerChar() {
        return answerChar;
    }

    public void setAnswerChar(char answerChar) {
        this.answerChar = answerChar;
    }

    @Override
    public String toString() {
        return "Question: " + this.title + "\nPossible answers:" + "\n" + this.answerOne + "\n"
                + this.answerTwo + "\n" + this.answerThree + "\n" + this.answerFour;
    }
}