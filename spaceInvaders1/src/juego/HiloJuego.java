/**
 * 
 */
package juego;

import estructura.HileraPrincipal;

/**
 * En esta clase se inicia la hilera principal ademas si en tiempo de ejecucion se preciona
 * el boton play este cambia el atributo boolean enCurso de la clase Juego a verdadero y esto 
 * inicia la partida iniciando las hileras enemigas y la animacion del juego
 * @author luisk
 *
 */
public class HiloJuego implements Runnable{
	
	Thread t;
	VentanaJuego ventana;
	
	/**
	 * Costructor de la clase
	 * @param ventana
	 */
	public HiloJuego(VentanaJuego ventana) {
		this.ventana = ventana;
		t = new Thread(this,"HiloJuego");
		t.start();
	}

	/**
	 * metodo que inicializa el thread del juego
	 */
	@Override
	public void run() {
		HileraPrincipal hilPrin = HileraPrincipal.getInstance();
		boolean enPartida = false;
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
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	}

}
