package estructura;

import java.util.Random;

public class MainParaPruebasEstructura {

	public static void main(String[] args) {
		HileraPrincipal hilPrin = HileraPrincipal.getInstance();
		int tipo;
		int elim;
		Random random = new Random();
		for(int i = 0; i < 10; i++) {
			tipo = random.nextInt(6);
			System.out.println(tipo);
			hilPrin.add(tipo);
		}
		for(int i = 0; i < 10; i++) {
			InterfaceHilera hilera = hilPrin.obtener(i).getHilera();
			System.out.println(hilera.getTipo());
			elim = random.nextInt(7);
			hilera.eliminar(elim);
		}
		Facade fachada = new Facade();
		Enemigo temp;
		for(int i = 0; i < 10; i++) {
			InterfaceHilera hilera = hilPrin.obtener(i).getHilera();
			System.out.println(hilera.getTipo());
			for(int ind = 0; ind < hilera.size();ind++) {
				temp = fachada.obtenerEnemigo(hilera, ind);
				System.out.println("Enemigo grado "+temp.getGrado()
						+" con id: "+temp.getId()+" y vida: "+temp.getVida());
			}
		}
		
		
	}

}
