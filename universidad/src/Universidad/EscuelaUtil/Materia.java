package Universidad.EscuelaUtil;

public class Materia {
  private String nombre;
  private int creditos;

  public Materia(String nombre, int creditos) {
    this.nombre = nombre;
    this.creditos = creditos;
  }

  public String getNombre() {
    return this.nombre;
  }

  public int getCreditos() {
    return this.creditos;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setCreditos(int creditos) {
    this.creditos = creditos;
  }
}
