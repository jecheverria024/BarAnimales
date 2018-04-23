package packModelo.Animalada;

import packModelo.ColaEntrada;
import packModelo.packCartas.ListaCartas;

public class ACocodrilo implements IAnimalada {
ColaEntrada cola= ColaEntrada.getColaEntrada();
	@Override
public void hacerAnimalada(int pFuerza, String pColor) {
		System.out.println("iniciando animalada cocodrilo");
		cola.comerAnimales();
		
		
	}
	

}
