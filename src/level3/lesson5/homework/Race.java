package level3.lesson5.homework;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;

@Getter
public class Race {
  protected static ArrayList<Car> finishedCars = new ArrayList<>();
  private final ArrayList<Stage> stages;

  public Race(Stage... stages) {
    this.stages = new ArrayList<>(Arrays.asList(stages));
  }
}
