package packModelo.Animalada;

import packModelo.ColaEntrada;

public class AMofeta implements IAnimalada {

	@Override
	public void hacerAnimalada(int pFuerza, String pColor) {
		System.out.println("mofetaaaaaaaaaaa");
		ColaEntrada.getColaEntrada().repelerMofeta();

	}

}
