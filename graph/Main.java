import java.io.File;
import java.util.Scanner;

public class Main {
  public void doTask(Archipelago archipelago, String citiesFile, String roadsFile) {
    try {
      File cities = new File(citiesFile);

      Scanner scanCities = new Scanner(cities);
      while (scanCities.hasNext()) {
        String[] cityParts = scanCities.nextLine().split(":", 2);
        String city = cityParts[0].trim();
        int population = Integer.parseInt(cityParts[1].trim());
        archipelago.addCity(city, population);
      }
      scanCities.close();

      File highways = new File(roadsFile);
      Scanner scanHighways = new Scanner(highways);

      while (scanHighways.hasNext()) {
        String[] highwaysParts = scanHighways.nextLine().split(":", 2);
        String cityA = highwaysParts[0].trim();
        String cityB = highwaysParts[1].trim();
        archipelago.connect(cityA, cityB);
      }
      scanHighways.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void runTask(Integer option) {
    if (option == 1) {
      System.out.println("-----TESTING ALL TASKS WITH MAIN TEST CASE-----");
      Archipelago archipelago = new Archipelago();

      doTask(archipelago, "city_population.txt", "road_network.txt");

      System.out.println("NUMBER OF ISLANDS: " + archipelago.numberOfIslands());
      System.out.println("ISLAND POPULATIONS: " + archipelago.getPopulation());
      System.out.println("NEW YORK TO LOS ANGELES " + archipelago.minNumUniqueHighways("New York", "Los Angeles"));
      System.out.println("ANAHEIM TO RIVERSIDE " + archipelago.minNumUniqueHighways("Anaheim", "Riverside"));
      System.out.println("IRVINE TO EASTVALE " + archipelago.minNumUniqueHighways("Irvine", "Eastvale"));
    } else if (option == 2) {
      System.out.println("-----TESTING ALL TASKS WITH CUSTOM TEST CASE-----");
      Archipelago archipelago = new Archipelago();

      doTask(archipelago, "test_city.txt", "test_road.txt");

      System.out.println("NUMBER OF ISLANDS: " + archipelago.numberOfIslands());
      System.out.println("ISLAND POPULATIONS: " + archipelago.getPopulation());
      System.out.println("A TO B " + archipelago.minNumUniqueHighways("A", "B"));
      System.out.println("B TO A " + archipelago.minNumUniqueHighways("B", "A"));
      System.out.println("B TO A " + archipelago.minNumUniqueHighways("B", "A"));
      System.out.println("F TO A " + archipelago.minNumUniqueHighways("F", "A"));
    }
  }

  public void printTaskOptions() {
    System.out.println("CHOOSE TASKS TO TEST:");
    for (int i = 1; i <= 2; i++) {
      System.out.println("TASK " + i);
    }
    System.out.println("0 TO QUIT");
    System.out.print("CHOOSE OPTION: ");
  }

  public void runTaskOptions() {
    Scanner input = new Scanner(System.in);

    Integer option;

    do {
      printTaskOptions();
      option = input.nextInt();
      runTask(option);
    } while (option != 0);

    input.close();
  }

  public void main(String[] args) {
    runTaskOptions();
  }

  public static void main() {
  }
}
