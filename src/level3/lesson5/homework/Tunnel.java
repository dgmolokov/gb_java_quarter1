package level3.lesson5.homework;

import lombok.AllArgsConstructor;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

@AllArgsConstructor
public class Tunnel implements Stage {
  private final Logger logger = Logger.getLogger(Tunnel.class.getSimpleName());
  private int length;
  private Semaphore smp;

  @Override
  public void go(Car c) {
    try {
      try {
        if (smp.availablePermits() == 0) {
          System.out.printf("%s готовится к этапу (ждет): %s\n", c, this);
        }
        smp.acquire();
        System.out.printf("%s начал этап: %s\n", c, this);
        Thread.sleep(length / c.getSpeed() * 1000);
      } catch (InterruptedException e) {
        logger.log(Level.WARNING, e.getMessage(), e);
      } finally {
        System.out.printf("%s закончил этап: %s\n", c, this);
        smp.release();
      }
    } catch (Exception e) {
      logger.log(Level.WARNING, e.getMessage(), e);
    }
  }

  @Override
  public String toString() {
    return String.format("Тоннель %d метров", length);
  }
}
