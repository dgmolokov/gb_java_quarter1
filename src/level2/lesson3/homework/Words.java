package level2.lesson3.homework;

import java.util.*;

public class Words {
  private static final int COUNTER = 1;

  public static void main(String[] args) {
    var words = new ArrayList<>(List.of(
      "Быстрина",
      "Гран",
      "Занумеровать",
      "Крахмал",
      "Промяться",
      "Пикник",
      "Занумеровать",
      "Пообещать",
      "Сечение",
      "Привадить",
      "Промяться",
      "Занумеровать",
      "Промяться",
      "Радиотелеграф",
      "Сечение"
    ));
    System.out.printf("Unique words - %s\n", Set.copyOf(words));
    System.out.println(countWords(words));
  }

  private static HashMap<String, Integer> countWords(List<String> words) {
    var wordsCount = new HashMap<String, Integer>();
    for (String word : words) {
      wordsCount.computeIfPresent(word, (key, value) -> value + COUNTER);
      wordsCount.putIfAbsent(word, COUNTER);
    }
    return wordsCount;
  }
}
