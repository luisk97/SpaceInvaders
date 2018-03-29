package estructura;

public class Hilera implements InterfaceHilera{
//	private int velocidad;
	private  final String tipo = "Basica";
	private Nodo cabeza;
	private Nodo ultimo;
	private int size;
	

	public Hilera() {
		cabeza = null;
		ultimo = null;
		size = 0;
	}

//
//	public int getVelocidad() {
//		return velocidad;
//	}
//
//
//	public void setVelocidad(int velocidad) {
//		this.velocidad = velocidad;
//	}
//

	public Nodo getCabeza() {
		return cabeza;
	}


	public void add(int i,int grado,int vida) {
		Nodo nuevo = new Nodo(new Enemigo(i,grado,vida));
		if(cabeza==null) {
			cabeza = nuevo;
			ultimo = cabeza;
		}else {
			Nodo temp = ultimo;
			temp.enlazarSiguiente(nuevo);
			ultimo = nuevo;
		}
		size++;
	}
	
	public void eliminar(int ind) {
		if(ind < size) {
			if(ind == 0) {
				System.out.println("Enemigo tipo "+cabeza.getEnemigo().getGrado()+"con id:"+cabeza.getEnemigo().getId()+" eliminado");
				cabeza = cabeza.getSiguiente();
			}else{
				Nodo temp = cabeza;
				for(int i = 0;i < (ind-1);i++) {
					temp = temp.getSiguiente();
				}
				System.out.println("Enemigo tipo "+temp.getEnemigo().getGrado()+"con id:"+temp.getEnemigo().getId()+" eliminado");
				if(ind == size-1) {
					temp.enlazarSiguiente(null);
					ultimo = temp;
				}else {
				 temp.enlazarSiguiente(temp.getSiguiente().getSiguiente());
				}
			}
			size--;
			System.out.println("Enemigo eliminado");
		}else {
			System.out.println("Indice no valido");
		}
		
	}


	@Override
	public int size() {
		return size;
	}


	@Override
	public boolean estaVacia() {
		return size==0;
	}

	@Override
	public String getTipo() {
		return tipo;
	}

	public Nodo obtener(int i) {
		if(size != 0) {
			if(i<size) {
				Nodo temp = cabeza;
		        while(0 < i){
		            temp = temp.getSiguiente();
		            i--;
		        }
		        return temp;
			}else {
				System.out.println("Indice no valido");
			}
		}else {
			System.out.println("Hilera vacia");
		}
		return null;
	}
	

}
