package packModelo.Animalada;

import packModelo.ColaEntrada;
import packModelo.packCartas.CartaAnimal;
import packModelo.packCartas.EsLoQueHay;
import packModelo.packCartas.ListaCartas;

public class AMono implements IAnimalada {
	ColaEntrada cola=ColaEntrada.getColaEntrada();
	@Override
public void hacerAnimalada(int pFuerza, String pColor) {
		int cont=cola.hayMas();
		if(cont!=-1){
			cola.espantar();
			int pos=cola.buscarPorFuerza(4);
			cola.anadirEnPos(0,cola.devolverCarta(pos));
			cola.moverDemasMonos();
		}
	}

	
}