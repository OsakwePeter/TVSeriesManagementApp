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
    private Series series;

    @BeforeEach
    void setup() {
        series = new Series();
        series.testAddSeries("S1", "Breaking Bad", 16, 62);
    }

    @Test
    void TestSearchSeries() {
        assertNotNull(series.testSearchSeries("S1"));
    }

    @Test
    void TestSearchSeries_SeriesNotFound() {
        assertNull(series.testSearchSeries("S99"));
    }

    @Test
    void TestUpdateSeries() {
        assertTrue(series.testUpdateSeries("S1", "Better Call Saul", 16, 50));
        assertEquals("Better Call Saul", series.testSearchSeries("S1").getSeriesName());
    }

    @Test
    void TestDeleteSeries() {
        assertTrue(series.testDeleteSeries("S1"));
    }

    @Test
    void TestDeleteSeries_SeriesNotFound() {
        assertFalse(series.testDeleteSeries("S99"));
    }

    @Test
    void TestSeriesAgeRestriction_AgeValid() {
        assertTrue(series.testValidateAgeRestriction("10"));
        assertTrue(series.testValidateAgeRestriction("18"));
    }

    @Test
    void TestSeriesAgeRestriction_AgeInvalid() {
        assertFalse(series.testValidateAgeRestriction("0"));
        assertFalse(series.testValidateAgeRestriction("20"));
        assertFalse(series.testValidateAgeRestriction("abc"));
    }
}
