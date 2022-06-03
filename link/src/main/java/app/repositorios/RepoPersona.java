package app.repositorios;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import app.dominio.Persona;


@RepositoryRestResource(path="personas")
public interface RepoPersona extends PagingAndSortingRepository<Persona, Integer> {
	@Override	
	@RestResource(exported = false)
	void deleteById(Integer id) ;
	
	@Override
	@RestResource(exported = false)
	void delete(Persona entity) ;

	Optional<Persona> findByUsuario(String usuario);
	
}
