package app.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import app.dominio.Orden;
@CrossOrigin
@RepositoryRestResource(path="ordenes")
public interface RepoOrden extends PagingAndSortingRepository<Orden, Integer> {
	@Override	
	@RestResource(exported = false)
	void deleteById(Integer id) ;
	
	@Override
	@RestResource(exported = false)
	void delete(Orden entity) ;

}
