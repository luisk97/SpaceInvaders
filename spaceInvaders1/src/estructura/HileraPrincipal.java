package estructura;

public class HileraPrincipal {
	private NodoPrincipal cabeza;
	private NodoPrincipal ultimo;
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
	
	public NodoPrincipal getCabeza() {
		return cabeza;
	}

	public void add(int tipo) {
		InterfaceHilera hilera = new HileraFactory().make(tipo);
		if(cabeza==null){
            cabeza = new NodoPrincipal(hilera);
            ultimo = cabeza;
        }else{
        	NodoPrincipal temp = ultimo;
        	NodoPrincipal nuevo = new NodoPrincipal(hilera);
	        temp.enlazarSiguiente(nuevo);
	        ultimo = nuevo;
        }
		size++;
	}
	
	public void eliminar(int ind) {
		if(ind < size) {
			if(ind == 0) {
				cabeza = cabeza.getSiguiente();
			}else{
				NodoPrincipal temp = cabeza;
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
	
	public NodoPrincipal obtener(int i) {
		if(size != 0) {
			if(i<size) {
				NodoPrincipal temp = cabeza;
		        while(0 < i){
		            temp = temp.getSiguiente();
		            i--;
		        }
		        return temp;
			}else {
				System.out.println("Indice no valido");
			}
		}else {
			System.out.println("Hilera vacia");
		}
		return null;
	}
	
	public void clear() {
		cabeza = null;
		ultimo = null;
		size = 0;
	}

	public int size() {
		return size;
	}
	
	public boolean estaVacia() {
		return size==0;
	}

}
