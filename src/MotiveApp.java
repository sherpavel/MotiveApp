//import ui.Window;
import java.util.*;
import java.io.*;

public class MotiveApp {
  public static void main(String[] args) {
    //Window.startWindow(800, 800);

    // We can take this value as an input
    int numTasks = 10;
    boolean tasksLeft = true;

    int pointGoal = 0;
    int totalPoints = 0;

    ArrayList<Task> taskList = new ArrayList<Task>(numTasks);
    int[] completedTaskIdx = new int[numTasks];
    // Read tasks from the .dat file and create and add the tasks to the taskList
    Scanner sc = null;
    try {
      sc = new Scanner(new File("src/data/tasks.dat"));
    }
    catch (FileNotFoundException e){
      System.out.println("File not found");
    }

    // Read the data file
    for(int i = 0; sc.hasNextLine(); i++){
      String line = sc.nextLine();
      String[] lineSplit = line.split(", ");
      String name = lineSplit[0];
      String taskSize = lineSplit[1];
      Task newTask = new Task(name,taskSize);
      taskList.add(newTask);
    }
    sc.close();


    for (Task task : taskList ) {
        System.out.println(task.getName());
        System.out.println(task.getPointValue());
    }

    // Turn incomplete tasks into completed tasks

    // Calculate the number of points a person has earned

    // Get indexes of completed tasks






  }


}