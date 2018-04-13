package juego;

import java.applet.AudioClip;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import estructura.InterfaceHilera;

/**
 * Esta clase se encarga de brindar las cordenadas y la imagen de la bala para
 * mostrarla en pantalla
 * @author luisk
 *
 */
public class Bala {
	private static final int LARGO = 30;
	private static final int ANCHO = 20;
	private int x;
	private int y;
	private int ya = -6;
	private Juego juego;
	private AudioClip sonido = java.applet.Applet.newAudioClip(getClass().getResource("/sonidos/golpe.wav"));
	JLabel label = new JLabel(new ImageIcon("src/imagenes/bala.png"));
	
	/**
	 * metodo constructor
	 * @param juego
	 * @param x
	 */
	public Bala(Juego juego,int x) {
		this.juego = juego;
		this.y = juego.getHeight()-80;
		this.x = x+35;
	}
	
	/**
	 * este metodo se encarga de actualizar las cordenadas de la bala
	 */
	public void move() {
		if(y+ya < 0) {
			juego.getNave().getBalas().remove(this);
			juego.remove(label);
			label.setVisible(false);			
		}
		if(collision()) {
//			juego.getEnemigo().recibirDiparo();
			juego.getNave().getBalas().remove(this);
			juego.getNave().aumentarPuntos(1);
			juego.remove(label);
			label.setVisible(false);
		}
			y+=ya;
			label.setBounds(x, y, ANCHO, LARGO);
			juego.add(label);
		
	}
	
	/**
	 * este metodo se encarga de verificar si la bala esta colisionando con algun
	 * enemigo de la hilera
	 * @return boolean true si esta colisionando o false si no
	 */
	public boolean collision() {
		if(!juego.getListaEnemigos().isEmpty()) {
			for(int i = 0; i<juego.getListaEnemigos().size();i++) {
				NaveEnemiga temp = juego.getListaEnemigos().get(i);
				if (temp.getBounds().intersects(getBounds())) {
					temp.recibirDiparo();
					sonido.play();
//					if(temp.getVida() <= 0) {
//						juego.getListaEnemigos().remove(i);
//					}
					juego.getNave().getBalas().remove(this);
					juego.getNave().aumentarPuntos(1);
					juego.remove(label);
					label.setVisible(false);
				}
			}
//		}else if(juego.getEnemigo().getBounds().intersects(getBounds())){
//			return true;
		}
		return false;
	}
	
	/**
	 * este metodo se encarga de pintar la bala en la pantalla
	 */
	public void paint() {
		label.setBounds(x, y, ANCHO, LARGO);
		juego.add(label);
	}
	
	/**
	 * debuelve un rectangulo en la misma posicion y de las mismas
	 * dimenciones de la Label de la bala el cual nos sirve para 
	 * verificar las colisiones de la bala
	 * @return Rectangle
	 */
	public Rectangle getBounds() {
		return new Rectangle(x,y,ANCHO,LARGO);
	}
}
