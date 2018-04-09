package estructura;

/**
 * Esta clase va ser la hilera principal donde se guardaran todas las hileras 
 * que nos iran apareciendo a lo largo del juego
 * @author luisk
 *
 */
public class HileraPrincipal {
	private NodoPrincipal cabeza;
	private NodoPrincipal ultimo;
	private static HileraPrincipal hil;
	private int size;

	/**
	 * Metodo constructor
	 */
	private HileraPrincipal() {
		size = 0;
		cabeza = null;
		ultimo = null;
	}
	
	/**
	 * Este metodo valida si ya tenemos una instancia de la hilera principal
	 * nos devuelve esa instancia y si no se crea una nueva asegurando asi que
	 * no se cree mas de una instancia de esta(implementacion del patron Singleton)
	 * @return HileraPrincipal
	 */
	public static HileraPrincipal getInstance() {
		if (hil == null) {
			hil = new HileraPrincipal();
		}
		return hil;
	}
	
	/**
	 * Retorna el primer nodo contenido en la hilera principal
	 * @return NodoPrincipal cabeza
	 */
	public NodoPrincipal getCabeza() {
		return cabeza;
	}

	/**
	 * Permitira añadir nuevos nodos a la hilera y como podemos ver aqui es 
	 * donde se hace uso de la clase HileraFactory
	 * @param tipo
	 */
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
	
	/**
	 * Este metodo permitira eliminar el nodo que se encuentre en la posicion indicada
	 * @param ind
	 */
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
	
	/**
	 * Este metodo retornara el nodo que se encuentre en la posicion solicitada
	 * @param i
	 * @return NodoPrincipal
	 */
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
	
	/**
	 * Este metodo permite eliminar todos los nodos contenidos dentro de la 
	 * hilera principal basicamente vaciarla
	 */
	public void clear() {
		cabeza = null;
		ultimo = null;
		size = 0;
	}

	/**
	 * retorna el tamaño que tiene la hilera
	 * @return int size
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Verifica si hay elementos contenidos dentro de la lista
	 * @return boolean true o false
	 */
	public boolean estaVacia() {
		return size==0;
	}

}
