package level2.lesson5.examples;

public class MyThreadNested {
  public static void main(String[] args) {
    Thread thread = new Thread(() -> {
      for (int i = 0; i < 5; i++) {
        System.out.println(i);
      }
    });
    thread.start();
  }
}
