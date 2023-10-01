package Controller;

import Universidad.Facultad;
import Universidad.Universidad;
import Vista.Vista;

public class Gestion {
  
  public static Universidad universidad;

  public static void config() {
    universidad = new Universidad("Universidad Industrial de Santander");
    universidad.agregarFacultad(new Facultad("Facultad de Ingenierias Fisico-Mecanicas"));
  }

  public static void init() {
    int opcion = Vista.Menus.Principal();
    System.out.println(opcion);
    while (true) {
      try {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      } catch (Exception e) {
          /*No hacer nada*/
      }
      switch (opcion) {
        case 1:
          Facultad selected = Vista.Menus.seleccionar(opcion);
          Vista.clearScreen();
          if (selected != null) {
            int opcion_menu = Vista.Menus.Facultades(selected);
            facultad(opcion_menu, selected);
          }
          break;
        case 2:
          Vista.Menus.Escuelas(opcion);
          break;
        case 3:
          Vista.Menus.Estudiantes(opcion);
          break;
        case 4:
          Vista.Menus.seleccionar(opcion);
          break;
        case 5:
          System.exit(0);
          break;
        default:
          Vista.mostrarError("Opcion invalida");
          break;
      }
    }
  }

  public static void facultad(int opcion, Facultad facultad) {
    switch (opcion) {
      case 1:
         Vista.clearScreen();
        facultad.mostrarFacultad();
        Vista.stop();
        break;
      case 2:
        if (facultad.getEscuelasSize() == 0) {
          Vista.mostrarError("No hay escuelas registradas");
          break;
        }
        Vista.clearScreen();
        facultad.mostarEscuelas();
        break;
      case 3:
        //
        break;
      case 4:
        //
        break;
      case 5:
        break;
      default:
        Vista.mostrarError("Opcion invalida");
        break;
    }
  } 

}
