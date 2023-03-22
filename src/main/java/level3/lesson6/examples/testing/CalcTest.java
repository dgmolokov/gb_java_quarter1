package level3.lesson6.examples.testing;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class CalcTest {
  private Calculator calculator;

  @BeforeEach
  public void init() {
    calculator = new Calculator();
  }

  @Test
  public void testAdd() {
    Assertions.assertEquals(4, calculator.add(2, 2));
  }

  @Test
  public void testSub() {
    Assertions.assertEquals(3, calculator.sub(5, 2));
  }

  @Test
  public void testMul() {
    Assertions.assertEquals(9, calculator.mul(3, 3));
  }

  @Test
  @Disabled("Деление пока тестировать не нужно")
  public void testDiv() {
    Assertions.assertEquals(1, calculator.div(2, 2));
  }

  @Test
  @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
  public void longOperation() {
    // выполняем тяжелую задачу
  }

  @Test
  public void checkSomething() {
    Assertions.assertThrows(ArithmeticException.class, () -> {
      var a = 2 / 0;
    });
  }

  @CsvSource({
    "1, 1, 2",
    "2, 3, 5",
    "7, 5, 12",
    "12, 12, 24"
  })
  @ParameterizedTest
  public void massTestAdd(int a, int b, int result) {
    Assertions.assertEquals(result, calculator.add(a, b));
  }

  @ParameterizedTest
  @MethodSource("dataForAddOperation")
  public void testAddOperation(int a, int b, int result) {
    Assertions.assertEquals(result, calculator.add(a, b));
  }

  public static Stream<Arguments> dataForAddOperation() {
    List<Arguments> out = new ArrayList<>();
    for (int i = 0; i < 10000; i++) {
      int a = (int) (Math.random() * 1000);
      int b = (int) (Math.random() * 1000);
      int result = a + b;
      out.add(Arguments.arguments(a, b, result));
    }
    return out.stream();
  }

  @ParameterizedTest
  @MethodSource("dataForArraySumOperation")
  public void testArraySumOperation(int[] array, int result) {
    Assertions.assertEquals(result, calculator.arraySum(array));
  }
  public static Stream<Arguments> dataForArraySumOperation() {
    List<Arguments> out = new ArrayList<>();
    out.add(Arguments.arguments(new int[] { 1, 1, 1 }, 3));
    out.add(Arguments.arguments(new int[] { 2, 2, 2 }, 6));
    out.add(Arguments.arguments(new int[] { 1, 2, 3 }, 6));
    out.add(Arguments.arguments(new int[] { 10, 10, 5 }, 25));
    return out.stream();
  }
}
