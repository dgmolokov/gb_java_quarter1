package level3.lesson7.homework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestApp {
  private static final Logger logger = Logger.getLogger(TestApp.class.getSimpleName());

  public static void main(String[] args) {
    try {
      start(Tests.class);
    } catch (RuntimeException e) {
      logger.log(Level.WARNING, e.getMessage(), e);
    }
  }

  private static void start(Class<?> testClass) throws RuntimeException {
    var methods = testClass.getMethods();
    var testsWithPriorities = new HashMap<Method, Integer>();
    Method beforeSuiteMethod = null;
    Method afterSuiteMethod = null;
    for (Method method : methods) {
      if (method.getAnnotation(Test.class) != null) {
        testsWithPriorities.put(method, method.getAnnotation(Test.class).priority());
      }
      if (method.getAnnotation(BeforeSuite.class) != null) {
        if (beforeSuiteMethod == null) beforeSuiteMethod = method;
        else throw new RuntimeException("Testing class must contain only one '@BeforeSuite method!'");
      }
      if (method.getAnnotation(AfterSuite.class) != null) {
        if (afterSuiteMethod == null) afterSuiteMethod = method;
        else throw new RuntimeException("Testing class must contain only one '@AfterSuite method!'");
      }
    }

    try {
      var instance = testClass.getConstructor().newInstance();
      executeServiceMethod(beforeSuiteMethod, instance);
      runTests(testsWithPriorities, instance);
      executeServiceMethod(afterSuiteMethod, instance);
    } catch (InvocationTargetException e) {
      logger.log(Level.WARNING, "invoke don't have access to callable method!", e);
    } catch (InstantiationException e) {
      logger.log(Level.WARNING, e.getMessage(), e);
    } catch (IllegalAccessException e) {
      logger.log(Level.WARNING, String.format("invoked method has thrown %s exception!", e.getCause()), e);
    } catch (NoSuchMethodException e) {
      logger.log(Level.WARNING, e.getMessage(), e);
    }
  }

  private static void executeServiceMethod(Method method, Object instance) throws InvocationTargetException, IllegalAccessException {
    if (method != null) {
      method.invoke(instance);
    } else {
      throw new RuntimeException("testClass must contain one '@BeforeSuite' and one '@AfterSuite' methods!");
    }
  }

  private static void runTests(HashMap<Method, Integer> testsWithPriorities, Object instance) throws InvocationTargetException, IllegalAccessException {
    for (int i = Test.MAX_PRIORITY; i >= Test.MIN_PRIORITY; i--) {
      for (Map.Entry<Method, Integer> testsEntry : testsWithPriorities.entrySet()) {
        if (testsEntry.getValue() == i) testsEntry.getKey().invoke(instance);
      }
    }
  }
}
