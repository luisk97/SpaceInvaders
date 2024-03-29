package estructura;

/**
 * Esta clase corresponde al segundo tipo de hilera a la cual se le 
 * eliminan todos los nodos si se elimina alguno que contenga un enemigo 
 * de tipo Jefe
 * @author luisk
 *
 */
public class HileraA implements InterfaceHilera{
	private final String tipo = "ClaseA";
	private NodoA cabeza;
	private NodoA ultimo;
	private int size;

	/**
	 * Metodo constructor
	 */
	public HileraA() {
		cabeza = null;
		ultimo = null;
		size = 0;
	}

	/**
	 * Permitira a�adir nuevos nodos a la lista enlazada(hilera)
	 */
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
						size--;
					}
				}else{
					NodoA temp = cabeza;
					for(int indice = 0;indice < (ind-1);indice++) {
						temp = temp.getSiguiente();
					}
					System.out.println("Enemigo tipo "+temp.getEnemigo().getGrado()+"con id:"+temp.getEnemigo().getId()+" eliminado");
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

	/**
	 * Permitira obtener el nodo que se encuentre en la posicion que se 
	 * paso como parametro
	 * @param i
	 * @return NodoA
	 */
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
