import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Latest Series-2025");
        System.out.println("************************************************");

        while (running) {
            System.out.println("\nEnter (1) to launch menu or any other key to exit");
            String input = scanner.nextLine();

            if (!input.equals("1")) {
                System.out.println("Goodbye!");
                break;
            }
            System.out.println("\nPlease select one of the following menu items:");
            System.out.println("(1) Capture a new series.");
            System.out.println("(2) Search for a series.");
            System.out.println("(3) Update series age restriction.");
            System.out.println("(4) Delete a series.");
            System.out.println("(5) Print series report - 2025");
            System.out.println("(6) Exit Application.");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    Series.captureSeries(scanner);
                    break;
                case "2":
                    Series.searchSeries(scanner);
                    break;
                case "3":
                    Series.updateSeries(scanner);
                    break;
                case "4":
                    Series.deleteSeries(scanner);
                    break;
                case "5":
                    Series.printReport();
                    break;
                case "6":
                    Series.exitSeriesApplication();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

