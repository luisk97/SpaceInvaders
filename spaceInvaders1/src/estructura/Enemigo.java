package estructura;

public class Enemigo {
	private int id;
	private int vida;
	private String grado;

	public Enemigo(int id,int grado,int vida) {
		this.id = id;
		this.vida = vida;
		if(grado == 2) {
			this.grado = "Jefe";
		}else {
			this.grado = "Cabo";
		}
		System.out.println("Se creo un "+this.grado+" con id: "+id+" y vida: "+vida);
	}

	public String getGrado() {
		return grado;
	}
	
	public void setGrado(String grado) {
		this.grado = grado;
	}

	public int getVida() {
		return vida;
	}
	
	public void recibirDisparo() {
		vida--;
	}

	public int getId() {
		return id;
	}

}
