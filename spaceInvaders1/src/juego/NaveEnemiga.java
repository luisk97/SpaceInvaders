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

public class NaveEnemiga implements Nave{
	private static final int LARGO = 90;
	private static final int ANCHO = 80;
	private int vida = 5;
	private String grado;
	private int id;
	private int x = 50;
	private int y = 0;
	private int xa = 2;
	private int ya = 0;
	private Juego juego;
//	JLabel lblNewLabel = new JLabel("Vida Enemigo: "+ vida);
	int flag = 0;
	private ArrayList<BalaEnemiga> balas;
	private Random disparoAleatorio = new Random();
	private JLabel label;
	
	public NaveEnemiga(Juego juego ,int x,int grado,int id) {
		this.id = id;
		this.x = x;
		balas = new ArrayList<BalaEnemiga>();
		this.juego = juego;
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
	}

	public void move() {
		flag = disparoAleatorio.nextInt(500);
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
		if(juego.getNave().getBounds().intersects(getBounds())) {
			juego.getNave().setVida(0);
			return true;
		}
		return false;
	}
	
	public void disparar() {
		balas.add(new BalaEnemiga(juego,x,y));
	}
	
	// Aqui esta la clave pero no se bien como hacerlo xd
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
							nuevoJefe = disparoAleatorio.nextInt(juego.getListaEnemigos().size());
							juego.getListaEnemigos().get(nuevoJefe).grado = "Jefe";
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
			}
		}
		System.out.println("Vida enemigo "+vida);
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
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
