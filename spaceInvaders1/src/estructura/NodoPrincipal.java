package estructura;

public class NodoPrincipal {
	private InterfaceHilera hilera;
	private NodoPrincipal siguiente;

	public NodoPrincipal(InterfaceHilera hilera) {
		siguiente = null;
		this.hilera = hilera;
	}

	public void enlazarSiguiente(NodoPrincipal siguiente) {
		this.siguiente = siguiente;
		
	}

	public NodoPrincipal getSiguiente() {
		return siguiente;
	}

	public InterfaceHilera getHilera() {
		return hilera;
	}

}
