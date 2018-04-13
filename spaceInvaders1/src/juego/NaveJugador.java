package juego;
import java.applet.AudioClip;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * En esta clase se brinda las coordenadas de la nave del jugador asi como la 
 * imagen asociada a esta ademas asigna la imagen al fondo del JPanel juego
 * @author luisk
 *
 */
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
	private AudioClip sonido = java.applet.Applet.newAudioClip(getClass().getResource("/sonidos/explosionJugador.wav"));
	private AudioClip sonidoDisparo = java.applet.Applet.newAudioClip(getClass().getResource("/sonidos/disparo.wav"));
	private JLabel label = new JLabel(new ImageIcon("src/imagenes/jugador.png"));
	private JLabel labelFondo = new JLabel(new ImageIcon("src/imagenes/Cuasar-Agujero-Negro.png"));
	
	/**
	 * Constructor de la clase
	 * @param juego
	 */
	public NaveJugador(Juego juego) {
		balas = new ArrayList<Bala>();
		this.juego = juego;
		this.nivel = 1;
		this.puntos = 0;
	}

	/**
	 * metodo que se encarga de actualizar las coordenadas de la nave del jugador 
	 * ademas de llamar al metodo move de las balas asociadas a la misma
	 */
	public void move() {
		if(x +xa > 0 && x + xa < juego.getWidth()-WIDTH)
			x+=xa;
		if(!balas.isEmpty()) {
			for(int i = 0; i<balas.size();i++)
				balas.get(i).move();
		}
		if(vida == 0) {
			sonido.play();
			juego.gameOver();
		}
		
	}
	
	/**
	 * Se encarga de pintar la imagen de la nave en las coordenadas correspondientes,
	 * tambien llama al metodo paint de las balas asociadas a la nave del jugador y
	 * añade la imagen del fondo del juego
	 */
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
	
	/**
	 * Este metodo se llama al soltar alguna de las teclas derecha o izquierda para
	 * que la nave no se siga moviendo luego de soltarlas
	 * @param e
	 */
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa=0;
	}
	
	/**
	 * Este metodo se llama al precionar una tecla y mueve la nave o dispara dependiendo
	 * de la tecla que se presiono
	 * @param e
	 */
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			xa = -4;
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa = 4;
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			disparar();
			sonidoDisparo.play();
			return;
		}
	}
	
	/**
	 * Metodo que se llama desde la clase HiloSocket el cual recibe la un string que es a orden 
	 * que se recibio en el socket desde el dispositivo movil
	 * @param orden
	 */
	public void recibeOrden(String orden) {
		if(orden.equals("Derecha")) {
			xa = 4;
		}else if(orden.equals("Izquierda")) {
			xa = -4;
		}else if(orden.equals("Disparar")) {
			disparar();
		}else {
			
		}
	}
	
	/**
	 * debuelve un rectangulo en la misma posicion y de las mismas
	 * dimenciones de la Label de la nave del jugador el cual nos 
	 * sirve para verificar las colisiones de esta
	 * @return Rectangle
	 */
	public Rectangle getBounds() {
		return new Rectangle(x,juego.getHeight()-84,WIDTH,HEIGHT);
	}
	
	/**
	 * metodo que añade Instancias de la clase Bala al arrayList de balas asociado
	 * a la nave del jugador
	 */
	private void disparar() {
		if(balas.isEmpty())
			balas.add(new Bala(juego,x));
	}

	/**
	 * metodo que baja el atributo vida de la nave del jugador
	 */
	public void recibirDiparo() {
		vida--;
		System.out.println("Mi vida:"+vida);
	}
	
	/**
	 * metodo quenos retorna la cantidad de vida que tiene el jugador
	 * @return int vida
	 */
	public int getVida() {
		return vida;
	}

	/**
	 * metodo que nos permite modificar la vida del jugador
	 * @param vida
	 */
	public void setVida(int vida) {
		this.vida = vida;
	}
	
//	public int getX() {
//		return x;
//	}

	/**
	 * metodo que nos permite modificar la posicion en el eje x de la nave
	 * del jugador
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * retorna el nivel actual del jugador
	 * @return int nivel
	 */
	public int getNivel() {
		return nivel;
	}

	/**
	 * aumenta el atributo nivel
	 */
	public void subirNivel() {
		nivel++;
	}
	
	/**
	 * Permite modificar el atributo nivel
	 * @param nivel
	 */
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	/**
	 * retorna la cantidad de puntos que tiene el jugador
	 * @return int puntos
	 */
	public int getPuntos() {
		return puntos;
	}

	/**
	 * nos permite incrementar el atributo puntos
	 * @param puntos
	 */
	public void aumentarPuntos(int puntos) {
		this.puntos += puntos;
	}
	
	/**
	 * nos permite modificar el atributo puntos
	 * @param puntos
	 */
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	/**
	 * devuelve el arrayList de balas asociado a la nave del jugador
	 * @return ArrayList<Bala> balas
	 */
	public ArrayList<Bala> getBalas() {
		return balas;
	}

}
