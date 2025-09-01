/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tvseriesmanagementapp;

/**
 *
 * @author payaf
 */
public class AnimatedSeries extends SeriesModel {
    private String studio;

    public AnimatedSeries(String id, String name, int ageRestriction, int episodes, String studio) {
        super(id, name, ageRestriction, episodes);
        this.studio = studio;
    }

    public String getStudio() { return studio; }
    public void setStudio(String studio) { this.studio = studio; }

    @Override
    public String toString() {
        return super.toString() + ", Studio: " + studio;
    }
}
