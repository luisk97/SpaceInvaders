package interfaz;

import java.util.Scanner;

import estructura.Hilera;
import estructura.Jugador;
import pruebaWindowWilder.VentanaPrincipal;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
					if(opcion == 1) {
						j.setNivel(1);
						j.setVida(10);
						System.out.println("Jugador:" + j.getNombre());
						System.out.println("Nivel:"+j.getNivel()+" Vida:"+j.getVida());
					}
					break;
				}
				case 2:
					flag = false;
			}
				
		}while(flag);

	}

}
