package level3.lesson5.examples.executorServiceExamples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RequestApp {
  public static void main(String[] args) throws InterruptedException {
    ExecutorService service = Executors.newFixedThreadPool(10);
    for (int n = 0; n < 100; n++) {
      Thread.sleep(1000);
      for (int i = 0; i < 100; i++) {
        service.execute(() -> {
          System.out.println(1);
        });
      }
    }
    service.shutdown();
  }
}
