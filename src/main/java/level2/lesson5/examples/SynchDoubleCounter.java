package level2.lesson5.examples;

// Делаем объект с двумя переменными, которые хотелось бы изменять параллельно с помощью POJO мониторов
// POJO - Plain Old Java Object (самые обычные Java объекты)
public class SynchDoubleCounter {
  private long first;
  private long second;
  private Object monFirst = new Object();
  private Object monSecond = new Object();
  public long getFirst() {
    return first;
  }
  public long getSecond() {
    return second;
  }
  public void incrementFirst() {
    synchronized (monFirst) {
      first++;
    }
  }
  public void incrementSecond() {
    synchronized (monSecond) {
      second++;
    }
  }
  public void decrementFirst() {
    synchronized (monFirst) {
      first--;
    }
  }
  public void decrementSecond() {
    synchronized (monSecond) {
      second--;
    }
  }
}