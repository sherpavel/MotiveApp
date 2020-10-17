import static javax.swing.text.html.HTML.Tag.SMALL;

public class Task {

  private enum taskType {SMALL, MEDIUM, LARGE}

  ;
  private String name;
  private int timeDuration;
  private taskType taskSize;


  public Task(String name, int timeDuration, taskType taskSize) {
    this.name = name;
    this.timeDuration = timeDuration;
    this.taskSize = taskSize;
  }

  public String getName() {
    return this.name;
  }

  public int getTimeDuration() {
    return this.timeDuration;
  }
//User asses how large/significant the task is assigned Small, Medium, and Large
  public int getPointValue() {
    switch (taskSize) {
      case SMALL:
        return 5;
      case MEDIUM:
        return 10;
      case LARGE:
        return 20;
    }
    return 0;
  }
}