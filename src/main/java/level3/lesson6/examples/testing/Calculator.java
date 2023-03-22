package level3.lesson6.examples.testing;

public class Calculator {
  public int add(int a, int b) {
    return a + b;
  }

  public int sub(int a, int b) {
    return a - b;
  }

  public int mul(int a, int b) {
    return a * b;
  }

  public int div(int a, int b) {
    return a / b;
  }

  public int arraySum(int[] array) {
    int sum = 0;
    for (int i = 0; i < array.length; i++) {
      sum += array[i];
    }
    return sum;
  }
}
