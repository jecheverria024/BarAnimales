package packModelo.Animalada;

import packModelo.ColaEntrada;
import packModelo.packCartas.CartaAnimal;
import packModelo.packCartas.EsLoQueHay;
import packModelo.packCartas.ListaCartas;

public class ALeon implements IAnimalada
{
  public ALeon() {}
  
 ColaEntrada cola = ColaEntrada.getColaEntrada();
 
  public void hacerAnimalada(int pFuerza, String pColor) {
    int posicion = cola.buscarPorFuerza(12);
    int pos2= cola.buscarPorColorFuerza(pFuerza, pColor);
   
    
    if (posicion==-1) {
      cola.eliminarMonos();
      cola.anadirEnPos(0,cola.getLista().getCarta(pos2));
    }
    else {
      EsLoQueHay.getEsLoQueHay().addLast(cola.getLista().getCarta(cola.getLista().longitud()-1));
      cola.borrarCarta(cola.getLista().getCarta(cola.getLista().longitud()-1));
    }
  }
  

}
