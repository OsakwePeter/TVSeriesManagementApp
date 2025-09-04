/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.flightbookingapp;

/**
 *
 * @author payaf
 */
public class EconomyPassenger extends Passenger {
    private int baggageAllowance; // in kg

    public EconomyPassenger(String id, String name, int seatNumber, int baggageAllowance) {
        super(id, name, seatNumber);
        this.baggageAllowance = baggageAllowance;
    }

    public int getBaggageAllowance() { return baggageAllowance; }
    public void setBaggageAllowance(int baggageAllowance) { this.baggageAllowance = baggageAllowance; }

    @Override
    public String toString() {
        return super.toString() + "\nBaggage Allowance: " + baggageAllowance + "kg";
    }
}
