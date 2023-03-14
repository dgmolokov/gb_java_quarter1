package level2.lesson5.homework;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
  private static final Logger LOGGER = Logger.getLogger("Main");
  static final int SIZE = 10_000_000;
  static final int HALF = SIZE / 2;


  private static void calculate(ArrayList<Float> list) {
    for (int i = 0; i < list.size(); i++) {
      list.set(i, (float) (list.get(i) * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2)));
    }
  }


  private static void methodA() {
    var list = new ArrayList<Float>(SIZE);
    for (int i = 0; i < SIZE; i++) {
      list.add(1.0f);
    }
    long startTime = System.currentTimeMillis();
    calculate(list);
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
    var thread1 = new Thread(() -> calculate(subList1), "Thread 1");
    var thread2 = new Thread(() -> calculate(subList2), "Thread 2");
    thread1.start();
    thread2.start();
    try {
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {
      LOGGER.log(Level.SEVERE, "An error occurred while calculating the list", e);
    }
    var resultList = new ArrayList<Float>(SIZE);
    resultList.addAll(subList1);
    resultList.addAll(subList2);
    System.out.printf("Two thread time: %d ms.\n", System.currentTimeMillis() - startTime);
  }


  public static void main(String[] args) {
    methodA();
    methodB();
  }
}
