import java.util.ArrayList;
import java.util.Scanner;

public class Series {
    private static ArrayList<Series> seriesList = new ArrayList<>();
    private int id;
    private String name;
    private int ageRestriction;
    private int episodes;

    public Series(int id, String name, int ageRestriction, int episodes) {
        this.id = id;
        this.name = name;
        this.ageRestriction = ageRestriction;
        this.episodes = episodes;
    }
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAgeRestriction() { return ageRestriction; }
    public int getEpisodes() { return episodes; }

    public void setName(String name) { this.name = name; }
    public void setAgeRestriction(int ageRestriction) { this.ageRestriction = ageRestriction; }
    public void setEpisodes(int episodes) { this.episodes = episodes; }


    public static void captureSeries(Scanner scanner) {
        System.out.println("CAPTURE A NEW SERIES");
        System.out.println("******************************");

        System.out.print("Enter the series id: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter the series name: ");
        String name = scanner.nextLine();

        int age = getValidAge(scanner);

        System.out.print("Enter the number of episodes for " + name + ": ");
        int episodes = Integer.parseInt(scanner.nextLine());

        seriesList.add(new Series(id, name, age, episodes));
        System.out.println("Series processed successfully!!!");
    }

    private static int getValidAge(Scanner scanner) {
        int age;
        while (true) {
            System.out.print("Enter the series age restriction: ");
            String input = scanner.nextLine();
            try {
                age = Integer.parseInt(input);
                if (age >= 2 && age <= 18) {
                    break;
                } else {
                    System.out.println("You have entered a incorrect series age!!!");
                }
            } catch (NumberFormatException e) {
                System.out.println("You have entered a incorrect series age!!!");
            }
            System.out.print("Please re-enter the series age >> ");
        }
        return age;
    }

    public static void searchSeries(Scanner scanner) {
        System.out.print("Enter the series id to search: ");
        int searchId = Integer.parseInt(scanner.nextLine());

        Series found = findSeriesById(searchId);
        if (found != null) {
            System.out.println("SERIES ID: " + found.id);
            System.out.println("SERIES NAME: " + found.name);
            System.out.println("SERIES AGE RESTRICTION: " + found.ageRestriction);
            System.out.println("SERIES NUMBER OF EPISODES: " + found.episodes);
        } else {
            System.out.println("Series with Series Id: " + searchId + " was not found!");
        }
    }

    public static void updateSeries(Scanner scanner) {
        System.out.print("Enter the series id to update: ");
        int updateId = Integer.parseInt(scanner.nextLine());

        Series found = findSeriesById(updateId);
        if (found != null) {
            found.setAgeRestriction(getValidAge(scanner));

            System.out.println("Series updated successfully!");
        } else {
            System.out.println("Series with Series Id: " + updateId + " was not found!");
        }
    }

    public static void deleteSeries(Scanner scanner) {
        System.out.print("Enter the series id to delete: ");
        int deleteId = Integer.parseInt(scanner.nextLine());

        Series found = findSeriesById(deleteId);
        if (found != null) {
            System.out.print("Are you sure you want to delete series " + deleteId + " from the system? Yes (y) to delete: ");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("y")) {
                seriesList.remove(found);
                System.out.println("Series with Series Id: " + deleteId + " WAS deleted!");
            } else {
                System.out.println("Delete operation cancelled.");
            }
        } else {
            System.out.println("Series with Series Id: " + deleteId + " was not found!");
        }
    }

    public static void printReport() {
        System.out.println("Series Report - 2025");
        int count = 1;
        for (Series s : seriesList) {
            System.out.println("Series " + count++);
            System.out.println("SERIES ID: " + s.id);
            System.out.println("SERIES NAME: " + s.name);
            System.out.println("SERIES AGE RESTRICTION: " + s.ageRestriction);
            System.out.println("NUMBER OF EPISODES: " + s.episodes);
            System.out.println("-------------------------------------");
        }
        if (seriesList.isEmpty()) {
            System.out.println("No series available.");
        }
    }

    public static void exitSeriesApplication() {
        System.out.println("Exiting application...");
        System.exit(0);
    }

    private static Series findSeriesById(int id) {
        for (Series s : seriesList) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }
}

