package packBD;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.JSONException;

public class GestorBD {
	private static GestorBD miGestorBd;
	// DATOS PARA EL ACCESO DE LA BD
	private Connection con = null;
	private String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
	//private String url = "jdbc:ucanaccess://src/packBD/BarBestial.accdb";

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
				
				
				java.io.File dbFile;
				String connStr=null;
				try {
					dbFile = java.io.File.createTempFile("tempdb", ".accdb");
					dbFile.deleteOnExit();
					java.nio.file.Files.copy(
							getClass().getResourceAsStream("/packBD/BarBestial.accdb"), 
					        dbFile.toPath(), 
					        java.nio.file.StandardCopyOption.REPLACE_EXISTING);
					connStr= String.format(
					        "jdbc:ucanaccess://%s;immediatelyReleaseResources=true", 
					        dbFile.getAbsolutePath());

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
				
				con = DriverManager.getConnection(connStr);
				System.out.println("conexion bd correcta ");
			}
		} catch (SQLException SQLE) {
			System.out.println("ERROR EN LA CONEXION CON BD\nERROR : " + SQLE.getMessage());
		} catch (ClassNotFoundException CNFE) {
			System.out.println( "ERROR DRIVER BD JAVA\nERROR : " + CNFE.getMessage());
		}
		return con;
	}

	public void anadirUsuario(String usu, String pass) {
		con = abrirConexion();
		try {
			PreparedStatement pst = con
					.prepareStatement("INSERT INTO Usuario(Username,Password) VALUES ('" + usu + "','" + pass + "')");
			pst.executeUpdate();
		} catch (SQLException SQLE) {
			System.out.println("Error al insertar usuario \n ERROR : " + SQLE.getMessage());
		}
	}

	public void almacenarRanking(String nombre, int puntuacion) throws SQLException {
		con = abrirConexion();
		try {
			PreparedStatement pst = con.prepareStatement("UPDATE Usuario SET Puntuacion=? WHERE Username=?");
			pst.setInt(1, puntuacion);
			pst.setString(2, nombre);
			pst.executeUpdate();
		} catch (SQLException SQLE) {
			System.out.println("ERROR AL INSERTAR LA PUNTUACION DE LA BD \n ERROR : " + SQLE.getMessage());
		}

	}

	public boolean comprobarLoggin(String usu, String pass) {
		con = abrirConexion();
		boolean correcto = false;
		try {
			PreparedStatement pst = con.prepareStatement("SELECT Password FROM Usuario WHERE Username= ? ");
			pst.setString(1, usu);
			ResultSet rs = pst.executeQuery();
			rs.next();
			rs.getString("Password");

			// respuesta=rs.getString(num);
			if (rs.getString("Password").equals(pass)) {
				correcto = true;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return correcto;
	}

	public boolean comprobarNoExiste(String usu) {
		con = abrirConexion();
		boolean correcto = false;
		try {
			PreparedStatement pst = con.prepareStatement("SELECT * FROM Usuario WHERE Username= ? ");
			pst.setString(1, usu);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				return false;
			}
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return correcto;
	}
	
	public ResultSet execSQL(String sql) throws JSONException {
		try {
			PreparedStatement pst = abrirConexion().prepareStatement(sql);
			return pst.executeQuery();	

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			return null;
		}
	}

	public boolean comprobarPassIguales(String contra, String contra2) {
		if(contra.equals(contra2)) {
			return true;
		}
		else 
			return false;
	}

}
