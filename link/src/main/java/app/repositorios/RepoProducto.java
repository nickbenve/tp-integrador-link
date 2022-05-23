package app.repositorios;


import java.util.Collection;


import app.dominio.Producto;
import app.excepciones.ProductoExistenteExepction;
import app.excepciones.ProductoInexistenteExepction;

public interface RepoProducto {
	
	public Collection<Producto> all();
	
	public Producto findByNombreYProv(String nombreYProv) ;
	
	public void save(Producto producto) throws ProductoExistenteExepction;
	public void agregarStock(Producto producto,Integer cantidad) throws ProductoInexistenteExepction;
	
}
