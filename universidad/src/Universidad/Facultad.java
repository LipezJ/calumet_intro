package Universidad;

import java.util.ArrayList;

public class Facultad {

  private String nombre;
  private ArrayList<Escuela> escuelas;

  public Facultad(String nombre) {
    this.nombre = nombre;
    this.escuelas = new ArrayList<Escuela>();
  }

  public void mostrarFacultad() {
    System.out.println("Nombre: " + this.nombre);
  }

  public void mostarEscuelas() {
    for (Escuela escuela : escuelas) {
      System.out.println(escuela.getNombre());
    }
  }

  public Escuela getEscuelaById(int id) {
    return escuelas.get(id);
  }

  public void agregarEscuela(Escuela escuela) {
    escuelas.add(escuela);
  }

  public String getNombre() {
    return this.nombre;
  }

  public int getEscuelasSize() {
    return this.escuelas.size();
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

}
