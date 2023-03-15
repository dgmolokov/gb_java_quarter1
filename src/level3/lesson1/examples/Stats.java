package level3.lesson1.examples;

// Объявление public class Stats<T extends Number> сообщает компилятору, что все объекты типа Т
// являются подклассами класса Number, и поэтому могут вызывать метод doubleValue(), как и любой
// другой из класса Number. Ограничивая параметр Т, мы предотвращаем создание нечисловых
// объектов класса Stats.

public class Stats<T extends Number> {
  private T[] nums;

  public Stats(T... nums) {
    this.nums = nums;
  }

  public double avg() {
    double sum = 0.0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i].doubleValue();
    }
    return sum / nums.length;
  }

  // Чтобы создать обобщенную версию метода sameAvg(), следует использовать метасимвольные
  // аргументы. Это средство обобщений Java, которое обозначается символом «?» и представляет собой
  // неизвестный тип.
  public boolean sameAvg(Stats<?> another) {
    return Math.abs(this.avg() - another.avg()) < 0.0001;
  }
}
