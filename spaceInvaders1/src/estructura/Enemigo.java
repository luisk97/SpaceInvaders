package estructura;

/**
 * Esta clase contendra la informacion del enemigo la cual se brindara a 
 * la clase NaveEnemiga para la implementacion en la interfaz
 * @author luisk
 *
 */
public class Enemigo {
	private int id;
	private int vida;
	private String grado;

	/**
	 * Metodo constructor
	 * @param id
	 * @param grado
	 * @param vida
	 */
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

	/**
	 * Retorna el atributo grado
	 * @return String grado
	 */
	public String getGrado() {
		return grado;
	}
	
	/**
	 * Permite modificar el atributo grado
	 * @param grado
	 */
	public void setGrado(String grado) {
		this.grado = grado;
	}

	/**
	 * retorna la vida con la cual se inicializara la nave enemiga grafica
	 * @return int Vida
	 */
	public int getVida() {
		return vida;
	}
	
//	public void recibirDisparo() {
//		vida--;
//	}

	/**
	 * Brindara el id con el cual se inicializo el enemigo
	 * @return int id
	 */
	public int getId() {
		return id;
	}

}
