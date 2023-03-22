package level3.lesson5.homework;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
  private static final Logger logger = Logger.getLogger(Main.class.getSimpleName());
  public static final int CARS_COUNT = 4;
  public static final int TUNNEL_CAPACITY = CARS_COUNT / 2;

  public static void main(String[] args) {
    System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
    var cdl = new CountDownLatch(CARS_COUNT);
    var smp = new Semaphore(TUNNEL_CAPACITY);
    var race = new Race(new Road(60), new Tunnel(80, smp), new Road(40));
    var cars = new ArrayList<Car>(CARS_COUNT);
    for (int i = 0; i < CARS_COUNT; i++) {
      cars.add(new Car(race, 20 + (int) (Math.random() * 10), cdl));
    }
    for (Car car : cars) {
      new Thread(car).start();
    }
    try {
      cdl.await();
      System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
      while (Race.finishedCars.size() != CARS_COUNT) {
        Thread.sleep(1000);
      }
    } catch (InterruptedException e) {
      logger.log(Level.WARNING, e.getMessage(), e);
    }
    System.out.printf("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!! Победитель - %s", Race.finishedCars.get(0));
  }
}

