package app.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import app.dominio.Orden;


public interface RepoOrden extends PagingAndSortingRepository<Orden, Integer> {
	@Override	
	@RestResource(exported = false)
	void deleteById(Integer id) ;
	
	@Override
	@RestResource(exported = false)
	void delete(Orden entity) ;

}
