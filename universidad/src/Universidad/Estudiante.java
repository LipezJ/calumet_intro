package Universidad;

public class Estudiante {

  private String nombre;
  private float promedio;
  private int semestre;

  public Estudiante(String nombre, float promedio, int semestre) {
    this.nombre = nombre;
    this.promedio = promedio;
    this.semestre = semestre;
  }

  public void mostrarEstudiante() {
    System.out.println("Nombre: " + this.nombre);
    System.out.println("Semestre: " + this.semestre);
    System.out.println("Promedio: " + this.promedio);
  }

  public String getNombre() {
    return this.nombre;
  }

  public float getPromedio() {
    return this.promedio;
  }

  public int getSemestre() {
    return this.semestre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setPromedio(float promedio) {
    this.promedio = promedio;
  }

  public void setSemestre(int semestre) {
    this.semestre = semestre;
  }
  
}
