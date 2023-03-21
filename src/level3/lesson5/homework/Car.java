package level3.lesson5.homework;

import lombok.Getter;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

@Getter
public class Car implements Runnable {
  private static final Logger logger = Logger.getLogger(Car.class.getSimpleName());
  private static int CARS_COUNT;
  private final CountDownLatch cdl;
  private final Race race;
  private final int speed;
  private final int memberNumber;

  public Car(Race race, int speed, CountDownLatch cdl) {
    this.race = race;
    this.speed = speed;
    this.cdl = cdl;
    CARS_COUNT++;
    this.memberNumber = CARS_COUNT;
  }

  @Override
  public void run() {
    var stages = race.getStages();
    try {
      System.out.printf("%s готовится\n", this);
      Thread.sleep(500 + (int) (Math.random() * 800));
      System.out.printf("%s готов\n", this);
      cdl.countDown();
      cdl.await();
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      logger.log(Level.WARNING, e.getMessage(), e);
    }
    for (Stage stage : stages) {
      stage.go(this);
    }
    Race.finishedCars.add(this);
  }

  @Override
  public String toString() {
    return String.format("Участник #%d", this.memberNumber);
  }
}
