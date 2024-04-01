package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import hilos.HiloHora;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;

public class FrmPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenuItem mntmCerrarSesion;
	private JMenuItem mntmSalir;
	private JMenu mnMantenimiento;
	private JMenuItem mntmActualizarDatos;
	private JMenu mnVacaciones;
	private JMenuItem mntmRegistrarVacaciones;
	private JMenuItem mntmEstadoSolicitud;
	private JMenuItem mntmRegistroRolVacacional;
	private JMenu mnEstadoVacacional;
	private JMenuItem mntmVacacionesArea;
	private JMenuItem mntmCambioEstadoSolicitud;
	private JMenuItem mntmCambioEstadoModificacion;
	private JMenu mnConsultas;
	private JMenuItem mntmTrabajadoresPorOficina;
	private JMenuItem mntmTipoContrato;
	private JMenu mnReportes;
	private JMenuItem mntmVacacionesOficina;
	private JMenuItem mntmVacacionesFechas;
	private JMenu mnUsuario;
	private JMenuItem mntmModificarUsuario;
	private JMenuItem mntmListarEliminar;
	private JMenu mnCréditos;
	private JMenuItem mntmColaboradores;
	public JLabel lblReloj;
	private JLabel lblImage;
	private JDesktopPane desktopPane;
	private JPanel panel;
	private JMenuItem mntmRegistrarEmpleado;
	private JMenuItem mntmRol;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
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
	public FrmPrincipal() {
		try {
			 UIManager.setLookAndFeel( "com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 969, 622);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setMnemonic('A');
		mnArchivo.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/archivo.png")));
		menuBar.add(mnArchivo);
		
		mntmCerrarSesion = new JMenuItem("Cerrar Sesión");
		mntmCerrarSesion.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, InputEvent.ALT_DOWN_MASK));
		mntmCerrarSesion.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/cerrar.png")));
		mnArchivo.add(mntmCerrarSesion);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_DOWN_MASK));
		mntmSalir.addActionListener(this);
		mntmSalir.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/salir.png")));
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setMnemonic('M');
		mnMantenimiento.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/mantenimiento.png")));
		menuBar.add(mnMantenimiento);
		
		mntmActualizarDatos = new JMenuItem("Actualizar Datos");
		mntmActualizarDatos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, InputEvent.ALT_DOWN_MASK));
		mntmActualizarDatos.addActionListener(this);
		mntmActualizarDatos.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/actualizarDatos.png")));
		mnMantenimiento.add(mntmActualizarDatos);
		
		mntmRegistrarEmpleado = new JMenuItem("Registrar Empleado");
		mntmRegistrarEmpleado.addActionListener(this);
		mntmRegistrarEmpleado.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.ALT_DOWN_MASK));
		mntmRegistrarEmpleado.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/guardar.png")));
		mnMantenimiento.add(mntmRegistrarEmpleado);
		
		mntmRol = new JMenuItem("Rol");
		mntmRol.addActionListener(this);
		mntmRol.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_DOWN_MASK));
		mntmRol.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/rol.png")));
		mnMantenimiento.add(mntmRol);
		
		mnVacaciones = new JMenu("Vacaciones");
		mnVacaciones.setMnemonic('V');
		mnVacaciones.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/vacaciones.png")));
		menuBar.add(mnVacaciones);
		
		mntmRegistrarVacaciones = new JMenuItem("Registrar Vacaciones");
		mntmRegistrarVacaciones.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
		mntmRegistrarVacaciones.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/registrar.png")));
		mntmRegistrarVacaciones.addActionListener(this);
		mnVacaciones.add(mntmRegistrarVacaciones);
		
		mntmEstadoSolicitud = new JMenuItem("Estado Solicitud");
		mntmEstadoSolicitud.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
		mntmEstadoSolicitud.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/solicitud.png")));
		mntmEstadoSolicitud.addActionListener(this);
		mnVacaciones.add(mntmEstadoSolicitud);
		
		mntmRegistroRolVacacional = new JMenuItem("Modificación Rol Vacacional");
		mntmRegistroRolVacacional.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK));
		mntmRegistroRolVacacional.addActionListener(this);
		mntmRegistroRolVacacional.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/rolVacacional.png")));
		mnVacaciones.add(mntmRegistroRolVacacional);
		
		mnEstadoVacacional = new JMenu("Estado Vacacional");
		mnEstadoVacacional.setMnemonic('E');
		mnEstadoVacacional.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/estadosVacaciones.png")));
		menuBar.add(mnEstadoVacacional);
		
		mntmVacacionesArea = new JMenuItem("Vacaciones del Área");
		mntmVacacionesArea.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/vacacionesArea.png")));
		mnEstadoVacacional.add(mntmVacacionesArea);
		
		mntmCambioEstadoSolicitud = new JMenuItem("Cambio estado de solicitud");
		mntmCambioEstadoSolicitud.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/cambiarSolicitud.png")));
		mnEstadoVacacional.add(mntmCambioEstadoSolicitud);
		
		mntmCambioEstadoModificacion = new JMenuItem("Cambio Estado de la modificacion vacacional");
		mntmCambioEstadoModificacion.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/cambiarEstado.png")));
		mnEstadoVacacional.add(mntmCambioEstadoModificacion);
		
		mnConsultas = new JMenu("Consultas");
		mnConsultas.setMnemonic('C');
		mnConsultas.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/consultas.png")));
		menuBar.add(mnConsultas);
		
		mntmTrabajadoresPorOficina = new JMenuItem("Trabajadores por oficina");
		mntmTrabajadoresPorOficina.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/trabajadorOficina.png")));
		mnConsultas.add(mntmTrabajadoresPorOficina);
		
		mntmTipoContrato = new JMenuItem("Tipo de contrato");
		mntmTipoContrato.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/tipoContrato.png")));
		mnConsultas.add(mntmTipoContrato);
		
		mnReportes = new JMenu("Reportes");
		mnReportes.setMnemonic('R');
		mnReportes.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/reportes.png")));
		menuBar.add(mnReportes);
		
		mntmVacacionesOficina = new JMenuItem("Vacaciones por oficina");
		mntmVacacionesOficina.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/reporteOficina.png")));
		mnReportes.add(mntmVacacionesOficina);
		
		mntmVacacionesFechas = new JMenuItem("Vacaciones por fechas");
		mntmVacacionesFechas.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/reporteFechas.png")));
		mnReportes.add(mntmVacacionesFechas);
		
		mnUsuario = new JMenu("Usuario");
		mnUsuario.setMnemonic('U');
		mnUsuario.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/usuario.png")));
		menuBar.add(mnUsuario);
		
		mntmModificarUsuario = new JMenuItem("Modificar");
		mntmModificarUsuario.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/modificarUsuario.png")));
		mnUsuario.add(mntmModificarUsuario);
		
		mntmListarEliminar = new JMenuItem("Listar y Eliminar");
		mntmListarEliminar.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/listar.png")));
		mnUsuario.add(mntmListarEliminar);
		
		mnCréditos = new JMenu("Créditos");
		mnCréditos.setMnemonic('C');
		mnCréditos.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/creditos.png")));
		menuBar.add(mnCréditos);
		
		mntmColaboradores = new JMenuItem("Colaboradores");
		mntmColaboradores.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/colaboradores.png")));
		mnCréditos.add(mntmColaboradores);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.NORTH);
		
		lblReloj = new JLabel("New label");
		lblReloj.setHorizontalAlignment(SwingConstants.RIGHT);
		lblReloj.setVerticalAlignment(SwingConstants.TOP);
		lblReloj.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblReloj);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		lblImage = new JLabel("New label");
		lblImage.setEnabled(false);
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/principal.jpg")));
		lblImage.setBounds(0, 0, 897, 393);
		//contentPane.add(lblImage);
		
		//mostrar hora
				cargarHora();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmRol) {
			actionPerformedMntmRol(e);
		}
		
		if (e.getSource() == mntmRegistrarEmpleado) {
			actionPerformedMntmRegistrarEmpleado(e);
		}
		if (e.getSource() == mntmRegistroRolVacacional) {
			actionPerformedMntmRegistroRolVacacional(e);
		}
		if (e.getSource() == mntmActualizarDatos) {
			actionPerformedMntmActualizarDatos(e);
		}
		if (e.getSource() == mntmEstadoSolicitud) {
			actionPerformedMntmEstadoSolicitud(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
		if (e.getSource() == mntmRegistrarVacaciones) {
			actionPerformedMntmRegistrar(e);
		}
	}
	protected void actionPerformedMntmRegistrar(ActionEvent e) {
		RegVacaciones reg = new RegVacaciones();
		reg.setVisible(true);
		contentPane.add(reg);
		
	
		
	}
	
	
	protected void actionPerformedMntmSalir(ActionEvent e) {
		System.exit(0);
	}
		
		private void cargarHora() {
			// 0 --> 100%
			HiloHora h = new HiloHora(lblReloj);
			//ejecutar 
			h.start();
	}
	protected void actionPerformedMntmEstadoSolicitud(ActionEvent e) {
		FrmEstadoSolicitud est = new FrmEstadoSolicitud();
		est.setVisible(true);
		contentPane.add(est);
	}
	protected void actionPerformedMntmActualizarDatos(ActionEvent e) {
		FrmActualizarDatos dat = new FrmActualizarDatos();
		dat.setVisible(true);
		contentPane.add(dat);
	}
	protected void actionPerformedMntmRegistroRolVacacional(ActionEvent e) {
		FrmModificarRol rol = new FrmModificarRol();
		rol.setVisible(true);
		contentPane.add(rol);
	}
	protected void actionPerformedMntmRegistrarEmpleado(ActionEvent e) {
		FrmEmpleado emp = new FrmEmpleado();
		emp.setVisible(true);
		contentPane.add(emp);
	}
	
		
	protected void actionPerformedMntmRol(ActionEvent e) {
		FrmRol rols = new FrmRol();
		rols.setVisible(true);
		contentPane.add(rols);
	}
	
}
