package level2.lesson5.examples.myRunnableTask;

public class MainApp {
  public static void main(String[] args) {
    Thread thread1 = new Thread(new MyRunnableTask());
    Thread thread2 = new Thread(new MyRunnableTask());
    thread1.start();
    thread2.start();
  }
}
