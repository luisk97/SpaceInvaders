package juego;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Juego extends JPanel{ 
	
	private NaveEnemiga enemigo = new NaveEnemiga(this);
	private NaveJugador nave = new NaveJugador(this);
	private boolean enCurso = false;
	
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
		if(enemigo.getVida() <= 0) {
			gameWin();
		}
		enemigo.move();
		nave.move();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		enemigo.paint();
		nave.paint();
	}
	
	public void gameOver() {
		JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
	}
	
	public void gameWin() {
		JOptionPane.showMessageDialog(this, "You Win", "Continue", JOptionPane.QUESTION_MESSAGE);
		enemigo.setVida(10+(nave.getNivel()*2));
		enemigo.setY(0);
		enemigo.setX(30);
//		enemigo.setXa(nave.getNivel());
		enemigo.setYa(35);
		nave.setVida(10);
		nave.subirNivel();
		for(int i = 0; i<nave.getBalas().size();i++) {
			nave.getBalas().get(i).label.setVisible(false);
		}
		nave.getBalas().clear();
		for(int i = 0; i<enemigo.getBalas().size();i++) {
			enemigo.getBalas().get(i).label.setVisible(false);
		}
		enemigo.getBalas().clear();
	}
	
	public NaveEnemiga getEnemigo() {
		return enemigo;
	}

	public NaveJugador getNave() {
		return nave;
	}

	public boolean isEnCurso() {
		return enCurso;
	}

	public void setEnCurso(boolean enCurso) {
		this.enCurso = enCurso;
	}


}
