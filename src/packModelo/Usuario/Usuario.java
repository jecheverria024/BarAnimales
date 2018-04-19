package packModelo.Usuario;

import java.util.Collections;

import packModelo.BarBestial;
import packModelo.ColaEntrada;
import packModelo.EnumColor;
import packModelo.Animal.Animal;
import packModelo.Animal.AnimalFactory;
import packModelo.Animal.Leon;
import packModelo.packCartas.CartaAnimal;
import packModelo.packCartas.ListaCartas;
import packObservable.ObservableAbstracto;

public class Usuario extends ObservableAbstracto {
	private ListaCartas mano;
	private ListaCartas mazo;
	private EnumColor color;
	private int puntos;

	public Usuario(EnumColor pColor) {
		puntos = 0;
		color = pColor;
		mano = new ListaCartas();
		mazo = inicializarMazo(pColor);
	}

	public void echarCarta(int pi) {

		CartaAnimal pCarta = mano.eliminar(pi);
		ColaEntrada.getColaEntrada().echarCarta(pCarta);
		if (this.mazo.longitud() != 0) {
			this.cogerCarta();
		}

	}

	public void cogerCarta() {

		CartaAnimal ca = mazo.cogerCartaDelMazo();
		mazo.borrarCarta(ca);
		mano.add(ca);
	}

	public boolean tieneCartas() {

		if (mano.longitud() == 0)
			return false;
		else
			return true;
	}

	private ListaCartas inicializarMazo(EnumColor pColor) {
		mazo = new ListaCartas();
		String pImagen;
		for (int i = 1; i <= 12; i++) {
			Animal a = AnimalFactory.getAnimalFactory().crearAnimal(i);
			pImagen = a.getClass().getName();
			CartaAnimal c = new CartaAnimal(pImagen, i, pColor, a);
			mazo.add(c);
		}
		return mazo;
	}

	public void barajar() {
		mazo.barajar();
		// imprimirmazo();
	}

	public void imprimirmazo() {

		mazo.imprimirlista();
	}

	public void imprimirmano() {

		mano.imprimirlista();
	}

	public ListaCartas getListaManos() {
		return this.mano;
	}
}
