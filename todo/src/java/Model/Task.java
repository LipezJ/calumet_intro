package Model;

import Model.Interfaces.TaskInterface;

/**
 *
 * @author lipezj
 */
public class Task implements TaskInterface {

  private String id;
  private String title;
  private String description;
  private boolean done;

  public Task(String id, String title, String description, boolean done) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.done = done;
  }

  @Override
  public boolean isDone() {
    return done;
  }
  
  @Override
  public void switchDone() {
    this.done = !this.done;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
