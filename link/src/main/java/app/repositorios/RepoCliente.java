package app.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import app.dominio.Cliente;



public interface RepoCliente extends PagingAndSortingRepository<Cliente, Integer>{
	@Override	
	@RestResource(exported = false)
	void deleteById(Integer id) ;
	
	@Override
	@RestResource(exported = false)
	void delete(Cliente entity) ;
}
