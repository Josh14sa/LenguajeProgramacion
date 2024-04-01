package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hilos.HiloTiempo;
import mantenimiento.GestionEmpleadoDAO;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;

import entidad.Usuario;

import java.awt.Color;


public class Logueo extends JFrame implements KeyListener, ActionListener, WindowListener {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtClave;
	public static Logueo frame;
	private JButton btnAceptar;
	private JLabel lblManejo;
	public static JLabel lblTiempo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Logueo();
					frame.setVisible(true);
					//centrar mi interfaz
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Logueo() {
		addWindowListener(this);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Logueo.class.getResource("/img/avatar.png")));
		setTitle("Acceso al Sistema");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 385, 219);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario :");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsuario.setBounds(130, 36, 96, 20);
		contentPane.add(lblUsuario);
		
		JLabel lblClave = new JLabel("Contrase\u00F1a:");
		lblClave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClave.setBounds(130, 77, 96, 20);
		contentPane.add(lblClave);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(236, 38, 103, 22);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtClave = new JPasswordField();
		txtClave.addKeyListener(this);
		txtClave.setBounds(236, 80, 103, 20);
		contentPane.add(txtClave);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(137, 116, 89, 23);
		contentPane.add(btnAceptar);
		btnAceptar.setEnabled(false);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(250, 116, 89, 23);
		contentPane.add(btnSalir);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(Logueo.class.getResource("/img/logueo.png")));
		lblFondo.setBounds(0, 0, 127, 184);
		contentPane.add(lblFondo);
		
		lblManejo = new JLabel("Esta ventana se cerrará en");
		lblManejo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblManejo.setBounds(139, 11, 152, 14);
		contentPane.add(lblManejo);
		
		lblTiempo = new JLabel("10 s");
		lblTiempo.setBounds(301, 11, 46, 14);
		contentPane.add(lblTiempo);
		//
		//iniciarConteo();
	}
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtClave) {
			keyReleasedTxtClave(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTxtClave(KeyEvent e) {
		if(txtClave.getText().trim().length()>= 1) {
			btnAceptar.setEnabled(true);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		validarCredenciales();
		
		
		/*FrmPrincipal prin = new FrmPrincipal();
		prin.setVisible(true);
		prin.setLocationRelativeTo(this);
		prin.setExtendedState(MAXIMIZED_BOTH);
		dispose();	*/
	}
	
	private void validarCredenciales() {
		String usuario, clave;
		
		usuario= txtUsuario.getText();
		clave = txtClave.getText();
		
		GestionEmpleadoDAO ge = new GestionEmpleadoDAO();		
		Usuario us = new Usuario(usuario,clave);		
		boolean ok = ge.validarCredenciales(us);
		
		//if (ok=true) {   REALLY?		
		if (ok == true) { 
			FrmPreLoader barra = new FrmPreLoader();
			barra.setVisible(true);
			barra.setLocationRelativeTo(this);			
		}else {
			JOptionPane.showMessageDialog(this, "Contraseña incorrecta");
		}
	}

	private void iniciarConteo() {
		//intanciar
		HiloTiempo h = new HiloTiempo(lblTiempo, frame);
		//ejecutar 
		h.start();
	}
	
	
	
	
	public void windowActivated(WindowEvent e) {
	}
	public void windowClosed(WindowEvent e) {
	}
	public void windowClosing(WindowEvent e) {
	}
	public void windowDeactivated(WindowEvent e) {
	}
	public void windowDeiconified(WindowEvent e) {
	}
	public void windowIconified(WindowEvent e) {
	}
	public void windowOpened(WindowEvent e) {
		if (e.getSource() == this) {
			windowOpenedThis(e);
		}
	}
	protected void windowOpenedThis(WindowEvent e) {
		iniciarConteo();
	}
}
