package packRanking;

import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;

import packBD.BD;

public class GestorRanking {
	private static GestorRanking theGestorRanking;
	private GestorRanking() {
	}
	public static GestorRanking getGestorRanking() {
		if (theGestorRanking == null) {
			theGestorRanking = new GestorRanking();
		}
		return theGestorRanking;
	}
	/*pasa los parametros al gestorBD */
	public void almacenarRanking(String nombre,  int puntuacion) throws SQLException {
			BD.getGestorBD().almacenarRanking(nombre,puntuacion );
	}
	
	public JSONArray  getRanking() throws JSONException {
		JSONArray json= BD.getGestorBD().obtenerPuntuacion("SELECT * FROM Usuarios ORDER BY Puntuacion DESC LIMIT 10");	
		return json;
	}
}

