package packBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import net.ucanaccess.jdbc.UcanaccessSQLException;

public class GestorBD {
	private static GestorBD miGestorBd;
	// DATOS PARA EL ACCESO DE LA BD
	private Statement Instruccion;
	private ResultSet Resultado; 
	private String SentenciaSQL;
	private Connection con = null;
	private String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
	private String url = "jdbc:ucanaccess://src/BarBestial.accdb";

	// CONSTRUCCTORA
	private GestorBD() {
	}

	public static GestorBD getGestorBD() {
		if (miGestorBd == null) {
			miGestorBd = new GestorBD();
		}
		return miGestorBd;
	}

	public Connection abrirConexion() {
		try {
			if (con == null) {
				Class.forName(driver);
				con = DriverManager.getConnection(url);
				JOptionPane.showMessageDialog(null, "Conexi�n correcta.");
			}
		} catch (SQLException SQLE) {
			JOptionPane.showMessageDialog(null, "ERROR EN LA CONEXION CON BD\nERROR : " + SQLE.getMessage());
		} catch (ClassNotFoundException CNFE) {
			JOptionPane.showMessageDialog(null, "ERROR DRIVER BD JAVA\nERROR : " + CNFE.getMessage());
		}
		return con;
	}
	
	public void anadirUsuario(String usu, String pass) {
		con = abrirConexion();
		try {			
			PreparedStatement pst = con
					.prepareStatement("INSERT INTO Usuario(Username,Password) VALUES ('"+usu+"','"+pass+"')");
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "El usuario se agrego correctamente");
		} catch (SQLException SQLE) {
			JOptionPane.showMessageDialog(null,
					"Error al insertar usuario \n ERROR : " + SQLE.getMessage());
		}
	}
	public void almacenarRanking(String nombre, int puntuacion) throws SQLException {
		con = abrirConexion();
		try {			
			PreparedStatement pst = con
					.prepareStatement("UPDATE Usuario SET Puntuacion=? WHERE Username=?");
			pst.setInt(1, puntuacion);
			pst.setString(2, nombre);
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "LA PUNTUACION SE AGREGO CON EXITO A LA BD");
		} catch (SQLException SQLE) {
			JOptionPane.showMessageDialog(null,
					"ERROR AL INSERTAR LA PUNTUACION DE LA BD \n ERROR : " + SQLE.getMessage());
		}
		
	}
	
	
	public boolean comprobarLoggin(String usu, String pass) {
		con =abrirConexion();
		boolean correcto=false;
		String respuesta = " ";
		try {
			PreparedStatement pst = con
					.prepareStatement("SELECT Password FROM Usuario WHERE Username= ? ");
			pst.setString(1, usu);
			ResultSet rs=pst.executeQuery();
			//respuesta=rs.getString(0);
			if(respuesta.equals(pass)){
				correcto=true;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return correcto;
	}
	
	/*
	 * OBTENER RANKING
	 * public JSONArray  obtenerPuntuacion(String sql) throws JSONException {
		JSONArray json=new JSONArray();
		try {
			Statement sentencia = (Statement) getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ResultSet resultado=sentencia.executeQuery(sql);	
			ResultSetMetaData rsmd =resultado.getMetaData();
			resultado.beforeFirst();
			while(resultado.next()) {
				int numCol=rsmd.getColumnCount();
				JSONObject obj = new JSONObject();
				for(int i=1; i<numCol+1; i++) {
	                String column_name = rsmd.getColumnLabel(i); 
	                switch( rsmd.getColumnType( i ) ) {
		                case java.sql.Types.INTEGER:
		                    obj.put(column_name, resultado.getInt(column_name));
		                    break;
		                case java.sql.Types.VARCHAR:
	                        obj.put(column_name, resultado.getString(column_name));   
	                        break;
		                }
				}
				json.put(obj);				
			}

		} catch (SQLException ex) {

			System.out.println("SQLException: " + ex.getMessage());
		}		
		 return json;
	}
	 * */

}