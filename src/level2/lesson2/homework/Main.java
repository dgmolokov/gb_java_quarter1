package level2.lesson2.homework;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    var lists = new ArrayList<List<String>>();
    for (int i = 0; i < 4; i++) {
      lists.add(List.of("1", "2", "3", "4"));
    }
    try {
      System.out.println(sum(lists));
    } catch (MyArraySizeException e) {
      System.out.println("Массив должен быть размером 4x4!");
    } catch (MyArrayDataException e) {
      System.out.println("Проверьте данные массива - найдено что-то кроме числа в строке!");
    }
  }

  private static int sum(List<List<String>> lists) throws MyArraySizeException, MyArrayDataException {
    int count = 0;
    if (lists.size() != 4) throw new MyArraySizeException();
    for (int i = 0; i < 4; i++) {
      var list = lists.get(i);
      if (list.size() != 4) throw new MyArraySizeException();
      for (int j = 0; j < 4; j++) {
        try {
          count += Integer.parseInt(list.get(j));
        } catch (NumberFormatException e) {
          throw new MyArrayDataException();
        }
      }
    }
    return count;
  }
}
