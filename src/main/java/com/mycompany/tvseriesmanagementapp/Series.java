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
import java.util.Iterator;
import java.util.Scanner;

public class Series {
    private ArrayList<SeriesModel> seriesList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

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

        int episodes;
        while (true) {
            try {
                System.out.println("Enter the number of episodes for the series:");
                episodes = Integer.parseInt(scanner.nextLine());
                if (episodes > 0) break;
                else System.out.println("Number of episodes must be greater than 0.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a numeric value.");
            }
        }

        seriesList.add(new SeriesModel(id, name, ageRestriction, episodes));
        System.out.println("Series recorded successfully!\n");
    }

    public void ViewAllSeries() {
        if (seriesList.isEmpty()) {
            System.out.println("No series recorded yet.\n");
        } else {
            for (SeriesModel series : seriesList) {
                System.out.println(series);
            }
        }
    }

    public void SearchSeries() {
        System.out.println("Enter the series ID to search:");
        String id = scanner.nextLine();
        for (SeriesModel series : seriesList) {
            if (series.getSeriesId().equals(id)) {
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
            if (series.getSeriesId().equals(id)) {
                System.out.println("Enter new name:");
                series.setSeriesName(scanner.nextLine());

                System.out.println("Enter new age restriction:");
                series.setSeriesAgeRestriction(Integer.parseInt(scanner.nextLine()));

                System.out.println("Enter new number of episodes:");
                series.setSeriesNumberOfEpisodes(Integer.parseInt(scanner.nextLine()));

                System.out.println("Series updated successfully!\n");
                return;
            }
        }
        System.out.println("Series with Series ID " + id + " was not found\n");
    }

    public void DeleteSeries() {
        System.out.println("Enter the series ID to delete:");
        String id = scanner.nextLine();
        Iterator<SeriesModel> iterator = seriesList.iterator();
        while (iterator.hasNext()) {
            SeriesModel series = iterator.next();
            if (series.getSeriesId().equals(id)) {
                System.out.println("Are you sure you want to delete series " + id + "? Type 'yes' to confirm:");
                if (scanner.nextLine().equalsIgnoreCase("yes")) {
                    iterator.remove();
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
        if (seriesList.isEmpty()) {
            System.out.println("No series available to report.\n");
        } else {
            for (SeriesModel series : seriesList) {
                System.out.println(series);
            }
        }
    }

    public void ExitSeriesApplication() {
        System.out.println("Exiting application. Goodbye!");
        System.exit(0);
    }
    
   public void SortSeriesByEpisodes() {
    seriesList.sort((s1, s2) -> Integer.compare(s1.getSeriesNumberOfEpisodes(), s2.getSeriesNumberOfEpisodes()));
    System.out.println("Series sorted by number of episodes:\n");
    ViewAllSeries();
}

public void FilterSeriesByAgeRestriction(int age) {
    System.out.println("Series allowed for age " + age + "+:\n");
    for (SeriesModel s : seriesList) {
        if (s.getSeriesAgeRestriction() <= age) {
            System.out.println(s);
        }
    }
}


    // === TEST METHODS ===

    public void testAddSeries(String id, String name, int age, int episodes) {
        seriesList.add(new SeriesModel(id, name, age, episodes));
    }

    public SeriesModel testSearchSeries(String id) {
        for (SeriesModel s : seriesList) {
            if (s.getSeriesId().equals(id)) return s;
        }
        return null;
    }

    public boolean testUpdateSeries(String id, String name, int age, int episodes) {
        for (SeriesModel s : seriesList) {
            if (s.getSeriesId().equals(id)) {
                s.setSeriesName(name);
                s.setSeriesAgeRestriction(age);
                s.setSeriesNumberOfEpisodes(episodes);
                return true;
            }
        }
        return false;
    }

    public boolean testDeleteSeries(String id) {
        return seriesList.removeIf(s -> s.getSeriesId().equals(id));
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
