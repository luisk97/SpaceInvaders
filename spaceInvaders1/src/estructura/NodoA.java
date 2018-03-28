package estructura;

public class NodoA {
	private Enemigo enemigo;
	private NodoA siguiente;
	

	public NodoA(Enemigo enemigo) {
		this.enemigo = enemigo;
		siguiente = null;
	}
	
	public NodoA getSiguiente() {
		return siguiente;
	}

	public void enlazarSiguiente(NodoA siguiente) {
		this.siguiente = siguiente;
	}

	public Enemigo getEnemigo() {
		return enemigo;
	}

}
