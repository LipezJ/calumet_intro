import Controller.Gestion;
import Universidad.Universidad;

public class Main {

	static Universidad universidad;

	public static void main(String[] args) {
		Gestion.config();
		Gestion.init();
		universidad.mostrarUniversidad();
	}

}