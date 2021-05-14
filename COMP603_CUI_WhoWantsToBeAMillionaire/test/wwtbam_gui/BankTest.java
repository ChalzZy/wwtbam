/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wwtbam_gui;

import wwtbam_gui.Bank;
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
public class BankTest {
    
    public BankTest() {
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
     * Test of getAvaiBank method, of class Bank.
     */
    @Test
    public void testGetAvaiBank() {
        System.out.println("getAvaiBank");
        
        Bank instance = new Bank();
        instance.setMoney(100);
        int expResult = 100;
        int result = instance.getAvaiBank();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setMoney method, of class Bank.
     */
    @Test
    public void testSetMoney() {
        System.out.println("setMoney");
        
        Bank instance = new Bank();
        int expResult = 100;
        instance.setMoney(expResult);
        int result = instance.getAvaiBank();
        
        assertEquals(expResult, result);
    }
    
}
