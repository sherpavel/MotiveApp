import ui.Window;
import task.Task;
import java.util.*;
import java.io.*;

public class MotiveApp {
  public static void main(String[] args) {

    // We can take this value as an input
    int numTasks = 10;

    int totalPoints = 0;
    ArrayList<Task> taskList = new ArrayList<Task>(numTasks);
    // Get user input and provide tasks based on what the person using the app needs
//    Scanner sc = new Scanner(System.in);


    // Read tasks from the .dat file and create and add the tasks to the taskList
    Scanner sc = null;
    try {
      File file = new File("src/data/tasks.dat");
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
    ArrayList<Integer> completedTasks = new ArrayList<Integer>(numTasks);
    for(Task task: taskList){
      if(task.getCompleted()){
        completedTasks.add(taskList.indexOf(task));
        totalPoints += task.getPointValue();
      }
    }
  }
}
