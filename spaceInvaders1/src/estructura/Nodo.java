package estructura;

public class Nodo {
	private Enemigo enemigo;
	private Nodo siguiente;
	

	public Nodo(Enemigo enemigo) {
		this.enemigo = enemigo;
		siguiente = null;
	}
	
	public Nodo getSiguiente() {
		return siguiente;
	}

	public void enlazarSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}

	public Enemigo getEnemigo() {
		return enemigo;
	}

}
