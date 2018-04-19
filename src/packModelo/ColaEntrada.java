package packModelo;

import java.util.Arrays;
import java.util.Collections;

import packInterface.VentanaPrincipal;
import packModelo.packCartas.CartaAnimal;
import packModelo.packCartas.EsLoQueHay;
import packModelo.packCartas.ListaCartas;
import packModelo.packCartas.PuertaDelCielo;
import packObservable.ObservableAbstracto;

public class ColaEntrada extends ObservableAbstracto {
	private ListaCartas cartas;
	private static ColaEntrada mColaEntrada;

	private ColaEntrada() {

		super();
		cartas = new ListaCartas();
	}

	public static ColaEntrada getColaEntrada() {
		if (mColaEntrada == null) {
			mColaEntrada = new ColaEntrada();
		}
		return mColaEntrada;
	}

	public boolean revisarCola() {
		boolean lleno = comprobarColaCompleta();
		if (lleno) {
			cartas.DosPrimeras();
			cartas.ultimaCarta();
		}
		return lleno;
	}

	public void add(CartaAnimal c) {

		cartas.add(c);

	}

	private boolean comprobarColaCompleta() {
		boolean lleno = false;
		if (cartas.longitud() == 5) {
			lleno = true;
		}
		return lleno;
	}

	public String infoCartas() {
		return this.cartas.infoCartas();
	}

	public void echarCarta(CartaAnimal pCarta) {
		cartas.add(pCarta);
		// En el if poner los animales que tengan las animaladas implementadas. mantener
		// este if hasta que esten todas las animaladas hechas
		if (pCarta.getFuerza() == 12 || pCarta.getFuerza() == 11 || pCarta.getFuerza() == 9 || pCarta.getFuerza() == 8
				|| pCarta.getFuerza() == 3 || pCarta.getFuerza() == 4 || pCarta.getFuerza() == 10
				|| pCarta.getFuerza() == 2 || pCarta.getFuerza() == 1|| pCarta.getFuerza() == 6) {
			pCarta.ejecutarAnimalada();

		}

		this.revisarCola();
		this.notificar(this, this.infoCartas());
	}

	public ListaCartas getLista() {
		return this.cartas;
	}

	public void imprimir() {
		System.out.println("Lista de cartas en la cola al finalizar");
		cartas.imprimirlista();
	}


	
	
	//buscarPorColorFuerza(intfuerza, color)
	public int buscarPorColorFuerza(int pFuerza, String pColor) {
		return this.cartas.buscarPorColorFuerza(pFuerza, pColor);
	}
	
	
	//buscarPorFuerza
	public int buscarPorFuerza(int pFuerza) {
		return this.cartas.buscarPorFuerza(pFuerza);	
	}
	
	//adelantar (posInicial, posFinal)
	
	//AdelantarMenoresNoCebra(posInicial, posFinal){}
	
	//echarMenoresNoCebra(fuerza)
	public void echarMenoresNoCebra(int pFuerza) {
		this.cartas.echarMenoresNoCebra(pFuerza);
	}
	//ordenar
	public void ordenarSegunFuerza() {
		this.cartas.ordenarSegunFuerza();
	}
	
	//invertir
	public void invertirFoca() {	
		this.cartas.invertirFoca();
	}
	
	//copiaranimal(pfuerza)--> camaleon
	public void copiarAnimal(int pFuerza) {
		this.cartas.copiarAnimal(pFuerza);
	}
	
	//adelantarMonos();
	
	//echarPorPosicion(posicion)
	public void echarPorPosicion(int pPos) {
		this.cartas.echarPorFuerza(pPos);
	}
	
}
