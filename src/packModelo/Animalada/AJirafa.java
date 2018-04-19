package packModelo.Animalada;

import packModelo.ColaEntrada;

public class AJirafa implements IAnimalada {

	@Override
	public void hacerAnimalada(int pFuerza, String pColor) {
		int posicion=ColaEntrada.getColaEntrada().buscarPorColorFuerza(pFuerza, pColor);
		ColaEntrada.getColaEntrada().adelantarMenoresNoCebra(posicion, pFuerza);
	}

}
