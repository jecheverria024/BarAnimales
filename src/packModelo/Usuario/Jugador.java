package packModelo.Usuario;

import java.sql.SQLException;

import packModelo.EnumColor;
import packRanking.GestorRanking;

public class Jugador extends Usuario {
	private String nombre;
	private int puntos;


	public Jugador(EnumColor pColor, String pNombre) {
		super(pColor);
		puntos=0;
		nombre = pNombre;
	}

	public String infoMano() {
		return this.getListaManos().infoCartas();
	}

	public void echarCarta(int pi) {
		super.echarCarta(pi);
		this.notificar(this, this.infoMano());
	}

	public void almacenarRanking() {
		try {
			GestorRanking.getGestorRanking().almacenarRanking(nombre, puntos);
			System.out.println("nombre: "+nombre+" puntos "+puntos);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void calcularPuntos() {
		this.puntos= puntos+1;
	}
	
	


}
