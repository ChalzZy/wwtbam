package comp603_cui_whowantstobeamillionaire;

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
public class PlayerTest {

    public PlayerTest() {
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
     * Test of setName method, of class Player.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");

        Player instance = new Player(null, 0);
        String expName = "Test";
        instance.setName(expName);
        String actualName = instance.getName();

        assertEquals(expName, actualName);
    }

    /**
     * Test of setScore method, of class Player.
     */
    @Test
    public void testSetScore() {
        System.out.println("setScore");
        
        Player instance = new Player(null, 0);
        int expScore = 5;
        instance.setScore(expScore);
        int actualScore = instance.getScore();
        
        assertEquals(expScore, actualScore);
    }
}
