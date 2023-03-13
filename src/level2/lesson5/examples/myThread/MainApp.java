package level2.lesson5.examples.myThread;

public class MainApp {
  public static void main(String[] args) {
    Thread thread1 = new MyThread();
    Thread thread2 = new MyThread();
    thread1.start();
    thread2.start();
  }
}
