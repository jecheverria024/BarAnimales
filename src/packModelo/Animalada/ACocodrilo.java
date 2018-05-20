package packModelo.Animalada;

import packModelo.ColaEntrada;
import packModelo.packCartas.ListaCartas;

public class ACocodrilo implements IAnimalada {
	ColaEntrada cola = ColaEntrada.getColaEntrada();

	@Override
	public void hacerAnimalada(int pFuerza, String pColor) {
		int posicion = ColaEntrada.getColaEntrada().buscarPorColorFuerza(pFuerza, pColor);
		boolean salir = false;
		while (!salir) {
			if (ColaEntrada.getColaEntrada().echarMenoresNoCebra(posicion, pFuerza)) {
				posicion--;
			} else {
				salir = true;
			}

		}
	}

}
