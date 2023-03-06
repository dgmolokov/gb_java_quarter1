package level2.lesson3.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phonebook {
  private static final HashMap<String, String> phonebook = new HashMap<>();

  public static void main(String[] args) {
    phonebook.put("8(923)5876152", "Molokov");
    phonebook.put("8(923)5342634", "Solyanin");
    phonebook.put("8(923)5812366", "Shopin");
    phonebook.put("8(923)5877875", "Molokov");
    phonebook.put("8(923)5826323", "Shopin");
    System.out.println(get("Solyanin"));
    System.out.println(get("Molokov"));
    System.out.println(get("Shopin"));
  }

  private static List<String> get(String lastName) {
    var phoneNumbers = new ArrayList<String>();
    if (phonebook.containsValue(lastName)) {
      for (Map.Entry<String, String> entry : phonebook.entrySet()) {
        if (lastName.equals(entry.getValue())) {
          phoneNumbers.add(entry.getKey());
        }
      }
      return phoneNumbers;
    }
    return null;
  }
}
