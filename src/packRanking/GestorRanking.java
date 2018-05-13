package packRanking;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

	
	public JSONArray  getRanking() throws JSONException {
		ResultSet rs= GestorBD.getGestorBD().obtenerPuntuacion("SELECT * FROM Usuario ORDER BY Puntuacion DESC LIMIT 10");	
		JSONArray json = new JSONArray();
		try {
			ResultSetMetaData rsmd =rs.getMetaData();
			while (rs.next()) {
				int numCol = rsmd.getColumnCount();
				JSONObject obj = new JSONObject();
				for (int i = 1; i < numCol + 1; i++) {
					String column_name = rsmd.getColumnLabel(i);
					switch (rsmd.getColumnType(i)) {
					case java.sql.Types.INTEGER:
						obj.put(column_name, rs.getInt(column_name));
						break;
					case java.sql.Types.VARCHAR:
						obj.put(column_name, rs.getString(column_name));
						break;
					}
				}
				json.put(obj);
			}

		} catch (SQLException ex) {
			System.out.println("2");
			System.out.println("SQLException: " + ex.getMessage());
		}
		return json;
	}
	
}

