package interfaz;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Button;
import javax.swing.JLabel;

public class VentanaPrincipal extends JFrame implements ActionListener{

	JButton btnNewButton;
	JButton btnSalir;
	Image imagenPrueba;
	JLabel label;
	JLabel label1;
	int x = 233;
	int y = 285;
	private JButton btnDer;
	private JButton btnIzq;
	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 686, 484);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		label = new JLabel(new ImageIcon("C:/Users/luisk.PC-LUISK/Documents/tec/lll Semestre/Datos l/Proyecto#1/Imagenes/navePrincipal3.png"));
		label.setBounds(x, y, 202, 156);
		label.setVisible(false);
		getContentPane().add(label);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(0, 0, 69, 23);
		btnSalir.setVisible(false);
		getContentPane().add(btnSalir);
		
		btnDer = new JButton("der");
		btnDer.setBounds(643, 248, 28, 23);
		btnDer.addActionListener(this);
		btnDer.setVisible(false);
		getContentPane().add(btnDer);
		
		btnIzq = new JButton("izq");
		btnIzq.addActionListener(this);
		btnIzq.setBounds(615, 248, 28, 23);
		btnIzq.setVisible(false);
		getContentPane().add(btnIzq);
		
		label1 = new JLabel(new ImageIcon("C:/Users/luisk.PC-LUISK/Documents/tec/lll Semestre/Datos l/Proyecto#1/Imagenes/imagenFondo1.jpg"));
		label1.setBounds(0, 0, 671, 445);
		label1.setVisible(false);
		getContentPane().add(label1);
		
		btnNewButton = new JButton(new ImageIcon("C:/Users/luisk.PC-LUISK/Documents/tec/lll Semestre/Datos l/Proyecto#1/Imagenes/botonStart1.jpg"));
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(278, 162, 113, 116);
		getContentPane().add(btnNewButton);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnNewButton) {
			label1.setVisible(true);
			label.setVisible(true);
			btnSalir.setVisible(true);
			btnNewButton.setVisible(false);
			btnIzq.setVisible(true);
			btnDer.setVisible(true);
		}else if(e.getSource()==btnSalir) {
			label.setVisible(false);
			btnSalir.setVisible(false);
			btnNewButton.setVisible(true);
			btnIzq.setVisible(false);
			btnDer.setVisible(false);
			label1.setVisible(false);
		}else if(e.getSource()==btnDer) {
			x = x+10;
			label.setBounds(x, y, 202, 156);
			getContentPane().add(label);
			getContentPane().add(label1);
		}else if(e.getSource()==btnIzq) {
			x = x-10;
			label.setBounds(x, y, 202, 156);
			getContentPane().add(label);
			getContentPane().add(label1);
		}
	}
}
