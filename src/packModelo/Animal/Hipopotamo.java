package packModelo.Animal;

import packModelo.Animalada.AHipopotamo;

public class Hipopotamo extends Animal implements IRecurrente{
	public Hipopotamo() {
		this.inicializarAnimalada(new AHipopotamo());
	}

	@Override
	public void recurrir(int pFuerza, String pColor) {
		this.ejecutarAnimalada(pFuerza, pColor);
		
	}


}
