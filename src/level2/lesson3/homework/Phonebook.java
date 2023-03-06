package level2.lesson3.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phonebook {
  private static final HashMap<String, String> phonebook = new HashMap<>();

  public static void main(String[] args) {
    add("8(923)5876152", "Molokov");
    add("8(923)5342634", "Solyanin");
    add("8(923)5812366", "Shopin");
    add("8(923)5877875", "Molokov");
    add("8(923)5826323", "Shopin");
    System.out.println(get("Solyanin"));
    System.out.println(get("Molokov"));
    System.out.println(get("Shopin"));
  }

  private static void add(String phoneNumber, String lastName) {
    phonebook.put(phoneNumber, lastName);
  }

  private static List<String> get(String lastName) {
    var phoneNumbers = new ArrayList<String>();
    if (phonebook.containsValue(lastName)) {
      for (Map.Entry<String, String> entry : phonebook.entrySet()) {
        if (lastName.equals(entry.getValue())) {
          phoneNumbers.add(entry.getKey());
        }
      }
    }
    return phoneNumbers;
  }
}
