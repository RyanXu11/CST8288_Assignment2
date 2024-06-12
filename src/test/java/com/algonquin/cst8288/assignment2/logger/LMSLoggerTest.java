/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.algonquin.cst8288.assignment2.logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * LMSLoggerTest
 * @author ryany
 */
public class LMSLoggerTest {
    
    /**
     * default constructor
     */
    public LMSLoggerTest() {
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
     * Test of getInstance method, of class LMSLogger.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        LMSLogger instance1 = LMSLogger.getInstance();
        LMSLogger instance2 = LMSLogger.getInstance();
        assertSame(instance1, instance2);
    }
    
}
