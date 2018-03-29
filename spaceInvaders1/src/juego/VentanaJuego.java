package juego;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.BevelBorder;

public class VentanaJuego extends JFrame{
	
	private Juego juego;
	private JPanel panelInicio;
	private JPanel panelPausa;
	private JLabel lblFondoTotal;
	private JButton btnPausa;
	private JLabel lblSiguienteHilera;
	private JLabel lblHileraActual;
	private JLabel lblPuntos;
	private JLabel lblNivel;
	private JLabel lblVida;

	/**
	 * Create the frame.
	 * @throws InterruptedException 
	 */
	private void initialize() throws InterruptedException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 580);
		setTitle("Space Invaders");
		getContentPane().setLayout(null);
 		
 		JButton btnSalir = new JButton("Salir");
 		btnSalir.setBounds(780, 10, 89, 23);
 		getContentPane().add(btnSalir);
 		btnSalir.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent arg0) {
 				System.exit(ABORT);
 			}
 		});
 		
 		panelInicio = new JPanel();
 		panelInicio.setBounds(0, 0, 884, 541);
 		getContentPane().add(panelInicio);
 		panelInicio.setLayout(null);
 		
 		JButton btnStart = new JButton(new ImageIcon("C:/Users/luisk.PC-LUISK/Documents/tec/lll Semestre/Datos l/Proyecto#1/Imagenes/btnPlay.png"));
 		btnStart.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				juego.setVisible(true);
 				juego.setEnCurso(true);
 				panelInicio.setVisible(false);
 				btnPausa.setVisible(true);
 				juego.getNave().setVida(10);
 				juego.getNave().setX(350);
 				juego.getNave().setPuntos(0);
 				juego.getNave().setNivel(1);
 				juego.getEnemigo().setVida(5);
 				juego.getEnemigo().setY(0);
 				juego.getEnemigo().setX(0);
 				juego.getEnemigo().setYa(0);
 				
 			}
 		});
 		btnStart.setBounds(308, 216, 245, 100);
 		panelInicio.add(btnStart);
 		
 		JLabel lblNewLabel = new JLabel(new ImageIcon("C:/Users/luisk.PC-LUISK/Documents/tec/lll Semestre/Datos l/Proyecto#1/Imagenes/imagenFondo5.jpg"));
 		lblNewLabel.setBounds(0, 0, 884, 541);
 		panelInicio.add(lblNewLabel);
 		
 		panelPausa = new JPanel();
 		panelPausa.setBackground(new Color(0, 128, 128));
 		panelPausa.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
 		panelPausa.setBounds(207, 113, 469, 358);
 		getContentPane().add(panelPausa);
 		panelPausa.setLayout(null);
 		panelPausa.setVisible(false);
 		
 		JButton btnContinuar = new JButton(new ImageIcon("C:/Users/luisk.PC-LUISK/Documents/tec/lll Semestre/Datos l/Proyecto#1/Imagenes/btnContinuar.png"));
 		btnContinuar.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				juego.setVisible(true);
 				juego.setEnCurso(true);
 				panelPausa.setVisible(false);
 				btnPausa.setVisible(true);
 			}
 		});
 		btnContinuar.setBackground(new Color(0, 128, 128));
 		btnContinuar.setForeground(new Color(135, 206, 235));
 		btnContinuar.setFont(new Font("SimSun", Font.PLAIN, 30));
 		btnContinuar.setBounds(155, 259, 159, 47);
 		panelPausa.add(btnContinuar);
 		
 		JLabel lblPausa = new JLabel(new ImageIcon("C:/Users/luisk.PC-LUISK/Documents/tec/lll Semestre/Datos l/Proyecto#1/Imagenes/pausa.png"));
 		lblPausa.setBounds(102, 30, 279, 96);
 		panelPausa.add(lblPausa);
 		
 		JButton btnInicio = new JButton(new ImageIcon("C:/Users/luisk.PC-LUISK/Documents/tec/lll Semestre/Datos l/Proyecto#1/Imagenes/botonInicio.png"));
 		btnInicio.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				juego.setVisible(false);
 				juego.setEnCurso(false);
 				panelInicio.setVisible(true);
 				panelPausa.setVisible(false);
 				btnPausa.setVisible(false);
 			}
 		});
 		btnInicio.setBackground(new Color(0, 128, 128));
 		btnInicio.setBounds(177, 183, 116, 41);
 		panelPausa.add(btnInicio);
 		
 		JLabel lblFondoPausa = new JLabel(new ImageIcon("C:/Users/luisk.PC-LUISK/Documents/tec/lll Semestre/Datos l/Proyecto#1/Imagenes/fondoPausaDef.png"));
 		lblFondoPausa.setBounds(0, 0, 469, 358);
 		panelPausa.add(lblFondoPausa);
		//		juego = new Juego();
		//		getContentPane().add(juego);
		//		panel = new JPanel();
		//		getContentPane().add(panel);
		//		panel.setLayout(null);
		//		JLabel lblNewLabel = new JLabel("New label");
		//		lblNewLabel.setBounds(434, 220, 46, 14);
		//		panel.add(lblNewLabel);
		//		panel.setVisible(false);
 		juego = new Juego();
		juego.setBounds(0, 42, 884, 499);
		getContentPane().add(juego);
		btnPausa = new JButton("Pausa");
		btnPausa.setBounds(672, 10, 89, 23);
		getContentPane().add(btnPausa);
		btnPausa.setVisible(false);
		btnPausa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(juego.isEnCurso()) {
					juego.setEnCurso(false);
					juego.setVisible(false);
					panelPausa.setVisible(true);
					btnPausa.setVisible(false);
				}else {
					juego.setEnCurso(true);
					juego.setVisible(true);
					panelInicio.setVisible(false);
				}
			}
		});
		
		lblVida = new JLabel("Vida:");
		lblVida.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVida.setForeground(new Color(255, 255, 255));
		lblVida.setBounds(10, 10, 60, 23);
		getContentPane().add(lblVida);
		
		lblNivel = new JLabel("Nivel:");
		lblNivel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNivel.setForeground(new Color(255, 255, 255));
		lblNivel.setBounds(72, 10, 92, 23);
		getContentPane().add(lblNivel);
		
		lblHileraActual = new JLabel("Hilera Actual:");
		lblHileraActual.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHileraActual.setForeground(new Color(255, 255, 255));
		lblHileraActual.setBounds(165, 10, 160, 23);
		getContentPane().add(lblHileraActual);
		
		lblSiguienteHilera = new JLabel("Siguiente:");
		lblSiguienteHilera.setForeground(new Color(255, 255, 255));
		lblSiguienteHilera.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSiguienteHilera.setBounds(330, 10, 113, 23);
		getContentPane().add(lblSiguienteHilera);
		
		lblPuntos = new JLabel("Puntos:");
		lblPuntos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPuntos.setForeground(new Color(255, 255, 255));
		lblPuntos.setBounds(470, 10, 199, 23);
		getContentPane().add(lblPuntos);
		
		lblFondoTotal = new JLabel(new ImageIcon("C:/Users/luisk.PC-LUISK/Documents/tec/lll Semestre/Datos l/Proyecto#1/Imagenes/fondoTotal.jpg"));
		lblFondoTotal.setBounds(0, 0, 884, 541);
		getContentPane().add(lblFondoTotal);
		juego.setVisible(false);
		setVisible(true);
	}

	public JPanel getPanelInicio() {
		return panelInicio;
	}

	public void setPanelInicio(JPanel panelInicio) {
		this.panelInicio = panelInicio;
	}

	public Juego getJuego() {
		return juego;
	}

	public void setLblSiguienteHilera(String siguienteHilera) {
		lblSiguienteHilera.setText("Siguiente:"+siguienteHilera);
	}

	public void setLblHileraActual(String hileraActual) {
		lblHileraActual.setText("Hilera Actual:"+hileraActual);
	}

	public void setLblPuntos(int puntos) {
		lblPuntos.setText("Puntos:"+puntos);
	}

	public void setLblNivel(int nivel) {
		lblNivel.setText("Nivel:"+nivel);
	}

	public void setLblVida(int vida) {
		lblVida.setText("Vida:"+vida);
	}
	
	public JButton getBtnPausa() {
		return btnPausa;
	}

	public void setBtnPausa(JButton btnPausa) {
		this.btnPausa = btnPausa;
	}

	public VentanaJuego() throws InterruptedException{
		initialize();
	}
}
