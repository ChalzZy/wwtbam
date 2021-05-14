/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wwtbam_gui;

import wwtbam_gui.Question;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author charl
 */
public class QuestionTest {
    private Question question = new Question("test", "A", "B", "C", "D", 1, 100);
    
    public QuestionTest() {
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
     * Test of getTitle method, of class Question.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        
        String expResult = "test";
        String result = question.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAnswerOne method, of class Question.
     */
    @Test
    public void testGetAnswerOne() {
        System.out.println("getAnswerOne");
        
        String expResult = "A";
        String result = question.getAnswerOne();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAnswerTwo method, of class Question.
     */
    @Test
    public void testGetAnswerTwo() {
        System.out.println("getAnswerTwo");
        
        String expResult = "B";
        String result = question.getAnswerTwo();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAnswerThree method, of class Question.
     */
    @Test
    public void testGetAnswerThree() {
        System.out.println("getAnswerThree");
        
        String expResult = "C";
        String result = question.getAnswerThree();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAnswerFour method, of class Question.
     */
    @Test
    public void testGetAnswerFour() {
        System.out.println("getAnswerFour");
        
        String expResult = "D";
        String result = question.getAnswerFour();
        assertEquals(expResult, result);
    }

    /**
     * Test of getQuestionValue method, of class Question.
     */
    @Test
    public void testGetQuestionValue() {
        System.out.println("getQuestionValue");
        
        int expResult = 100;
        int result = question.getQuestionValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAnswerIndex method, of class Question.
     */
    @Test
    public void testGetAnswerIndex() {
        System.out.println("getAnswerIndex");
        
        int expResult = 1;
        int result = question.getAnswerIndex();
        assertEquals(expResult, result);
    }    
}
