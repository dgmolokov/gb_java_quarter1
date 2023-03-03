package level2.lesson1.homework.creatures;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Competitor implements CompetitorInterface {
  private String name;
  private int maxRunDistance;
  private int maxJumpDistance;

  public boolean run(int distance) {
    setMaxRunDistance(getMaxRunDistance() - distance);
    if (getMaxRunDistance() < 0) {
      System.out.printf("%s устал и не смог пробежать дорожку в %d метров!\n", getName(), distance);
      return false;
    }
    System.out.printf("%s пробежал дорожку в %d метров! %s может пробежать еще %d метров.\n", getName(), distance, getName(), getMaxRunDistance());
    return true;
  }

  public boolean jump(int distance) {
    if (getMaxJumpDistance() < 0) {
      System.out.printf("%s не смог перепрыгнуть стенку в %d сантиметров!\n", getName(), distance);
      return false;
    }
    System.out.printf("%s перепрыгнул стенку в %d сантиметров!\n", getName(), distance);
    return true;
  }
}
