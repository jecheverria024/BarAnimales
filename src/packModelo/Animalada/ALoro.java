package packModelo.Animalada;

import java.util.Scanner;

import packInterface.VentanaPedirPosicion;
import packInterface.VentanaPrincipal;
import packModelo.ColaEntrada;

public class ALoro implements IAnimalada {

	@Override
	public void hacerAnimalada(int pFuerza, String pColor) {
		
		int num = 0;
		boolean correcto = false;
		if (ColaEntrada.getColaEntrada().getLista().longitud() > 0) {
			VentanaPedirPosicion frame = new VentanaPedirPosicion(ColaEntrada.getColaEntrada().getLista().longitud());
			frame.setVisible(true);
			while (!correcto) {
				//Scanner sc = new Scanner(System.in);
				//System.out.println("Inserta la posicion del animal que deseas eliminar");
				// falta implementar para que seleccionen un numero desde la interfaz
				//num = sc.nextInt();
				if (frame.comprobarSelec()!=-1) {
					correcto = true;
					frame.dispose();
				}
			}
			ColaEntrada.getColaEntrada().asustarLoro(num);

		}
	}

}
