package level2.lesson2.examples;

public class ArithmeticTest {
  public static void main(String[] args) {
    int b = 0;
    try {
      int result = divide(10, b);
      System.out.printf("Result = %d\n", result);
    } catch (ArithmeticException e) {
      System.out.println("Divide by zero!");
    }

    try {
      int result = divide(10, b);
      System.out.printf("Result = %d\n", result);
    } catch (Throwable e) {  // все исключения наследуются от Throwable
      System.out.println("Divide by zero!");
    }

    // обработка нескольких исключений (всегда идем от частного к общему)
    b = 1;
    try {
      int result = divide(10, b);
      System.out.printf("Result = %d\n", result);
      int[] array = {1, 2, 3};
      for (int i = 0; i <= array.length; i++) {
        System.out.println(array[i]);
      }
    } catch (ArithmeticException e) {
      System.out.println("Divide by zero!");
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Index error!");
    } catch (RuntimeException e) {
      System.out.println("Another error!");
    }

    // в catch можно передавать несколько исключений через оператор ИЛИ
    try {
      int result = divide(11, b);
      System.out.printf("Result = %d\n", result);
      int[] array = {1, 2, 3};
      for (int i = 0; i <= array.length; i++) {
        System.out.println(array[i]);
      }
    } catch (ArithmeticException | IndexOutOfBoundsException e) {
      System.out.println("ERROR!");
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
  }

  private static int divide(int a, int b) {
    return a / b;
  }
}
