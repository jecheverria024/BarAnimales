package packModelo.Animalada;

import packModelo.ColaEntrada;

public class AHipopotamo implements IAnimalada {

	@Override
	public void hacerAnimalada(int fuerza, String color) {
		int posicion = ColaEntrada.getColaEntrada().buscarPorColorFuerza(fuerza, color);

		boolean salir = false;
		while (!salir) {
			if (ColaEntrada.getColaEntrada().adelantarMenoresNoCebra(posicion, fuerza)) {
				posicion--;
			} else {
				salir = true;
			}

		}
	}

}
