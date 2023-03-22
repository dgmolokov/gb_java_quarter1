package level3.lesson5.examples;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
  public static void main(String[] args) throws InterruptedException {
    final int THREADS_COUNT = 6;
    final CountDownLatch cd1 = new CountDownLatch(THREADS_COUNT);
    System.out.println("Начинаем");
    for (int i = 0; i < THREADS_COUNT; i++) {
      final int w = i;
      new Thread(() -> {
        try {
          // считаем, что выполнение задачи занимает ~1 сек
          Thread.sleep(500 + (int)(500 * Math.random()));
          cd1.countDown();
          // как только задача выполнена, уменьшаем счетчик
          System.out.println("Поток #" + w + " - готов");
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }).start();
    }
    // пока счетчик не приравняется нулю, будем стоять на этой строке
    cd1.await();
    // как только все потоки выполнили свои задачи - пишем сообщение
    System.out.println("Работа завершена");
  }
}
