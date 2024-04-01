package hilos;
import javax.swing.JFrame;
import javax.swing.JLabel;


import vista.Logueo;

public class HiloTiempo extends Thread {
	//Declarar componentes
	private JLabel lblTiempo;
	private JFrame ventana;

	//constructor
	public HiloTiempo(JLabel lblTiempo, JFrame ventana) {
		this.lblTiempo = lblTiempo;
		this.ventana = ventana;
	}
	
	
	
	
	@Override
	public void run() {
		for(int i = 30; i >= 0; i--) {
			//Logueo.lblTiempo.setText(i +"s"); no me permite reutilizar el codigo
			lblTiempo.setText(i +"s");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println(i);
		}
		//Logueo.frame.dispose(); -- no me permite reutilizar el codigo
		ventana.dispose();
	}
}
