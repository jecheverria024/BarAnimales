package packBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class BD {
	
	private BD bd;
	private Statement st;
	private Connection conn;
	public BD(){
		bd=new BD();
	}
	
	public void conectar(String ip, int puerto, String user, String pass){
		//cargar mysqlDriver
		try{
			Class.forName("org.gtj.mm.mysql.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		//abrir conexion
		try{
			Connection conn= DriverManager.getConnection("jdbc:mysql://"+ip+":"+puerto, user, pass);
			conn.setAutoCommit(true);
			Statement st= (Statement) conn.createStatement();
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		
		
	}
	
	public void devolverRanking() throws SQLException{
		String sentencia= "Select username, puntos from registro.Usuarios";
		ResultSet res= st.executeQuery(sentencia);
		
	}

}
