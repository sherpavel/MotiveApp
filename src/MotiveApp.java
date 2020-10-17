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

    List<Task> taskList = new ArrayList<Task>(numTasks);
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
    while(sc.hasNextLine()){
      String line = sc.nextLine();
      String[] lineSplit = line.split(",");
      String name = lineSplit[0];
      String taskSize = lineSplit[1];
      taskList.add(new Task(name, taskSize));
    }
    sc.close();

    while (tasksLeft) {
      // Output a task for the person to do at specific times


      // If they finished the task then remove it from the list and add points
//      totalPoints += taskList.get( ).getPointValue();
      tasksLeft = false;
    }

  }
}
