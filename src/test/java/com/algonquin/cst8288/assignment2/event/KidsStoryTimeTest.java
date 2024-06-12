/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.algonquin.cst8288.assignment2.event;

import com.algonquin.cst8288.assignment2.constants.Constants;
import static com.algonquin.cst8288.assignment2.event.testConstant.TOLERANCE_DOUBLE;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ryany
 */
public class KidsStoryTimeTest {
    
    public KidsStoryTimeTest() {
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
     * Test of calculateAdmissionFee method, of class KidsStoryTime.
     */
    @Test
    public void testCalculateAdmissionFee() {
        System.out.println("calculateAdmissionFee");
        KidsStoryTime instance = new KidsStoryTime();
        instance.calculateAdmissionFee();
        double expResult = Constants.KIDS_STORYTIME_DURATION * Constants.KIDS_STORYTIME_RATE;
        double result = instance.getAdmissionFees();
        assertEquals(expResult, result, TOLERANCE_DOUBLE);
    }
    
}
