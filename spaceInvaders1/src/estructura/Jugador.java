package estructura;

public class Jugador {
	private static Jugador j;
	private String nombre;
	private int vida;
	private int nivel;
	private int puntos;
	
	public Jugador(String nombre) {
		this.nombre = nombre;
		vida = 0;
		nivel = 0;
		puntos = 0;
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

}
