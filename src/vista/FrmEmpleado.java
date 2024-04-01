package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import interfaces.EmpleadoInterfacesDAO;
import mantenimiento.GestionEmpleadoDAO;
import mantenimiento.GestionRolDAO;
import entidad.Empleado;
import entidad.Rol;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JTextPane;
import java.awt.Panel;
import java.awt.Button;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class FrmEmpleado extends JInternalFrame implements ActionListener {
	private JTextField txtDni;
	private JTextField txtNombres;
	private JTextField txtApePaterno;
	private JTextField txtCorreo;
	private JTextField txtCelular;
	private JTextField txtApeMaterno;
	private JDateChooser dateFechaNac;
	private JTable tbEmpleado;
	private JTextField txtUsuario;
	private JTextField txtClave;
	private JButton btnCerrar;
	private JComboBox cboRol;
	private JButton btnBuscar;
	private JButton btnModificar;
	private JButton btnRegistrar;
	private JScrollPane scrollPane;

	DefaultTableModel modelo = new DefaultTableModel();
	private JButton btnEliminar;
	private JTextField txtIdEmpleado;
	private JLabel lblCdigo;
	private JComboBox cboSexo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmEmpleado dialog = new FrmEmpleado();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public FrmEmpleado() {
		getContentPane().setBackground(SystemColor.activeCaption);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
	
		setTitle("EMPLEADO");
		setBounds(100, 100, 1084, 479);
		getContentPane().setLayout(null);

		JLabel lblDni = new JLabel("Dni:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDni.setBounds(10, 52, 21, 15);
		getContentPane().add(lblDni);

		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombres.setBounds(235, 11, 52, 15);
		getContentPane().add(lblNombres);

		JLabel lblApePaterno = new JLabel("Apellido Paterno:");
		lblApePaterno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblApePaterno.setBounds(10, 89, 93, 15);
		getContentPane().add(lblApePaterno);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFecha.setBounds(235, 129, 36, 15);
		getContentPane().add(lblFecha);

		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCelular.setBounds(235, 52, 39, 15);
		getContentPane().add(lblCelular);

		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCorreo.setBounds(235, 89, 40, 15);
		getContentPane().add(lblCorreo);

		txtDni = new JTextField();
		txtDni.setBounds(113, 50, 112, 20);
		getContentPane().add(txtDni);
		txtDni.setColumns(10);

		txtNombres = new JTextField();
		txtNombres.setBounds(297, 9, 133, 20);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);

		txtApePaterno = new JTextField();
		txtApePaterno.setBounds(113, 87, 112, 20);
		getContentPane().add(txtApePaterno);
		txtApePaterno.setColumns(10);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSexo.setBounds(440, 11, 31, 15);
		getContentPane().add(lblSexo);

		txtCorreo = new JTextField();
		txtCorreo.setBounds(297, 87, 133, 20);
		getContentPane().add(txtCorreo);
		txtCorreo.setColumns(10);

		txtCelular = new JTextField();
		txtCelular.setBounds(297, 50, 133, 20);
		getContentPane().add(txtCelular);
		txtCelular.setColumns(10);

		btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon(FrmEmpleado.class.getResource("/img/actualizar.png")));
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnModificar.addActionListener(this);
		btnModificar.setBounds(641, 60, 120, 38);
		getContentPane().add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(FrmEmpleado.class.getResource("/img/eliminar.png")));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(771, 11, 120, 38);
		getContentPane().add(btnEliminar);

		JLabel lblApeMaterno = new JLabel("Apellido Materno:");
		lblApeMaterno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblApeMaterno.setBounds(10, 129, 95, 15);
		getContentPane().add(lblApeMaterno);

		txtApeMaterno = new JTextField();
		txtApeMaterno.setBounds(113, 127, 112, 20);
		getContentPane().add(txtApeMaterno);
		txtApeMaterno.setColumns(10);

		dateFechaNac = new JDateChooser();
		dateFechaNac.setBounds(297, 127, 133, 20);
		getContentPane().add(dateFechaNac);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(FrmEmpleado.class.getResource("/img/busca.png")));
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(641, 109, 120, 38);
		getContentPane().add(btnBuscar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 173, 1042, 252);
		getContentPane().add(scrollPane);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsuario.setBounds(440, 89, 39, 15);
		getContentPane().add(lblUsuario);

		JLabel lblClave = new JLabel("Clave:");
		lblClave.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblClave.setBounds(439, 129, 32, 15);
		getContentPane().add(lblClave);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(489, 86, 127, 22);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);

		txtClave = new JTextField();
		txtClave.setBounds(489, 125, 127, 22);
		getContentPane().add(txtClave);
		txtClave.setColumns(10);

		JLabel lblRol = new JLabel("Rol:");
		lblRol.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRol.setBounds(440, 52, 20, 15);
		getContentPane().add(lblRol);

		cboRol = new JComboBox();
		cboRol.setBounds(489, 48, 127, 24);
		getContentPane().add(cboRol);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon(FrmEmpleado.class.getResource("/img/exit.png")));
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(771, 106, 120, 38);
		getContentPane().add(btnCerrar);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setIcon(new ImageIcon(FrmEmpleado.class.getResource("/img/guardar.png")));
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(641, 11, 120, 38);
		getContentPane().add(btnRegistrar);

		tbEmpleado = new JTable();
		tbEmpleado.setModel(modelo);
		modelo.addColumn("Código");
		modelo.addColumn("DNI");
		modelo.addColumn("Apellido Paterno");
		modelo.addColumn("Apellido Materno");
		modelo.addColumn("Nombres");
		modelo.addColumn("Sexo");
		modelo.addColumn("Fecha de Nacimiento");
		modelo.addColumn("Celular");
		modelo.addColumn("Correo");
		modelo.addColumn("Usuario");
		modelo.addColumn("Clave");
		modelo.addColumn("Rol");
		tbEmpleado.getColumnModel().getColumn(0).setPreferredWidth(50);
		tbEmpleado.getColumnModel().getColumn(2).setPreferredWidth(110);
		tbEmpleado.getColumnModel().getColumn(3).setPreferredWidth(110);
		tbEmpleado.getColumnModel().getColumn(4).setPreferredWidth(110);
		tbEmpleado.getColumnModel().getColumn(5).setPreferredWidth(40);
		tbEmpleado.getColumnModel().getColumn(6).setPreferredWidth(90);
		tbEmpleado.getColumnModel().getColumn(9).setPreferredWidth(50);
		tbEmpleado.getColumnModel().getColumn(10).setPreferredWidth(40);
		tbEmpleado.getColumnModel().getColumn(11).setPreferredWidth(80);

		scrollPane.setViewportView(tbEmpleado);

		txtIdEmpleado = new JTextField();
		txtIdEmpleado.setEditable(false);
		txtIdEmpleado.setBounds(113, 11, 112, 22);
		getContentPane().add(txtIdEmpleado);
		txtIdEmpleado.setColumns(10);

		lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCdigo.setBounds(10, 11, 41, 15);
		getContentPane().add(lblCdigo);
		
		cboSexo = new JComboBox();
		cboSexo.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "Masculino", "Femenino"}));
		cboSexo.setBounds(489, 9, 127, 21);
		getContentPane().add(cboSexo);

		llenaCombo();
		listado();

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}

	}

	protected void actionPerformedBtnRegistrar(ActionEvent e) {

		registrarDatos();
		limpiar();
	}

	protected void actionPerformedBtnBuscar(ActionEvent e) {

		buscarDatos();
	}

	protected void actionPerformedBtnModificar(ActionEvent e) {

		modificarDatos();
		limpiar();
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {

		eliminarDatos();
		limpiar();

	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {

		dispose();
	}

	void registrarDatos() {

		String dni, sexo, nombres, apePaterno, apeMaterno, correo, fechaNac, usuario, clave, celular;
		
		int rol;

		dni = leerDni();
		apePaterno = leerApePaterno();
		apeMaterno = leerApeMaterno();
		nombres = leerNombres();
		fechaNac = leerFecha();
		celular = leerCelular();
		correo = leerCorreo();
		usuario = dni;
		clave = dni;
		sexo = leerSexo();
		rol = leerRol();

		if (dni == null || apePaterno == null || apeMaterno == null || nombres == null || celular == null
				|| correo == null || fechaNac == null || usuario == null || clave == null || sexo == null || rol == -1) {
			return;
		}

		GestionEmpleadoDAO ge = new GestionEmpleadoDAO();
		Empleado emp = new Empleado(dni, apePaterno, apeMaterno, nombres, sexo, fechaNac, celular, correo, usuario,
				clave, rol);
		int ok = ge.registrar(emp);

		if (ok == 0) {
			JOptionPane.showMessageDialog(this, "Error al registrar");
		} else {
			JOptionPane.showMessageDialog(this, "Se registro correctamente");
			
			listado();
		}

	}

	void buscarDatos() {

		String dni = leerDni();

		GestionEmpleadoDAO ge = new GestionEmpleadoDAO();
		Empleado emp = ge.buscar(dni);

		if (emp == null) {
			alerta("El DNI no existe en la Base de Datos", JOptionPane.ERROR_MESSAGE);
			limpiar();
		} else {
			txtIdEmpleado.setText(String.valueOf(emp.getId_empleado()));
			txtApePaterno.setText(emp.getApePaterno());
			txtApeMaterno.setText(emp.getApeMaterno());
			txtNombres.setText(emp.getNombres());
			cboSexo.setSelectedItem(emp.getSexo());
			txtCelular.setText(emp.getCelular());
			txtCorreo.setText(emp.getCorreo());
			txtUsuario.setText(emp.getUsuario());
			txtClave.setText(emp.getClave());
			cboRol.setSelectedIndex(emp.getRol());
			try {
				dateFechaNac.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(emp.getFechaNac()));
			} catch (Exception e) {
				alerta("Error en la fecha : " + e.getMessage(), JOptionPane.WARNING_MESSAGE);
			}

		}

	}

	void modificarDatos() {

		String dni, sexo, nombres, apePaterno, apeMaterno, correo, fechaNac, usuario, clave, celular;

		int rol, idEmpleado;

		idEmpleado = Integer.parseInt(txtIdEmpleado.getText());
		dni = leerDni();
		apePaterno = leerApePaterno();
		apeMaterno = leerApeMaterno();
		nombres = leerNombres();
		sexo = leerSexo();
		fechaNac = leerFecha();
		celular = leerCelular();
		correo = leerCorreo();
		usuario = leerUsuario();
		clave = leerClave();
		rol = leerRol();

		if (dni == null || apePaterno == null || apeMaterno == null || nombres == null || celular == null
				|| correo == null || fechaNac == null || usuario == null || clave == null || sexo == null || rol == -1) {
			return;
		}

		GestionEmpleadoDAO ge = new GestionEmpleadoDAO();
		Empleado emp = new Empleado(idEmpleado, dni, apePaterno, apeMaterno, nombres, sexo, fechaNac, celular, correo, usuario, clave,
				 rol);
		int ok = ge.modificar(emp);

		if (ok == 0) {
			JOptionPane.showMessageDialog(this, "Error al actualizar los datos");
		} else {
			JOptionPane.showMessageDialog(this, "Se actualizo correctamente");

			listado();
		}
	}

	void eliminarDatos() {

		String dni;

		dni = leerDni();

		GestionEmpleadoDAO ge = new GestionEmpleadoDAO();
		Empleado emp = new Empleado();
		emp.setDni(dni);
		int ok = ge.eliminar(emp);

		if (ok == 0) {
			JOptionPane.showMessageDialog(this, "Error al eliminar");
		} else {
			JOptionPane.showMessageDialog(this, "Se elimino el registro");

			listado();
		}

	}

	void listado() {

		ArrayList<Empleado> lista = new GestionEmpleadoDAO().listado();

		modelo.setRowCount(0);
		for (Empleado emp : lista) {

			Object[] datos = { emp.getId_empleado(), emp.getDni(), emp.getApePaterno(), emp.getApeMaterno(),
					emp.getNombres(), emp.getSexo(), emp.getFechaNac(), emp.getCelular(), emp.getCorreo(), emp.getUsuario(),
					emp.getClave(), emp.getRol()};

			modelo.addRow(datos);
		}
	}

	void llenaCombo() {

		GestionRolDAO gr = new GestionRolDAO();
		ArrayList<Rol> listaRol = gr.listado();

		cboRol.addItem("Seleccione");
		for (Rol t : listaRol) {
			cboRol.addItem(t.getDescripcion());
		}


	}

	private void limpiar() {
		
		txtIdEmpleado.setText("");
		txtDni.setText("");
		txtApePaterno.setText("");
		txtApeMaterno.setText("");
		txtNombres.setText("");
		cboSexo.setSelectedIndex(0);
		dateFechaNac.setDate(null);
		txtCelular.setText("");
		txtCorreo.setText("");
		txtUsuario.setText("");
		txtClave.setText("");
		cboRol.setSelectedIndex(0);

		txtDni.requestFocus();

	}

	private int leerRol() {

		switch (cboRol.getSelectedIndex()) {
		case 0:
			alerta("Debe selecionar un rol", JOptionPane.WARNING_MESSAGE);

			return -1;

		default:
			return cboRol.getSelectedIndex();
		}
	}

	private String leerSexo() {

		switch (cboSexo.getSelectedIndex()) {
		case 0:
			alerta("Debe seleccionar un sexo", JOptionPane.WARNING_MESSAGE);
			return null;
			
		case 1:
			return "Masculino";

		default:
			return "Femenino";
		}

	}

	private String leerClave() {
		if (txtClave.getText().equals("")) {
			alerta("El campo clave no debe estar vacio", JOptionPane.WARNING_MESSAGE);
			return null;
		}

		if (!txtClave.getText().matches("[a-zA-ZáéíóúÁÉÍÓÚ0-9]{2,10}")) {
			alerta("El campo clave solo permite letras y/o números", JOptionPane.WARNING_MESSAGE);
			return null;
		}

		return txtClave.getText();
	}

	private String leerUsuario() {

		if (txtUsuario.getText().equals("")) {
			alerta("El campo usuario no debe estar vacio", JOptionPane.WARNING_MESSAGE);
			return null;
		}

		if (!txtUsuario.getText().matches("[a-zA-ZáéíóúÁÉÍÓÚ0-9]{2,10}")) {
			alerta("El campo usuario solo permite letras y/o números", JOptionPane.WARNING_MESSAGE);
			return null;
		}

		try {
			return txtUsuario.getText().trim();
		} catch (Exception e) {
			alerta("Usuario incorrecto" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
			return null;
		}

	}

	private String leerDni() {

		if (txtDni.getText().equals("")) {
			alerta("El campo DNI no debe estar vacio", JOptionPane.WARNING_MESSAGE);
			return null;
		}
		if (!txtDni.getText().matches("[0-9]{8}")) {
			alerta("Ingresar número DNI correcto ", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		try {
			return (txtDni.getText().toString());
		} catch (Exception e) {
			alerta("DNI incorrecto" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	private String leerApePaterno() {
		if (txtApePaterno.getText().equals("")) {
			alerta("El campo apellido paterno no debe estar vacio", JOptionPane.WARNING_MESSAGE);
			return null;
		}
		if (!txtApePaterno.getText().matches("[A-Za-záéíóúÁÉÍÓÚ]{2,25}")) {
			alerta("El campo apellido paterno solo permite letras", JOptionPane.ERROR_MESSAGE);
			return null;
		}

		try {
			return txtApePaterno.getText();
		} catch (Exception e) {
			alerta("Apellido paterno incorrecto" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	private String leerApeMaterno() {
		if (txtApeMaterno.getText().equals("")) {
			alerta("El campo apellido materno no debe estar vacio", JOptionPane.WARNING_MESSAGE);
			return null;
		}
		if (!txtApeMaterno.getText().matches("[A-Za-záéíóúÁÉÍÓÚ]{2,25}")) {
			alerta("El campo apellido materno solo permite letras", JOptionPane.ERROR_MESSAGE);
			return null;
		}

		try {
			return txtApeMaterno.getText().trim();
		} catch (Exception e) {
			alerta("Apellido materno incorrecto" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	private String leerNombres() {
		if (txtNombres.getText().equals("")) {
			alerta("El campo nombres no debe estar vacio", JOptionPane.WARNING_MESSAGE);
			return null;
		}
		if (!txtNombres.getText().matches("[[A-Za-záéíóúÁÉÍÓÚ]+( [A-Za-záéíóúÁÉÍÓÚ]+)*]{2,25}")) {
			alerta("Los nombres solo aceptan letras", JOptionPane.ERROR_MESSAGE);
			return null;
		}

		try {
			return txtNombres.getText().trim();
		} catch (Exception e) {
			alerta("Nombres incorrectos" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	private String leerCelular() {
		if (txtCelular.getText().equals("")) {
			alerta("El campo celular no debe estar vacio", JOptionPane.WARNING_MESSAGE);
			return null;
		}
		if (!txtCelular.getText().matches("[0-9]{9}")) {
			alerta("El celular ingresado no es correcto", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		try {
			return txtCelular.getText().toString().trim();
		} catch (Exception e) {
			alerta("celular incorrecto" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	private String leerCorreo() {
		if (txtCorreo.getText().equals("")) {
			alerta("El campo correo no debe estar vacio", JOptionPane.WARNING_MESSAGE);
			return null;
		}
		if (!txtCorreo.getText().matches(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,30})$")) {
			alerta("El correo ingresado no es válido", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		try {
			return txtCorreo.getText().trim();
		} catch (Exception e) {
			alerta("Correo no permitido" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	String leerFecha() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		try {
			return sdf.format(dateFechaNac.getDate());
		} catch (Exception e) {
			alerta("Fecha incorrecta" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
			return null;

		}
	}

	void alerta(String msg, int tipo) {
		JOptionPane.showMessageDialog(this, msg, "Sistema - aviso", tipo);
	}
}
