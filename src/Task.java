public class Task {

  private String name;
  private String taskSize;
  private boolean completed;


  public Task(String name, String taskSize) {
    this.name = name;
    this.taskSize = taskSize;
    this.completed = false;
  }

  public String getName() {
    return this.name;
  }

  public void setCompleted(boolean bool){
    this.completed = bool;
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