/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tvseriesmanagementapp;

/**
 *
 * @author payaf
 */
public class SeriesModel {
    private String seriesId;
    private String seriesName;
    private int seriesAgeRestriction;
    private int seriesNumberOfEpisodes;

    // Constructor
    public SeriesModel(String id, String name, int ageRestriction, int episodes) {
        this.seriesId = id;
        this.seriesName = name;
        this.seriesAgeRestriction = ageRestriction;
        this.seriesNumberOfEpisodes = episodes;
    }

    // Getters
    public String getSeriesId() { 
    return seriesId; 
    }
    
    public String getSeriesName() { 
    return seriesName; 
    }
    
    public int getSeriesAgeRestriction() { 
    return seriesAgeRestriction; 
    }
    
    public int getSeriesNumberOfEpisodes() { 
    return seriesNumberOfEpisodes; 
    }

    // Setters
    public void setSeriesId(String seriesId) { 
    this.seriesId = seriesId; 
    }
    
    public void setSeriesName(String seriesName) { 
    this.seriesName = seriesName; 
    }
    
    public void setSeriesAgeRestriction(int seriesAgeRestriction) { 
    this.seriesAgeRestriction = seriesAgeRestriction; 
    }
    
    public void setSeriesNumberOfEpisodes(int seriesNumberOfEpisodes) { 
    this.seriesNumberOfEpisodes = seriesNumberOfEpisodes; 
    }

    // toString
    @Override
    public String toString() {
        return "SERIES ID: " + seriesId +
               "\nSERIES NAME: " + seriesName +
               "\nSERIES AGE RESTRICTION: " + seriesAgeRestriction +
               "\nSERIES NUMBER OF EPISODES: " + seriesNumberOfEpisodes;
    }
}
