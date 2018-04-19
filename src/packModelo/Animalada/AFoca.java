package packModelo.Animalada;

import packModelo.ColaEntrada;

public class AFoca implements IAnimalada {

	@Override
public void hacerAnimalada(int pFuerza, String pColor) {
		
		System.out.println("aqui se debaria ejecutar la animalada de la foca");
		ColaEntrada.getColaEntrada().invertirFoca();
		
	}


}
