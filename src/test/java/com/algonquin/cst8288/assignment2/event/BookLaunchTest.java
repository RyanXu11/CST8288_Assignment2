/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.algonquin.cst8288.assignment2.event;

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
public class BookLaunchTest {
    
    public BookLaunchTest() {
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
     * Test of calculateAdmissionFee method, of class BookLaunch.
     */
    @Test
    public void testCalculateAdmissionFee() {
        System.out.println("calculateAdmissionFee");
        BookLaunch instance = new BookLaunch();
        instance.calculateAdmissionFee();
        double expResult = 50.0;
        double result = instance.getAdmissionFees();
        assertEquals(expResult, result, TOLERANCE_DOUBLE);
    }
    
}
