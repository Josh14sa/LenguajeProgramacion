package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mantenimiento.GestionRolDAO;
import entidad.Rol;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class FrmRol extends JInternalFrame implements ActionListener {

	private final JPanel ContentPane = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtRol;
	private JTable tbRol;
	private JScrollPane scrollPane;
	
	DefaultTableModel modelo = new DefaultTableModel();
	private JButton btnCerrar;
	private JButton btnBuscar;
	private JButton btnHabilitar;
	private JButton btnModificar;
	private JButton btnRegistrar;
	private JButton btnEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmRol dialog = new FrmRol();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmRol() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("ROL");
		setBounds(100, 100, 443, 442);
		getContentPane().setLayout(new BorderLayout());
		ContentPane.setBackground(SystemColor.activeCaption);
		ContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(ContentPane, BorderLayout.CENTER);
		ContentPane.setLayout(null);
		{
			JLabel lblCdigo = new JLabel("C\u00F3digo");
			lblCdigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblCdigo.setBounds(12, 13, 37, 15);
			ContentPane.add(lblCdigo);
		}
		{
			JLabel lblRolDelEmpleado = new JLabel("Rol del Empleado");
			lblRolDelEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblRolDelEmpleado.setBounds(12, 53, 93, 15);
			ContentPane.add(lblRolDelEmpleado);
		}
		{
			txtCodigo = new JTextField();
			txtCodigo.setEditable(false);
			txtCodigo.setBounds(59, 10, 116, 22);
			ContentPane.add(txtCodigo);
			txtCodigo.setColumns(10);
		}
		{
			txtRol = new JTextField();
			txtRol.setBounds(115, 50, 147, 22);
			ContentPane.add(txtRol);
			txtRol.setColumns(10);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 192, 396, 199);
			ContentPane.add(scrollPane);

			tbRol = new JTable();
			tbRol.setModel(modelo);
			modelo.addColumn("Código");
			modelo.addColumn("Rol");
			tbRol.getColumnModel().getColumn(1).setPreferredWidth(250);
			scrollPane.setViewportView(tbRol);

		}
		{
			btnModificar = new JButton("Modificar");
			btnModificar.setIcon(new ImageIcon(FrmRol.class.getResource("/img/actualizar.png")));
			btnModificar.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnModificar.addActionListener(this);
			btnModificar.setBounds(12, 83, 120, 38);
			ContentPane.add(btnModificar);
		}
		{
			btnHabilitar = new JButton("Habilitar");
			btnHabilitar.setIcon(new ImageIcon(FrmRol.class.getResource("/img/activar2.png")));
			btnHabilitar.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnHabilitar.addActionListener(this);
			btnHabilitar.setBounds(12, 132, 120, 38);
			ContentPane.add(btnHabilitar);
		}
		{
			btnBuscar = new JButton("Buscar");
			btnBuscar.setIcon(new ImageIcon(FrmRol.class.getResource("/img/busca.png")));
			btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnBuscar.addActionListener(this);
			btnBuscar.setBounds(142, 83, 120, 38);
			ContentPane.add(btnBuscar);
		}
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.setIcon(new ImageIcon(FrmRol.class.getResource("/img/exit.png")));
			btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(272, 132, 120, 38);
			ContentPane.add(btnCerrar);
		}
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setIcon(new ImageIcon(FrmRol.class.getResource("/img/guardar.png")));
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegistrar.setBounds(142, 132, 120, 38);
		ContentPane.add(btnRegistrar);
		{
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(this);
			btnEliminar.setIcon(new ImageIcon(FrmRol.class.getResource("/img/eliminar.png")));
			btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnEliminar.setBounds(272, 84, 120, 38);
			ContentPane.add(btnEliminar);
		}
		
		listado();
	}
	
	void listado() {
		
		ArrayList<Rol> lista = new GestionRolDAO().listado();
		
		modelo.setRowCount(0);
		for (Rol r : lista) {

			Object[] datos = { r.getIdRol(), r.getDescripcion()};

			modelo.addRow(datos);
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnHabilitar) {
			actionPerformedBtnConsultar(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		
		habilitarBusqueda(true);
		btnHabilitar.setEnabled(false);
		limpiar();
		txtCodigo.setText("");
		txtCodigo.requestFocus();
	}
	
	protected void actionPerformedBtnModificar(ActionEvent e) {
		
		modificarDatos();
		limpiar();
	}
	
	private void habilitarBusqueda(boolean sino) {
		txtCodigo.setEditable(sino);
	}
	
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		
		buscarDatos();
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		
		dispose();
	}
	
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		registrarDatos();
		limpiar();
	}
	
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		eliminarDatos();
		limpiar();
	}
	
	private void registrarDatos() {
		
		String rol;

		rol = leerRol();
		
		if (rol == null) {
			return;
		}

		GestionRolDAO gr = new GestionRolDAO();
		Rol r = new Rol(rol);
		int ok = gr.registrar(r);

		if (ok == 0) {
			JOptionPane.showMessageDialog(this, "Error al registrar el rol");
		} else {
			JOptionPane.showMessageDialog(this, "Se registro el rol correctamente");
			listado();
		}
		
	}

	void modificarDatos() {

		String rol;

		int codigo;

		codigo = Integer.parseInt(txtCodigo.getText());
		rol = leerRol();

		if (rol == null) {
			return;
		}

		GestionRolDAO gr = new GestionRolDAO();
		Rol ro = new Rol(codigo, rol);
		int ok = gr.modificar(ro);

		if (ok == 0) {
			JOptionPane.showMessageDialog(this, "Error al actualizar datos");
		} else {
			JOptionPane.showMessageDialog(this, "Se actualizo correctamente los datos");

			listado();
		}
	}
	
	void buscarDatos() {

		int codigo = leerCodigo();

		GestionRolDAO gr = new GestionRolDAO();
		Rol r = gr.buscar(codigo);

		if (r == null) {
			alerta("El rol no existe en la Base de Datos", JOptionPane.ERROR_MESSAGE);
			limpiar();
		} else {
			txtCodigo.setText(String.valueOf(r.getIdRol()));
			txtRol.setText(r.getDescripcion());

		}

	}
	
	void eliminarDatos() {
		
		int codigo;

		codigo = leerCodigo();

		GestionRolDAO gr = new GestionRolDAO();
		Rol r = new Rol();
		r.setIdRol(codigo);
		int ok = gr.eliminar(r);

		if (ok == 0) {
			JOptionPane.showMessageDialog(this, "Error al eliminar");
		} else {
			JOptionPane.showMessageDialog(this, "Se elimino el rol registrado");
			
			listado();
		}

	}
	
	private int leerCodigo() {
		
		if (txtCodigo.getText().equals("")) {
			alerta("El campo código no debe estar vacío", JOptionPane.WARNING_MESSAGE);
			return -1;
		}
		
		if (!txtCodigo.getText().matches("[0-9]")) {
			alerta("El campo código solo permite números", JOptionPane.WARNING_MESSAGE);
			return -1;
		}
		return Integer.parseInt(txtCodigo.getText());
	}
	
	private String leerRol() {
		
		if (txtRol.getText().trim().equals("")) {
			alerta("El campo rol no debe estar vacío", JOptionPane.WARNING_MESSAGE);
			return null;
		}
		if (!txtRol.getText().trim().matches("[[A-Za-záéíóúÁÉÍÓÚ]+( [A-Za-záéíóúÁÉÍÓÚ]+)*]{2,30}")) {
			alerta("El campo rol solo permite letras", JOptionPane.ERROR_MESSAGE);
			return null;
		}

		try {
			return txtRol.getText().trim();
		} catch (Exception e) {
			alerta("Rol incorrecto" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
	
	void alerta(String msg, int tipo) {
		JOptionPane.showMessageDialog(this, msg, "Sistema - aviso", tipo);
	}
	
	void limpiar() {

		txtCodigo.setText("");
		txtRol.setText("");
		txtRol.requestFocus();
	}
	
	
}
