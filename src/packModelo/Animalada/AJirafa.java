package packModelo.Animalada;

import packModelo.ColaEntrada;

public class AJirafa implements IAnimalada {

	@Override
	public void hacerAnimalada(int fuerza, String color) {
		ColaEntrada.getColaEntrada().avanzarCartaJirafa(fuerza, color);

	}

}
