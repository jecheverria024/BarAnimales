package packModelo.Animalada;

import packModelo.ColaEntrada;
import packModelo.packCartas.CartaAnimal;
import packModelo.packCartas.EsLoQueHay;
import packModelo.packCartas.ListaCartas;

public class ALeon implements IAnimalada
{
  public ALeon() {}
  
  ListaCartas list = ColaEntrada.getColaEntrada().getLista();
 
  public void hacerAnimalada(int pFuerza, String pColor) {
    boolean esta = list.buscarPorFuerza(12);
    System.out.println(esta);
    System.out.println("animalada leon");
    if (!esta) {
      eliminarMonos();
      moverPrimeraPos();
    }
    else {
      EsLoQueHay.getEsLoQueHay().addLast(list.getCarta(list.longitud() - 1));
      list.borrarCarta(list.getCarta(list.longitud() - 1));
    }
  }
  
  private void eliminarMonos() {
    boolean salir = false;
    while (!salir) {
      if (list.buscarPorFuerza(4)) {
        int i = list.posicionDeLaCarta(4);
        CartaAnimal c = list.getCarta(i);
        list.borrarCarta(list.getCarta(i));
        EsLoQueHay.getEsLoQueHay().addLast(c);
      }
      else {
        salir = true;
      }
    }
  }
  
  private void moverPrimeraPos() {
    list.avanzarCartaLeon();
  }
}
