package packRanking;

import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;

import packBD.BD;
import packBD.GestorBD;

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
			GestorBD.getGestorBD().almacenarRanking(nombre,puntuacion );
	}
	
	/*
	public JSONArray  getRanking() throws JSONException {
		//JSONArray json= GestorBD.getGestorBD().obtenerPuntuacion("SELECT * FROM Usuario ORDER BY Puntuacion DESC LIMIT 10");	
		//return json;
	}
	*/
}

