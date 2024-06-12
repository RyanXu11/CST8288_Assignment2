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
public class MovieNightTest {
    
    public MovieNightTest() {
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
     * Test of calculateAdmissionFee method, of class MovieNight.
     */
    @Test
    public void testCalculateAdmissionFee() {
        System.out.println("calculateAdmissionFee");
        MovieNight instance = new MovieNight();
        instance.calculateAdmissionFee();
        double expResult = Constants.MOVIE_NIGHT_DURATION * Constants.MOVIE_NIGHT_RATE;
        double result = instance.getAdmissionFees();
        assertEquals(expResult, result, TOLERANCE_DOUBLE);
    }
    
}
