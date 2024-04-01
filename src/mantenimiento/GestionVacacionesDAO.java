package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entidad.Vacaciones;
import interfaces.VacacionesInterfacesDAO;
import utils.MySQLConexion8;

public class GestionVacacionesDAO implements VacacionesInterfacesDAO {
	//Aquí trabajamos la Lógica del Negocio
	

	@Override
	public int registrar(Vacaciones v) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			//PASO 1: Establecer la conexion con la BD
			con = MySQLConexion8.getConexion();
			//PASO 2: Establecer la instrucción SQL para REGISTRAR
			String sql = "insert into tb_Registro_Vacaciones values ();";
			//PASO 3: Crear el objeto pstm y enviar la variable sql
			pstm = con.prepareStatement(sql);
			//PASO 4: Obtener los parametros para la instrucción SQL
			pstm.setString(1, v.getFechaInicio());
			pstm.setString(2, v.getFechaFin());
			pstm.setString(3, v.getArea());
			//PASO 5: Ejecutar la instrucción SQL
			res = pstm.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL - Registrar" + e.getMessage());
		}finally {
			try {
				
				if(pstm != null) pstm.close();
				if(con != null) con.close();
				
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
			}
		}
				
		return res;
	}
	

}
