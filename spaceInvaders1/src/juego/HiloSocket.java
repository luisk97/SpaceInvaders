package juego;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase se encarga de escuchar mediante el puerto 8000 la llegada de ordenes para mover la nave
 * del jugador o disparar con la misma
 * @author luisk
 *
 */
public class HiloSocket implements Runnable{
	Thread t;
	VentanaJuego ventana;
	
	/**
	 * Constructor de la clase
	 * @param ventana
	 */
	public HiloSocket(VentanaJuego ventana) {
		this.ventana = ventana;
		t = new Thread(this,"HiloSocket");
		t.start();
	}
	
	@Override
	public void run() {
		try {
			System.out.println("entramos al try");
			ServerSocket servidor = new ServerSocket(8000);
			while(true) {
				Socket clienteNuevo = servidor.accept();
				System.out.println("se conecto el cliente");
				ObjectInputStream entrada = new ObjectInputStream(clienteNuevo.getInputStream());
				System.out.println("Llego el Objeto");
				System.out.println("Mandando otro mensaje al cliente");
				String mensaje = (String)entrada.readObject();
				System.out.println("Mensaje: "+mensaje);
				ventana.getJuego().getNave().recibeOrden(mensaje);
				ObjectOutputStream resp = new ObjectOutputStream(clienteNuevo.getOutputStream());
				resp.writeObject("vida:"+ventana.getJuego().getNave().getVida()+"   puntos:"+ventana.getJuego().getNave().getPuntos()+
						"   nivel:"+ventana.getJuego().getNave().getNivel()+"   hilera:"+ventana.getJuego().getHileraActual()+"   siguiente:"+ventana.getJuego().getHileraSiguiente());
				System.out.println("Mensaje enviado");
				clienteNuevo.close();
//			 	servidor.close();
			}
		}catch (IOException e) {
			Logger.getLogger(Juego.class.getName()).log(Level.SEVERE,null,e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
