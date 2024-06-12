/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.algonquin.cst8288.assignment2.database;

import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * DBConnectionTest
 * @author ryany
 */
public class DBConnectionTest {
    
    /**
     * default constructor
     */
    public DBConnectionTest() {
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
     * Test of getInstance method, of class DBConnection.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        DBConnection instance1 = DBConnection.getInstance();
        DBConnection instance2 = DBConnection.getInstance();
        assertSame(instance1, instance2);
    }

}
