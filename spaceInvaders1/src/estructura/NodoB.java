package estructura;

/**
 * Esta clase es la que forma la lista enlazada de la clase HileraB
 * @author luisk
 *
 */
public class NodoB {
	private Enemigo enemigo;
	private NodoB siguiente;
	private NodoB anterior;

	/**
	 * Metodo constructor de la clase
	 * @param enemigo
	 */
	public NodoB(Enemigo enemigo) {
		this.enemigo = enemigo;
	}

	/**
	 * Este metodo nos retorna el valor contenido dentro del nodo que en este caso es un enemigo
	 * @return Enemigo enemigo
	 */
	public Enemigo getEnemigo() {
		return enemigo;
	}

	
//	public void setEnemigo(Enemigo enemigo) {
//		this.enemigo = enemigo;
//	}

	/**
	 * metodo que retorna la referencia al siguiente nodo
	 * @return NodoB
	 */
	public NodoB getSiguiente() {
		return siguiente;
	}

	/**
	 * este metodo permite guardar la referencia a otro nodo para de 
	 * este modo formar la lista enlazada
	 * @param siguiente
	 */
	public void enlazarSiguiente(NodoB siguiente) {
		this.siguiente = siguiente;
	}

	/**
	 * Este metodo nos brinda la referencia al nodo contenido en el 
	 * atributo anterior
	 * @return NodoB anterior
	 */
	public NodoB getAnterior() {
		return anterior;
	}

	/**
	 * Este metodo permite guardar la referencia a otro nodo para de 
	 * este modo formar la lista enlazada
	 * @param anterior
	 */
	public void enlazarAnterior(NodoB anterior) {
		this.anterior = anterior;
	}

}
