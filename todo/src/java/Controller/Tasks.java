package Controller;

import Controller.Interfaces.TasksInterface;
import DB.ConnectionDB;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.UUID;
import Model.Task;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lipezj
 */
public class Tasks implements TasksInterface {

  final static HashMap<String, Task> TasksList = new HashMap<>();

  public static boolean addTask(String title, String description) {
    String uuid = UUID.randomUUID().toString();
    Task newTask = new Task(uuid, title, description, false);
    if (saveTask(newTask)) {
      TasksList.put(uuid, newTask);
      return true;
    }
    return false;
  }

  public static ArrayList<Task> getTasks() {
    ArrayList<Task> Tasks = new ArrayList<>(TasksList.values());
    return Tasks;
  }

  public static HashMap<String, Task> getTaskMap() {
    return TasksList;
  }

  public static void updateTasks() {
    ConnectionDB conn = new ConnectionDB();

    String query = "SELECT * FROM tasks;";
    ResultSet res = conn.consultarBD(query);

    try {
      Task tarea;
      while (res.next()) {
        tarea = new Task(res.getString("id"), res.getString("title"), res.getString("description"), res.getBoolean("done"));
        TasksList.put(tarea.getId(), tarea);
      }
    } catch (SQLException e) {
      System.err.println("Error: " + e.getMessage());
    } finally {
      conn.cerrarConexion();
    }
  }

  public static Task getTask(String id) {
    return TasksList.get(id);
  }

  public static boolean saveTask(Task task) {
    ConnectionDB conn = new ConnectionDB();

    String query = String.format("INSERT INTO tasks VALUES (\"%s\", \"%s\", \"%s\", %s);",
            task.getId(),
            task.getTitle(),
            task.getDescription(),
            task.isDone());

    if (conn.setAutoCommitBD(false)) {
      if (conn.insertarBD(query)) {
        conn.commitBD();
        conn.cerrarConexion();
        return true;
      } else {
        conn.rollbackBD();
      }
    }
    conn.cerrarConexion();
    return false;
  }

  public static boolean deleteTask(String id) {
    ConnectionDB conn = new ConnectionDB();

    String query = String.format("DELETE FROM tasks WHERE id = \"%s\"", id);

    if (conn.actualizarBD(query)) {
      TasksList.remove(id);
      return true;
    }
    return false;
  }

  public static boolean markTask(String id) {
    ConnectionDB conn = new ConnectionDB();

    if (TasksList.containsKey(id)) {
      String query = String.format("UPDATE tasks SET done = %s WHERE id = \"%s\"", !TasksList.get(id).isDone(), id);
      if (conn.actualizarBD(query)) {
        TasksList.get(id).switchDone();
        return true;
      }
    }
    return false;
  }

}
