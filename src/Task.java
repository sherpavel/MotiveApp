public class Task {

  private String name;
  private int timeDuration;
  private int pointValue;

  public Task(String name, int timeDuration, int pointValue) {
    this.name = name;
    this.timeDuration = timeDuration;
    this.pointValue = pointValue;
  }

  public String getName() {
    return this.name;
  }

  public int getTimeDuration() {
    return this.timeDuration;
  }

  public int getPointValue() {
    return this.pointValue;
  }
}