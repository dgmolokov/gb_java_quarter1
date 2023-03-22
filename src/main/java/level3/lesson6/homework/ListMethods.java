package level3.lesson6.homework;

import java.util.ArrayList;
import java.util.List;

public class ListMethods {
  public List<Integer> cropAfter4(List<Integer> list) {
    if (!list.contains(4)) throw new RuntimeException();
    var result = new ArrayList<Integer>();
    for (Integer i : list) {
      if (i == 4) {
        result.clear();
        continue;
      }
      result.add(i);
    }
    return result;
  }

  public boolean checkValues(List<Integer> list) {
    return list.contains(1) || list.contains(4);
  }
}
