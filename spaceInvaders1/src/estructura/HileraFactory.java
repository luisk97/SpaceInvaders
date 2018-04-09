package estructura;

import java.util.Random;

/**
 * Esta clase es la implementacion de patron de diseño Factory con el cual
 * solo debemos indicar el tipo de hilera que deseamos y nos debuelve una 
 * instancia de la hilera requerida sin tener que hacer todas esas validaciones
 * en la clase cliente
 * @author luisk
 *
 */
public class HileraFactory {
	private Random random = new Random();
	private int enem;
	private int cantEnem = 7;

	/**
	 * Mediante este metodo nos ahorramos tener que hacer todas estas validaciones
	 * en la clase cliente, solo tenemos que indicar mediante un parametro numerico
	 * la clase de hilera que deseamos y este metodo se encarga de construir la
	 * hilera con la cantidad de enemigos predefinida de la manera que se requiere
	 * segun sea la clase de hilera
	 * @param tipo
	 * @return InterfaceHilera
	 */
	public InterfaceHilera make(int tipo) {
		if(tipo == 0) {
			Hilera basic = new Hilera();
			System.out.println("Se creo una Hilera Basic");
			for(int i = 0; i<cantEnem; i++) {
				basic.add(i,1,3);
			}
			return basic;
		}else if(tipo == 1) {
			HileraA tipoA = new HileraA();
			System.out.println("Se creo una Hilera TipoA");
			enem = random.nextInt(cantEnem);
			for(int i = 0; i < cantEnem; i++) {
				if(i == enem) {
					tipoA.add(i,2,7);
				}else {
					tipoA.add(i,1,3);
				}
			}
			return tipoA;
		}else if(tipo == 2) {
			HileraB tipoB = new HileraB();
			System.out.println("Se creo una Hilera TipoB");
			enem = random.nextInt(cantEnem);
			for(int i = 0; i < cantEnem; i++) {
				if(i == enem) {
					tipoB.add(i,2,7);
				}else {
					tipoB.add(i,1,3);
				}
			}
			return tipoB;
		}else if(tipo == 3) {
			HileraC tipoC = new HileraC();
			System.out.println("Se creo una Hilera TipoC");
			enem = random.nextInt(cantEnem);
			for(int i = 0; i < cantEnem; i++) {
				if(i == enem) {
					tipoC.add(i,2,7);
				}else {
					tipoC.add(i,1,3);
				}
			}
			return tipoC;
		}else if(tipo == 4) {
			HileraD tipoD = new HileraD();
			System.out.println("Se creo una Hilera TipoD");
			enem = random.nextInt(cantEnem);
			int resistencia;
			for(int i = 0; i < cantEnem; i++) {
				resistencia = random.nextInt(6);
				if(resistencia == 0)
					resistencia=1;
				if(i == enem) {
					tipoD.add(i,2,7);
				}else {
					tipoD.add(i,1,resistencia);
				}
			}
			tipoD.burbuja();
			return tipoD;
		}else if(tipo == 5) {
			HileraE tipoE = new HileraE();
			System.out.println("Se creo una Hilera TipoE");
			for(int i = 0; i < 7; i++) {
				if(i == 3) {
					tipoE.add(i,2,7);
				}else {
					tipoE.add(i,1,3);
				}
			}
			return tipoE;
		}else {
			return null;
		}
	}

}
