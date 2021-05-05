package comp603_cui_whowantstobeamillionaire;

import java.util.ArrayList;

/**
 * Generates an ArrayList of questions. Can add questions into the ArrayList
 *
 * @author Jona Stevenson & Charles Monaghan
 */
public class QuestionManager {

    private ArrayList<Question> questions;

    public QuestionManager() {
        this.questions = new ArrayList<>();
    }

    /**
     * @param question Takes in a Question object
     */
    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    /**
     * NOTE: Must add questions into the ArrayList first
     *
     * @return an ArrayList of available questions
     */
    public ArrayList<Question> getQuestions() {
        return questions;
    }
}
