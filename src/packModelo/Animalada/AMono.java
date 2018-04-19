package packModelo.Animalada;

import packModelo.ColaEntrada;
import packModelo.packCartas.CartaAnimal;
import packModelo.packCartas.EsLoQueHay;
import packModelo.packCartas.ListaCartas;

public class AMono implements IAnimalada {
	ListaCartas list=ColaEntrada.getColaEntrada().getLista();
	@Override
public void hacerAnimalada(int pFuerza, String pColor) {
		if(this.hayMas()){
			this.espantar();
			this.moverPrimeraPos();
			this.moverDemasMonos();
		}
	}

	private boolean hayMas(){
		return list.buscarPorFuerza(4);
	}
	
	private void espantar(){
		int pos;
		int pos1;
		pos=list.posicionDeLaCarta(10);
		pos1=list.posicionDeLaCarta(11);
		while(pos!=-1 || pos1!=-1){
			if(pos!=-1){
				EsLoQueHay.getEsLoQueHay().addLast(list.getCarta(pos));
				list.borrarCarta(list.getCarta(pos));
			}else if(pos1!=-1){
				EsLoQueHay.getEsLoQueHay().addLast(list.getCarta(pos1));
				list.borrarCarta(list.getCarta(pos1));
			}
			
			pos=list.posicionDeLaCarta(10);
			pos1= list.posicionDeLaCarta(11);
			
		}
		
	}
	
	private void moverPrimeraPos(){
		list.avanzarCartaMono();
	}
	
	private void moverDemasMonos(){
		int i=1;
		while(i<list.longitud()){
			if(list.getCarta(i).getFuerza()==4){
				CartaAnimal c=list.getCarta(i);
				list.borrarCarta(c);
				list.anadirCartaEnPos(1, c);
				}
			i++;
		}
	}
}
