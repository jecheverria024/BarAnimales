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

	private boolean revisarCola() {
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
	public boolean comprobarLongitudCartas(int pNum) {
		return this.cartas.comprobarLongitudCartas(pNum);
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
	public boolean colaVacia() {
		return this.cartas.colaVacia();
	}
	public void echarCarta(CartaAnimal pCarta) {
		cartas.add(pCarta);
		// En el if poner los animales que tengan las animaladas implementadas. mantener
		// este if hasta que esten todas las animaladas hechas
		if (pCarta.getFuerza()==11 ||pCarta.getFuerza()==9 || pCarta.getFuerza()==8  || pCarta.getFuerza()==5) {
			pCarta.ejecutarAnimalada();

		}
		
	}
	public void revisar() {
		//hacer recurrentes
		this.revisarCola();
		this.revisarSiHayCamaleon();
		this.notificar(this, this.infoCartas());
	}
	private void revisarSiHayCamaleon() {
		this.cartas.revisarSiHayCamaleon();
		
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
	
	//buscarporpos
	
	public int buscarPorPosicion(int pPos) {
		return this.cartas.buscarPorPosicion(pPos);
	}
	//adelantar (posInicial, pFuerza)
	public void adelantar (int pPosInicial, int pFuerza) {
		this.cartas.adelantar(pPosInicial, pFuerza);
	}
	
	//AdelantarMenoresNoCebra(posInicial, posFinal){}
	public void adelantarMenoresNoCebra(int pPosInicial, int pFuerza) {
		this.cartas.adelantarMenoresNoCebra(pPosInicial, pFuerza);
	}
	//echarMenoresNoCebra(fuerza)
	public void echarMenoresNoCebra(int pFuerza) {
		this.cartas.echarMenoresNoCebra(pFuerza);
	}
	
	//ordenar
	public void ordenar() {
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
	public void avanzarCartaMono() {
		this.cartas.avanzarCartaMono();
	}
	//echarPorPosicion(posicion)
	public void echarPorPosicion(int pPos) {
		this.cartas.echarPorPosicion(pPos);
	}

}
