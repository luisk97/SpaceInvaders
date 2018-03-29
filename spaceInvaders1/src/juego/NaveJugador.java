package juego;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class NaveJugador implements Nave{
	private static final int WIDTH = 90;
	private static final int HEIGHT= 80;
	private int vida = 10;
	private int puntos;
	private int x = 0;
	private int xa = 0;
	private ArrayList<Bala> balas;
	private Juego juego;
	private int nivel;

	private JLabel label = new JLabel(new ImageIcon(
			"C:/Users/luisk.PC-LUISK/Documents/tec/lll Semestre/Datos l/Proyecto#1/Imagenes/jugador.png"));
	private JLabel labelFondo = new JLabel(new ImageIcon(
			"C:/Users/luisk.PC-LUISK/Documents/tec/lll Semestre/Datos l/Proyecto#1/Imagenes/Cuasar-Agujero-Negro.png"));
	
	public NaveJugador(Juego juego) {
		balas = new ArrayList<Bala>();
		this.juego = juego;
		this.nivel = 1;
		this.puntos = 0;
	}

	public void move() {
		if(x +xa > 0 && x + xa < juego.getWidth()-WIDTH)
			x+=xa;
		if(!balas.isEmpty()) {
			for(int i = 0; i<balas.size();i++)
				balas.get(i).move();
		}
		if(vida == 0)
			juego.gameOver();
		
	}
	
	public void paint() {
		label.setBounds(x, juego.getHeight()-84, WIDTH, HEIGHT);
		labelFondo.setBounds(0, 0, juego.getWidth(), juego.getHeight());
		juego.add(label);
		if(!balas.isEmpty()) {
			for(int i = 0; i<balas.size();i++)
				balas.get(i).paint();
		}
		juego.add(labelFondo);
	}
	
	public void keyReleased(KeyEvent e) {
		xa=0;
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			xa = -4;
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa = 4;
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			disparar();
			return;
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,juego.getHeight()-84,WIDTH,HEIGHT);
	}
	
	private void disparar() {
		if(balas.isEmpty())
			balas.add(new Bala(juego,x));
	}

	public void recibirDiparo() {
		vida--;
		System.out.println("Mi vida:"+vida);
		
		
	}
	
	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getNivel() {
		return nivel;
	}

	public void subirNivel() {
		nivel++;
	}
	
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	public int getPuntos() {
		return puntos;
	}

	public void aumentarPuntos(int puntos) {
		this.puntos += puntos;
	}
	
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	public ArrayList<Bala> getBalas() {
		return balas;
	}

}
