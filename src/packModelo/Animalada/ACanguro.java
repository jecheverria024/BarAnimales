package packModelo.Animalada;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


import packModelo.BarBestial;
import packModelo.ColaEntrada;
import packModelo.packCartas.CartaAnimal;
import packModelo.packCartas.ListaCartas;

public class ACanguro implements IAnimalada {

	@Override
public void hacerAnimalada(int pFuerza, String pColor) {
		
		JFrame frame = new JFrame( "Eleccion");
		boolean correcto=false;
		int pPos=-1;
		if(BarBestial.getBarBestial().esTurnoJugador()) {
			if(!ColaEntrada.getColaEntrada().colaVacia() ) {
				while(!correcto) {
					try {
						pPos=Integer.parseInt(JOptionPane.showInputDialog(frame, "Introduzca posicion en la cola","Canguro", JOptionPane.INFORMATION_MESSAGE));	    		
					}
					catch(Exception e) {
						
						JOptionPane.showMessageDialog(frame, "Introduzca un numero valido, por favor","Canguro", JOptionPane.INFORMATION_MESSAGE);
					}
			    	if(ColaEntrada.getColaEntrada().comprobarLongitudCartas(pPos) && pPos>0) {
			    		if(pPos==1 || pPos==2) {
			    		correcto=true;}
			    	}
				}
				
			}
			else {
				JOptionPane.showMessageDialog(frame, "No hay elementos en la cola para elegir","Canguro", JOptionPane.INFORMATION_MESSAGE);
			}
		}else{
			if(!ColaEntrada.getColaEntrada().colaVacia() ){
				while(!correcto) {
			    	pPos= (int) (Math.random()*1 + 1) ;		
			    	if(ColaEntrada.getColaEntrada().comprobarLongitudCartas(pPos) && pPos>0) {
			    		correcto=true;
			    		//pPos--;
			    	}
			    		
				}
			}
		}
		int pos= ColaEntrada.getColaEntrada().buscarPorColorFuerza(pFuerza, pColor);
		this.saltar(pos);
		if(pPos==2) {
			pos= ColaEntrada.getColaEntrada().buscarPorColorFuerza(pFuerza, pColor);
			this.saltar(pos);
		}
	}

	private void saltar(int pos){
		
		ColaEntrada.getColaEntrada().comprobarSalto(pos);
		
	}
}
