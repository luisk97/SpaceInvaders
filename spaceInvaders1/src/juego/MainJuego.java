package juego;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import estructura.HileraPrincipal;

/**
 * 
 * @author luisk
 *
 */
public class MainJuego {

	/**
	 * Metodo principal en el cual se inicia la ventana de juego y la hilera principal
	 * ademas si en tiempo de ejecucion se preciona el boton play este cambia el atributo
	 * boolean enCurso de la clase Juego a verdadero y esto inicia la partida iniciando 
	 * las hileras enemigas y la animacion del juego
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		HileraPrincipal hilPrin = HileraPrincipal.getInstance();
		boolean enPartida = false;
//		Random randomHilera = new Random();
//		int tipo;
		VentanaJuego ventana = new VentanaJuego();
//		ventana.getJuego().iniciarEnemigos();
		while(true) {
			enPartida = ventana.getJuego().isEnCurso();
			if(enPartida) {
				if(ventana.getJuego().getNave().getNivel()==(ventana.getJuego().getNivelMaximo()+1)) {
					ventana.getBtnPausa().setVisible(false);
					ventana.getJuego().setEnCurso(false);
					ventana.getPanelInicio().setVisible(true);
					ventana.getJuego().setVisible(false);
				}else {
					if(hilPrin.estaVacia()){
					ventana.getJuego().iniciarEnemigos();
					}
				}
				ventana.getJuego().repaint();
				ventana.getJuego().move();
//				ventana.getJuego().repaint();
				ventana.setLblVida(ventana.getJuego().getNave().getVida());
				ventana.setLblNivel(ventana.getJuego().getNave().getNivel());
				ventana.setLblPuntos(ventana.getJuego().getNave().getPuntos());
				if(hilPrin.size()>0) {
					ventana.setLblHileraActual(hilPrin.getCabeza().getHilera().getTipo());
					if(hilPrin.size()<=1) {
						ventana.setLblSiguienteHilera("Ninguna");
					}else {
						ventana.setLblSiguienteHilera(hilPrin.obtener(1).getHilera().getTipo());
					}
				}
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
