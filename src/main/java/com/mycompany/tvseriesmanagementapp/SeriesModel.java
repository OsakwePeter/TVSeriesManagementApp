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
    public String SeriesId;
    public String SeriesName;
    public int SeriesAgeRestriction;
    public int SeriesNumberOfEpisodes;

    public SeriesModel(String id, String name, int ageRestriction, int episodes) {
        this.SeriesId = id;
        this.SeriesName = name;
        this.SeriesAgeRestriction = ageRestriction;
        this.SeriesNumberOfEpisodes = episodes;
    }

    public String toString() {
        return "SERIES ID: " + SeriesId + "\nSERIES NAME: " + SeriesName +
                "\nSERIES AGE RESTRICTION: " + SeriesAgeRestriction +
                "\nSERIES NUMBER OF EPISODES: " + SeriesNumberOfEpisodes + "\n";
    }
}

