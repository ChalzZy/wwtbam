package comp603_cui_whowantstobeamillionaire;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jona Stevenson & Charles Monaghan
 */
public class QuestionManagerTest {

    public QuestionManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addQuestion method, of class QuestionManager.
     */
    @Test
    public void testAddQuestion() {
        System.out.println("addQuestion");

        Question question = new Question(null, null, null, null, null, 0, 5);
        
        QuestionManager instance = new QuestionManager();
        int expSize = instance.getQuestions().size() + 1;
        instance.addQuestion(question);
        int actualSize = instance.getQuestions().size();
        
        assertEquals(expSize, actualSize);
    }
}
