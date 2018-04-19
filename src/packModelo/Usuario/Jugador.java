package packModelo.Usuario;

import packModelo.EnumColor;

public class Jugador extends Usuario {

	public Jugador(EnumColor pColor) {
		super(pColor);
	}
	public String infoMano() {
		return this.getListaManos().infoCartas();
	}
	public void echarCarta(int pi) {
		super.echarCarta(pi);
		this.notificar(this, this.infoMano());
	}
}
