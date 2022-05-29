package app.repositorios;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import app.dominio.Producto;


public interface RepoProductoSpring extends  CrudRepository<Producto, Integer>{
	
	List<Producto> all();
    Producto findByNombreYProv(String nombreYProv) ;

}
