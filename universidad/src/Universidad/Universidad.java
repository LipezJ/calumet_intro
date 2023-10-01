package Universidad;

import java.util.ArrayList;

public class Universidad {

  private String nombre;
  private ArrayList<Facultad> facultades;

  public Universidad(String nombre) {
    this.nombre = nombre;
    this.facultades = new ArrayList<Facultad>();
  }

  public void mostrarUniversidad() {
    System.out.println("Nombre: " + this.nombre);
  } 

  public void mostrarFacultades() {
    for (Facultad facultad : facultades) {
      System.out.println(facultad.getNombre());
    }
  }

  public Facultad getFacultadById(int id) {
    return facultades.get(id);
  }

  public void agregarFacultad(Facultad facultad) {
    facultades.add(facultad);
  }

  public String getNombre() {
    return this.nombre;
  }

  public ArrayList<Facultad> getFacultades() {
    return this.facultades;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  
}
