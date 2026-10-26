import java.util.ArrayDeque;
import java.lang.Exception;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Archipelago {
  private HashMap<String, City> cities;

  public Archipelago() {
    cities = new HashMap<>();
  }

  public void addCity(String name, int population) {
    cities.put(name, new City(name, population));
  }

  public void connect(String nameA, String nameB) throws Exception {
    if (cities.size() == 0) {
      throw new Exception("Archipelago is empty.");
    }
    if (!cities.containsKey(nameA) || !cities.containsKey(nameB))
      throw new Exception(nameA + " or " + nameB + " does not exist.");
    City cityA = cities.get(nameA);
    City cityB = cities.get(nameB);

    cityA.neighbors.add(cityB);
    cityB.neighbors.add(cityA);
  }

  public int numberOfIslands() {
    int count = 0;
    ArrayDeque<City> q = new ArrayDeque<>();
    Set<City> visited = new HashSet<>();

    for (City city : cities.values()) {
      if (visited.contains(city)) {
        continue;
      }
      q.addLast(city);
      visited.add(city);

      while (!q.isEmpty()) {
        City currC = q.pop();
        for (City neighbor : currC.neighbors) {
          if (!visited.contains(neighbor)) {
            visited.add(neighbor);
            q.addLast(neighbor);
          }
        }
      }
      count++;
    }

    return count;
  }

  public List<Integer> getPopulation() {
    ArrayDeque<City> q = new ArrayDeque<>();
    Set<City> visited = new HashSet<>();
    List<Integer> populations = new ArrayList<>();
    for (City city : cities.values()) {
      if (visited.contains(city)) {
        continue;
      }
      int totalPop = 0;
      q.addLast(city);
      visited.add(city);
      while (!q.isEmpty()) {
        City currC = q.pop();
        totalPop += currC.population;
        for (City neighbor : currC.neighbors) {
          if (!visited.contains(neighbor)) {
            visited.add(neighbor);
            q.addLast(neighbor);
          }
        }
      }
      populations.add(totalPop);
    }
    return populations;
  }

  public int minNumUniqueHighways(String cityA, String cityB) {
    if (!cities.containsKey(cityA) || !cities.containsKey(cityB)) {
      return -1;
    }
    if (cityA.equals(cityB)) {
      return 0;
    }

    int minNum = 0;
    ArrayDeque<City> q = new ArrayDeque<>();
    Set<City> visited = new HashSet<>();
    City city = cities.get(cityA);
    City destination = cities.get(cityB);
    q.addLast(city);
    visited.add(city);

    while (!q.isEmpty()) {
      int level = q.size();

      for (int i = 0; i < level; i++) {
        City currC = q.pop();
        for (City neighbor : currC.neighbors) {
          if (neighbor.equals(destination)) {
            return minNum + 1;
          }
          if (!visited.contains(neighbor)) {
            q.addLast(neighbor);
            visited.add(neighbor);
          }
        }
      }
      minNum++;
    }
    return -1;
  }
}
