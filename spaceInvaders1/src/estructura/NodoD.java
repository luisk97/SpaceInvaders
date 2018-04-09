package estructura;

/**
 * Esta clase es la que forma la lista enlazada de la clase HileraD
 * @author luisk
 *
 */
public class NodoD {
	
	private Enemigo enemigo;
	private NodoD siguiente;
	

	/**
	 * Metodo constructor de la clase
	 * @param enemigo
	 */
	public NodoD(Enemigo enemigo) {
		this.enemigo = enemigo;
		siguiente = null;
	}
	
	/**
	 * metodo que retorna la referencia al siguiente nodo
	 * @return NodoD
	 */
	public NodoD getSiguiente() {
		return siguiente;
	}
	
	/**
	 * este metodo permite guardar la referencia a otro nodo para de 
	 * este modo formar la lista enlazada
	 * @param siguiente
	 */
	public void enlazarSiguiente(NodoD siguiente) {
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
