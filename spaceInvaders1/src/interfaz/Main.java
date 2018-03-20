package interfaz;

import java.util.Scanner;

import estructura.Hilera;
import estructura.HileraPrincipal;
import estructura.Jugador;
public class Main {

	public static void main(String[] args) {
		VentanaPrincipal  ventana = new VentanaPrincipal();
		ventana.setVisible(true);

		boolean flag = true;
		Scanner s = new Scanner(System.in);
		int opcion;
		do {
			System.out.println("      Menu");
			System.out.println("1-Nueva partida");
			System.out.println("2-Salir");
			opcion = s.nextInt();
			HileraPrincipal hileraPri;
			Jugador j;
			Hilera hilera;
			switch(opcion){
				case 1:{
					String nombre;
					System.out.println("Digite su nombre:");
					nombre = s.next();
					j = new Jugador(nombre);
					System.out.println("¿Jugar? 1=si 2=no");
					int op = s.nextInt();
					if(op == 1) {
						j.setNivel(1);
						j.setVida(10);
						System.out.println("Jugador:" + j.getNombre());
						System.out.println("Nivel:"+j.getNivel()+" Vida:"+j.getVida());
						hileraPri = HileraPrincipal.getInstance();
						for(int i=0;i<5;i++) {
							System.out.println("Hilera "+(i+1));
							hileraPri.add(i+1,"Hilera nivel "+(i+1));
							dormir(1);
						}
						boolean flag2=true;
						int disparo;
						do {
							if(hileraPri.getCabeza() != null) {
								System.out.println("Hilera actual:" + hileraPri.getCabeza().getTipo());
							}else {
								System.out.println("Todos los enemigos derrotados!!");
								System.out.println("GANASTE!!!");
								flag2 = false;
								break;
							}
							if(hileraPri.getCabeza().getSiguiente() != null) {
								System.out.println("Siguiente hilera:" + hileraPri.getCabeza().getSiguiente().getTipo());
							}else {
								System.out.println("Esta es la ultima hilera");
							}
							System.out.println("1=¡Disparar! 2=Salir");
							disparo = s.nextInt();
							switch(op) {
								case 1:
									if(disparo == 1) {
										if(hileraPri.getCabeza() != null) {
											if(hileraPri.getCabeza().getCabeza() != null) {
												System.out.println(hileraPri.getCabeza().getCabeza().getId()
														+" eliminado de la "+hileraPri.getCabeza().getTipo());
												hileraPri.getCabeza().eliminar(0);
											}else {
												System.out.println(hileraPri.getCabeza().getTipo()+" eliminada");
												hileraPri.eliminar(0);
											}
										}
										break;
									}
								case 2:
									flag2 = false;
							}
						}while(flag2);
					}
					break;
				}
				case 2:
					flag = false;
			}
				
		}while(flag);

	}
	
	public static void dormir(int time) {
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
