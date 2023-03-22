package level3.lesson5.homework;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Race {
  protected static List<Car> finishedCars = new ArrayList<>();
  protected static int CARS_COUNT;
  private final List<Stage> stages;

  public Race(Stage... stages) {
    this.stages = List.of(stages);
  }
}
