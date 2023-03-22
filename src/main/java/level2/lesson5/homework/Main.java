package level2.lesson5.homework;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
  private static final Logger LOGGER = Logger.getLogger("Main");
  static final int SIZE = 10_000_000;
  static final int HALF = SIZE / 2;


  private static Double calculate(Float i) {
    return i * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2);
  }


  private static void methodA() {
    var list = new ArrayList<Float>(SIZE);
    var resultList = new ArrayList<Double>(SIZE);
    for (int i = 0; i < SIZE; i++) {
      list.add(1.0f);
    }
    long startTime = System.currentTimeMillis();
    for (Float i : list) {
      resultList.add(calculate(i));
    }
    System.out.printf("One thread time: %d ms.\n", System.currentTimeMillis() - startTime);
  }

  private static void methodB() {
    var list = new ArrayList<Float>(SIZE);
    for (int i = 0; i < SIZE; i++) {
      list.add(1.0f);
    }
    long startTime = System.currentTimeMillis();
    var subList1 = new ArrayList<>(list.subList(0, HALF));
    var subList2 = new ArrayList<>(list.subList(HALF + 1, list.size()));
    var resultList = new ArrayList<Double>(SIZE);
    var thread1 = new Thread(() -> {
      for (Float i : subList1) {
        resultList.add(calculate(i));
      }
    }, "Thread 1");
    var thread2 = new Thread(() -> {
      for (Float i : subList2) {
        resultList.add(calculate(i));
      }
    }, "Thread 2");
    thread1.start();
    thread2.start();
    try {
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {
      LOGGER.log(Level.WARNING, "An error occurred while calculating the list", e);
    }
    System.out.printf("Two thread time: %d ms.\n", System.currentTimeMillis() - startTime);
  }


  public static void main(String[] args) {
    methodA();
    methodB();
  }
}
