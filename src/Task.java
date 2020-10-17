public class Task {

  private String name;
  private String  taskSize;


  public Task(String name, String taskSize) {
    this.name = name;
    this.taskSize = taskSize;
  }

  public String getName() {
    return this.name;
  }

//User asses how large/significant the task is assigned Small, Medium, and Large
  public int getPointValue() {
    return switch (taskSize) {
      case "SMALL" -> 5;
      case "MEDIUM" -> 10;
      case "LARGE" -> 20;
      default -> 0;
    };
  }
}