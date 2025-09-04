/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.flightbookingapp;

/**
 *
 * @author payaf
 */
import java.util.Scanner;

public class Flight {
    private Passenger[] passengers;  // array for fixed capacity
    private int count;
    private Scanner scanner = new Scanner(System.in);

    public Flight(int capacity) {
        passengers = new Passenger[capacity];
        count = 0;
    }

    // Add passenger
    public void addPassenger() {
        if (count >= passengers.length) {
            System.out.println("Flight is fully booked!");
            return;
        }

        System.out.println("Select passenger type:");
        System.out.println("1. Economy Passenger");
        System.out.println("2. Business Passenger");
        String choice = scanner.nextLine();

        System.out.println("Enter Passenger ID:");
        String id = scanner.nextLine();
        System.out.println("Enter Passenger Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Seat Number:");
        int seatNumber = Integer.parseInt(scanner.nextLine());

        Passenger passenger;
        if (choice.equals("1")) {
            System.out.println("Enter baggage allowance (kg):");
            int baggage = Integer.parseInt(scanner.nextLine());
            passenger = new EconomyPassenger(id, name, seatNumber, baggage);
        } else {
            System.out.println("Does passenger have lounge access? (yes/no):");
            boolean lounge = scanner.nextLine().equalsIgnoreCase("yes");
            passenger = new BusinessPassenger(id, name, seatNumber, lounge);
        }

        passengers[count++] = passenger;
        System.out.println("Passenger added successfully!\n");
    }

    // View all passengers
    public void viewPassengers() {
        if (count == 0) {
            System.out.println("No passengers booked yet.\n");
            return;
        }
        System.out.println("===== Passenger List =====");
        for (int i = 0; i < count; i++) {
            System.out.println(passengers[i]);
            System.out.println("--------------------------");
        }
    }

    // Search passenger by ID
    public void searchPassenger() {
        System.out.println("Enter Passenger ID to search:");
        String id = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (passengers[i].getId().equalsIgnoreCase(id)) {
                System.out.println("Passenger found:");
                System.out.println(passengers[i]);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No passenger with ID " + id + " found.\n");
        }
    }

    // Delete passenger
    public void deletePassenger() {
        System.out.println("Enter Passenger ID to delete:");
        String id = scanner.nextLine();

        for (int i = 0; i < count; i++) {
            if (passengers[i].getId().equalsIgnoreCase(id)) {
                // Shift array left
                for (int j = i; j < count - 1; j++) {
                    passengers[j] = passengers[j + 1];
                }
                passengers[--count] = null;
                System.out.println("Passenger with ID " + id + " deleted.\n");
                return;
            }
        }
        System.out.println("No passenger with ID " + id + " found.\n");
    }

    // Report
    public void seatReport() {
        System.out.println("===== Flight Seat Report =====");
        System.out.println("Total Seats: " + passengers.length);
        System.out.println("Occupied Seats: " + count);
        System.out.println("Available Seats: " + (passengers.length - count));
        System.out.println("==============================\n");
    }

    // === Test Methods ===
    public boolean testAddPassenger(Passenger p) {
        if (count >= passengers.length) return false;
        passengers[count++] = p;
        return true;
    }

    public Passenger testSearchPassenger(String id) {
        for (int i = 0; i < count; i++) {
            if (passengers[i].getId().equalsIgnoreCase(id)) return passengers[i];
        }
        return null;
    }

    public boolean testDeletePassenger(String id) {
        for (int i = 0; i < count; i++) {
            if (passengers[i].getId().equalsIgnoreCase(id)) {
                for (int j = i; j < count - 1; j++) {
                    passengers[j] = passengers[j + 1];
                }
                passengers[--count] = null;
                return true;
            }
        }
        return false;
    }
}
