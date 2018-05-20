package packModelo.Usuario;

import packModelo.BarBestial;
import packModelo.EnumColor;

public class Ordenador extends Usuario {
	public Ordenador(EnumColor pColor) {
		super(pColor);

	}

	public void jugar() {
		echarCarta(0);
	}

}
