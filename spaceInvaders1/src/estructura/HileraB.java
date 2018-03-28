package estructura;

public class HileraB implements InterfaceHilera{
	private final String tipo = "ClaseB";
	private NodoB cabeza;
	private NodoB ultimo;
	private int size;

	public HileraB() {
		cabeza = null;
		ultimo = null;
		size = 0;
	}

	@Override
	public void add(int i,int grado,int vida) {
		NodoB nuevo = new NodoB(new Enemigo(i,grado,vida));
		if(cabeza==null) {
			cabeza = nuevo;
			ultimo = cabeza;
		}else {
			NodoB temp = ultimo;
            temp.enlazarSiguiente(nuevo);
            nuevo.enlazarAnterior(temp);
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
						cabeza.enlazarAnterior(null);
						size--;
					}
				}else{
					NodoB temp = cabeza;
					for(int i = 0;i < ind;i++) {
						temp = temp.getSiguiente();
					}
					if(temp.getEnemigo().getGrado().equals("Jefe")) {
						cabeza = null;
						ultimo = null;
						size = 0;
					}else {
						if(ind == size-1) {
							ultimo = temp.getAnterior();
							ultimo.enlazarSiguiente(null);
						}else {
							temp.getAnterior().enlazarSiguiente(temp.getSiguiente());
							temp.getSiguiente().enlazarAnterior(temp.getAnterior());
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getTipo() {
		return tipo;
	}

	public NodoB obtener(int i) {
		if(size != 0) {
			if(i<size) {
				NodoB temp = cabeza;
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

}
