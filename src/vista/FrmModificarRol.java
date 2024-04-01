package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.toedter.calendar.JDateChooser;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class FrmModificarRol extends JInternalFrame {
	private JDateChooser dateChooser;
	private JLabel lblModificar;
	private JLabel lblNumeroParticipante;
	private JTextField txtsolicitud;
	private JButton btnBuscar;
	private JLabel lblFecha;
	private JTextField textField_1;
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
					FrmModificarRol frame = new FrmModificarRol();
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
	public FrmModificarRol() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 544, 242);
		getContentPane().setLayout(null);
		
		lblModificar = new JLabel("Modificar Rol Vacacional");
		lblModificar.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblModificar.setBounds(134, 20, 257, 13);
		getContentPane().add(lblModificar);
		
		lblNumeroParticipante = new JLabel("N° Solicitud");
		lblNumeroParticipante.setBounds(17, 63, 86, 16);
		getContentPane().add(lblNumeroParticipante);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(23, 120, 45, 13);
		getContentPane().add(lblFecha);
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(95, 105, 133, 28);
		getContentPane().add(dateChooser_1);
		
		JLabel lblA = new JLabel("A");
		lblA.setBounds(240, 118, 50, 16);
		getContentPane().add(lblA);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(258, 105, 133, 28);
		getContentPane().add(dateChooser);
		
		txtsolicitud = new JTextField();
		txtsolicitud.setBounds(100, 57, 118, 28);
		getContentPane().add(txtsolicitud);
		txtsolicitud.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(416, 57, 86, 28);
		getContentPane().add(btnBuscar);
		
		JLabel lblCodigoModificacion = new JLabel("Código Modificación");
		lblCodigoModificacion.setBounds(18, 162, 146, 16);
		getContentPane().add(lblCodigoModificacion);
		
		textField_1 = new JTextField();
		textField_1.setBounds(161, 156, 129, 28);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(416, 137, 86, 28);
		getContentPane().add(btnGuardar);

	}
}
