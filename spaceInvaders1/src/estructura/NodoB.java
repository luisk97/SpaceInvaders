package estructura;

public class NodoB {
	private Enemigo enemigo;
	private NodoB siguiente;
	private NodoB anterior;

	public NodoB(Enemigo enemigo) {
		this.enemigo = enemigo;
	}

	public Enemigo getEnemigo() {
		return enemigo;
	}

	public void setEnemigo(Enemigo enemigo) {
		this.enemigo = enemigo;
	}

	public NodoB getSiguiente() {
		return siguiente;
	}

	public void enlazarSiguiente(NodoB siguiente) {
		this.siguiente = siguiente;
	}

	public NodoB getAnterior() {
		return anterior;
	}

	public void enlazarAnterior(NodoB anterior) {
		this.anterior = anterior;
	}

}
