package estructura;

import java.util.Random;

public class HileraFactory {
	Random random = new Random();
	int enem;

	public InterfaceHilera make(int tipo) {
		if(tipo == 0) {
			Hilera basic = new Hilera();
			System.out.println("Se creo una Hilera Basic");
			for(int i = 0; i<7; i++) {
				basic.add(i,1,3);
			}
			return basic;
		}else if(tipo == 1) {
			HileraA tipoA = new HileraA();
			System.out.println("Se creo una Hilera TipoA");
			enem = random.nextInt(7);
			for(int i = 0; i < 7; i++) {
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
			enem = random.nextInt(7);
			for(int i = 0; i < 7; i++) {
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
			enem = random.nextInt(7);
			for(int i = 0; i < 7; i++) {
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
			enem = random.nextInt(7);
			int res;
			for(int i = 0; i < 7; i++) {
				res = random.nextInt(6);
				if(res == 0)
					res=1;
				if(i == enem) {
					tipoD.add(i,2,7);
				}else {
					tipoD.add(i,1,res);
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
