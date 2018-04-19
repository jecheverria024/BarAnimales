package packModelo.Animalada;

import packModelo.ColaEntrada;

public class AHipopotamo implements IAnimalada {

	@Override
	public void hacerAnimalada(int fuerza, String color) {
		int pPosInicial=ColaEntrada.getColaEntrada().buscarPorColorFuerza(fuerza, color);
		ColaEntrada.getColaEntrada().adelantarMenoresNoCebra(pPosInicial, fuerza);
	}
	
}
