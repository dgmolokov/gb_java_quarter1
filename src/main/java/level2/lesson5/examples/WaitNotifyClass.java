package level2.lesson5.examples;

// синхронизация с помощью wait и notify

/*Метод wait() обычно ожидает до тех пор, пока не будет вызван метод notify() или notifyAll(). Но вполне
вероятно, хотя и в очень редких случаях, что ожидающий поток исполнения может быть возобновлен
вследствие ложной активизации без вызова метода notify() или notifyAll(). Из-за этой маловероятной
возможности рекомендуется вызывать метод wait() в цикле, проверяющем условие, по которому поток
ожидает возобновления (в примере выше проверка текущей буквы сделана в цикле).*/
public class WaitNotifyClass {
  private final Object mon = new Object();
  private volatile char currentLetter = 'A';

  public static void main(String[] args) {
    WaitNotifyClass waitNotifyObj = new WaitNotifyClass();
    Thread thread1 = new Thread(() -> {
      waitNotifyObj.printA();
    });
    Thread thread2 = new Thread(() -> {
      waitNotifyObj.printB();
    });
    thread1.start();
    thread2.start();
  }

  public void printA() {
    synchronized (mon) {
      try {
        for (int i = 0; i < 10; i++) {
          while (currentLetter != 'A') {
            mon.wait();
          }
          System.out.print("A");
          currentLetter = 'B';
          mon.notify();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void printB() {
    synchronized (mon) {
      try {
        for (int i = 0; i < 10; i++) {
          while (currentLetter != 'B') {
            mon.wait();
          }
          System.out.print("B");
          currentLetter = 'A';
          mon.notify();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
