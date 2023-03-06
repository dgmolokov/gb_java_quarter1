package level2.lesson3.homework;

import java.util.*;

public class Words {
  private static final HashMap<String, Integer> wordsCount = new HashMap<>();

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
    System.out.println(getUniqueWords(words));
    System.out.println(countWords(words));
  }

  private static Set<String> getUniqueWords(List<String> words) {
    return Set.copyOf(words);
  }

  private static HashMap<String, Integer> countWords(List<String> words) {
    for (String word : words) {
      wordsCount.computeIfPresent(word, (key, value) -> value + 1);
      wordsCount.putIfAbsent(word, 1);
    }
    return wordsCount;
  }
}
