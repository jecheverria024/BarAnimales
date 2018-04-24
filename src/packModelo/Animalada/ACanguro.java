package packModelo.Animalada;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


import packModelo.BarBestial;
import packModelo.ColaEntrada;
import packModelo.packCartas.CartaAnimal;
import packModelo.packCartas.ListaCartas;

public class ACanguro implements IAnimalada {
ListaCartas list=ColaEntrada.getColaEntrada().getLista();
	@Override
public void hacerAnimalada(int pFuerza, String pColor) {
		
		//int num=0;
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
			    		if(pPos==1 || pPos==2) {
			    		correcto=true;}
			    		//pPos--;
			    	}
				}
				
			}
			else {
				JOptionPane.showMessageDialog(frame, "No hay elementos en la cola para elegir");
			}
		}else{
			if(!ColaEntrada.getColaEntrada().colaVacia() ){
				System.out.println("Canguro Ordenador");
				while(!correcto) {
			    	pPos= (int) (Math.random()*1 + 1) ;		
			    	if(ColaEntrada.getColaEntrada().comprobarLongitudCartas(pPos) && pPos>0) {
			    		correcto=true;
			    		//pPos--;
			    	}
			    		
				}
			}
		}
		this.saltar(pPos);

	}

	private void saltar(int num){
		
		ColaEntrada.getColaEntrada().comprobarSalto(num);
		
	}
}
