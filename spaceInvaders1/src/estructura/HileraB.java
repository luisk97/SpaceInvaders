package estructura;

/**
 * Esta clase corresponde a la tercer clase de hilera la cual varia dinamica y 
 * aleatoriamente la posicion del Jefe
 * @author luisk
 *
 */
public class HileraB implements InterfaceHilera{
	private final String tipo = "ClaseB";
	private NodoB cabeza;
	private NodoB ultimo;
	private int size;

	/**
	 * Metodo constructor
	 */
	public HileraB() {
		cabeza = null;
		ultimo = null;
		size = 0;
	}

	/**
	 * Permitira añadir nuevos nodos a la lista enlazada(hilera)
	 */
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

	/**
	 * Este metodo permitira eliminar el nodo que se encuentre en la posicion indicada
	 * validando primero si el enemigo contenido dentro del nodo es de tipo jefe y si 
	 * es asi se elimina todos los nodos contenidos en la hilera
	 */
	@Override
	public void eliminar(int ind) {
		if(size > 0) {
			if(ind < size) {
				if(ind == 0) {
					if(cabeza.getEnemigo().getGrado().equals("Jefe")) {
						System.out.println("Enemigo tipo "+cabeza.getEnemigo().getGrado()+"con id:"+cabeza.getEnemigo().getId()+" eliminado");
						cabeza = null;
						ultimo = null;
						size = 0;
					}else {
						System.out.println("Enemigo tipo "+cabeza.getEnemigo().getGrado()+"con id:"+cabeza.getEnemigo().getId()+" eliminado");
						cabeza = cabeza.getSiguiente();
						cabeza.enlazarAnterior(null);
						size--;
					}
				}else{
					NodoB temp = cabeza;
					for(int i = 0;i < ind;i++) {
						temp = temp.getSiguiente();
					}
					System.out.println("Enemigo tipo "+temp.getEnemigo().getGrado()+"con id:"+temp.getEnemigo().getId()+" eliminado");
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

/**
 * Permitira obtener el nodo que se encuentre en la posicion que se 
 * paso como parametro
 * @param i
 * @return NodoB
 */
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
