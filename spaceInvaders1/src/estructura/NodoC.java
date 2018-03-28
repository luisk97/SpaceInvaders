package estructura;

public class NodoC {

	private Enemigo enemigo;
	private NodoC siguiente;
	

	public NodoC(Enemigo enemigo) {
		this.enemigo = enemigo;
		siguiente = null;
	}
	
	public NodoC getSiguiente() {
		return siguiente;
	}
	
	public void enlazarSiguiente(NodoC siguiente) {
		this.siguiente = siguiente;
	}

	public Enemigo getEnemigo() {
		return enemigo;
	}

}
