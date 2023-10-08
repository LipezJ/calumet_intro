package Controller.Interfaces;

import Model.Task;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author lipezj
 */
public interface TasksInterface {

  static boolean addTask(String title, String description) {
    return false;
  }

  static ArrayList<Task> getTasks() {
    return null;
  }

  static HashMap<String, Task> getTaskMap() {
    return null;
  }

  static void updateTasks() {
  }

  static Task getTask(String id) {
    return null;
  }

  static boolean saveTask(Task task) {
    return false;
  }

  static boolean deleteTask(String id) {
    return false;
  }

  static boolean markTask(String id) {
    return false;
  }
}
