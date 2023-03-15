package level3.lesson1.homework.thirdTask;

import level3.lesson1.homework.thirdTask.fruits.Apple;
import level3.lesson1.homework.thirdTask.fruits.Orange;

public class Main {
  public static void main(String[] args) {
    var firstAppleBox = new Box<Apple>();
    var secondAppleBox = new Box<Apple>();
    var orangeBox = new Box<Orange>();
    firstAppleBox.addFruit(new Apple(1.0f));
    for (int i = 0; i < 3; i++) {
      secondAppleBox.addFruit(new Apple(1.0f));
    }
    for (int i = 0; i < 2; i++) {
      orangeBox.addFruit(new Orange(1.5f));
    }
    System.out.println(firstAppleBox.compare(orangeBox));
    System.out.println(secondAppleBox.compare(orangeBox));
    System.out.println(firstAppleBox.getWeight());
    firstAppleBox.addFromAnotherBox(secondAppleBox);
    System.out.println(firstAppleBox.getWeight());
    System.out.println(secondAppleBox.getWeight());
  }
}
