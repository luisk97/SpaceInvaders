package estructura;

public class Enemigo {
	private String id;
	private int vida;
	private String grado;
	private Enemigo siguiente;

	public Enemigo(int vida,String id) {
		this.vida = vida;
		this.id = id;
		siguiente = null;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public Enemigo getSiguiente() {
		return siguiente;
	}

	public void enlazarSiguiente(Enemigo siguiente) {
		this.siguiente = siguiente;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public void recibirDisparo(int disparo) {
		
	}

	public String getId() {
		return id;
	}

}
