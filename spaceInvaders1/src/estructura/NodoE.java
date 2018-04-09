package estructura;

/**
 * Esta clase es la que forma la lista enlazada de la clase HileraE
 * @author luisk
 *
 */
public class NodoE {
	private Enemigo enemigo;
	private NodoE siguiente;
	private NodoE anterior;

	/**
	 * Metodo constructor de la clase
	 * @param enemigo
	 */
	public NodoE(Enemigo enemigo) {
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
	 * @return NodoE
	 */
	public NodoE getSiguiente() {
		return siguiente;
	}

	/**
	 * este metodo permite guardar la referencia a otro nodo para de 
	 * este modo formar la lista enlazada
	 * @param siguiente
	 */
	public void enlazarSiguiente(NodoE siguiente) {
		this.siguiente = siguiente;
	}

	/**
	 * Este metodo nos brinda la referencia al nodo contenido en el 
	 * atributo anterior
	 * @return NodoE anterior
	 */
	public NodoE getAnterior() {
		return anterior;
	}

	/**
	 * este metodo permite guardar la referencia a otro nodo para de 
	 * este modo formar la lista enlazada
	 * @param anterior
	 */
	public void enlazarAnterior(NodoE anterior) {
		this.anterior = anterior;
	}
}
