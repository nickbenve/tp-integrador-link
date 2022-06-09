package app.repositorios;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import app.dominio.Admin;
import app.dominio.Carrito;


@RepositoryRestResource(path="carritos")
public interface RepoCarrito extends PagingAndSortingRepository<Carrito, Integer> {
	
	

}
