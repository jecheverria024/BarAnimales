package packMain;

import java.awt.Dimension;
import java.awt.Toolkit;

import packInterface.VentanaInicioJuego;
import packModelo.BarBestial;

public class Main {

	public static void main(String[] args) {
		VentanaInicioJuego frame = new VentanaInicioJuego();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = frame.getSize(); //Tamaño del frame actual (ancho x alto)
		if (frameSize.height > screenSize.height) {
		frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
		frameSize.width = screenSize.width;
		}
		frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		frame.setVisible(true);
	}

}
