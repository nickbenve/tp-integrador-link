package app.repositorios;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import app.dominio.Admin;
import app.dominio.Rol;

@RepositoryRestResource(path="roles")
public interface RepoRol extends PagingAndSortingRepository<Rol, UUID>{

}
