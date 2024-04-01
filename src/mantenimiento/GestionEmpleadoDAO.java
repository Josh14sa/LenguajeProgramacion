package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import entidad.Empleado;
import entidad.Usuario;
import interfaces.EmpleadoInterfacesDAO;
import utils.MySQLConexion8;

public class GestionEmpleadoDAO implements EmpleadoInterfacesDAO {
	
	@Override
	public int registrar(Empleado em) {

		int rs = 0;

		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion8.getConexion();

			con.setAutoCommit(false);

			String sql = "Insert into empleado values (null,?,?,?,?,?,?,?,?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, em.getDni());
			pst.setString(2, em.getApePaterno());
			pst.setString(3, em.getApeMaterno());
			pst.setString(4, em.getNombres());
			pst.setString(5, em.getSexo());
			pst.setString(6, em.getFechaNac());
			pst.setString(7, em.getCelular());
			pst.setString(8, em.getCorreo());
			pst.setString(9, em.getUsuario());
			pst.setString(10, em.getClave());
			pst.setInt(11, em.getRol());

			rs = pst.executeUpdate();

			con.commit();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en registrar : " + e.getMessage());
			rs = 0;

			try {
				con.rollback();

			} catch (SQLException e1) {

				System.err.print("Error al deshacer cambios : " + e1.getMessage());
			}
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.print("Error al cerrar la BD : " + e.getMessage());
			}

		}
		return rs;
	}

	@Override
	public int modificar(Empleado em) {

		int rs = 0;

		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion8.getConexion();

			con.setAutoCommit(false);

			String sql = "Update empleado set dni = ?, ap_Paterno  = ?, ap_Materno  = ?, nombres = ?, sexo = ?, "
					+ "fecha_nacimiento = ?, celular = ?, correo = ?, usuario = ?, clave = ?, rol = ? "
					+ "where id_empleado = ?";
			pst = con.prepareStatement(sql);

			pst.setString(1, em.getDni());
			pst.setString(2, em.getApePaterno());
			pst.setString(3, em.getApeMaterno());
			pst.setString(4, em.getNombres());
			pst.setString(5, em.getSexo());
			pst.setString(6, em.getFechaNac());
			pst.setString(7, em.getCelular());
			pst.setString(8, em.getCorreo());
			pst.setString(9, em.getUsuario());
			pst.setString(10, em.getClave());
			pst.setInt(11, em.getRol());
			pst.setInt(12, em.getId_empleado());

			rs = pst.executeUpdate();

			con.commit();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en modificar : " + e.getMessage());
			rs = 0;

			try {
				con.rollback();

			} catch (SQLException e1) {

				System.err.print("Error al deshacer cambios : " + e1.getMessage());
			}
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.print("Error al cerrar la Base de Datos : " + e.getMessage());
			}

		}
		return rs;
	}

	@Override
	public Empleado buscar(String dni) {
		Empleado emp = null;

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion8.getConexion();

			String sql = "select * from empleado where dni = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, dni);

			rs = pst.executeQuery();

			if (rs.next()) {

				emp = new Empleado();
				emp.setId_empleado(rs.getInt(1));
				emp.setDni(rs.getString(2));
				emp.setApePaterno(rs.getString(3));
				emp.setApeMaterno(rs.getString(4));
				emp.setNombres(rs.getString(5));
				emp.setSexo(rs.getString(6));
				emp.setFechaNac(rs.getString(7));
				emp.setCelular(rs.getString(8));
				emp.setCorreo(rs.getString(9));
				emp.setUsuario(rs.getString(10));
				emp.setClave(rs.getString(11));
				emp.setRol(rs.getInt(12));

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en buscar : " + e.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.print("Error al cerrar la Base de Datos : " + e.getMessage());
			}

		}
		return emp;
	}

	@Override
	public int eliminar(Empleado e) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion8.getConexion();

			String sql = "delete from empleado where dni = ?";

			pst = con.prepareStatement(sql);
			pst.setString(1, e.getDni());

			rs = pst.executeUpdate();

		} catch (Exception ex) {

			JOptionPane.showMessageDialog(null, "Error en eliminar : " + ex.getMessage());

		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception ex) {
				System.out.print("Error al cerrar la BD : " + ex.getMessage());
			}

		}

		return rs;
	}

	@Override
	public ArrayList<Empleado> listado() {
		ArrayList<Empleado> lista = null;

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion8.getConexion();

			String sql = "select * from empleado";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			lista = new ArrayList<Empleado>();

			while (rs.next()) {

				Empleado emp = new Empleado();
				emp.setId_empleado(rs.getInt(1));
				emp.setDni(rs.getString(2));
				emp.setApePaterno(rs.getString(3));
				emp.setApeMaterno(rs.getString(4));
				emp.setNombres(rs.getString(5));
				emp.setSexo(rs.getString(6));
				emp.setFechaNac(rs.getString(7));
				emp.setCelular(rs.getString(8));
				emp.setCorreo(rs.getString(9));
				emp.setUsuario(rs.getString(10));
				emp.setClave(rs.getString(11));
				emp.setRol(rs.getInt(12));
				lista.add(emp);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en listado : " + e.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.print("Error al cerrar la BD : " + e.getMessage());
			}

		}
		return lista;
	}

	@Override
	public Empleado validarAcceso(String usuario, String clave) {
		Empleado emp = null;

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion8.getConexion();

			String sql = "{call usp_validaUsuario(?, ?)}";
			pst = con.prepareStatement(sql);
			pst.setString(1, usuario);
			pst.setString(2, clave);

			rs = pst.executeQuery();

			if (rs.next()) {

				emp = new Empleado();
				emp.setId_empleado(rs.getInt(1));
				emp.setDni(rs.getString(2));
				emp.setApePaterno(rs.getString(3));
				emp.setApeMaterno(rs.getString(4));
				emp.setNombres(rs.getString(5));
				emp.setSexo(rs.getString(6));
				emp.setFechaNac(rs.getString(7));
				emp.setCelular(rs.getString(8));
				emp.setCorreo(rs.getString(9));
				emp.setUsuario(rs.getString(10));
				emp.setClave(rs.getString(11));
				emp.setRol(rs.getInt(12));
				

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en validar : " + e.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.print("Error al cerrar la Base de Datos : " + e.getMessage());
			}

		}
		return emp;
	}
	
	public boolean validarCredenciales(Usuario us) {
		
		boolean validar = false;

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion8.getConexion();
			
			String sql = "SELECT * FROM empleado WHERE usuario=? AND clave=?";	
						
			pst = con.prepareStatement(sql);			
			pst.setString(1, us.getUsuario());
			pst.setString(2, us.getClave());
			
			rs = pst.executeQuery();
			validar = rs.next();
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL - VALIDAR USUARIO"+e.getMessage());
		} finally {
			try {
				if(pst != null) pst.close();
				if(rs != null)rs.close();
				if(con != null)con.close();
				
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la BASE DE DATOS"+e2.getMessage());
			}
		}
		return validar;
	}

}
