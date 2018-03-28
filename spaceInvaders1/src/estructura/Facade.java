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
			Enemigo enemigo = basica.obtener(i).getEnemigo();
			return enemigo;
		}else if(hilera instanceof HileraA) {
			tipoA = (HileraA)hilera;
			Enemigo enemigo = tipoA.obtener(i).getEnemigo();
			return enemigo;
		}else if(hilera instanceof HileraB) {
			tipoB = (HileraB)hilera;
			Enemigo enemigo = tipoB.obtener(i).getEnemigo();
			return enemigo;
		}else if(hilera instanceof HileraC) {
			tipoC = (HileraC)hilera;
			Enemigo enemigo = tipoC.obtener(i).getEnemigo();
			return enemigo;
		}else if(hilera instanceof HileraD) {
			tipoD = (HileraD)hilera;
			Enemigo enemigo = tipoD.obtener(i).getEnemigo();
			return enemigo;
		}else if(hilera instanceof HileraE) {
			tipoE = (HileraE)hilera;
			Enemigo enemigo = tipoE.obtener(i).getEnemigo();
			return enemigo;
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
