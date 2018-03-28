package estructura;

public class NodoE {
	private Enemigo enemigo;
	private NodoE siguiente;
	private NodoE anterior;

	public NodoE(Enemigo enemigo) {
		this.enemigo = enemigo;
	}

	public Enemigo getEnemigo() {
		return enemigo;
	}

	public void setEnemigo(Enemigo enemigo) {
		this.enemigo = enemigo;
	}

	public NodoE getSiguiente() {
		return siguiente;
	}

	public void enlazarSiguiente(NodoE siguiente) {
		this.siguiente = siguiente;
	}

	public NodoE getAnterior() {
		return anterior;
	}

	public void enlazarAnterior(NodoE anterior) {
		this.anterior = anterior;
	}
}
