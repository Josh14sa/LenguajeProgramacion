package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.PreparableStatement;

import entidad.Empleado;

public class MySQLConexion8 {
	public static Connection getConexion() {
		//1. Declaramos un objeto de tipo "Connection"
		Connection con = null;
		try {
			//2. Cargar el Driver - Establecemos la ruta del driver de conexión 
			Class.forName("com.mysql.cj.jdbc.Driver");
			//3. Ingresamos los Datos para la conexión a la BD
            String url = "jdbc:mysql://localhost:3306/bd_vacaciones?serverTimezone=UTC";
			String usr = "root"; //Usuario con el que ingresa en MySQL
			String psw = "mysql";//contraseña que se ingresa en el programa MySQL
			con = DriverManager.getConnection(url, usr, psw);
		} catch (ClassNotFoundException e) {
			System.out.println("Error Driver No Instalado!!!" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Error de conexion con la BD!!!" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error general : " + e.getMessage());
		
		
	}
		return con;		

}
}
	


/*public ArrayList<Empleado> retornaUsuario() throws SQLException{
	ArrayList<Empleado> ls=new ArrayList<Empleado>();
	PreparedStatement ps= con.prepareStatement("SELECT * FROM empleado");
	ResultSet rs = ps.executeQuery();
	while (rs.next()) {
		Empleado a = new Empleado(rs.getInt("id"),rs.getString("dni"),rs.getString("apePaterno"),rs.getString("apeMaterno"),rs.getString("nombres"),rs.getString("sexo"),rs.getString("fechaNac"),rs.getString("celular"),rs.getString("correo"),rs.getString("usuario"),rs.getString("clave"),rs.getInt("rol"));
	}
	rs.close();
	return ls;
}
}*/
