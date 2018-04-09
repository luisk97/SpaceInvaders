package juego;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import estructura.Enemigo;
import estructura.Facade;
import estructura.Hilera;
import estructura.HileraA;
import estructura.HileraB;
import estructura.HileraC;
import estructura.HileraD;
import estructura.HileraE;

/**
 * Esta clase se encarga de brindarnos las coordenadas de la nave enemiga 
 * asi como su respectiva imagen dependiendo el tipo de enemigo que sea
 * @author luisk
 *
 */
public class NaveEnemiga implements Nave{
	private static final int LARGO = 90;
	private static final int ANCHO = 80;
	private int vida = 0;
	private String grado;
	private int id;
	private int x = 50;
	private int y = 0;
	private int xa;
	private int ya = 20;
	private Juego juego;
//	JLabel lblNewLabel = new JLabel("Vida Enemigo: "+ vida);
	int flag = 0;
	private ArrayList<BalaEnemiga> balas;
	private Random random = new Random();
	private JLabel label;

	/**
	 * Metodo constructor de la nave enemiga
	 * @param juego
	 * @param x
	 * @param grado
	 * @param id
	 * @param vida
	 */
	public NaveEnemiga(Juego juego ,int x,int grado,int id,int vida) {
		this.id = id;
		this.x = x;
		balas = new ArrayList<BalaEnemiga>();
		this.juego = juego;
		this.vida = vida;
		if(grado == 2) {
			label = new JLabel(new ImageIcon(
					"C:/Users/luisk.PC-LUISK/Documents/tec/lll Semestre/Datos l/Proyecto#1/Imagenes/jefe.png"));
			this.grado = "Jefe";
			System.out.println("Se creo un jefe grafico");
		}else {
			label = new JLabel(new ImageIcon(
					"C:/Users/luisk.PC-LUISK/Documents/tec/lll Semestre/Datos l/Proyecto#1/Imagenes/cabo.png"));
			this.grado = "Cabo";
			System.out.println("Se creo un cabo grafico");
		}
		if(juego.getNave().getNivel() > 2 && juego.getNave().getNivel() < 5) {
			xa = 3;
		}else if(juego.getNave().getNivel() > 4 && juego.getNave().getNivel() < 6){
			xa = 4;
		}else if(juego.getNave().getNivel() > 5) {
			xa = 5;
		}else {
			xa = 2;
		}
	}

