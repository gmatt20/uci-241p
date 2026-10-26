import java.util.ArrayList;
import java.util.List;

public class City {
  String name;
  List<City> neighbors;
  int population;

  public City(String name, int population) {
    this.name = name;
    this.population = population;
    this.neighbors = new ArrayList<>();
  }
}
