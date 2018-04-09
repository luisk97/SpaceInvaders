package estructura;

/**
 * Esta clase es la que forma la lista enlazada de la clase Hilera la cual
 * es la clase basica de hilera
 * @author luisk
 *
 */
public class Nodo {
	private Enemigo enemigo;
	private Nodo siguiente;
	
	/**
	 * Metodo constructor de la clase
	 * @param enemigo
	 */
	public Nodo(Enemigo enemigo) {
		this.enemigo = enemigo;
		siguiente = null;
	}
	
	/**
	 * metodo que retorna la referencia al siguiente nodo
	 * @return Nodo
	 */
	public Nodo getSiguiente() {
		return siguiente;
	}

	/**
	 * este metodo permite guardar la referencia a otro nodo para de 
	 * este modo formar la lista enlazada
	 * @param siguiente
	 */
	public void enlazarSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}

	/**
	 * Este metodo nos retorna el valor contenido dentro del nodo que en este caso es un enemigo
	 * @return Enemigo enemigo
	 */
	public Enemigo getEnemigo() {
		return enemigo;
	}

}
