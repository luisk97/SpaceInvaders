package juego;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BalaEnemiga {
	private static final int LARGO = 30;
	private static final int ANCHO = 20;
	int x;
	int y = 0;
	int ya = 4;
	private Juego juego;
	JLabel label = new JLabel(new ImageIcon(
			"C:/Users/luisk.PC-LUISK/Documents/tec/lll Semestre/Datos l/Proyecto#1/Imagenes/lazer.png"));
	
	
	public BalaEnemiga(Juego juego,int x,int y) {
		this.juego = juego;
		this.x = x+33;
		this.y = y+75;
	}
	
	public void move() {
		if(y+ya > juego.getHeight() - LARGO) {
			juego.getEnemigo().getBalas().remove(this);
			juego.remove(label);
			label.setVisible(false);			
		}
		if(collision()) {
			juego.getNave().recibirDiparo();
			juego.getEnemigo().getBalas().remove(this);
			juego.remove(label);
			label.setVisible(false);
		}
			y+=ya;
			label.setBounds(x, y, ANCHO, LARGO);
			juego.add(label);
		
	}
	
	public boolean collision() {
		return juego.getNave().getBounds().intersects(getBounds());
	}
	
	public void paint() {
		label.setBounds(x, y, ANCHO, LARGO);
		juego.add(label);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,ANCHO,LARGO);
	}
}
