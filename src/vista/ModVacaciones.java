package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;

public class ModVacaciones extends JInternalFrame {
	private JTable tbVacaciones;
	private JScrollPane scrollPane;
	private JLabel lblModificar;
	private JLabel lblFechaInicio;
	private JLabel lblFechaFin;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JDateChooser dateChooser;
	Date fecha = new Date();
	//aplicar un formato
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
	private JButton btnEliminar;

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
					ModVacaciones frame = new ModVacaciones();
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
	public ModVacaciones() {
		setAutoscrolls(true);
		setMaximizable(true);
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 618, 352);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(25, 71, 527, 127);
		getContentPane().add(scrollPane);
		
		tbVacaciones = new JTable();
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
		
		lblModificar = new JLabel("Modificar vacaciones");
		lblModificar.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblModificar.setBounds(121, 21, 323, 33);
		getContentPane().add(lblModificar);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(102, 240, 133, 28);
		getContentPane().add(dateChooser);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(319, 240, 133, 28);
		getContentPane().add(dateChooser);
		
		lblFechaInicio = new JLabel("Fecha Inicio");
		lblFechaInicio.setBounds(25, 252, 82, 16);
		getContentPane().add(lblFechaInicio);
		
		lblFechaFin = new JLabel("Fecha Fin");
		lblFechaFin.setBounds(247, 252, 87, 16);
		getContentPane().add(lblFechaFin);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(482, 210, 86, 28);
		getContentPane().add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(482, 287, 86, 28);
		getContentPane().add(btnCancelar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(482, 246, 86, 28);
		getContentPane().add(btnEliminar);

	}
}
