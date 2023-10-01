package Universidad.EscuelaUtil;

import java.util.ArrayList;

public class Carrera {
  private String nombre;
  private ArrayList<Materia> materias;

  public Carrera(String nombre) {
    this.nombre = nombre;
    this.materias = new ArrayList<Materia>();
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void mostrarMaterias() {
    for (Materia materia : materias) {
      System.out.println(materia.getNombre());
    }
  }
}
