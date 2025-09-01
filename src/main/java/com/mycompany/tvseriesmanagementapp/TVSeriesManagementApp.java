/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tvseriesmanagementapp;

/**
 *
 * @author payaf
 */

import java.util.Scanner;

public class TVSeriesManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Series seriesManager = new Series();

        while (true) {
            System.out.println("LATEST SERIES - 2025");
            System.out.println("****************************************");
            System.out.println("Enter (1) to launch menu or any other key to exit");
            String input = scanner.nextLine();
            if (!input.equals("1")) break;

            while (true) {
                System.out.println("\nPlease select one of the following menu items:");
                System.out.println("1. Add a new series");
                System.out.println("2. View all series");
                System.out.println("3. Search for a series");
                System.out.println("4. Update a series");
                System.out.println("5. Delete a series");
                System.out.println("6. View series report");
                System.out.println("7. Exit");
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1": seriesManager.CaptureSeries(); break;
                    case "2": seriesManager.ViewAllSeries(); break;
                    case "3": seriesManager.SearchSeries(); break;
                    case "4": seriesManager.UpdateSeries(); break;
                    case "5": seriesManager.DeleteSeries(); break;
                    case "6": seriesManager.SeriesReport(); break;
                    case "7": seriesManager.ExitSeriesApplication();
                    default: System.out.println("Invalid option\n"); break;
                }
            }
        }
    }
}

