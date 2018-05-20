package packModelo.Animalada;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import packInterface.VentanaPrincipal;
import packModelo.BarBestial;
import packModelo.ColaEntrada;

public class ALoro implements IAnimalada {

	@Override
	public void hacerAnimalada(int pFuerza, String pColor) {
		JFrame frame = new JFrame("Eleccion");
		boolean correcto = false;
		int pPos = -1;
		if (BarBestial.getBarBestial().esTurnoJugador()) {
			if (!ColaEntrada.getColaEntrada().colaVacia()) {
				while (!correcto) {
					try {
						pPos = Integer.parseInt(JOptionPane.showInputDialog(frame, "Introduzca posicion en la cola",
								"Loro", JOptionPane.INFORMATION_MESSAGE));
					} catch (Exception e) {

						JOptionPane.showMessageDialog(frame, "Introduzca un numero valido, por favor", "Loro",
								JOptionPane.INFORMATION_MESSAGE);
					}
					if (ColaEntrada.getColaEntrada().comprobarLongitudCartas(pPos) && pPos > 0) {
						correcto = true;
						pPos--;

					}
				}

			} else {
				JOptionPane.showMessageDialog(frame, "No hay elementos en la cola para elegir", "Loro",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			if (!ColaEntrada.getColaEntrada().colaVacia()) {
				while (!correcto) {
					pPos = (int) (Math.random() * 5 + 1);
					if (ColaEntrada.getColaEntrada().comprobarLongitudCartas(pPos) && pPos > 0) {
						correcto = true;
						pPos--;
					}
				}

			}
		}
		if (!ColaEntrada.getColaEntrada().colaVacia()) {
			ColaEntrada.getColaEntrada().echarPorPosicion(pPos);
		}
	}

}
