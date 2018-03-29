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
				if(hilPrin.estaVacia()){
					ventana.getJuego().iniciarEnemigos();
				}
				ventana.getJuego().repaint();
				ventana.getJuego().move();
//				ventana.getJuego().repaint();
				ventana.setLblVida(ventana.getJuego().getNave().getVida());
				ventana.setLblNivel(ventana.getJuego().getNave().getNivel());
				ventana.setLblPuntos(ventana.getJuego().getNave().getPuntos());
				if(ventana.getJuego().getNave().getVida() <= 0) {
					ventana.getBtnPausa().setVisible(false);
					ventana.getJuego().setEnCurso(false);
					ventana.getPanelInicio().setVisible(true);
					ventana.getJuego().setVisible(false);
				}
			}else {
				
			}
			Thread.sleep(10);
		}
		
	}

}
