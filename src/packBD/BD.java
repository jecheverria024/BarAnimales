package packBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mysql.jdbc.Statement;



public class BD {

	private Connection conn;
	private static BD miBD=null;
	private String driver="net.ucanaccess.jdbc.UcanaccessDriver";
	private BD() {
		this.conectar();
	}
	public static BD getGestorBD() {
		if (miBD == null) {
			miBD = new BD();
			
		}
		return miBD;
	}
	  
	public void setConexion(Connection conexion) {
	        this.conn = conexion;
	}
	public Connection getConexion() {
		return conn;
	}    
	public void conectar(){
		// TODO Auto-generated method stub
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			System.out.println("Registro completo");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}

		Connection con = null;

		try {
			String jdbc="jdbc:ucanaccess://src/BarBestial.accdb"; //fichero access
			String usuario="";
			String pass="";
			
			this.setConexion(DriverManager.getConnection(jdbc));

			// Otros y operaciones sobre la base de datos...
			System.out.println("Conexion completada");
			

		} catch (SQLException ex) {

			System.out.println("SQLException: " + ex.getMessage());

		}
		
		
	}
	public void almacenarRanking(String nombre, int puntuacion) throws SQLException {
		Statement sentencia = (Statement) getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		String sql="INSERT INTO Usuarios(Puntuacion) VALUES("+puntuacion+") WHERE Username='"+nombre + "'";
		sentencia.executeUpdate(sql);	
		
	}
	public JSONArray  obtenerPuntuacion(String sql) throws JSONException {
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

}
