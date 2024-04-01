package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;

public class FrmActualizarDatos extends JInternalFrame {
	private JLabel lblActualizar;
	private JLabel lblDni;
	private JTextField txtDni;
	private JLabel lblNombres;
	private JTextField txtNombres;
	private JLabel lblApellidos;
	private JTextField txtApellidos;
	private JLabel lblDireccion;
	private JTextField txtDireccion;
	private JLabel lblCelular;
	private JTextField txtCelular;
	private JLabel lblCorreo;
	private JTextField txtEmail;
	private JButton btnBuscar;
	private JButton btnGuardar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmActualizarDatos frame = new FrmActualizarDatos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmActualizarDatos() {
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		lblActualizar = new JLabel("Actualizar Datos");
		lblActualizar.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblActualizar.setBounds(97, 21, 214, 13);
		getContentPane().add(lblActualizar);
		
		lblDni = new JLabel("Dni");
		lblDni.setBounds(19, 57, 45, 13);
		getContentPane().add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setBounds(85, 54, 96, 19);
		getContentPane().add(txtDni);
		txtDni.setColumns(10);
		
		lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(19, 88, 75, 13);
		getContentPane().add(lblNombres);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(85, 85, 127, 19);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(19, 119, 75, 13);
		getContentPane().add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(85, 113, 127, 19);
		getContentPane().add(txtApellidos);
		txtApellidos.setColumns(10);
		
		lblDireccion = new JLabel("Dirección");
		lblDireccion.setBounds(19, 156, 75, 13);
		getContentPane().add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(85, 153, 164, 19);
		getContentPane().add(txtDireccion);
		txtDireccion.setColumns(10);
		
		lblCelular = new JLabel("Celular");
		lblCelular.setBounds(19, 195, 75, 13);
		getContentPane().add(lblCelular);
		
		txtCelular = new JTextField();
		txtCelular.setBounds(85, 192, 96, 19);
		getContentPane().add(txtCelular);
		txtCelular.setColumns(10);
		
		lblCorreo = new JLabel("E-mail");
		lblCorreo.setBounds(19, 228, 45, 13);
		getContentPane().add(lblCorreo);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(85, 225, 164, 19);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(306, 96, 85, 21);
		getContentPane().add(btnBuscar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(306, 152, 85, 21);
		getContentPane().add(btnGuardar);

	}
}
