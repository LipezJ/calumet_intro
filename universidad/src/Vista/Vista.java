package Vista;

import java.util.Scanner;

import Controller.Gestion;
import Universidad.Facultad;

public class Vista {

  static Scanner scanner = new Scanner(System.in);

  public static class Menus {

    public static int Principal() {
      System.out.println("Bienvenido a la " + Gestion.universidad.getNombre() + "!");
      System.out.println("1. Facultades");
      System.out.println("2. Escuelas");
      System.out.println("3. Estudiantes");
      System.out.println("4. Salir");
      String opcion = scanner.nextLine();
      return Integer.parseInt(opcion);
    }

    public static int Facultades(Facultad facultad) {
      System.out.println("Facultad: " + facultad.getNombre());
      System.out.println("1. Mostrar Facultad");
      System.out.println("2. Mostrar Escuelas");
      System.out.println("3. Agregar Escuela");
      System.out.println("4. Regresar");
      String opcion = scanner.nextLine();
      return Integer.parseInt(opcion);
    }

    public static int Escuelas(int id) {
      System.out.println("Escuela: " + Gestion.universidad.getFacultadById(id).getEscuelaById(id).getNombre());
      System.out.println("1. Mostrar Escuela");
      System.out.println("2. Mostrar Estudiantes");
      System.out.println("3. Agregar Estudiante");
      System.out.println("4. Regresar");
      String opcion = scanner.nextLine();
      return Integer.parseInt(opcion);
    }

    public static int Estudiantes(int id) {
      System.out.println("Estudiante: " + Gestion.universidad.getFacultadById(id).getEscuelaById(id).getEstudianteById(id).getNombre());
      System.out.println("1. Mostrar Estudiante");
      System.out.println("2. Mostrar Promedio");
      System.out.println("3. Editar Estudiante");
      System.out.println("4. Regresar");
      String opcion = scanner.nextLine();
      return Integer.parseInt(opcion);
    }

    public static Facultad seleccionar(int type) {
      System.out.println("Seleccione una opcion: ");
      if ( type == 1 ) {
        for (int i = 0; i < Gestion.universidad.getFacultades().size(); i++) {
          System.out.println((i + 1) + ". " + Gestion.universidad.getFacultadById(i).getNombre());
        }
      }
      String opcion = scanner.nextLine();
      return Gestion.universidad.getFacultadById(Integer.parseInt(opcion) - 1);
    }

  }

  public static void mostrarMensaje(String mensaje) {
    System.out.println(mensaje);
  }

  public static void mostrarError(String mensaje) {
    clearScreen();
    System.out.println(mensaje);
    stop();
    clearScreen();
  }

  public static void mostrarUniversidad() {
    Gestion.universidad.mostrarUniversidad();
  }

  public static void mostrarFacultad(String nombre) {
    System.out.println("Nombre: " + nombre);
  }

  public static void mostrarEscuela(String nombre) {
    System.out.println("Nombre: " + nombre);
  }

  public static void mostrarEstudiante(String nombre, float promedio, int semestre) {
    System.out.println("Nombre: " + nombre);
    System.out.println("Semestre: " + semestre);
    System.out.println("Promedio: " + promedio);
  }

  public static void clearScreen() {
    try {
      new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    } catch (Exception e) {
        /*No hacer nada*/
    }
  }

  public static void stop() {
    System.out.println("Presione enter para continuar...");
    scanner.nextLine();
  }

}
