package level2.lesson2.homework;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    var lists = new ArrayList<List<Integer>>();
    for (int i = 0; i < 4; i++) {
      lists.add(List.of(1, 2, 3, 4));
    }
    System.out.println(sum(lists));
  }

  private static int sum(ArrayList lists) {
    int count = 0;
    if (lists.size() != 4) throw new MyArraySizeException("Список должен быть размером 4x4!");
    for (int i = 0; i < 4; i++) {
      var list = (List<Integer>) lists.get(i);
      if (list.size() != 4) throw new MyArraySizeException("Список должен быть размером 4x4!");
      for (int j = 0; j < 4; j++) {
        count += list.get(j);
      }
    }
    return count;
  }
}
