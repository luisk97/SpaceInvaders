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

public class Juego extends JPanel{ 
	
//	private NaveEnemiga enemigo = new NaveEnemiga(this,0,1);
	private NaveJugador nave = new NaveJugador(this);
	private boolean enCurso = false;
	private String hileraActual;
	private String hileraSiguiente;
	private HileraPrincipal hilPrin = HileraPrincipal.getInstance();
	private ArrayList<NaveEnemiga> listaEnemigos = new ArrayList<NaveEnemiga>();
	private Facade fachada = new Facade();
	
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
	
	public void move() {
//		if(enemigo.getVida() <= 0) {
//			gameWin();
//		}
//		enemigo.move();
		if(!listaEnemigos.isEmpty()) {
			for(int i = 0; i<listaEnemigos.size();i++) {
				listaEnemigos.get(i).setId(i);
				listaEnemigos.get(i).move();
			}
		}else {
			if(!hilPrin.estaVacia()) {
				InterfaceHilera hileraactual=hilPrin.getCabeza().getHilera();
				Enemigo temp;
				for(int i = 0; i<hileraactual.size(); i++) {
					temp = fachada.obtenerEnemigo(hileraactual, i);
					if(temp.getGrado() == "Jefe") {
						listaEnemigos.add(new NaveEnemiga(this,80*i,2,i));
					}else {
						listaEnemigos.add(new NaveEnemiga(this,80*i,1,i));
					}
				}
			}else {
				gameWin();
			}
		}
		nave.move();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
//		enemigo.paint();
		if(!listaEnemigos.isEmpty()) {
			for(int i = 0; i<listaEnemigos.size();i++)
				listaEnemigos.get(i).paint();
		}
		nave.paint();
	}
	
	public void gameOver() {
		JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
	}
	
	public void gameWin() {
		JOptionPane.showMessageDialog(this, "You Win", "Continue", JOptionPane.QUESTION_MESSAGE);
		System.exit(ABORT);
//		enemigo.setVida(10+(nave.getNivel()*2));
//		enemigo.setY(0);
//		enemigo.setX(30);
////		enemigo.setXa(nave.getNivel());
//		enemigo.setYa(35);
		nave.setVida(10);
		nave.subirNivel();
		for(int i = 0; i<nave.getBalas().size();i++) {
			nave.getBalas().get(i).label.setVisible(false);
		}
		nave.getBalas().clear();
//		for(int i = 0; i<enemigo.getBalas().size();i++) {
//			enemigo.getBalas().get(i).label.setVisible(false);
//		}
//		enemigo.getBalas().clear();
//	}
//	
//	public NaveEnemiga getEnemigo() {
//		return enemigo;
	}

	public NaveJugador getNave() {
		return nave;
	}
	
	
	
	public void iniciarEnemigos() {
		System.out.println("Entramos en iniciarEnemigos()");
		int tipo;
		hilPrin = HileraPrincipal.getInstance();
		System.out.println("Obtuvimos correctamente la instancia de HileraPrincipal");
		Random random = new Random();
		for(int i = 0; i < 5; i++) {
			tipo = random.nextInt(6);
			System.out.println(3);
			hilPrin.add(3);
		}
		System.out.println("Se crearon correctamente todas las Hileras");
		InterfaceHilera hileraactual=hilPrin.getCabeza().getHilera();
		hileraActual = hileraactual.getTipo();
		Enemigo temp;
		for(int i = 0; i<7; i++) {
			temp = fachada.obtenerEnemigo(hileraactual, i);
			if(temp.getGrado() == "Jefe") {
				listaEnemigos.add(new NaveEnemiga(this,80*i,2,i));
			}else {
				listaEnemigos.add(new NaveEnemiga(this,80*i,1,i));
			}
		}
		
	}

	public boolean isEnCurso() {
		return enCurso;
	}

	public void setEnCurso(boolean enCurso) {
		this.enCurso = enCurso;
	}

	public String getHileraActual() {
		return hileraActual;
	}

	public void setHileraActual(String hileraActual) {
		this.hileraActual = hileraActual;
	}

	public String getHileraSiguiente() {
		return hileraSiguiente;
	}

	public void setHileraSiguiente(String hileraSiguiente) {
		this.hileraSiguiente = hileraSiguiente;
	}
	
	public HileraPrincipal getHilPrin() {
		return hilPrin;
	}
	
	public ArrayList<NaveEnemiga> getListaEnemigos() {
		return listaEnemigos;
	}

	public void setListaEnemigos(ArrayList<NaveEnemiga> listaEnemigos) {
		this.listaEnemigos = listaEnemigos;
	}


}
