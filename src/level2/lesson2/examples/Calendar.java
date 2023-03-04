package level2.lesson2.examples;

public class Calendar {
  enum Month {
    JANUARY,
    FEBRUARY,
    JUNE,
    DECEMBER,
  }

  public int getNumberOfDays(Month month) throws Exception { // в throws указываются исключения, которые может генерировать метод
    return switch (month) {
      case JANUARY -> 31;
      case FEBRUARY -> 28;
      case JUNE -> 30;
//      case DECEMBER -> 31;
//      default -> throw new IllegalArgumentException(); // генерируем исключение сами
      default -> throw new Exception("Test");
    };
  }

  public static void main(String[] args) {
    Calendar calendar = new Calendar();
    try {
      System.out.println(calendar.getNumberOfDays(Month.DECEMBER));
    } catch (Exception e) { // все Checked исключения должны быть обязательно обработаны через try-catch, либо проброшены наверх
      System.out.println("ERROR");
    }
  }
}
