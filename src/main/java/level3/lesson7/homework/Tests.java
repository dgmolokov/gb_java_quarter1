package level3.lesson7.homework;

public class Tests {
  @BeforeSuite
  public void begin() {
    System.out.println("Executing '@BeforeSuite method'");
  }

  @AfterSuite
  public void end() {
    System.out.println("Executing '@AfterSuite method'");
  }

  @Test(priority = 5)
  public void test5() {
    System.out.println("Executing test with 5 priority");
  }

  @Test(priority = 10)
  public void firstTest10() {
    System.out.println("Executing test with 10 priority");
  }

  @Test(priority = 10)
  public void secondTest10() {
    System.out.println("Executing test with 10 priority");
  }

  @Test(priority = 3)
  public void test3() {
    System.out.println("Executing test with 3 priority");
  }

  @Test
  public void test() {
    System.out.println("Executing test with default (1) priority");
  }

  @Test(priority = 6)
  public void test6() {
    System.out.println("Executing test with 6 priority");
  }
}
