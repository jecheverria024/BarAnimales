package packModelo.Usuario;

import java.sql.SQLException;

import packModelo.EnumColor;
import packRanking.GestorRanking;

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

	public void almacenarRanking(int puntos) {
		try {
			GestorRanking.getGestorRanking().almacenarRanking(nombre, puntos);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
