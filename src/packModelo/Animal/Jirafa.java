package packModelo.Animal;

import packModelo.Animalada.AHipopotamo;
import packModelo.Animalada.AJirafa;

public class Jirafa extends Animal implements IRecurrente {
	public Jirafa() {
		this.inicializarAnimalada(new AJirafa());
	}

	@Override
	public void recurrir(int pFuerza, String pColor) {
		this.ejecutarAnimalada(pFuerza, pColor);

	}
}
