package estructura;

import java.util.Random;

public class HileraE implements InterfaceHilera{
	private final String tipo = "ClaseE";
	private NodoE cabeza;
	private NodoE ultimo;
	private int size;
	private  Random random = new Random();

	public HileraE() {
		// TODO Auto-generated constructor stub
	}

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

	@Override
	public void eliminar(int ind) {
		if(size > 0) {
			if(ind < size) {
				int nuevoJefe;
				if(ind == 0) {
					if(cabeza.getEnemigo().getGrado().equals("Jefe")) {
						cabeza = cabeza.getSiguiente();
						ultimo.enlazarSiguiente(cabeza);
						cabeza.enlazarAnterior(ultimo);
						size--;
						nuevoJefe = random.nextInt(size);
						this.obtener(nuevoJefe).getEnemigo().setGrado("Jefe");
					}else {
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
