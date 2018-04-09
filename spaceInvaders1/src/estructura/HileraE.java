package estructura;

import java.util.Random;

/**
 * Esta clase corresponde a la quinta clase de hilera la cual debe girar como un
 * reloj en la pantalla
 * @author luisk
 *
 */
public class HileraE implements InterfaceHilera{
	private final String tipo = "ClaseE";
	private NodoE cabeza;
	private NodoE ultimo;
	private int size;
	private  Random random = new Random();

	/**
	 * Metodo constructor
	 */
	public HileraE() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Permite añadir un nuevo nodo con un enemigo con las caracteristicas 
	 * que se pasaron como parametro a la hilera
	 */
	@Override
	public void add(int i,int grado,int vida) {
		NodoE nuevo = new NodoE(new Enemigo(i,grado,vida));
		if(cabeza==null) {
			cabeza = nuevo;
			ultimo = cabeza;
			cabeza.enlazarSiguiente(ultimo);
			cabeza.enlazarAnterior(ultimo);
			ultimo.enlazarSiguiente(cabeza);
			ultimo.enlazarAnterior(cabeza);
		}else {
			ultimo.enlazarSiguiente(nuevo);
			nuevo.enlazarAnterior(ultimo);
			ultimo = nuevo;
			ultimo.enlazarSiguiente(cabeza);
			cabeza.enlazarAnterior(ultimo);
			
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
						System.out.println("Enemigo tipo "+cabeza.getEnemigo().getGrado()+"con id:"+cabeza.getEnemigo().getId()+" eliminado");
						cabeza = cabeza.getSiguiente();
						ultimo.enlazarSiguiente(cabeza);
						cabeza.enlazarAnterior(ultimo);
						size--;
						if(size != 0) {
							nuevoJefe = random.nextInt(size);
							this.obtener(nuevoJefe).getEnemigo().setGrado("Jefe");
						}
					}else {
						System.out.println("Enemigo tipo "+cabeza.getEnemigo().getGrado()+"con id:"+cabeza.getEnemigo().getId()+" eliminado");
						cabeza = cabeza.getSiguiente();
						ultimo.enlazarSiguiente(cabeza);
						cabeza.enlazarAnterior(ultimo);
						size--;
					}
				}else{
					NodoE temp = cabeza;
					for(int indice = 0;indice < ind;indice++){
						temp = temp.getSiguiente();
					}
					System.out.println("Enemigo tipo "+temp.getEnemigo().getGrado()+"con id:"+temp.getEnemigo().getId()+" eliminado");
					if(temp.getEnemigo().getGrado().equals("Jefe")) {
						if(ind == size-1) {
							temp.getAnterior().enlazarSiguiente(cabeza);
							cabeza.enlazarAnterior(temp.getAnterior());
							ultimo = cabeza.getAnterior();
						}else {
						 temp.getAnterior().enlazarSiguiente(temp.getSiguiente());
						 temp.getSiguiente().enlazarAnterior(temp.getAnterior());
						}
						size--;
						nuevoJefe = random.nextInt(size);
						this.obtener(nuevoJefe).getEnemigo().setGrado("Jefe");
					}else {
						if(ind == size-1) {
							temp.getAnterior().enlazarSiguiente(cabeza);
							cabeza.enlazarAnterior(temp.getAnterior());
							ultimo = cabeza.getAnterior();
						}else {
							temp.getAnterior().enlazarSiguiente(temp.getSiguiente());
							temp.getSiguiente().enlazarAnterior(temp.getAnterior());
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
	 * @return NodoE
	 */
	public  NodoE obtener(int i) {
		if(size != 0) {
			if(i<size) {
				NodoE temp = cabeza;
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
