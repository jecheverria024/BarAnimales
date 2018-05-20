package packModelo.Animal;

import packModelo.Animalada.ACocodrilo;

public class Cocodrilo extends Animal implements IRecurrente {

	public Cocodrilo() {
		this.inicializarAnimalada(new ACocodrilo());
	}

	@Override
	public void recurrir(int pFuerza, String pColor) {
		this.ejecutarAnimalada(pFuerza, pColor);

	}
}
