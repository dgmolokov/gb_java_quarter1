package level2.lesson2.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Main {
  private static final Logger log = Logger.getLogger("Main");
  public static void main(String[] args) {
    var lists = new ArrayList<List>();
    for (int i = 0; i < 4; i++) {
      lists.add(List.of(1, 2, 3, 4));
    }
    try {
      System.out.println(getSumOfMatrixElements(lists));
    } catch (MyArraySizeException | MyArrayDataException e) {
      log.info(e.getMessage());
    }
  }

  private static int getSumOfMatrixElements(ArrayList<List> lists) {
    if (lists.size() != 4) throw new MyArraySizeException("Количество списков должно быть равно четырем!");
    int sum = 0;
    try {
      for (List list: lists) {
        sum += getSumOfList(list);
      }
      return sum;
    } catch (ClassCastException e) {
      throw new MyArrayDataException("В списках найдено что-то кроме чисел!");
    }
  }

  private static int getSumOfList(List<Integer> list) {
    if (list.size() != 4) throw new MyArraySizeException("Количество элементов в списке должно быть равно четырем!");
    int sum = 0;
    for (int i: list) {
      sum += i;
    }
    return sum;
  }
}
