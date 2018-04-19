package packModelo.Animalada;

import packModelo.ColaEntrada;

public class AHipopotamo implements IAnimalada {

	@Override
	public void hacerAnimalada(int fuerza, String color) {
		ColaEntrada.getColaEntrada().avanzarCartaHipopotamo(fuerza, color);
	}
	
}
