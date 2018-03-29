package estructura;

public class Facade {
	private Hilera basica;
	private HileraA tipoA;
	private HileraB tipoB;
	private HileraC tipoC;
	private HileraD tipoD;
	private HileraE tipoE;
	

	public Facade() {
		basica = null;
		tipoA = null;
		tipoB = null;
		tipoC = null;
		tipoD = null;
		tipoE = null;
	}
	
	public Enemigo obtenerEnemigo(InterfaceHilera hilera,int i) {
		if(hilera instanceof Hilera) {
			basica = (Hilera)hilera;
			if(!basica.estaVacia()) {
				Enemigo enemigo = basica.obtener(i).getEnemigo();
				return enemigo;
			}else {
				return null;
			}
		}else if(hilera instanceof HileraA) {
			tipoA = (HileraA)hilera;
			if(!tipoA.estaVacia()) {
				Enemigo enemigo = tipoA.obtener(i).getEnemigo();
				return enemigo;
			}else {
				return null;
			}
		}else if(hilera instanceof HileraB) {
			tipoB = (HileraB)hilera;
			if(!tipoB.estaVacia()) {
				Enemigo enemigo = tipoB.obtener(i).getEnemigo();
				return enemigo;
			}else {
				return null;
			}
		}else if(hilera instanceof HileraC) {
			tipoC = (HileraC)hilera;
			if(!tipoC.estaVacia()) {
				Enemigo enemigo = tipoC.obtener(i).getEnemigo();
				return enemigo;
			}else {
				return null;
			}
		}else if(hilera instanceof HileraD) {
			tipoD = (HileraD)hilera;
			if(!tipoD.estaVacia()) {
				Enemigo enemigo = tipoD.obtener(i).getEnemigo();
				return enemigo;
			}else {
				return null;
			}
		}else if(hilera instanceof HileraE) {
			tipoE = (HileraE)hilera;
			if(!tipoE.estaVacia()) {
				Enemigo enemigo = tipoE.obtener(i).getEnemigo();
				return enemigo;
			}else {
				return null;
			}
		}else {
			System.out.println("Parametro no valido");
		}
		return null;
	}
	
//	public void eliminarEnemigo(InterfaceHilera hilera,int i) {
//		if(hilera instanceof Hilera) {
//			basica = (Hilera)hilera;
//			basica.eliminar(i);
//		}else if(hilera instanceof HileraA) {
//			tipoA = (HileraA)hilera;
//			tipoA.eliminar(i);
//		}else if(hilera instanceof HileraB) {
//			tipoB = (HileraB)hilera;
//			tipoB.eliminar(i);
//		}else if(hilera instanceof HileraC) {
//			tipoC = (HileraC)hilera;
//			tipoC.eliminar(i);
//		}else if(hilera instanceof HileraD) {
//			tipoD = (HileraD)hilera;
//			tipoD.eliminar(i);
//		}else if(hilera instanceof HileraE) {
//			tipoE = (HileraE)hilera;
//			tipoE.eliminar(i);
//		}else {
//			System.out.println("Parametro no valido");
//		}
//	}

}
