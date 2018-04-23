package packModelo.Animal;

import packModelo.Animalada.ACebra;

public class Cebra extends Animal implements IRecurrente {

	public Cebra() {
		this.inicializarAnimalada(new ACebra());
		//la animalada de la cebra es que lo le afectan el cocodrilo y el hipopotamos
		//esta implementada en el cocodrilo e hipopotamo
	}

	@Override
	public void recurrir(int pFuerza, String pColor) {
		this.ejecutarAnimalada(pFuerza, pColor);
		
	}

}
