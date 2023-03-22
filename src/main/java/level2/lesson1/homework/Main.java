package level2.lesson1.homework;

import level2.lesson1.homework.creatures.Cat;
import level2.lesson1.homework.creatures.Competitor;
import level2.lesson1.homework.creatures.Human;
import level2.lesson1.homework.creatures.Robot;
import level2.lesson1.homework.obstacles.Obstacle;
import level2.lesson1.homework.obstacles.Treadmill;
import level2.lesson1.homework.obstacles.Wall;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    var competitors = List.of(
      new Cat("Barsik", 100, 100),
      new Cat("Murzik", 150, 150),
      new Human("Andrey", 2000, 150),
      new Human("Dima", 500, 100),
      new Robot("T-1000", 50000, 300)
    );
    var obstacles = List.of(
      new Treadmill(100),
      new Wall(50),
      new Treadmill(150),
      new Wall(100),
      new Treadmill(200),
      new Wall(150),
      new Treadmill(300),
      new Wall(200),
      new Treadmill(400),
      new Wall(250),
      new Treadmill(500),
      new Wall(300)
    );
    for (Competitor competitor : competitors) {
      for (Obstacle obstacle : obstacles) {
        if (obstacle instanceof Treadmill) {
          if (!competitor.run(obstacle.getDistance())) {
            System.out.printf("%s выбывает!\n", competitor.getName());
            break;
          }
        }
        if (obstacle instanceof Wall) {
          if (!competitor.jump(obstacle.getDistance())) {
            System.out.printf("%s выбывает!\n", competitor.getName());
            break;
          }
        }
      }
    }
  }
}
