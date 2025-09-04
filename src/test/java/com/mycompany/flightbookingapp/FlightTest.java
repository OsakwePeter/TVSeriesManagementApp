/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.flightbookingapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
/**
 *
 * @author payaf
 */
public class FlightTest {
    private Flight flight;

    @BeforeEach
    void setUp() {
        flight = new Flight(5); // small capacity for testing
    }

    @Test
    void testAddPassenger() {
        Passenger p = new EconomyPassenger("P001", "Alice", 1, 20);
        assertTrue(flight.testAddPassenger(p), "Passenger should be added successfully");
    }

    @Test
    void testSearchPassenger_Found() {
        Passenger p = new BusinessPassenger("P002", "Bob", 2, true);
        flight.testAddPassenger(p);

        Passenger found = flight.testSearchPassenger("P002");
        assertNotNull(found, "Passenger should be found");
        assertEquals("Bob", found.getName());
    }

    @Test
    void testSearchPassenger_NotFound() {
        Passenger found = flight.testSearchPassenger("P999");
        assertNull(found, "Passenger should not be found");
    }

    @Test
    void testDeletePassenger_Success() {
        Passenger p = new EconomyPassenger("P003", "Charlie", 3, 25);
        flight.testAddPassenger(p);

        assertTrue(flight.testDeletePassenger("P003"), "Passenger should be deleted");
        assertNull(flight.testSearchPassenger("P003"), "Deleted passenger should not be found");
    }

    @Test
    void testDeletePassenger_NotFound() {
        assertFalse(flight.testDeletePassenger("P999"), "Deleting non-existing passenger should return false");
    }

    @Test
    void testCapacityLimit() {
        for (int i = 0; i < 5; i++) {
            assertTrue(flight.testAddPassenger(new EconomyPassenger("P" + i, "Test" + i, i, 20)));
        }
        // Adding beyond capacity should fail
        assertFalse(flight.testAddPassenger(new EconomyPassenger("PX", "Overflow", 99, 20)));
    }
}
