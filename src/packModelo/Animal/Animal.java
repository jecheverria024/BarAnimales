package packModelo.Animal;

import packModelo.Animalada.IAnimalada;

public abstract class Animal {
	private IAnimalada animalada;

	public Animal() {
	}

	public void ejecutarAnimalada(int fuerza, String color) {

		this.animalada.hacerAnimalada(fuerza, color);
	}

	public void inicializarAnimalada(IAnimalada ia) {
		this.animalada = ia;
	}
}
