package packModelo.Usuario;

import packModelo.EnumColor;

public class Jugador extends Usuario {
	private String nombre;

	public Jugador(EnumColor pColor, String pNombre) {
		super(pColor);
		nombre = pNombre;
	}

	public String infoMano() {
		return this.getListaManos().infoCartas();
	}

	public void echarCarta(int pi) {
		super.echarCarta(pi);
		this.notificar(this, this.infoMano());
	}
}
