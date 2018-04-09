package estructura;

/**
 * Esta clase nos define los metodos que debe tener una clase de tipo hilera
 * @author luisk
 *
 */
public interface InterfaceHilera {
	
	/**
	 * Mediante este metodo se verifica el tipo de hilera que se esta tratando
	 * @return String
	 */
	public String getTipo();
	
	/**
	 * Mediante este metodo añadimos nuevos elementos a la hilera
	 * @param id
	 * @param grado
	 * @param vida
	 */
	public void add(int id,int grado,int vida);
	
	/**
	 * Este metodo permitira eliminar el nodo que se encuentre en la posicion indicada
	 * @param i
	 */
	public void eliminar(int i);
	
	/**
	 * retorna el tamaño que tiene la hilera
	 * @return int size
	 */
	public int size();
	
	/**
	 * Verifica si hay elementos contenidos dentro de la hilera
	 * @return boolean true o false
	 */
	public boolean estaVacia();

}
