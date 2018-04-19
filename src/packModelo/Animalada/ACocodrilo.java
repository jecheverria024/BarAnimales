package packModelo.Animalada;

import packModelo.ColaEntrada;
import packModelo.packCartas.ListaCartas;

public class ACocodrilo implements IAnimalada {
ListaCartas list= ColaEntrada.getColaEntrada().getLista();
	@Override
public void hacerAnimalada(int pFuerza, String pColor) {
		System.out.println("iniciando animalada cocodrilo");
		list.avanzarCartaCocodrilo();
		
		
	}
	

}
