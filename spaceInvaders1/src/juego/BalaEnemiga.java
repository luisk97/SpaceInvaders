package juego;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Esta clase nos brinda las coordenadas de la bala enemiga y la imagen de la misma
 * @author luisk
 *
 */
public class BalaEnemiga {
	private static final int LARGO = 30;
	private static final int ANCHO = 20;
	private int x;
	private int y = 0;
	private int ya = 4;
	private Juego juego;
	JLabel label = new JLabel(new ImageIcon(
			"C:/Users/luisk.PC-LUISK/Documents/tec/lll Semestre/Datos l/Proyecto#1/Imagenes/lazer.png"));
	
	/**
	 * metodo constructor
	 * @param juego
	 * @param x
	 * @param y
	 */
	public BalaEnemiga(Juego juego,int x,int y) {
		this.juego = juego;
		this.x = x+33;
		this.y = y+75;
	}
	
	/**
	 * se encarga de actualizar las coordenadas de la bala
	 */
	public void move() {
		if(y+ya > juego.getHeight() - LARGO) {
//			juego.getEnemigo().getBalas().remove(this);
			juego.remove(label);
			label.setVisible(false);			
		}
		if(collision()) {
//			juego.getEnemigo().getBalas().remove(this);
			label.setVisible(false);
			juego.remove(label);
			juego.getNave().recibirDiparo();
			y = 0;
			ya = 0;
		}
			y+=ya;
			label.setBounds(x, y, ANCHO, LARGO);
			juego.add(label);
		
	}
	
	/**
	 * Verifica si la bala esta colisionando con la nave del jugador
	 * @return boolean true o false
	 */
	public boolean collision() {
		return juego.getNave().getBounds().intersects(getBounds());
	}
	
	/**
	 * Este metodo se encarga de pintar la bala en pantalla con sus
	 * nuevas coordenadas
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
