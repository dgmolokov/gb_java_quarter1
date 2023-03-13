package level2.lesson5.examples;

public class ManageThreads {
  public static void main(String[] args) throws InterruptedException {
//    // получение имени текущего потока
//    System.out.println(Thread.currentThread().getName());

//    // приостановка потоков
//    for (int i = 0; i < 10; i++) {
//      try {
//        Thread.sleep(10);
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
//      System.out.println(i);
//    }

//    // Daemon (служебный) поток - работает до тех пор, пока работает хотя бы один обычный поток
//    Thread thread = new Thread(() -> System.out.println(1));
//    thread.setDaemon(true);
//    thread.start();

//    // Ожидание завершения работы потока
//    Thread thread = new Thread(() -> {
//      for (int i = 0; i < 5; i++) {
//        try {
//          Thread.sleep(50);
//        } catch (InterruptedException e) {
//          e.printStackTrace();
//        }
//        System.out.println(i);
//      }
//    });
//    thread.start();
//    thread.join();
//    System.out.println("END");

//    // Управление приоритетом. Thread.MIN_PRIORITY - 1, Thread.MAX_PRIORITY - 10
//    Thread thread = new Thread(() -> {
//      for (int i = 0; i < 5; i++) {
//        try {
//          Thread.sleep(50);
//        } catch (InterruptedException e) {
//          e.printStackTrace();
//        }
//        System.out.println(i);
//      }
//    });
//    thread.start();
//    thread.getPriority();
//    thread.setPriority(5);
  }
}
