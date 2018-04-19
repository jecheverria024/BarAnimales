package packModelo.Usuario;

import packModelo.BarBestial;
import packModelo.EnumColor;

public class Ordenador extends Usuario {
	public Ordenador(EnumColor pColor) {
		super(pColor);

	}

	// Esto se hará mas complejo en los siguientes sprints, de momento solo echa la
	// carta que esta en primera posicion
	public void jugar() {

		echarCarta(0);

	}

	public void asignarColor(EnumColor pColor) {

	}

	public void actualizarPuntos(int pPuntos) {

	}

	public void asignarNombre(String pNombre) {

	}
}
