package juego;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import estructura.Enemigo;
import estructura.Facade;
import estructura.HileraPrincipal;
import estructura.InterfaceHilera;

/**
 * Esta clase es un JPanel el cual contiene los graficos de las 
 * naves y balas que tendran una animacion en el juego, este se 
 * visualizara cada vez que se inicie una partida
 * @author luisk
 *
 */
public class Juego extends JPanel{ 
	
//	private NaveEnemiga enemigo = new NaveEnemiga(this,0,1);
	private VentanaJuego ventana;
	private NaveJugador nave = new NaveJugador(this);
	private boolean enCurso = false;
	private String hileraActual;
	private String hileraSiguiente;
	private HileraPrincipal hilPrin = HileraPrincipal.getInstance();
	private ArrayList<NaveEnemiga> listaEnemigos = new ArrayList<NaveEnemiga>();
	private Facade fachada = new Facade();
	private Random random = new Random();
	private int nivelMaximo = 6;
	
	
	/**
	 * metodo constructor el cual inicia un Listener del teclado para 
	 * manejar la nave mediante el teclado
	 */
	public Juego() {
		addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				nave.keyPressed(e);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				nave.keyReleased(e);
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		setFocusable(true);
	}
	
	/**
	 * metodo que se encarga de llamar a todos los metodos move de las 
	 * diferentes instancias que se encuentren en tiempo de ejecucion 
	 * ademas se encarga de ir actualizando la hilera actual de enemigos
	 */
	public void move() {
//		if(enemigo.getVida() <= 0) {
//			gameWin();
//		}
//		enemigo.move();
		if(!listaEnemigos.isEmpty()) {
			for(int i = 0,iInvers = listaEnemigos.size()-1; i<listaEnemigos.size();i++,iInvers--) {
				listaEnemigos.get(i).setId(i);
				listaEnemigos.get(i).setIdInvers(iInvers);
				listaEnemigos.get(i).move();
			}
		}else {
			if(!hilPrin.estaVacia()) {
				hilPrin.eliminar(0);
				subirNivel();
				if(!hilPrin.estaVacia()) {
					InterfaceHilera hileraactual=hilPrin.getCabeza().getHilera();
					hileraActual = hileraactual.getTipo();
					Enemigo temp;
					for(int i = 0,iInvers = hileraactual.size()-1; i<hileraactual.size(); i++,iInvers--) {
						temp = fachada.obtenerEnemigo(hileraactual, i);
						if(temp.getGrado() == "Jefe") {
							listaEnemigos.add(new NaveEnemiga(this,80*i,2,i,iInvers,7));
						}else {
							listaEnemigos.add(new NaveEnemiga(this,80*i,1,i,iInvers,temp.getVida()));
						}
					}
					for(int i = 0,iInvers = listaEnemigos.size()-1; i<listaEnemigos.size();i++,iInvers--) {
						listaEnemigos.get(i).setId(i);
						listaEnemigos.get(i).setIdInvers(iInvers);
						listaEnemigos.get(i).move();
					}
				}
			}else {
				gameWin();
			}
		}
		nave.move();
	}
	
	/**
	 * se encarga de llamar los metodos paint de todas las instancias en 
	 * tiempo de ejecucion
	 */
	public void paint(Graphics g) {
		super.paint(g);
//		enemigo.paint();
		if(!listaEnemigos.isEmpty()) {
			for(int i = 0; i<listaEnemigos.size();i++)
				listaEnemigos.get(i).paint();
		}
		nave.paint();
	}
	
	/**
	 * Despliega una ventana con un mensaje de juego perdido
	 */
	public void gameOver() {
		JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
	}
	
	/**
	 * Despliega una ventana con un mensaje de Nivel Ganado y se encarga de actualizar
	 * los atributos de la nave del jugador
	 */
	public void subirNivel() {
		JOptionPane.showMessageDialog(this, "Ganaste el nivel "+nave.getNivel(), "Continue", JOptionPane.QUESTION_MESSAGE);
		nave.setVida(10);
		nave.subirNivel();
		for(int i = 0; i<nave.getBalas().size();i++) {
			nave.getBalas().get(i).label.setVisible(false);
		}
		nave.getBalas().clear();
	}
	
	
	/**
	 * Despliega una ventana con el mensaje de Juego Ganado quita de la pantalla 
	 * las balas de la nave del jugador
	 */
	public void gameWin() {
		JOptionPane.showMessageDialog(this, "You Win", "Continue", JOptionPane.QUESTION_MESSAGE);
		
//		System.exit(ABORT);
//		enemigo.setVida(10+(nave.getNivel()*2));
//		enemigo.setY(0);
//		enemigo.setX(30);
////		enemigo.setXa(nave.getNivel());
//		enemigo.setYa(35);
		for(int i = 0; i<nave.getBalas().size();i++) {
			nave.getBalas().get(i).label.setVisible(false);
		}
		nave.getBalas().clear();
//		this.setVisible(false);
//		enCurso = false;
//		for(int i = 0; i<enemigo.getBalas().size();i++) {
//			enemigo.getBalas().get(i).label.setVisible(false);
//		}
//		enemigo.getBalas().clear();
//	}
//	
//	public NaveEnemiga getEnemigo() {
//		return enemigo;
	}

