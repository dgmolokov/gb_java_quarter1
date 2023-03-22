package level3.lesson1.homework.firstTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    var listIntegers = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
    var listStrings = new ArrayList<>(List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
    System.out.printf("Before swap:\n%s\n%s\n", listIntegers, listStrings);
    Collections.swap(listIntegers, 0, 9);
    Collections.swap(listStrings, 0, 9);
    System.out.printf("After swap:\n%s\n%s\n", listIntegers, listStrings);
  }
}
