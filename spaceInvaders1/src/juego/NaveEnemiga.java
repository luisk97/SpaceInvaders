package juego;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class NaveEnemiga implements Nave{
	private static final int LARGO = 90;
	private static final int ANCHO = 80;
	private int vida = 5;
	private int x = 50;
	private int y = 0;
	private int xa = 2;
	private int ya = 0;
	private Juego juego;
//	JLabel lblNewLabel = new JLabel("Vida Enemigo: "+ vida);
	int flag = 0;
	private ArrayList<BalaEnemiga> balas;
	private Random disparoAleatorio = new Random();
	private JLabel label = new JLabel(new ImageIcon(
			"C:/Users/luisk.PC-LUISK/Documents/tec/lll Semestre/Datos l/Proyecto#1/Imagenes/naveEnemiga0.png"));
	
	public NaveEnemiga(Juego juego) {
		balas = new ArrayList<BalaEnemiga>();
		this.juego = juego; 
	}
	
	public void move() {
		flag = disparoAleatorio.nextInt(100);
		if(x + xa < 0) {
			xa = -xa;
			y+=ya;
		}
		if(x+xa > juego.getWidth() - ANCHO) {
			xa = -xa;
			y+=ya;
		}
		if(flag == 2)
			disparar();
//		if(y+ya < 0)
//			ya = 2;
//		if(y+ya > juego.getHeight() - LARGO) {
//			ya = -2;
//		}
		if(collision()) {
			juego.gameOver();
		}
		
		x+=xa;
		if(!balas.isEmpty()) {
			for(int i = 0; i<balas.size();i++)
				balas.get(i).move();
		}
	}
	
	public boolean collision() {
		return juego.getNave().getBounds().intersects(getBounds());
	}
	
	public void disparar() {
		balas.add(new BalaEnemiga(juego,x,y));
	}
	
	public void recibirDiparo() {
		vida--;
		System.out.println("Vida enemigo"+vida);
	}
	
	public void paint() {
//		lblNewLabel.setText("Vida Enemigo: "+ vida);
//		lblNewLabel.setBounds(770, 0, 110, 20);
		label.setBounds(x, y, ANCHO, LARGO);
		juego.add(label);
//		juego.add(lblNewLabel);
		if(!balas.isEmpty()) {
			for(int i = 0; i<balas.size();i++)
				balas.get(i).paint();
		}
	}
	
	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public Rectangle getBounds() {
		return new Rectangle(x,y,ANCHO,LARGO);
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getXa() {
		return xa;
	}

	public void setXa(int nivel) {
		if(xa<0) {
			xa = -xa;
			xa += nivel;
		}else {
			xa = xa + nivel;
		} 
	}

	public int getYa() {
		return ya;
	}

	public void setYa(int ya) {
		this.ya = ya;
	}
	
	public ArrayList<BalaEnemiga> getBalas() {
		return balas;
	}
	
	
	
	
	
	
	
//	private int id;
//	private String grado;
//
//	public Enemigo(int id,int grado,int vida) {
//		this.id = id;
//		this.vida = vida;
//		if(grado == 2) {
//			this.grado = "Jefe";
//		}else {
//			this.grado = "Cabo";
//		}
//		System.out.println("Se creo un "+this.grado+" con id: "+id+" y vida: "+vida);
//	}
//
//	public String getGrado() {
//		return grado;
//	}
//	
//	public void setGrado(String grado) {
//		this.grado = grado;
//	}
//	
//	public void recibirDisparo() {
//		vida--;
//	}
//
//	public int getId() {
//		return id;
//	}


}
