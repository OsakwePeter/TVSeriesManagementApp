/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.flightbookingapp;

/**
 *
 * @author payaf
 */
import java.util.Scanner;

public class FlightBookingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Flight flight = new Flight(20); // 20 seats capacity

        while (true) {
            System.out.println("\n===== Flight Booking System =====");
            System.out.println("1. Add Passenger");
            System.out.println("2. View All Passengers");
            System.out.println("3. Search Passenger");
            System.out.println("4. Delete Passenger");
            System.out.println("5. Seat Report");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1": flight.addPassenger(); break;
                case "2": flight.viewPassengers(); break;
                case "3": flight.searchPassenger(); break;
                case "4": flight.deletePassenger(); break;
                case "5": flight.seatReport(); break;
                case "6":
                    System.out.println("Exiting system. Goodbye!");
                    System.exit(0);
                default: System.out.println("Invalid option. Try again.\n");
            }
        }
    }
}
