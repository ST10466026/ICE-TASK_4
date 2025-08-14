/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package showtracker;

import java.util.ArrayList;
import java.util.Scanner;

public class ShowCollection {
    private ArrayList<Show> showList = new ArrayList<>();
    private Scanner inputScanner = new Scanner(System.in);

    private void drawBox(String text) {
        String border = new String(new char[text.length() + 4]).replace("\0", "*");
        System.out.println(border);
        System.out.println("* " + text + " *");
        System.out.println(border);
    }

    public void addShow() {
        drawBox("ADD NEW SHOW");

        System.out.print("Enter Show ID: ");
        String id = inputScanner.nextLine();

        System.out.print("Enter Show Name: ");
        String name = inputScanner.nextLine();

        int ageLimit;
        while (true) {
            System.out.print("Enter Age Restriction (2 - 18): ");
            String ageInput = inputScanner.nextLine();
            try {
                ageLimit = Integer.parseInt(ageInput);
                if (ageLimit >= 2 && ageLimit <= 18) break;
                System.out.println("Invalid age! Must be between 2 and 18.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Numbers only.");
            }
        }

        int episodeCount;
        while (true) {
            System.out.print("Enter Number of Episodes: ");
            String epInput = inputScanner.nextLine();
            try {
                episodeCount = Integer.parseInt(epInput);
                if (episodeCount > 0) break;
                System.out.println("Invalid! Must be greater than 0.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Numbers only.");
            }
        }

        showList.add(new Show(id, name, ageLimit, episodeCount));
        drawBox("Show successfully saved!");
    }

    public void findShow() {
        drawBox("SEARCH FOR A SHOW");
        System.out.print("Enter Show ID to search: ");
        String id = inputScanner.nextLine();

        for (Show s : showList) {
            if (s.showId.equalsIgnoreCase(id)) {
                System.out.println("\n=== SHOW FOUND ===");
                System.out.println(s);
                return;
            }
        }
        System.out.println("\nNo show found with ID: " + id);
    }

    public void editShow() {
        drawBox("UPDATE SHOW");
        System.out.print("Enter Show ID to update: ");
        String id = inputScanner.nextLine();

        for (Show s : showList) {
            if (s.showId.equalsIgnoreCase(id)) {
                System.out.print("Enter new Show Name: ");
                s.showName = inputScanner.nextLine();

                int newAge;
                while (true) {
                    System.out.print("Enter new Age Restriction (2 - 18): ");
                    String ageInput = inputScanner.nextLine();
                    try {
                        newAge = Integer.parseInt(ageInput);
                        if (newAge >= 2 && newAge <= 18) break;
                        System.out.println("Invalid age! Must be between 2 and 18.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! Numbers only.");
                    }
                }
                s.showAge = newAge;

                int newEpisodes;
                while (true) {
                    System.out.print("Enter new Number of Episodes: ");
                    String epInput = inputScanner.nextLine();
                    try {
                        newEpisodes = Integer.parseInt(epInput);
                        if (newEpisodes > 0) break;
                        System.out.println("Invalid! Must be greater than 0.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! Numbers only.");
                    }
                }
                s.showEpisodes = newEpisodes;

                drawBox("Show updated successfully!");
                return;
            }
        }
        System.out.println("No show found with ID: " + id);
    }

    public void removeShow() {
        drawBox("DELETE SHOW");
        System.out.print("Enter Show ID to delete: ");
        String id = inputScanner.nextLine();

        for (Show s : showList) {
            if (s.showId.equalsIgnoreCase(id)) {
                System.out.print("Are you sure you want to delete this show? (Y/N): ");
                String confirm = inputScanner.nextLine();
                if (confirm.equalsIgnoreCase("Y")) {
                    showList.remove(s);
                    drawBox("Show deleted successfully!");
                } else {
                    System.out.println("Deletion cancelled.");
                }
                return;
            }
        }
        System.out.println("No show found with ID: " + id);
    }

    public void displayReport() {
        drawBox("LATEST SHOW REPORT - 2025");
        if (showList.isEmpty()) {
            System.out.println("No shows available.");
        } else {
            for (Show s : showList) {
                System.out.println(s);
                System.out.println("-----------------------------");
            }
        }
    }

    public void closeApplication() {
        drawBox("EXITING APPLICATION");
        System.exit(0);
    }

    // Test support methods
    public void addShowDirect(Show show) {
        showList.add(show);
    }

    public Show getShowById(String id) {
        for (Show s : showList) {
            if (s.showId.equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    public boolean modifyShowById(String id, String newName, int newAge, int newEpisodes) {
        for (Show s : showList) {
            if (s.showId.equalsIgnoreCase(id)) {
                s.showName = newName;
                s.showAge = newAge;
                s.showEpisodes = newEpisodes;
                return true;
            }
        }
        return false;
    }

    public boolean removeShowById(String id) {
        return showList.removeIf(s -> s.showId.equalsIgnoreCase(id));
    }

    public boolean validAge(int age) {
        return age >= 2 && age <= 18;
    }
}

