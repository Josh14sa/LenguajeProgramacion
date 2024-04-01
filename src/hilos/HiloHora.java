package hilos;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

import vista.FrmPrincipal;

public class HiloHora extends Thread {
	
	//componente privado
	private JLabel lblReloj;
	
	//constructor
	public HiloHora(JLabel lblReloj) {
		super();
		this.lblReloj = lblReloj;
	}
	//
	@Override
	public void run() {
		while (true) {
			//Instanciar un objeto de la clase "Date"
			Date hora = new Date();
			//Instanciar un objeto de la clase "SimpleDateFormat" para definir
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
			//mostrar la hora en la etiqueta "lblRelog"
			lblReloj.setText(sdf.format(hora));
		}
	}
}
