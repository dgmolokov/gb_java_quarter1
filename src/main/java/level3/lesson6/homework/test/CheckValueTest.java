package level3.lesson6.homework.test;

import level3.lesson6.homework.ListMethods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CheckValueTest {
  public static ListMethods listMethods;

  @BeforeAll
  public static void init() {
    listMethods = new ListMethods();
  }

  @Test
  public void testWithSingleOne() {
    Assertions.assertTrue(listMethods.checkValues(List.of(1, 2, 7)));
  }

  @Test
  public void testWithSingleFour() {
    Assertions.assertTrue(listMethods.checkValues(List.of(4, 2, 7)));
  }

  @Test
  public void testWithOneAndFour() {
    Assertions.assertTrue(listMethods.checkValues(List.of(4, 2, 7, 1)));
  }

  @Test
  public void testWithoutOneAndFour() {
    Assertions.assertFalse(listMethods.checkValues(List.of(2, 7)));
  }
}
