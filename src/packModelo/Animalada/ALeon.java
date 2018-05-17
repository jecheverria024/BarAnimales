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
    int posicion = cola.buscarPorColorFuerza(12,"VERDE");
    int pos2= cola.buscarPorColorFuerza(pFuerza, pColor);
    CartaAnimal c=cola.devolverCarta(pos2);
    System.out.println("Leon  "+ cola.longitud() +" posi "+posicion);
    if (posicion==pos2|| posicion==-1) {
      cola.eliminarMonos();
      cola.echarPorPosicion(pos2);;
      cola.anadirEnPos(0,c);
     
    }
    else {
      EsLoQueHay.getEsLoQueHay().addLast(c);
      cola.borrarCarta(c);
    }
  }
  

}
