package juego;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import estructura.HileraPrincipal;

/**
 * Clase principal que se encarga del arranque del juego
 * @author luisk
 *
 */
public class MainJuego {

	/**
	 * Metodo principal en el cual se inicia la ventana de juego y tambien se inician el Thread
	 * de la animacion del juego y el Thread del socket para el control por dispositivo movil
	 * @param args
	 * @throws InterruptedException
	 * @throws IOException 
	 */
	public static void main(String[] args) throws InterruptedException, IOException {
		
		VentanaJuego ventana = new VentanaJuego();
		HiloJuego hiloJuego = new HiloJuego(ventana);
		HiloSocket hiloSocket = new HiloSocket(ventana);
		
		
//		HileraPrincipal hilPrin = HileraPrincipal.getInstance();
//		boolean enPartida = false;
////		Random randomHilera = new Random();
////		int tipo;
//		VentanaJuego ventana = new VentanaJuego();
////		ventana.getJuego().iniciarEnemigos();
//		while(true) {
//			enPartida = ventana.getJuego().isEnCurso();
//			if(enPartida) {
//				if(ventana.getJuego().getNave().getNivel()==(ventana.getJuego().getNivelMaximo()+1)) {
//					ventana.getBtnPausa().setVisible(false);
//					ventana.getJuego().setEnCurso(false);
//					ventana.getPanelInicio().setVisible(true);
//					ventana.getJuego().setVisible(false);
//				}else {
//					if(hilPrin.estaVacia()){
//					ventana.getJuego().iniciarEnemigos();
//					}
//				}
//				ventana.getJuego().repaint();
//				ventana.getJuego().move();
////				ventana.getJuego().repaint();
//				ventana.setLblVida(ventana.getJuego().getNave().getVida());
//				ventana.setLblNivel(ventana.getJuego().getNave().getNivel());
//				ventana.setLblPuntos(ventana.getJuego().getNave().getPuntos());
//				if(hilPrin.size()>0) {
//					ventana.setLblHileraActual(hilPrin.getCabeza().getHilera().getTipo());
//					if(hilPrin.size()<=1) {
//						ventana.setLblSiguienteHilera("Ninguna");
//					}else {
//						ventana.setLblSiguienteHilera(hilPrin.obtener(1).getHilera().getTipo());
//					}
//				}
//				if(ventana.getJuego().getNave().getVida() <= 0) {
//					ventana.getBtnPausa().setVisible(false);
//					ventana.getJuego().setEnCurso(false);
//					ventana.getPanelInicio().setVisible(true);
//					ventana.getJuego().setVisible(false);
//				}
//			}else {
//				
//			}
//			Thread.sleep(10);
//		}
		
	}

}

//try {
//	ServerSocket servidor = new ServerSocket(8000);
//	Socket clienteNuevo = servidor.accept();
//	ObjectInputStream entrada = new ObjectInputStream(clienteNuevo.getInputStream());
//	System.out.println("Llego el Objeto");
//	System.out.println("Mandando otro mensaje al cliente");
//	String mensaje = (String)entrada.readObject();
//	System.out.println("Mensaje: "+mensaje);
//	nave.recibeOrden(mensaje);
//	ObjectOutputStream resp = new ObjectOutputStream(clienteNuevo.getOutputStream());
//	resp.writeObject("Hola cliente");
//	System.out.println("Mensaje enviado");
//	clienteNuevo.close();
//	servidor.close();
//	
//}catch (IOException e) {
//	Logger.getLogger(Juego.class.getName()).log(Level.SEVERE,null,e);
//} catch (ClassNotFoundException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}
