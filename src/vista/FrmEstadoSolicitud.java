package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JDesktopPane;

public class FrmEstadoSolicitud extends JInternalFrame {
	private JLabel lblEstadoSolicitud;
	private JDateChooser dateChooser;
	private JRadioButton rdbtnPreAprobado;
	private JRadioButton rdbtnAprobado;
	

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
					FrmEstadoSolicitud frame = new FrmEstadoSolicitud();
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
	public FrmEstadoSolicitud() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 594, 326);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(25, 71, 527, 127);
		getContentPane().add(scrollPane);
		
		JTable tbVacaciones = new JTable();
		scrollPane.setViewportView(tbVacaciones);
		tbVacaciones.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID", "Fecha Inicio", "Fecha Fin", "Estado"
			}
		));
		tbVacaciones.setFillsViewportHeight(true);
		
		
		
		rdbtnPreAprobado = new JRadioButton("Pre-Aprobado");
		rdbtnPreAprobado.setBounds(95, 230, 174, 18);
		getContentPane().add(rdbtnPreAprobado);
		rdbtnPreAprobado.setFont(new Font("SansSerif", Font.BOLD, 16));
		
		rdbtnAprobado = new JRadioButton("Aprobado");
		rdbtnAprobado.setBounds(344, 230, 139, 18);
		getContentPane().add(rdbtnAprobado);
		rdbtnAprobado.setFont(new Font("SansSerif", Font.BOLD, 16));
		
		JLabel lblModificar = new JLabel("Estado de Solicitud");
		lblModificar.setBounds(110, 18, 323, 33);
		getContentPane().add(lblModificar);
		lblModificar.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificar.setFont(new Font("Tahoma", Font.BOLD, 20));
		
	}
}
