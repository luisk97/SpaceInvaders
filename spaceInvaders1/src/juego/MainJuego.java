package juego;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import estructura.HileraPrincipal;

public class MainJuego {

	public static void main(String[] args) throws InterruptedException {
		HileraPrincipal hilPrin = HileraPrincipal.getInstance();
		boolean enPartida = false;
		Random randomHilera = new Random();
		int tipo;
		VentanaJuego ventana = new VentanaJuego();
		while(true) {
			enPartida = ventana.getJuego().isEnCurso();
			if(enPartida) {
				ventana.getJuego().move();
				ventana.getJuego().repaint();
				ventana.setLblVida(ventana.getJuego().getNave().getVida());
				ventana.setLblNivel(ventana.getJuego().getNave().getNivel());
				ventana.setLblPuntos(ventana.getJuego().getNave().getPuntos());
				if(ventana.getJuego().getNave().getVida() <= 0) {
					ventana.getBtnPausa().setVisible(false);
					ventana.getJuego().setEnCurso(false);
					ventana.getPanelInicio().setVisible(true);
					ventana.getJuego().setVisible(false);
				}
				if(hilPrin.estaVacia()){
					for(int i = 0; i < 6; i++) {
						tipo = randomHilera.nextInt(6);
						hilPrin.add(tipo);
					}
				}
			}else {
				
			}
			Thread.sleep(10);
		}
		
	}

}
