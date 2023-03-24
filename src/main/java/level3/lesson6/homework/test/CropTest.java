package level3.lesson6.homework.test;

import level3.lesson6.homework.ListMethods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CropTest {
  private static ListMethods listMethods;

  @BeforeAll
  public static void init() {
    listMethods = new ListMethods();
  }

  @Test
  public void testWithSingleFour() {
    Assertions.assertEquals(List.of(1, 7), listMethods.cropAfter4(List.of(1, 2, 2, 3, 4, 1, 7)));
  }

  @Test
  public void testWithTwoFours() {
    Assertions.assertEquals(List.of(1, 7), listMethods.cropAfter4(List.of(1, 2, 4, 2, 3, 4, 1, 7)));
  }

  @Test
  public void testWithLastFours() {
    Assertions.assertEquals(List.of(), listMethods.cropAfter4(List.of(1, 2, 4, 2, 3, 4, 1, 4)));
  }

  @Test
  public void testWithoutFours() {
    Assertions.assertThrows(RuntimeException.class, () -> listMethods.cropAfter4(List.of(1, 2, 2, 3, 1, 7)));
  }
}
