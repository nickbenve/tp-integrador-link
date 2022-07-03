package app.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import app.dominio.Producto;
@CrossOrigin
@RepositoryRestResource(path="productos")
public interface RepoProducto extends PagingAndSortingRepository<Producto, Integer> {
	


}
