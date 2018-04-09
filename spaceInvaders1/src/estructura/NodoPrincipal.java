package estructura;

/**
 * Esta clase es la que forma la lista enlazada de la clase HileraPrincipal
 * @author luisk
 *
 */
public class NodoPrincipal {
	private InterfaceHilera hilera;
	private NodoPrincipal siguiente;

	/**
	 * Metodo constructor de la clase
	 * @param hilera
	 */
	public NodoPrincipal(InterfaceHilera hilera) {
		siguiente = null;
		this.hilera = hilera;
	}

	/**
	 * este metodo permite guardar la referencia a otro nodo para de 
	 * este modo formar la lista enlazada
	 * @param siguiente
	 */
	public void enlazarSiguiente(NodoPrincipal siguiente) {
		this.siguiente = siguiente;
	}

	/**
	 * metodo que retorna la referencia al siguiente nodo
	 * @return NodoPrincipal
	 */
	public NodoPrincipal getSiguiente() {
		return siguiente;
	}

	/**
	 * Este metodo nos retorna el valor contenido dentro del nodo que en este caso
	 * es alguna clase de hilera
	 * @return InterfaceHilera hilera
	 */
	public InterfaceHilera getHilera() {
		return hilera;
	}

}
