package app.repositorios;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import app.dominio.Persona;

@CrossOrigin
@RepositoryRestResource(path="personas")
public interface RepoPersona extends PagingAndSortingRepository<Persona, UUID> {

	Optional<Persona> findByUsuarioAndContrasenia(String usuario,String contrasenia);
	
}
