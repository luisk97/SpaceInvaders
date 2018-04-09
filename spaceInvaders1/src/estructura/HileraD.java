package estructura;

import java.util.Random;

/**
 * Esta clase corresponde a la quinta clase de hilera la cual cambia la posicion
 *  del Jefe si este muere y se mantiene ordenada de mayor a menor segun la vida 
 *  del enemigo contenido en cada nodo
 * @author luisk
 *
 */
public class HileraD implements InterfaceHilera{
	private final String tipo = "ClaseD";
	private NodoD cabeza;
	private NodoD ultimo;
	private int size;
	private  Random random = new Random();
	private boolean flag;

	/**
	 * Metodo constructor
	 */
	public HileraD() {
		cabeza = null;
		ultimo = null;
		size = 0;
		flag = true;
	}

	/**
	 * Permite añadir un nuevo nodo con un enemigo con las caracteristicas 
	 * que se pasaron como parametro a la hilera
	 */
	@Override
	public void add(int i,int grado,int vida) {
		NodoD nuevo = new NodoD(new Enemigo(i,grado,vida));
		if(cabeza==null) {
			cabeza = nuevo;
			ultimo = cabeza;
			cabeza.enlazarSiguiente(ultimo);
		}else {
			NodoD temp = ultimo;
			temp.enlazarSiguiente(nuevo);
			ultimo = nuevo;
			ultimo.enlazarSiguiente(cabeza);
		}
		size++;
		
	}

	/**
	 * Este metodo permitira eliminar el nodo que se encuentre en la posicion indicada
	 */
	@Override
	public void eliminar(int ind) {
		if(size > 0) {
			if(ind < size) {
				int nuevoJefe;
				if(ind == 0) {
					if(cabeza.getEnemigo().getGrado().equals("Jefe")) {
						cabeza = cabeza.getSiguiente();
						ultimo.enlazarSiguiente(cabeza);
						size--;
						if(size != 0) {
							nuevoJefe = random.nextInt(size);
							this.obtener(nuevoJefe).getEnemigo().setGrado("Jefe");
						}
					}else {
						cabeza = cabeza.getSiguiente();
						ultimo.enlazarSiguiente(cabeza);
						size--;
					}
				}else{
					NodoD temp = cabeza;
					for(int indice = 0;indice < (ind-1);indice++){
						temp = temp.getSiguiente();
					}
					if(temp.getSiguiente().getEnemigo().getGrado().equals("Jefe")) {
						if(ind == size-1) {
							temp.enlazarSiguiente(cabeza);
							ultimo = temp;
						}else {
						 temp.enlazarSiguiente(temp.getSiguiente().getSiguiente());
						}
						size--;
						nuevoJefe = random.nextInt(size);
						this.obtener(nuevoJefe).getEnemigo().setGrado("Jefe");
					}else {
						if(ind == size-1) {
							temp.enlazarSiguiente(null);
							ultimo = temp;
						}else {
						 temp.enlazarSiguiente(temp.getSiguiente().getSiguiente());
						}
						size--;
					}
				}
				System.out.println("Enemigo eliminado");
			}else {
				System.out.println("Indice no valido");
			}
		}else {
			System.out.println("Hilera vacia");
		}
	}
	
	/**
	 * este metodo realizara un ordenamiento de los nodos de acuerdo al valor
	 * que tenga el atributo vida del enemigo contenido dentro del nodo 
	 * ordenandolos de mayor a menor
	 */
	public void burbuja() {
		NodoD aux;
		NodoD temp;
		while(flag) {
			flag = false;
			temp = ultimo;
			for(int i = 0; i < size-1; i++) {
				if(temp.getSiguiente().getEnemigo().getVida() < temp.getSiguiente().getSiguiente().getEnemigo().getVida()) {
					if(i == 0) {
						aux = cabeza.getSiguiente();
						temp.getSiguiente().enlazarSiguiente(aux.getSiguiente());
						aux.enlazarSiguiente(cabeza);
						cabeza = aux;
						temp.enlazarSiguiente(cabeza);
					}else if(i == size-2) {
						aux = temp.getSiguiente().getSiguiente();
						temp.getSiguiente().enlazarSiguiente(cabeza);
						aux.enlazarSiguiente(temp.getSiguiente());
						ultimo = temp.getSiguiente();
						temp.enlazarSiguiente(aux);
					}else {
						aux = temp.getSiguiente().getSiguiente();
						temp.getSiguiente().enlazarSiguiente(aux.getSiguiente());
						aux.enlazarSiguiente(temp.getSiguiente());
						temp.enlazarSiguiente(aux);
					}
					flag = true;
				}
				temp = temp.getSiguiente();
			}
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

	/**
	 * Permitira obtener el nodo que se encuentre en la posicion que se 
     * paso como parametro
	 * @param i
	 * @return NodoD
	 */
	public  NodoD obtener(int i) {
		if(size != 0) {
			if(i<size) {
				NodoD temp = cabeza;
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
