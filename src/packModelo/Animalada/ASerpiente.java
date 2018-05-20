package packModelo.Animalada;

import packModelo.ColaEntrada;

public class ASerpiente implements IAnimalada {

	@Override
	public void hacerAnimalada(int fuerza, String color) {
		ColaEntrada.getColaEntrada().ordenar();
	}

}
