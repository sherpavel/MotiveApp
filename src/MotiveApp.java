import ui.Window;
import task.Task;
import java.util.*;
import java.io.*;

public class MotiveApp {
  public static void main(String[] args) {

    // We can take this value as an input
    int numTasks = 10;
    boolean tasksLeft = true;

    int pointGoal = 0;
    int totalPoints = 0;

    ArrayList<Task> taskList = new ArrayList<Task>(numTasks);
    // Read tasks from the .dat file and create and add the tasks to the taskList
    Scanner sc = null;
    try {
      File file = new File("./data/tasks.dat");
      sc = new Scanner(file);
    }
    catch (FileNotFoundException e){
      System.out.println("File not found");
    }
    // Read the data file
    for(int i = 0; sc.hasNextLine(); i++){
      String line = sc.nextLine();
      String[] lineSplit = line.split(",");
      String name = lineSplit[0];
      String taskSize = lineSplit[1];
      Task newTask = new Task(name,taskSize);
      taskList.add(newTask);
    }
    sc.close();

    Window.startWindow(taskList);

//    int[] completedTasks = new int[numTasks];
//    for(int i =0; i < taskList.length; i++){
//      if(taskList.get(i).getCompleted()){
//        completedTasks
//      }
//    }
    while (tasksLeft) {
      // Output a task for the person to do at specific times


      // If they finished the task then remove it from the list and add points
//      totalPoints += taskList.get( ).getPointValue();
      tasksLeft = false;
    }
  }
}
