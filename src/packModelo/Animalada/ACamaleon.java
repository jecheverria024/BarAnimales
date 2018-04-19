package packModelo.Animalada;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import packModelo.ColaEntrada;

public class ACamaleon implements IAnimalada {

	@Override
	public void hacerAnimalada(int pFuerza, String pColor) {
		JFrame frame = new JFrame( "Eleccion");
		boolean correcto=false;
		int pPos=-1;
		if(!ColaEntrada.getColaEntrada().colaVacia()) {
			while(!correcto) {
		    	pPos=Integer.parseInt(JOptionPane.showInputDialog(frame, "Introduzca posicion en la cola"));	    		
		    	if(ColaEntrada.getColaEntrada().comprobarLongitudCartas(pPos) && pPos>0) {
		    		correcto=true;
		    		pPos--;
		    	}
			}
			int fuerza=ColaEntrada.getColaEntrada().buscarPorPosicion(pPos);
			ColaEntrada.getColaEntrada().copiarAnimal(fuerza);
		}
		else {
			JOptionPane.showMessageDialog(frame, "No hay elementos en la cola para elegir");
		}
		
	   
	}
	
}
