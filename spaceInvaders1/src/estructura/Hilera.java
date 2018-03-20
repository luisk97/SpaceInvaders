package estructura;

public class Hilera {
	private int velocidad;
	private String tipo;
	private Enemigo cabeza;
	private Enemigo ultimo;
	private int size;
	private Hilera siguiente;
	

	public Hilera(int velocidad) {
		this.velocidad = velocidad;
		cabeza = null;
		size = 0;
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


	public void add(int i) {
		if(cabeza==null) {
			cabeza = new Enemigo(1,"Enemigo numero "+i);
			ultimo = cabeza;
		}else {
			Enemigo temp = ultimo;
			Enemigo nuevo = new Enemigo(1,"Enemigo numero "+i);
			temp.enlazarSiguiente(nuevo);
			ultimo = nuevo;
		}
		size++;
	}
	
	public void eliminar(int ind) {
		if(ind < size) {
			if(ind == 0) {
				cabeza = cabeza.getSiguiente();
			}else{
				Enemigo temp = cabeza;
				for(int i = 0;i < (ind-1);i++) {
					temp = temp.getSiguiente();
				}
				if(ind == size-1) {
					temp.enlazarSiguiente(null);
					ultimo = temp;
				}else {
				 temp.enlazarSiguiente(temp.getSiguiente().getSiguiente());
				}
			}
			size--;
		}else {
			System.out.println("Indice no valido");
		}
		
	}


	public int getSize() {
		return size;
	}


	public Hilera getSiguiente() {
		return siguiente;
	}


	public void enlazarSiguiente(Hilera hilera) {
		siguiente = hilera;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	

}
