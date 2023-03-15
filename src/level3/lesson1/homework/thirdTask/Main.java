package level3.lesson1.homework.thirdTask;

import level3.lesson1.homework.thirdTask.fruits.Apple;
import level3.lesson1.homework.thirdTask.fruits.Orange;

import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    var firstAppleBox = new Box<>(List.of(new Apple(1.0f)));
    var secondAppleBox = new Box<>(List.of(new Apple(1.0f), new Apple(2.0f)));
    var orangeBox = new Box<>(List.of(new Orange(1.5f), new Orange(1.5f)));
    System.out.println(firstAppleBox);
    System.out.println(secondAppleBox);
    System.out.println(orangeBox);
    System.out.println(firstAppleBox.compare(orangeBox));
    System.out.println(secondAppleBox.compare(orangeBox));
    System.out.println(firstAppleBox);
    firstAppleBox.addFromAnotherBox(secondAppleBox);
    System.out.println(firstAppleBox);
    System.out.println(secondAppleBox);
  }
}
