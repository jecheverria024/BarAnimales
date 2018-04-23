package packModelo.packCartas;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

import packModelo.ColaEntrada;
import packModelo.EnumColor;
import packModelo.Animal.Leon;
import packModelo.Animalada.ACanguro;

public class ListaCartas {
	private ArrayList<CartaAnimal> lista;

	public ListaCartas() {
		lista = new ArrayList<CartaAnimal>();

	}

	public int longitud() {
		return lista.size();
	}

	public String infoCartas() {
		System.out.println("longitud: " + this.lista.size());
		CartaAnimal unaCarta = null;
		Iterator<CartaAnimal> itr = this.getIterador();
		String info = null;
		if (this.lista.size() > 0) {
			info = itr.next().info();
			while (itr.hasNext()) {
				unaCarta = itr.next();
				info = info + " " + unaCarta.info();
			}
		}
		return info;
	}

	public void add(CartaAnimal c) {
		lista.add(c);
	}

	private Iterator<CartaAnimal> getIterador() {
		return lista.iterator();
	}

	public void borrarCarta(CartaAnimal c) {
		lista.remove(c);
	}

	public CartaAnimal conseguirCarta() {
		return lista.get(0);
	}

	public void ultimaCarta() {
		CartaAnimal c = lista.get(lista.size() - 1);
		EsLoQueHay.getEsLoQueHay().addLast(c);
		borrarCarta(c);
	}
	public CartaAnimal eliminar(int i) {
		CartaAnimal c = getCarta(i);
		borrarCarta(c);
		return c;

	}
	
	public CartaAnimal cogerCartaDelMazo() {
		return lista.get(lista.size() - 1);
	}

	public CartaAnimal getCarta(int i) {
		return lista.get(i);
	}

	public void barajar() {
		Collections.shuffle(lista);
	}

	public void DosPrimeras() {

		for (int i = 0; i < 2; i++) {
			CartaAnimal c = this.conseguirCarta();
			PuertaDelCielo.getPuertaDelCielo().add(c);
			borrarCarta(c);
		}

	}

	public void imprimirlista() {
		System.out.println(lista.size());
		for (int i = 0; i < lista.size(); i++) {
			System.out.print(lista.get(i).getColor() + "   ");
			System.out.println(lista.get(i).getFuerza());
		}
	}





	
	//buscarPorColorFuerza(intfuerza, color)
	public int buscarPorColorFuerza(int pFuerza, String pColor) {
		Iterator<CartaAnimal> itr = this.getIterador();
		int posicion = 0;
		CartaAnimal ca = null;
		boolean encontrado = false;
		while (itr.hasNext() && !encontrado) {
			ca = itr.next();
			if (ca.info().equals(pFuerza + " " + pColor)) {
				encontrado = true;
			} else {
				posicion++;
			}
		}
		if (encontrado==false) {
			posicion=-1;
		}
		return posicion;
	}
	//buscar por Posicion
	
	public int buscarPorPosicion(int pPos) {
		return this.lista.get(pPos).getFuerza();		
	}
	//buscarPorFuerza(fuerza) excepto ultima carta
	public int buscarPorFuerza(int pFuerza) {
		int i = -1;
		boolean enc = false;
		while (i < lista.size()-1 && !enc) {
			CartaAnimal c = lista.get(i);
			if (c.getFuerza() == pFuerza) {
				enc = true;
			} else {
				i++;
			}
		}
		if(enc==false) {
			i=-1;
		}
		return i;
	}
	
	//adelantar (pPosInicial)
	public void adelantar (int pPosInicial, int pFuerza) {
		pPosInicial = pPosInicial - 1;
		System.out.println("Posicion: " + pPosInicial);
		if (pPosInicial >= 0 && !this.lista.get(pPosInicial).compararFuerza(pFuerza)) {
			CartaAnimal ca=this.lista.remove(pPosInicial);
			this.lista.add(pPosInicial, ca);
		}
	}
	//AdelantarMenoresNoCebra(posInicial, posFinal){}
	public void adelantarMenoresNoCebra (int pPosInicial, int pFuerza) {
		pPosInicial = pPosInicial - 1;
		System.out.println("Posicion: " + pPosInicial);
		if (pPosInicial >= 0 && !this.lista.get(pPosInicial).compararFuerza(pFuerza)
				&& !this.lista.get(pPosInicial).esCebra()) {
			CartaAnimal ca=this.lista.remove(pPosInicial);
			this.lista.add(pPosInicial, ca);
		}
	}
	//echarMenoresNoCebra(fuerza)
	public void echarMenoresNoCebra(int pFuerza) {
		System.out.println("iniciar animalada cocodrilo");
		int i = lista.size() - 2;
		boolean salir = false;
		while (i >= 0 && !salir) {
			if (!lista.get(i).compararFuerza(pFuerza) && lista.get(i).esCebra()) {
				EsLoQueHay.getEsLoQueHay().addLast(lista.get(i));
				lista.remove(i);
				i--;
			} else {
				salir = true;
			}

		}
	}
	
	//ordenar
	public void ordenarSegunFuerza() {
		Collections.sort(this.lista);
	}
	
	//invertir
	public void invertirFoca() {	
		Collections.reverse(lista);
	}
	
	//copiaranimal(pfuerza)--> camaleon
	public void copiarAnimal(int pFuerza) {	
		this.lista.get(this.lista.size()-1).ejecutarAnimaladaOtroAnimal(pFuerza);
	}
	
	//adelantarMonos();
	public void avanzarCartaMono() {
		CartaAnimal c = lista.get(lista.size() - 1);
		lista.remove(lista.size() - 1);
		lista.add(0, c);

	}
	
	//echarPorPosicion(posicion)
	public void echarPorPosicion(int pos) {
		EsLoQueHay.getEsLoQueHay().addLast(lista.get(pos));
		borrarCarta(lista.get(pos));
	}

	public void revisarSiHayCamaleon() {
		Iterator<CartaAnimal> it=this.getIterador();
		CartaAnimal ca=null;
		while(it.hasNext()) {
			ca=it.next();
			if(ca.esCamaleon()) {
				ca.volverASerCamaleon();
			}
		}
	}

	public boolean comprobarLongitudCartas(int pNum) {
		if(this.lista.size()>pNum) {
			return true;
		}
		else return false;
	}

	public boolean colaVacia() {
		if(this.lista.size()>0) {
			return false;
		}
		else return true;
	}
	
	
}
