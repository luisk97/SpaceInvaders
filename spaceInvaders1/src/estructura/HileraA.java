package estructura;

public class HileraA implements InterfaceHilera{
	private final String tipo = "ClaseA";
	private NodoA cabeza;
	private NodoA ultimo;
	private int size;

	public HileraA() {
		cabeza = null;
		ultimo = null;
		size = 0;
	}

	@Override
	public void add(int i,int grado,int vida) {
		NodoA nuevo = new NodoA(new Enemigo(i,grado,vida));
		if(cabeza==null) {
			cabeza = nuevo;
			ultimo = cabeza;
		}else {
			NodoA temp = ultimo;
			temp.enlazarSiguiente(nuevo);
			ultimo = nuevo;
		}
		size++;
		
	}

	@Override
	public void eliminar(int ind) {
		if(size > 0) {
			if(ind < size) {
				if(ind == 0) {
					if(cabeza.getEnemigo().getGrado().equals("Jefe")) {
						cabeza = null;
						ultimo = null;
						size = 0;
					}else {
						cabeza = cabeza.getSiguiente();
						size--;
					}
				}else{
					NodoA temp = cabeza;
					for(int indice = 0;indice < (ind-1);indice++) {
						temp = temp.getSiguiente();
					}
					if(temp.getSiguiente().getEnemigo().getGrado().equals("Jefe")) {
						cabeza = null;
						ultimo = null;
						size = 0;
					}else {
						if(ind == size-1) {
							temp.enlazarSiguiente(null);
							ultimo = temp;
						}else {
						 temp.enlazarSiguiente(temp.getSiguiente().getSiguiente());
						}
						size--;
					}
				}
				System.out.println("Enemigo eliminado");
			}else {
				System.out.println("Indice no valido");
			}
		}else {
			System.out.println("Hilera vacia");
		}
		
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean estaVacia() {
		return size==0;
	}
	
	@Override
	public String getTipo() {
		return tipo;
	}

	public  NodoA obtener(int i) {
		if(size != 0) {
			if(i<size) {
				NodoA temp = cabeza;
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
		System.out.println("No se que putas paso XC");
		return null;
	}

}