	/**
	 * retorna la nave la instancia de la nave del jugador
	 * @return NaveJugador nave
	 */
	public NaveJugador getNave() {
		return nave;
	}
	
	
	/**
	 * este metodo se encarga de inicializar las hileras creando instancias 
	 * aleatoriamente de los diferentes tipos de hileras y añadiendolas a la 
	 * hilera principal del juego, ademas de inicializar el arrayList de naves 
	 * enemigas graficas con los enemigos segun corresponda con lo asignado en
	 * la estructura de datos
	 */
	public void iniciarEnemigos() {
		System.out.println("Entramos en iniciarEnemigos()");
		int tipo;
		hilPrin = HileraPrincipal.getInstance();
		System.out.println("Obtuvimos correctamente la instancia de HileraPrincipal");
		for(int i = 0; i < nivelMaximo; i++) {
			tipo = random.nextInt(6);
			System.out.println(tipo);
			hilPrin.add(tipo);
		}
		System.out.println("Se crearon correctamente todas las Hileras");
		InterfaceHilera hileraactual=hilPrin.getCabeza().getHilera();
		hileraActual = hileraactual.getTipo();
		Enemigo temp;
		for(int i = 0,iInvers = 6; i<7; i++,iInvers--) {
			temp = fachada.obtenerEnemigo(hileraactual, i);
			if(temp.getGrado() == "Jefe") {
				listaEnemigos.add(new NaveEnemiga(this,80*i,2,i,iInvers,7));
			}else {
				listaEnemigos.add(new NaveEnemiga(this,80*i,1,i,iInvers,temp.getVida()));
			}
		}
		
	}

	/**
	 * Retorna el atributo enCurso
	 * @return boolean enCurso
	 */
	public boolean isEnCurso() {
		return enCurso;
	}

	/**
	 * Metodo que modifica el valor de la varaible enCurso
	 * @param enCurso
	 */
	public void setEnCurso(boolean enCurso) {
		this.enCurso = enCurso;
	}

	/**
	 * metodo que nos retorna la clase de la hilera que esta actualmente en la partida
	 * @return String hileraActual
	 */
	public String getHileraActual() {
		return hileraActual;
	}

//	public void setHileraActual(String hileraActual) {
//		this.hileraActual = hileraActual;
//	}

	/**
	 * Nos retorna el tipo la hilera que sigue despues de derrotar a la actual
	 * @return String hileraSiguiente
	 */
	public String getHileraSiguiente() {
		return hileraSiguiente;
	}

//	public void setHileraSiguiente(String hileraSiguiente) {
//		this.hileraSiguiente = hileraSiguiente;
//	}
	
	/**
	 * nos retorna la instancia de la hilera principal del juego la cual 
	 * contiene todas las hilera que enfrentaremos
	 * @return HileraPrincipal hilPrin
	 */
	public HileraPrincipal getHilPrin() {
		return hilPrin;
	}
	
	/**
	 * Retorna el arrayList que contiene las naves enemigas en Partida
	 * @return ArrayList<NaveEnemiga> listaEnemigos
	 */
	public ArrayList<NaveEnemiga> getListaEnemigos() {
		return listaEnemigos;
	}

//	public void setListaEnemigos(ArrayList<NaveEnemiga> listaEnemigos) {
//		this.listaEnemigos = listaEnemigos;
//	}

	/**
	 * retorna el nivel maximo al cual queremos llegar
	 * @return int nivelMaximo
	 */
	public int getNivelMaximo() {
		return nivelMaximo;
	}

//	public void setNivelMaximo(int nivelMaximo) {
//		this.nivelMaximo = nivelMaximo;
//	}
	
	/**
	 * Verifica si estamos en el nivel maximo
	 * @return boolean true o false
	 */
	public boolean enNivelMaximo() {
		return nave.getNivel() >= nivelMaximo;
	}


}
