package level3.lesson1.examples;

public class StatsDemoApp {
  public static void main(String[] args) {
    Stats<Integer> intStats = new Stats<Integer>(1, 2, 3, 4, 5);
    System.out.println("Среднее значение stats равно " + intStats.avg());

    Stats<Double> doubleStats = new Stats<Double>(1.0, 2.0, 3.0, 4.0, 5.0);
    System.out.println("Среднее значение doubleStats равно " + doubleStats.avg());

    Stats<Float> floatStats = new Stats<>(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
    System.out.println("Среднее значение stats равно " + floatStats.avg());

    // Это не скомпилируется, потому что String не является подклассом Number
//    Stats<String> strStats = new Stats<>("1", "2", "3", "4", "5");
//    System.out.println("Среднее значение strStats равно " + strStats.avg());

    System.out.print("Средние iStats и dStats ");
    if (intStats.sameAvg(doubleStats)) {
      System.out.println("равны");
    } else {
      System.out.println("отличаются");
    }
    System.out.print("Средние iStats и fStats ");
    if (intStats.sameAvg(floatStats)) {
      System.out.println("равны");
    } else {
      System.out.println("отличаются");
    }
  }
}
