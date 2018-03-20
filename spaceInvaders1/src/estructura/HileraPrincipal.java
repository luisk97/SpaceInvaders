package estructura;

public class HileraPrincipal {
	private Hilera cabeza;
	private Hilera ultimo;
	private static HileraPrincipal hil;
	private int size;

	private HileraPrincipal() {
		size = 0;
		cabeza = null;
		ultimo = null;
	}
	
	public static HileraPrincipal getInstance() {
		if (hil == null) {
			hil = new HileraPrincipal();
		}
		return hil;
	}
	
	public Hilera getCabeza() {
		return cabeza;
	}

	public void add(int vel,String tipo) {
		if(cabeza==null){
            cabeza = new Hilera(vel);
            cabeza.setTipo(tipo);
            ultimo = cabeza;
        }else{
	        Hilera temp = ultimo;
	        Hilera nuevo = new Hilera(vel);
	        temp.enlazarSiguiente(nuevo);
	        ultimo = nuevo;
	        ultimo.setTipo(tipo);
        }
		for(int i = 0; i<5; i++) {
        	ultimo.add(i+1);
        	dormir(0);
        	System.out.println("Enemigo numero "+(i+1));
        }
        size++;
	}
	
	public void eliminar(int ind) {
		if(ind < size) {
			if(ind == 0) {
				cabeza = cabeza.getSiguiente();
			}else{
				Hilera temp = cabeza;
				for(int i = 0;i < (ind-1);i++) {
					temp = temp.getSiguiente();
				}
				if(ind == size-1) {
					temp.enlazarSiguiente(null);
					ultimo = temp;
				}else {
				 temp.enlazarSiguiente(temp.getSiguiente().getSiguiente());
				}
			}
			size--;
		}else {
			System.out.println("Indice no valido");
		}
	}

	public int getSize() {
		return size;
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
