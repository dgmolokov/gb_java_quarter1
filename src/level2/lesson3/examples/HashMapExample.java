package level2.lesson3.examples;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
  public static void main(String[] args) {
    Map<String, String> hm = new HashMap<>();
    hm.put("Russia", "Moscow");
//    hm.put("Russia", "Smolensk");
    hm.put("France", "Moscow");
    hm.put("Germany", "Moscow");
    hm.put("Norway", "Moscow");

    for (String key : hm.keySet()) {
      String value = hm.get(key);
      System.out.printf("%s - %s", key, value);
    }
  }
}
