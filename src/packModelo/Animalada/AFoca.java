package packModelo.Animalada;

import packModelo.ColaEntrada;

public class AFoca implements IAnimalada {

	@Override
	public void hacerAnimalada(int pFuerza, String pColor) {

		ColaEntrada.getColaEntrada().invertirFoca();

	}

}
