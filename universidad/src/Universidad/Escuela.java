package Universidad;

import java.util.ArrayList;

public class Escuela {

  private String nombre;
  private ArrayList<Estudiante> estudiantes;

  public Escuela(String nombre) {
    this.nombre = nombre;
    this.estudiantes = new ArrayList<Estudiante>();
  }

  public void mostrarEscuela() {
    System.out.println("Nombre: " + this.nombre);
  }

  public void mostrarEstudiantes() {
    for (Estudiante estudiante : estudiantes) {
      System.out.println(estudiante.getNombre());
    }
  }

  public Estudiante getEstudianteById(int id) {
    return estudiantes.get(id);
  }

  public void agregarEstudiante(Estudiante estudiante) {
    estudiantes.add(estudiante);
  }

  public float calcularPromedioEstudiantes() {
    float promedio = 0;
    for (Estudiante estudiante : estudiantes) {
      promedio += estudiante.getPromedio();
    }
    return promedio / estudiantes.size();
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

}
