/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.flightbookingapp;

/**
 *
 * @author payaf
 */
public class Passenger {
    private String id;
    private String name;
    private int seatNumber;

    public Passenger(String id, String name, int seatNumber) {
        this.id = id;
        this.name = name;
        this.seatNumber = seatNumber;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public int getSeatNumber() { return seatNumber; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSeatNumber(int seatNumber) { this.seatNumber = seatNumber; }

    @Override
    public String toString() {
        return "Passenger ID: " + id +
               "\nName: " + name +
               "\nSeat Number: " + seatNumber;
    }
}
