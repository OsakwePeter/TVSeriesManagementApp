/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.flightbookingapp;

/**
 *
 * @author payaf
 */
public class BusinessPassenger extends Passenger {
    private boolean loungeAccess;

    public BusinessPassenger(String id, String name, int seatNumber, boolean loungeAccess) {
        super(id, name, seatNumber);
        this.loungeAccess = loungeAccess;
    }

    public boolean hasLoungeAccess() { return loungeAccess; }
    public void setLoungeAccess(boolean loungeAccess) { this.loungeAccess = loungeAccess; }

    @Override
    public String toString() {
        return super.toString() + "\nLounge Access: " + (loungeAccess ? "Yes" : "No");
    }
}
