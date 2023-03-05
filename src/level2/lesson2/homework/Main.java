package level2.lesson2.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Main {
  private static final Logger log = Logger.getLogger("Main");
  public static void main(String[] args) {
    var lists = new ArrayList<List<Integer>>();
    for (int i = 0; i < 4; i++) {
      lists.add(List.of(1, 2, 3, 4));
    }
    try {
      System.out.println(sum(lists));
    } catch (MyArraySizeException e) {
      log.info(e.getMessage());
    }
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
