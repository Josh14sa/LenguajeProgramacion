package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import utils.Validaciones;

import java.util.Date;

import java.awt.Font;

import java.text.SimpleDateFormat;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class RegVacaciones extends JInternalFrame implements ActionListener {
	private JPanel contentPane;
	private JDateChooser dateChooser;
	private JLabel lblRegistroVacaciones;
	private JLabel lblFecha;
	Date fecha = new Date();
	// aplicar un formato
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
	private JLabel lblA;
	private JButton btnRegistrar;
	private JLabel lblCodigo;
	private JTextField txtId;
	private JLabel lblArea;
	private JTextField txtArea;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private JButton btnBuscar;
	private JDateChooser txtFechaInicio;
	private JTextField textField;
	private JDateChooser txtFechaFin;
	private JTable tbRegistros;
	
	
	//Instanciar un objeto para la estructura de la tabla
	DefaultTableModel model = new DefaultTableModel();
		

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
					RegVacaciones frame = new RegVacaciones();
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
	public RegVacaciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 465);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		getContentPane().setForeground(SystemColor.activeCaption);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 523, 465);
		getContentPane().setLayout(null);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(87, 382, 86, 28);
		getContentPane().add(btnRegistrar);

		lblCodigo = new JLabel("Código");
		lblCodigo.setBounds(23, 80, 50, 16);
		getContentPane().add(lblCodigo);

		lblFecha = new JLabel("Fecha Inicio:");
		lblFecha.setBounds(23, 135, 71, 13);
		getContentPane().add(lblFecha);
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));

		lblA = new JLabel("Fecha Fin:");
		lblA.setBounds(265, 133, 64, 16);
		getContentPane().add(lblA);

		txtId = new JTextField();
		txtId.setBounds(102, 74, 112, 28);
		txtId.setEditable(false);
		getContentPane().add(txtId);
		txtId.setColumns(10);

		lblArea = new JLabel("Área / Oficina:");
		lblArea.setBounds(23, 166, 86, 16);
		getContentPane().add(lblArea);

		txtArea = new JTextField();
		txtArea.setBounds(102, 160, 112, 28);
		txtArea.setEditable(false);
		getContentPane().add(txtArea);
		txtArea.setColumns(10);

		lblRegistroVacaciones = new JLabel("Registro de Vacaciones");
		lblRegistroVacaciones.setBounds(117, 13, 286, 36);
		getContentPane().add(lblRegistroVacaciones);
		lblRegistroVacaciones.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRegistroVacaciones.setHorizontalAlignment(SwingConstants.CENTER);

		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(203, 382, 86, 28);
		getContentPane().add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(317, 382, 86, 28);
		getContentPane().add(btnEliminar);

		scrollPane = new JScrollPane();
		scrollPane.setOpaque(true);
		scrollPane.setEnabled(false);
		scrollPane.setBounds(23, 222, 470, 138);
		getContentPane().add(scrollPane);

		tbRegistros = new JTable();
		tbRegistros.setShowVerticalLines(true);
		tbRegistros.setShowHorizontalLines(true);
		tbRegistros.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbRegistros);

		btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon(RegVacaciones.class.getResource("/img/busca.png")));
		btnBuscar.setBounds(222, 61, 50, 46);
		getContentPane().add(btnBuscar);

		txtFechaInicio = new JDateChooser();
		txtFechaInicio.setDateFormatString("dd-MM-yyyy");
		txtFechaInicio.setBounds(102, 120, 112, 28);
		contentPane.add(txtFechaInicio);

		txtFechaFin = new JDateChooser();
		txtFechaFin.setDateFormatString("dd-MM-yyyy");
		txtFechaFin.setBounds(341, 120, 104, 28);
		contentPane.add(txtFechaFin);

		// Crear las columnas de la tabla
		model.addColumn("Código");
		model.addColumn("Fecha Inicio");
		model.addColumn("Fecha Fin");
		model.addColumn("Área");

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
	}

	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		//Declarar las variables
		String fecIni, fecFin,area;
		//Entrada
		fecIni = getFechaInicio();
		fecFin = getFechaFin();
		area = getArea();
		//Procesos
		//
		
		
	}

	private String getArea() {
		String area = null;
		if(txtArea.getText().length() == 0) {
			mensajeError("Ingresar el área");
			txtArea.setText("");
			
		}else if(txtArea.getText().trim().matches(Validaciones.TEXTO)) {
			area = txtArea.getText().trim();
		}else {
			mensajeError("El área ingresada no cumple con el formato");
			txtArea.setText("");
			txtArea.requestFocus();
		}
		return area;
	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this,  msj,"Error",0);
		
	}

	private String getFechaFin() {
		// TODO Auto-generated method stub
		return null;
	}

	private String getFechaInicio() {
		String fecIni = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		fecIni = sdf.format(txtFechaInicio.getDate());		
		return fecIni;
	}
}