	/**
	 * Este metodo se encarga de la posicion en pantalla de la nave enemiga y llama 
	 * el metodo move de las balas contenidas en el ArrayList asociado a cada nave,
	 * tambien asigna velocidad dependiendo el nivel, ademas verifica si la hilera 
	 * es de clase B para realizar la animacion del cambio de posicion del jefe
	 */
	public void move() {
		flag = random.nextInt(500);
		if(juego.getNave().getNivel() > 2 && juego.getNave().getNivel() < 5) {
			if(x + xa < 0) {
				xa = 3;
				y+=ya;
			}
			if(x+xa > juego.getWidth() - ANCHO) {
				xa = -3;
				y+=ya;
			}
		}else if(juego.getNave().getNivel() > 4 && juego.getNave().getNivel() < 6){
			if(x + xa < 0) {
				xa = 4;
				y+=ya;
			}
			if(x+xa > juego.getWidth() - ANCHO) {
				xa = -4;
				y+=ya;
			}
		}else if(juego.getNave().getNivel() > 5) {
			if(x + xa < 0) {
				xa = 5;
				y+=ya;
			}
			if(x+xa > juego.getWidth() - ANCHO) {
				xa = -5;
				y+=ya;
			}
			flag = random.nextInt(300);
		}else {
			if(x + xa < 0) {
				xa = 2;
				y+=ya;
			}
			if(x+xa > juego.getWidth() - ANCHO) {
				xa = -2;
				y+=ya;
			}
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
		if(juego.getHilPrin().getCabeza().getHilera().getTipo() == "ClaseB") {
			int cambio = random.nextInt(500);
			int nuevoJefe = random.nextInt(juego.getListaEnemigos().size());
			NaveEnemiga tempNav;
			if(cambio == 1) {
				for(int i = 0; i<juego.getListaEnemigos().size();i++) {
					tempNav = juego.getListaEnemigos().get(i);
					if(tempNav.getGrado().equals("Jefe")) {
						tempNav.setGrado("Cabo");
						tempNav.setVida(3);
						tempNav.getLabel().setVisible(false);
						tempNav.setLabel(new JLabel(new ImageIcon(
						"C:/Users/luisk.PC-LUISK/Documents/tec/lll Semestre/Datos l/Proyecto#1/Imagenes/cabo.png")));
					}
				}
				juego.getListaEnemigos().get(nuevoJefe).setGrado("Jefe");
				juego.getListaEnemigos().get(nuevoJefe).setVida(7);
				juego.getListaEnemigos().get(nuevoJefe).getLabel().setVisible(false);
				juego.getListaEnemigos().get(nuevoJefe).setLabel(new JLabel(new ImageIcon(
						"C:/Users/luisk.PC-LUISK/Documents/tec/lll Semestre/Datos l/Proyecto#1/Imagenes/jefe.png")));
				Enemigo temp;
				Facade fachada = new Facade();
				if(juego.getHilPrin().getCabeza().getHilera().size() != 0) {
					temp = fachada.obtenerEnemigo(juego.getHilPrin().getCabeza().getHilera(), nuevoJefe);
					temp.setGrado("Jefe");
				}
			}
		}
	}
	
	/**
	 * verifica si la nave enemiga esta colisionando con la nave del jugador
	 * @return boolean true o false
	 */
	public boolean collision() {
		if(juego.getNave().getBounds().intersects(getBounds())) {
			juego.getNave().setVida(0);
			return true;
		}
		return false;
	}
	
	/**
	 * se encarga de a�adir instancias de la clase BalaEnemiga en el atributo
	 * balas de tipo ArrayList asociado a cada nave enemiga
	 */
	public void disparar() {
		balas.add(new BalaEnemiga(juego,x,y));
	}
	
	// Aqui se decide bastante
	/**
	 * Este metodo se encarga de bajar la vida de la nave enemiga tras verificar
	 * si esta colisionando con una bala del jugador, ademas se encarga de 
	 * verificar el tipo de hilera a la cual pertenece la nave enemiga para 
	 * en caso de muerte realizarla segun corresponda
	 */
	public void recibirDiparo() {
		vida--;
		if(vida <= 0) {
			if(!balas.isEmpty()){
				for(int i = 0; i<balas.size(); i++){
					balas.get(i).label.setVisible(false);
				}
				balas.clear();
			}
			if(juego.getHilPrin().getCabeza().getHilera() instanceof Hilera) {
				System.out.println("Enemigo grafico tipo "+grado+" con id:"+id+" eliminado");
				label.setVisible(false);
				juego.remove(label);
				juego.getListaEnemigos().remove(this);
				juego.getHilPrin().getCabeza().getHilera().eliminar(id);
			}else if(juego.getHilPrin().getCabeza().getHilera() instanceof HileraA) {
				if(!juego.getListaEnemigos().isEmpty()){	
					if(grado == "Jefe") {
						for(int i = 0; i<juego.getListaEnemigos().size(); i++){
							juego.getListaEnemigos().get(i).label.setVisible(false);
						}
						juego.getListaEnemigos().clear();
						juego.getHilPrin().getCabeza().getHilera().eliminar(id);
						System.out.println("Enemigo grafico tipo "+grado+" con id:"+id+" eliminado");
						System.out.println("Como es TipoA se elimino toda la hilera");
					}else {
						System.out.println("Enemigo grafico tipo "+grado+" con id:"+id+" eliminado");
						label.setVisible(false);
						juego.remove(label);
						juego.getListaEnemigos().remove(this);
						juego.getHilPrin().getCabeza().getHilera().eliminar(id);
					}
				}
			}else if(juego.getHilPrin().getCabeza().getHilera() instanceof HileraB) {
				if(!juego.getListaEnemigos().isEmpty()){
					if(grado == "Jefe") {
						for(int i = 0; i<juego.getListaEnemigos().size(); i++){
							juego.getListaEnemigos().get(i).label.setVisible(false);
						}
						juego.getListaEnemigos().clear();
						juego.getHilPrin().getCabeza().getHilera().eliminar(id);
						System.out.println("Enemigo grafico tipo "+grado+" con id:"+id+" eliminado");
						System.out.println("Como es TipoB se elimino toda la hilera");
					}else {
						System.out.println("Enemigo grafico tipo "+grado+" con id:"+id+" eliminado");
						label.setVisible(false);
						juego.remove(label);
						juego.getListaEnemigos().remove(this);
						juego.getHilPrin().getCabeza().getHilera().eliminar(id);
					}
				}
			}else if(juego.getHilPrin().getCabeza().getHilera() instanceof HileraC) {
				if(!juego.getListaEnemigos().isEmpty()){
					if(grado == "Jefe") {
						int nuevoJefe;
						Facade fachada = new Facade();
						Enemigo temp;
						label.setVisible(false);
						juego.remove(label);
						juego.getListaEnemigos().remove(this);
						juego.getHilPrin().getCabeza().getHilera().eliminar(id);
						if(juego.getListaEnemigos().size() != 0) {
							nuevoJefe = random.nextInt(juego.getListaEnemigos().size());
							juego.getListaEnemigos().get(nuevoJefe).grado = "Jefe";
							juego.getListaEnemigos().get(nuevoJefe).vida = 7;
							juego.getListaEnemigos().get(nuevoJefe).label.setVisible(false);
							juego.getListaEnemigos().get(nuevoJefe).label = new JLabel(new ImageIcon(
										"C:/Users/luisk.PC-LUISK/Documents/tec/lll Semestre/Datos l/Proyecto#1/Imagenes/jefe.png"));
							if(juego.getHilPrin().getCabeza().getHilera().size() != 0) {
								temp = fachada.obtenerEnemigo(juego.getHilPrin().getCabeza().getHilera(), nuevoJefe);
								temp.setGrado(grado);
							}
							System.out.println("Enemigo grafico tipo "+grado+" con id:"+id+" eliminado");
							System.out.println("Como es TipoC se eligio otro Jefe");
						}
					}else {
						System.out.println("Enemigo grafico tipo "+grado+" con id:"+id+" eliminado");
						label.setVisible(false);
						juego.remove(label);
						juego.getListaEnemigos().remove(this);
						juego.getHilPrin().getCabeza().getHilera().eliminar(id);
					}
				}
			}else if(juego.getHilPrin().getCabeza().getHilera() instanceof HileraD) {
				if(!juego.getListaEnemigos().isEmpty()){
					if(grado == "Jefe") {
						Facade fachada = new Facade();
						Enemigo temp;
						label.setVisible(false);
						juego.remove(label);
						juego.getListaEnemigos().remove(this);
						juego.getHilPrin().getCabeza().getHilera().eliminar(id);
						if(juego.getListaEnemigos().size() != 0) {
							juego.getListaEnemigos().get(id).grado = "Jefe";
							juego.getListaEnemigos().get(id).vida = 7;
							juego.getListaEnemigos().get(id).label.setVisible(false);
							juego.getListaEnemigos().get(id).label = new JLabel(new ImageIcon(
										"C:/Users/luisk.PC-LUISK/Documents/tec/lll Semestre/Datos l/Proyecto#1/Imagenes/jefe.png"));
							if(juego.getHilPrin().getCabeza().getHilera().size() != 0) {
								temp = fachada.obtenerEnemigo(juego.getHilPrin().getCabeza().getHilera(), id);
								temp.setGrado(grado);
							}
							System.out.println("Enemigo grafico tipo "+grado+" con id:"+id+" eliminado");
							System.out.println("Como es TipoD se eligio otro Jefe");
						}
					}else {
						System.out.println("Enemigo grafico tipo "+grado+" con id:"+id+" eliminado");
						label.setVisible(false);
						juego.remove(label);
						juego.getListaEnemigos().remove(this);
						juego.getHilPrin().getCabeza().getHilera().eliminar(id);
					}
				}
			}else if(juego.getHilPrin().getCabeza().getHilera() instanceof HileraE) {
				System.out.println("Enemigo grafico tipo "+grado+" con id:"+id+" eliminado");
				label.setVisible(false);
				juego.remove(label);
				juego.getListaEnemigos().remove(this);
				juego.getHilPrin().getCabeza().getHilera().eliminar(id);
			}
		}
		System.out.println("Vida enemigo "+vida);
	}
	
	/**
	 * Se enarga de pintar la nave en pantalla con las coordenadas que corespondan
	 * asi como llamar el metodo paint de las balas asociadas a la nave enemiga
	 */
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
	
	
//	public int getVida() {
//		return vida;
//	}

	/**
	 * nos permite modificar el atributo vida
	 * @param vida
	 */
	public void setVida(int vida) {
		this.vida = vida;
	}

	/**
	 * debuelve un rectangulo en la misma posicion y de las mismas
	 * dimenciones de la Label de la nave enemiga el cual nos sirve para 
	 * verificar las colisiones de esta
	 * @return Rectangle
	 */
	public Rectangle getBounds() {
		return new Rectangle(x,y,ANCHO,LARGO);
	}
	
//	public int getX() {
//		return x;
//	}

//	public void setX(int x) {
//		this.x = x;
//	}

//	public int getY() {
//		return y;
//	}

//	public void setY(int y) {
//		this.y = y;
//	}

//	public int getXa() {
//		return xa;
//	}

//	public void setXa(int nivel) {
//		if(xa<0) {
//			xa = -xa;
//			xa += nivel;
//		}else {
//			xa = xa + nivel;
//		} 
//	}

//	public int getYa() {
//		return ya;
//	}
//
//	public void setYa(int ya) {
//		this.ya = ya;
//	}
	

//	public int getId() {
//		return id;
//	}

	/**
	 * metodo que nos permite asignar un id a la nave el cual nos funciona para poder 
	 * saber cual eliminar en la hilera de la estructura de datos
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * metodo que nos retorna el atributo grado
	 * @return String grado
	 */
	public String getGrado() {
		return grado;
	}

	/**
	 * metodo que nos permite modificar el atributo grado
	 * @param grado
	 */
	public void setGrado(String grado) {
		this.grado = grado;
	}
	
	/**
	 * Nos retorna la imagen asociada a la nave
	 * @return JLabel label
	 */
	public JLabel getLabel() {
		return label;
	}

	/**
	 * nos permite midificar el atributo label
	 * @param label
	 */
	public void setLabel(JLabel label) {
		this.label = label;
	}
	
	/**
	 * Retorna el arrayList de balas asociado a la nave enemiga
	 * @return ArrayList<BalaEnemiga> balas
	 */
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
