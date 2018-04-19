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

	public CartaAnimal eliminar(int i) {
		CartaAnimal c = getCarta(i);
		borrarCarta(c);
		return c;

	}

	public void imprimirlista() {
		System.out.println(lista.size());
		for (int i = 0; i < lista.size(); i++) {
			System.out.print(lista.get(i).getColor() + "   ");
			System.out.println(lista.get(i).getFuerza());
		}
	}

	public void avanzarCartaHipopotamo(int fuerza, String color) {
		Iterator<CartaAnimal> itr = this.getIterador();
		int posicion = 0;
		CartaAnimal ca = null;
		boolean encontrado = false;
		while (itr.hasNext() && !encontrado) {
			ca = itr.next();
			if (ca.info().equals(fuerza + " " + color)) {
				encontrado = true;
			} else {
				posicion++;
			}
		}
		boolean salir = false;
		while (!salir) {
			posicion = posicion - 1;
			System.out.println("Posicion: " + posicion);
			if (posicion >= 0 && this.lista.get(posicion).getFuerza() < fuerza
					&& this.lista.get(posicion).getFuerza() != 7) {
				this.lista.remove(ca);
				this.lista.add(posicion, ca);
			} else {
				salir = true;
			}
		}
	}

	public void avanzarCarta (int fuerza, String color) {
		Iterator<CartaAnimal> itr = this.getIterador();
		int posicion = 0;
		CartaAnimal ca = null;
		boolean encontrado = false;
		while (itr.hasNext() && !encontrado) {
			ca = itr.next();
			if (ca.info().equals(fuerza + " " + color)) {
				encontrado = true;
			} else {
				posicion++;
			}
		}
		posicion = posicion - 1;
		System.out.println("Posicion: " + posicion);
		if (posicion >= 0 && this.lista.get(posicion).getFuerza() < fuerza
				&& this.lista.get(posicion).getFuerza() != 7) {
			this.lista.remove(ca);
			this.lista.add(posicion, ca);
		}
	}

	public void avanzarCartaCanguro(int num) {
		if (lista.size() >= 3) {
			if (num == 1) {

				CartaAnimal carta = lista.get(lista.size() - 2);
				this.lista.remove(carta);
				this.lista.add(lista.size() - 1, carta);

			} else if (num == 2) {

				CartaAnimal carta = lista.get(lista.size() - 1);
				this.lista.remove(carta);
				this.lista.add(lista.size() - 2, carta);

			} else {
				System.out.println("inserta un 1 o un 2");

			}
		} else if (lista.size() == 2) {

			CartaAnimal carta = lista.get(lista.size() - 1);
			this.lista.remove(carta);
			this.lista.add(lista.size() - 1, carta);

		}

	}

	

	public int posicionDeLaCarta(int pFuerza) {
		int i = 0;
		boolean enc = false;
		while (i < lista.size() && !enc) {
			if (lista.get(i).getFuerza() == pFuerza) {
				enc = true;
			} else {
				i++;
			}
		}
		if (enc) {
			return i;
		} else {
			return -1;
		}

	}

	public void avanzarCartaMono() {
		CartaAnimal c = lista.get(lista.size() - 1);
		lista.remove(lista.size() - 1);
		lista.add(0, c);

	}

	public void anadirCartaEnPos(int pos, CartaAnimal c) {
		lista.add(pos, c);
	}

	public void avanzarCartaCocodrilo() {
		System.out.println("iniciar animalada cocodrilo");
		int i = lista.size() - 2;
		boolean salir = false;
		while (i >= 0 && !salir) {
			if (lista.get(i).getFuerza() < 10 && lista.get(i).getFuerza() != 7) {
				EsLoQueHay.getEsLoQueHay().addLast(lista.get(i));
				lista.remove(i);
				i--;
			} else {
				salir = true;
			}

		}
	}

	public void avanzarCartaLeon() {
		CartaAnimal c = lista.get(lista.size() - 1);
		lista.remove(lista.size() - 1);
		lista.add(0, c);
	}



	public void echarPorFuerza(int pFuerza) {
				for (int j = lista.size() - 1; j >= 0; j--) {
					if (lista.get(j).getFuerza() == pFuerza && lista.get(j).getFuerza() != 1) {
						EsLoQueHay.getEsLoQueHay().addLast(lista.get(j));
						System.out.println("borrada" +lista.get(j).getFuerza());
						borrarCarta(lista.get(j));
						imprimirlista();
					}
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
	
	//buscarPorFuerza(fuerza)
	public int buscarPorFuerza(int pFuerza) {
		int i = -1;
		boolean enc = false;
		while (i < lista.size() - 1 && !enc) {
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
	
	//adelantar (posInicial, posFinal)
	
	//AdelantarMenoresNoCebra(posInicial, posFinal){}
	
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
		this.lista.get(this.lista.size()-1).cambiarAnimal(pFuerza);
		this.lista.get(this.lista.size()-1).ejecutarAnimalada();;
	}
	
	//adelantarMonos();
	
	//echarPorPosicion(posicion)
	public void echarPorPosicion(int pos) {
		EsLoQueHay.getEsLoQueHay().addLast(lista.get(pos));
		borrarCarta(lista.get(pos));
	}
	
}
