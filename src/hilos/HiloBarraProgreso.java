package hilos;
import javax.swing.JProgressBar;

import vista.FrmPreLoader;
public class HiloBarraProgreso extends Thread {

@Override
public void run() {
	for (int i = 0; i<= 100; i++) {
		FrmPreLoader.prbCarga.setValue(i);
		try {
			Thread.sleep(5); //tiempo de demora en la carga del PROGRESS BAR
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}
