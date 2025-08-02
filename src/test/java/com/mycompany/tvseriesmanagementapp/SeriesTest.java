/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.tvseriesmanagementapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author payaf
 */

public class SeriesTest {
    private Series seriesManager;

    @BeforeEach
    public void setup() {
        seriesManager = new Series();
        seriesManager.testAddSeries("101", "Extreme Sports", 12, 10);
        seriesManager.testAddSeries("102", "Bargain Hunters", 8, 6);
    }

    @Test
    public void TestSearchSeries1() {
        SeriesModel result = seriesManager.testSearchSeries("101");
        assertNotNull(result);
        assertEquals("Extreme Sports", result.SeriesName);
    }

    @Test
    public void TestSearchSeries_SeriesNotFound1() {
        SeriesModel result = seriesManager.testSearchSeries("999");
        assertNull(result);
    }

    @Test
    public void TestUpdateSeries1() {
        boolean updated = seriesManager.testUpdateSeries("101", "X Sports", 15, 12);
        assertTrue(updated);
        SeriesModel updatedSeries = seriesManager.testSearchSeries("101");
        assertEquals("X Sports", updatedSeries.SeriesName);
    }

    @Test
    public void TestDeleteSeries1() {
        boolean deleted = seriesManager.testDeleteSeries("102");
        assertTrue(deleted);
        assertNull(seriesManager.testSearchSeries("102"));
    }

    @Test
    public void TestDeleteSeries_SeriesNotFound1() {
        assertFalse(seriesManager.testDeleteSeries("404"));
    }

    @Test
    public void TestSeriesAgeRestriction_AgeValid1() {
        assertTrue(seriesManager.testValidateAgeRestriction("10"));
        assertTrue(seriesManager.testValidateAgeRestriction("2"));
        assertTrue(seriesManager.testValidateAgeRestriction("18"));
    }

    @Test
    public void TestSeriesAgeRestriction_AgeNotValid1() {
        assertFalse(seriesManager.testValidateAgeRestriction("one"));
        assertFalse(seriesManager.testValidateAgeRestriction("20"));
        assertFalse(seriesManager.testValidateAgeRestriction("-3"));
    }
}
