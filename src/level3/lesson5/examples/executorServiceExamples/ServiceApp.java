package level3.lesson5.examples.executorServiceExamples;

import java.util.concurrent.*;

//● newSingleThreadExecutor() создает пул в котором только один рабочий поток, т. е. в единицу
//времени он может выполнять только одну задачу;
//● newFixedThreadPool(int nThreads) создает пул с фиксированным количеством потоков;
//● newCachedThreadPool() создает пул, который автоматически расширяется, если ему дали
//задачу и у него не хватает “свободных” потоков. Минусом является то, что у cachedThreadPool нет
//верхней границы, и при высокой частоте появления новых задач он потенциально может
//создавать очень большое количество потоков (возможно потратит все системные ресурсы).

public class ServiceApp {
  public static void main(String[] args) throws InterruptedException, ExecutionException {
//    ExecutorService fixedService = Executors.newFixedThreadPool(10);
//    ExecutorService singleService = Executors.newSingleThreadExecutor();
//    ExecutorService cachedService = Executors.newCachedThreadPool();

    //Метод execute(Runnable runnable) принимает объект java.lang.Runnable и выполняет его асинхронно (в
    //параллельном потоке).
    System.out.println("запуск через execute(Runnable runnable)");
    ExecutorService executorService1 = Executors.newFixedThreadPool(4);
    executorService1.execute(() -> {
      System.out.println("Асинхронная задача");
    });
    executorService1.shutdown();

    //Метод submit(Runnable runnable) также принимает реализацию Runnable, но возвращает объект типа
    //Future. Объекты типа Future хранят в себе информацию о выполняемой в параллельном потоке
    //задаче. Например, можно проверить завершено ли выполнение задачи или нет
    System.out.println("запуск через submit(Runnable runnable)");
    ExecutorService executorService2 = Executors.newFixedThreadPool(2);
    Future future1 = executorService2.submit(() -> {
      System.out.println("Асинхронная задача");
    });
    System.out.println(future1.get()); //null если задача завершилась
    executorService2.shutdown();

    //Экземпляр типа Callable<T> позволяет не только дать потоку задачу, но и получить результат
    //выполнения метода T call(). Для получения результата выполнения такой задачи используется объект
    //типа Future.
    System.out.println("запуск через submit(Callable callable)");
    ExecutorService executorService3 = Executors.newFixedThreadPool(2);
    Future<String> future2 = executorService3.submit(new Callable<String>() {
      @Override
      public String call() throws Exception {
        System.out.println("Асинхронный вызов");
        return "Результат из потока";
      }
    });
    System.out.println("future2.get() = " + future2.get());
    executorService3.shutdown();
    //А что произойдет, если мы запросим результат выполнения потока, до того как сам поток получит этот
    //результат?
    //В таком случае, при вызове future.get() из main потока, main поток перейдет в режим ожидания
    //потока-исполнителя, тем самым станет дожидаться завершения выполнения задачи и получения
    //возврата строки.
    ExecutorService executorService4 = Executors.newFixedThreadPool(2);
    Future<String> future3 = executorService4.submit(() -> {
      System.out.println("Асинхронный вызов");
      Thread.sleep(2000);
      return "Результат из потока";
    });
    System.out.println("future3.get() = " + future3.get());
    executorService4.shutdown();
    //Еще одной интересной особенностью Callable является возможность проброса исключений из потока.
    ExecutorService executorService5 = Executors.newFixedThreadPool(2);
    Future<String> future4 = executorService5.submit(() -> {
      System.out.println("Асинхронный вызов");
      int x = 10 / 0;
      return "Результат из потока";
    });
    try {
      System.out.println("future4.get() = " + future4.get());
    } catch (ExecutionException e) {
      e.printStackTrace();
      e.getCause();
    }
    executorService5.shutdown();
  }
}
