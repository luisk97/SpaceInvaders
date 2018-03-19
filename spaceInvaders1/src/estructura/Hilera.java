package estructura;

public class Hilera {
	private int velocidad;
	private Enemigo cabeza;
	

	public Hilera() {
		velocidad = 1;
		cabeza = null;
	}


	public int getVelocidad() {
		return velocidad;
	}


	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}


	public Enemigo getCabeza() {
		return cabeza;
	}


	public void setCabeza(Enemigo cabeza) {
		this.cabeza = cabeza;
	}

}
