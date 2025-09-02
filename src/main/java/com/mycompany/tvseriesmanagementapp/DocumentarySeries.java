/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tvseriesmanagementapp;

/**
 *
 * @author payaf
 */
public class DocumentarySeries extends SeriesModel {
    private String topic;

    public DocumentarySeries(String id, String name, int ageRestriction, int episodes, String topic) {
        super(id, name, ageRestriction, episodes);
        this.topic = topic;
    }

    public String getTopic() { return topic; }
    public void setTopic(String topic) { this.topic = topic; }

    @Override
    public String toString() {
        return super.toString() + "\nTopic: " + topic;
    }
}
