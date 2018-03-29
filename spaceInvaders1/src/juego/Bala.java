package juego;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bala {
	private static final int LARGO = 30;
	private static final int ANCHO = 20;
	int x;
	int y;
	int ya = -6;
	private Juego juego;
	JLabel label = new JLabel(new ImageIcon(
			"C:/Users/luisk.PC-LUISK/Documents/tec/lll Semestre/Datos l/Proyecto#1/Imagenes/bala.png"));
	
	
	public Bala(Juego juego,int x) {
		this.juego = juego;
		this.y = juego.getHeight()-80;
		this.x = x+35;
	}
	
	public void move() {
		if(y+ya < 0) {
			juego.getNave().getBalas().remove(this);
			juego.remove(label);
			label.setVisible(false);			
		}
		if(collision()) {
			juego.getEnemigo().recibirDiparo();
			juego.getNave().getBalas().remove(this);
			juego.getNave().aumentarPuntos(1);
			juego.remove(label);
			label.setVisible(false);
		}
			y+=ya;
			label.setBounds(x, y, ANCHO, LARGO);
			juego.add(label);
		
	}
	
	public boolean collision() {
		return juego.getEnemigo().getBounds().intersects(getBounds());
	}
	
	public void paint() {
		label.setBounds(x, y, ANCHO, LARGO);
		juego.add(label);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,ANCHO,LARGO);
	}
}
