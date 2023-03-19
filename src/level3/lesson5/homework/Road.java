package level3.lesson5.homework;

import lombok.AllArgsConstructor;

import java.util.logging.Level;
import java.util.logging.Logger;

@AllArgsConstructor
public class Road implements Stage {
  private final Logger logger = Logger.getLogger(Road.class.getSimpleName());
  int length;

  @Override
  public void go(Car c) {
    try {
      System.out.printf("%s начал этап: %s\n", c, this);
      Thread.sleep(length / c.getSpeed() * 1000);
      System.out.printf("%s закончил этап: %s\n", c, this);
    } catch (InterruptedException e) {
      logger.log(Level.WARNING, e.getMessage(), e);
    }
  }

  @Override
  public String toString() {
    return String.format("Дорога %d метров", length);
  }
}
