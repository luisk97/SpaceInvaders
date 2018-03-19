package estructura;

public class Enemigo {
	private int vida;
	private String grado;
	private Enemigo siguiente;

	public Enemigo(int vida,String grado) {
		this.setVida(vida);
		this.grado = grado;
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

	public void setSiguiente(Enemigo siguiente) {
		this.siguiente = siguiente;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

}
