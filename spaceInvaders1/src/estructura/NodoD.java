package estructura;

public class NodoD {
	
	private Enemigo enemigo;
	private NodoD siguiente;
	

	public NodoD(Enemigo enemigo) {
		this.enemigo = enemigo;
		siguiente = null;
	}
	
	public NodoD getSiguiente() {
		return siguiente;
	}
	
	public void enlazarSiguiente(NodoD siguiente) {
		this.siguiente = siguiente;
	}

	public Enemigo getEnemigo() {
		return enemigo;
	}
}
