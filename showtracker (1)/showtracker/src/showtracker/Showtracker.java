package showtracker;

import java.util.Scanner;

public class Showtracker {
    public static void main(String[] args) {
        ShowCollection app = new ShowCollection();
        Scanner scanner = new Scanner(System.in);

        System.out.println("LATEST SHOWS - 2025");
        System.out.println("********************************");
        System.out.print("Enter (1) to launch menu or any other key to exit: ");
        String choice = scanner.nextLine();

        if (!choice.equals("1")) {
            System.out.println("Goodbye!");
            return;
        }

        while (true) {
            System.out.println("\nPlease select one of the following menu items:");
            System.out.println("(1) Capture a new show.");
            System.out.println("(2) Search for a show.");
            System.out.println("(3) Update show details.");
            System.out.println("(4) Delete a show.");
            System.out.println("(5) Print show report - 2025.");
            System.out.println("(6) Exit Application.");
            System.out.print("Enter choice: ");
            String menuChoice = scanner.nextLine();

            switch (menuChoice) {
                case "1" -> app.addShow();
                case "2" -> app.findShow();
                case "3" -> app.editShow();
                case "4" -> app.removeShow();
                case "5" -> app.displayReport();
                case "6" -> app.closeApplication();
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
