package level3.lesson1.homework.thirdTask;

import level3.lesson1.homework.thirdTask.fruits.Fruit;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
  List<T> fruits = new ArrayList<>();

  public Box(List<T> initialFruitList) {
    fruits.addAll(initialFruitList);
  }

  public float getWeight() {
    float sum = 0;
    for (Fruit fruit : fruits) {
      sum += fruit.getWeight();
    }
    return sum;
  }

  public boolean compare(Box<? extends Fruit> box) {
    return getWeight() == box.getWeight();
  }

  public void addFromAnotherBox(Box<T> box) {
    fruits.addAll(box.fruits);
    box.fruits.clear();
  }

  public void addFruit(T fruit) {
    fruits.add(fruit);
  }

  @Override
  public String toString() {
    return String.format("%d fruits, %f weight", fruits.size(), getWeight());
  }
}
