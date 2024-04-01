package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hilos.HiloBarraProgreso;
import hilos.HiloTiempo;

import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.ImageIcon;

public class FrmPreLoader extends JFrame implements WindowListener, ChangeListener {

	private JPanel contentPane;
	public static JProgressBar prbCarga;
	private JLabel lblCargar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPreLoader frame = new FrmPreLoader();
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
	public FrmPreLoader() {
		addWindowListener(this);
		setTitle("Cargando...");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 362, 423);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		prbCarga = new JProgressBar();
		prbCarga.addChangeListener(this);
		prbCarga.setStringPainted(true);
		prbCarga.setBounds(0, 23, 313, 19);
		contentPane.add(prbCarga);
		
		JLabel lblMensajes = new JLabel("El sistema est\u00E1 cargando, espere unos segundos");
		lblMensajes.setForeground(Color.BLUE);
		lblMensajes.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMensajes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensajes.setBounds(0, 5, 313, 14);
		contentPane.add(lblMensajes);
		
		lblCargar = new JLabel("");
		lblCargar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargar.setIcon(new ImageIcon(FrmPreLoader.class.getResource("/img/loader_800.gif")));
		lblCargar.setBounds(10, 52, 328, 324);
		contentPane.add(lblCargar);
		
		//metodo para iniciar la carga de la barra
		iniciarBarraProgreso();
		
	}

	private void iniciarBarraProgreso() {
		// 0 --> 100%
		HiloBarraProgreso h = new HiloBarraProgreso();
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
	
	}
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == prbCarga) {
			stateChangedPrbCarga(e);
		}
	}
	protected void stateChangedPrbCarga(ChangeEvent e) {
		// 1. Validar si la barra de profesor tiene el valor 100
		if (prbCarga.getValue() == 100) {
			//Instancia un objeto de tipo FrmkPrinciapl
			FrmPrincipal prin = new FrmPrincipal();
			//Objeto sea visible
			prin.setVisible(true);
			//Ubicacion
			prin.setLocationRelativeTo(this);
			//Cerrar la ventana actual (barra de progreso) -- this: hace referencia al objeto creado
			this.dispose();
		}
		
	}
}
