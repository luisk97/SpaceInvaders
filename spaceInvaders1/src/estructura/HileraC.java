package estructura;

//import java.util.Random;

/**
 * Esta clase corresponde a la cuarta clase de hilera la cual varia 
 * aleatoriamente la posicion del Jefe si este muere
 * @author luisk
 *
 */
public class HileraC implements InterfaceHilera{
	private final String tipo= "ClaseC";
	private NodoC cabeza;
	private NodoC ultimo;
	private int size;
//	private  Random random = new Random();

	/**
	 * Metodo constructor
	 */
	public HileraC() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Permite añadir un nuevo nodo con un enemigo con las caracteristicas 
	 * que se pasaron como parametro a la hilera
	 */
	@Override
	public void add(int i,int grado,int vida) {
		NodoC nuevo = new NodoC(new Enemigo(i,grado,vida));
		if(cabeza==null) {
			cabeza = nuevo;
			ultimo = cabeza;
			cabeza.enlazarSiguiente(ultimo);
		}else {
			ultimo.enlazarSiguiente(nuevo);
			ultimo = nuevo;
			ultimo.enlazarSiguiente(cabeza);
		}
		size++;
		
	}

	/**
	 * Este metodo permitira eliminar el nodo que se encuentre en la posicion indicada
	 * la validacion para cambiar el Jefe a otra posicion ya no se realiza aqui si no
	 * que fue mas combeniente efectuarla en la clase NaveEnemiga para que el jefe quedara
	 * en la misma posicion que en el arrayList de las naves enemigas graficas 
	 */
	@Override
	public void eliminar(int ind) {
		if(size > 0) {
			if(ind < size) {
//				int nuevoJefe;
				if(ind == 0) {
//					if(cabeza.getEnemigo().getGrado().equals("Jefe")) {
//						System.out.println("Enemigo tipo "+cabeza.getEnemigo().getGrado()+"con id:"+cabeza.getEnemigo().getId()+" eliminado");
//						cabeza = cabeza.getSiguiente();
//						ultimo.enlazarSiguiente(cabeza);
//						size--;
//						if(size != 0) {
//							nuevoJefe = random.nextInt(size);
//							this.obtener(nuevoJefe).getEnemigo().setGrado("Jefe");
//						}
//					}else {
						System.out.println("Enemigo tipo "+cabeza.getEnemigo().getGrado()+"con id:"+cabeza.getEnemigo().getId()+" eliminado");
						cabeza = cabeza.getSiguiente();
						ultimo.enlazarSiguiente(cabeza);
						size--;
//					}
				}else{
					NodoC temp = cabeza;
					for(int indice = 0;indice < (ind-1);indice++){
						temp = temp.getSiguiente();
					}
					System.out.println("Enemigo tipo "+temp.getSiguiente().getEnemigo().getGrado()+"con id:"+temp.getSiguiente().getEnemigo().getId()+" eliminado");
//					if(temp.getSiguiente().getEnemigo().getGrado().equals("Jefe")) {
//						if(ind == size-1) {
//							temp.enlazarSiguiente(cabeza);
//							ultimo = temp;
//						}else {
//						 temp.enlazarSiguiente(temp.getSiguiente().getSiguiente());
//						}
//						size--;
//						if(size != 0) {
//							nuevoJefe = random.nextInt(size);
//							this.obtener(nuevoJefe).getEnemigo().setGrado("Jefe");
//						}
//					}else {
						if(ind == size-1) {
							temp.enlazarSiguiente(null);
							ultimo = temp;
						}else {
						 temp.enlazarSiguiente(temp.getSiguiente().getSiguiente());
						}
						size--;
//					}
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
	 * @return NodoC
	 */
	public  NodoC obtener(int i) {
		if(size != 0) {
			if(i<size) {
				NodoC temp = cabeza;
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
