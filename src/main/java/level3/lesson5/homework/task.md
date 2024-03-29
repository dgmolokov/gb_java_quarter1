1. Перенести приведенный ниже код в новый проект, где мы организуем гонки.

Все участники должны стартовать одновременно, несмотря на разное время подготовки. В тоннель не может одновременно заехать больше половины участников (условность).

Попробуйте все это синхронизировать.

Первый участник, пересекший финишную черту, объявляется победителем (в момент пересечения этой самой черты). Победитель должен быть только один (ситуация с 0 или 2+ победителями недопустима).
Когда все завершат гонку, нужно выдать объявление об окончании.

Можно корректировать классы (в том числе конструктор машин) и добавлять объекты классов из пакета java.util.concurrent.

```java
public class MainClass {
  public static final int CARS_COUNT = 4;
  public static void main(String[] args) {
    System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
    Race race = new Race(new Road(60), new Tunnel(), new Road(40));
    Car[] cars = new Car[CARS_COUNT];
    for (int i = 0; i < cars.length; i++) {
      cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
    }
    for (int i = 0; i < cars.length; i++) {
      new Thread(cars[i]).start();
    }
    System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
    System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
  }
}
public class Car implements Runnable {
  private static int CARS_COUNT;
  private Race race;
  private int speed;
  private String name;
  public String getName() {
    return name;
  }
  public int getSpeed() {
    return speed;
  }
  public Car(Race race, int speed) {
    this.race = race;
    this.speed = speed;
    CARS_COUNT++;
    this.name = "Участник #" + CARS_COUNT;
  }
  @Override
  public void run() {
    try {
      System.out.println(this.name + " готовится");
      Thread.sleep(500 + (int)(Math.random() * 800));
      System.out.println(this.name + " готов");
    } catch (Exception e) {
      e.printStackTrace();
    }
    for (int i = 0; i < race.getStages().size(); i++) {
      race.getStages().get(i).go(this);
    }
  }
}
public abstract class Stage {
  protected int length;
  protected String description;
  public String getDescription() {
    return description;
  }
  public abstract void go(Car c);
}
public class Road extends Stage {
  public Road(int length) {
    this.length = length;
    this.description = "Дорога " + length + " метров";
  }
  @Override
  public void go(Car c) {
    try {
      System.out.println(c.getName() + " начал этап: " + description);
      Thread.sleep(length / c.getSpeed() * 1000);
      System.out.println(c.getName() + " закончил этап: " + description);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
public class Tunnel extends Stage {
  public Tunnel() {
    this.length = 80;
    this.description = "Тоннель " + length + " метров";
  }
  @Override
  public void go(Car c) {
    try {
      try {
        System.out.println(c.getName() + " готовится к этапу(ждет): " +
          description);
        System.out.println(c.getName() + " начал этап: " + description);
        Thread.sleep(length / c.getSpeed() * 1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        System.out.println(c.getName() + " закончил этап: " +
          description);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
public class Race {
  private ArrayList<Stage> stages;
  public ArrayList<Stage> getStages() { return stages; }
  public Race(Stage... stages) {
    this.stages = new ArrayList<>(Arrays.asList(stages));
  }
}
```