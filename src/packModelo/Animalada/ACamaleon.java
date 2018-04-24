package packModelo.Animalada;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import packModelo.BarBestial;
import packModelo.ColaEntrada;

public class ACamaleon implements IAnimalada {

	@Override
	public void hacerAnimalada(int pFuerza, String pColor) {
		JFrame frame = new JFrame( "Eleccion");
		boolean correcto=false;
		int pPos=-1;
		if(BarBestial.getBarBestial().esTurnoJugador()) {
			if(!ColaEntrada.getColaEntrada().colaVacia() ) {
				while(!correcto) {
					try {
						pPos=Integer.parseInt(JOptionPane.showInputDialog(frame, "Introduzca posicion en la cola"));	    		
					}
					catch(Exception e) {
						
						JOptionPane.showMessageDialog(frame, "Introduzca un numero valido, por favor");
					}
			    	if(ColaEntrada.getColaEntrada().comprobarLongitudCartas(pPos) && pPos>0) {
			    		correcto=true;
			    		pPos--;
			    		
			    	}
				}
				
			}
			else {
				JOptionPane.showMessageDialog(frame, "No hay elementos en la cola para elegir");
			}
		}
		else {
			if(!ColaEntrada.getColaEntrada().colaVacia() ) {
				System.out.println("CAMALEON ORDENADOR");
				while(!correcto) {
			    	pPos= (int) (Math.random()*5 + 1) ;		
			    	if(ColaEntrada.getColaEntrada().comprobarLongitudCartas(pPos) && pPos>0) {
			    		correcto=true;
			    		pPos--;
			    	}
				}
				
			}
		}
		if (pPos>=0) {
			int fuerza=ColaEntrada.getColaEntrada().buscarPorPosicion(pPos);
			ColaEntrada.getColaEntrada().copiarAnimal(fuerza);
		}

		if(!ColaEntrada.getColaEntrada().colaVacia() ) {
			int fuerza=ColaEntrada.getColaEntrada().buscarPorPosicion(pPos);
		ColaEntrada.getColaEntrada().copiarAnimal(fuerza);
		}
		
	}
	
}
