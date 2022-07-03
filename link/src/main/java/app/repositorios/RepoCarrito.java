package app.repositorios;


import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import app.dominio.Carrito;
import app.dominio.Cliente;

@CrossOrigin
@RepositoryRestResource(path="carritos")
public interface RepoCarrito extends PagingAndSortingRepository<Carrito, Integer> {
	
	public Optional<Carrito> findByCliente(Cliente cliente);

}
