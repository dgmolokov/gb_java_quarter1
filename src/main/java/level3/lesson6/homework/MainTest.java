package level3.lesson6.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MainTest {
  private ListMethods methods;

  @BeforeEach
  public void init() {
    methods = new ListMethods();
  }

  @Test
  public void testCropException() {
    Assertions.assertThrows(RuntimeException.class, () -> methods.cropAfter4(List.of()));
  }

  @ParameterizedTest
  @MethodSource("dataForCrop")
  public void testCrop(List<Integer> data, List<Integer> result) {
    Assertions.assertEquals(result, methods.cropAfter4(data));
  }

  public static Stream<Arguments> dataForCrop() {
    List<Arguments> out = new ArrayList<>();
    out.add(Arguments.arguments(List.of(1, 2, 4, 4, 2, 3, 4, 1, 7), List.of(1, 7)));
    out.add(Arguments.arguments(List.of(1, 2, 4, 4, 2, 3, 6, 1, 7), List.of(2, 3, 6, 1, 7)));
    out.add(Arguments.arguments(List.of(1, 2, 4, 4, 2, 3, 4, 4, 7), List.of(7)));
    out.add(Arguments.arguments(List.of(1, 2, 4, 4, 2, 3, 4, 1, 4), List.of()));
    return out.stream();
  }

  @ParameterizedTest
  @MethodSource("dataForCheckValuesTrue")
  public void testCheckValuesTrue(List<Integer> data) {
    Assertions.assertTrue(methods.checkValues(data));
  }

  public static Stream<Arguments> dataForCheckValuesTrue() {
    List<Arguments> out = new ArrayList<>();
    out.add(Arguments.arguments(List.of(1, 2, 4, 4, 2, 3, 4, 1, 7)));
    out.add(Arguments.arguments(List.of(1, 2, 4, 4, 2, 3, 6, 1, 7)));
    out.add(Arguments.arguments(List.of(1, 2, 4, 4, 2, 3, 4, 4, 7)));
    out.add(Arguments.arguments(List.of(1, 2, 4, 4, 2, 3, 4, 1, 4)));
    return out.stream();
  }

  @ParameterizedTest
  @MethodSource("dataForCheckValuesFalse")
  public void testCheckValuesFalse(List<Integer> data) {
    Assertions.assertFalse(methods.checkValues(data));
  }

  public static Stream<Arguments> dataForCheckValuesFalse() {
    List<Arguments> out = new ArrayList<>();
    out.add(Arguments.arguments(List.of(2, 2, 3, 7)));
    out.add(Arguments.arguments(List.of(2, 2, 3, 6, 7)));
    out.add(Arguments.arguments(List.of(2, 2, 3, 7)));
    out.add(Arguments.arguments(List.of(2, 5, 3)));
    return out.stream();
  }
}
