/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tvseriesmanagementapp;

/**
 *
 * @author payaf
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Series {
    public ArrayList<SeriesModel> seriesList = new ArrayList<>();
    public Scanner scanner = new Scanner(System.in);

    public void CaptureSeries() {
        System.out.println("Enter the series id:");
        String id = scanner.nextLine();
        System.out.println("Enter the series name:");
        String name = scanner.nextLine();

        int ageRestriction;
        while (true) {
            try {
                System.out.println("Enter the series age restriction:");
                ageRestriction = Integer.parseInt(scanner.nextLine());
                if (ageRestriction >= 2 && ageRestriction <= 18) break;
                else System.out.println("Age restriction must be between 2 and 18.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a numeric age restriction.");
            }
        }

        System.out.println("Enter the number of episodes for the series:");
        int episodes = Integer.parseInt(scanner.nextLine());

        seriesList.add(new SeriesModel(id, name, ageRestriction, episodes));
        System.out.println("Series recorded successfully!\n");
    }

    public void ViewAllSeries() {
        for (SeriesModel series : seriesList) {
            System.out.println(series);
        }
    }

    public void SearchSeries() {
        System.out.println("Enter the series ID to search:");
        String id = scanner.nextLine();
        for (SeriesModel series : seriesList) {
            if (series.SeriesId.equals(id)) {
                System.out.println(series);
                return;
            }
        }
        System.out.println("Series with Series ID " + id + " was not found\n");
    }

    public void UpdateSeries() {
        System.out.println("Enter the series ID to update:");
        String id = scanner.nextLine();
        for (SeriesModel series : seriesList) {
            if (series.SeriesId.equals(id)) {
                System.out.println("Enter new name:");
                series.SeriesName = scanner.nextLine();
                System.out.println("Enter new age restriction:");
                series.SeriesAgeRestriction = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter new number of episodes:");
                series.SeriesNumberOfEpisodes = Integer.parseInt(scanner.nextLine());
                System.out.println("Series updated successfully!\n");
                return;
            }
        }
        System.out.println("Series with Series ID " + id + " was not found\n");
    }

    public void DeleteSeries() {
        System.out.println("Enter the series ID to delete:");
        String id = scanner.nextLine();
        for (SeriesModel series : seriesList) {
            if (series.SeriesId.equals(id)) {
                System.out.println("Are you sure you want to delete series " + id + "? Type 'yes' to confirm:");
                if (scanner.nextLine().equalsIgnoreCase("yes")) {
                    seriesList.remove(series);
                    System.out.println("Series ID " + id + " has been deleted\n");
                } else {
                    System.out.println("Deletion cancelled\n");
                }
                return;
            }
        }
        System.out.println("Series with Series ID " + id + " was not found\n");
    }

    public void SeriesReport() {
        System.out.println("Best series report - 2025\n");
        for (SeriesModel series : seriesList) {
            System.out.println(series);
        }
    }

    public void ExitSeriesApplication() {
        System.out.println("Exiting application. Goodbye!");
        System.exit(0);
    }

    // === TEST METHODS ===

    public void testAddSeries(String id, String name, int age, int episodes) {
        seriesList.add(new SeriesModel(id, name, age, episodes));
    }

    public SeriesModel testSearchSeries(String id) {
        for (SeriesModel s : seriesList) {
            if (s.SeriesId.equals(id)) return s;
        }
        return null;
    }

    public boolean testUpdateSeries(String id, String name, int age, int episodes) {
        for (SeriesModel s : seriesList) {
            if (s.SeriesId.equals(id)) {
                s.SeriesName = name;
                s.SeriesAgeRestriction = age;
                s.SeriesNumberOfEpisodes = episodes;
                return true;
            }
        }
        return false;
    }

    public boolean testDeleteSeries(String id) {
        return seriesList.removeIf(s -> s.SeriesId.equals(id));
    }

    public boolean testValidateAgeRestriction(String input) {
        try {
            int age = Integer.parseInt(input);
            return age >= 2 && age <= 18;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}