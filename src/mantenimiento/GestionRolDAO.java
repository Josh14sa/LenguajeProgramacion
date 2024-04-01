package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import interfaces.RolInterfacesDAO;
import entidad.Rol;
import utils.MySQLConexion8;

public class GestionRolDAO implements RolInterfacesDAO {

	@Override
	public int registrar(Rol r) {

		int rs = 0;

		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion8.getConexion();

			con.setAutoCommit(false);

			String sql = "Insert into tb_rol values (null,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, r.getDescripcion());

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
				System.out.print("Error al cerrar la Base de Datos : " + e.getMessage());
			}

		}
		return rs;
	}

	@Override
	public int modificar(Rol r) {
		int rs = 0;

		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion8.getConexion();

			con.setAutoCommit(false);

			String sql = "Update tb_rol set des_rol = ? where id_rol = ?";
			pst = con.prepareStatement(sql);

			pst.setString(1, r.getDescripcion());
			pst.setInt(2, r.getIdRol());

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
				System.out.print("Error al cerrar la BD : " + e.getMessage());
			}

		}
		return rs;
	}

	@Override
	public Rol buscar(int r) {
		Rol ro = null;

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion8.getConexion();

			String sql = "select * from tb_rol where id_rol = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, r);

			rs = pst.executeQuery();

			if (rs.next()) {

				ro = new Rol();
				ro.setIdRol(rs.getInt(1));
				ro.setDescripcion(rs.getString(2));
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en buscar : " + e.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.print("Error al cerrar la BD : " + e.getMessage());
			}

		}
		return ro;
	}

	@Override
	public int eliminar(Rol r) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion8.getConexion();

			String sql = "Delete from tb_rol where id_rol=?";

			pst = con.prepareStatement(sql);
			pst.setInt(1, r.getIdRol());

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
	public ArrayList<Rol> listado() {
		ArrayList<Rol> lista = null;

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion8.getConexion();

			String sql = "select * from tb_rol";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			lista = new ArrayList<Rol>();

			while (rs.next()) {

				Rol r = new Rol();
				r.setIdRol(rs.getInt(1));
				r.setDescripcion(rs.getString(2));

				lista.add(r);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en listado (Tipo): " + e.getMessage());
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

}
