package level3.lesson5.examples.lockExamples;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Интерфейс Lock из пакета java.util.concurrent – это продвинутый механизм синхронизации потоков.
//По гибкости он выигрывает в сравнении с блоками синхронизации.
//Создаем объект типа Lock и вызываем у него метод lock() – он захватывается. Если другой поток
//попытается вызвать этот метод у того же объекта – он будет блокирован до тех пор, пока поток,
//удерживающий объект lock, не освободит его через метод unlock(). Тогда этот объект смогут
//захватить другие потоки.
public class SimplestLockApp {
  public static void main(String[] args) {
    final Lock lock = new ReentrantLock();
    new Thread(() -> {
      try {
        lock.lock();
        // Критическая секция
      } finally {
        lock.unlock();
      }
    }).start();
  }
}
