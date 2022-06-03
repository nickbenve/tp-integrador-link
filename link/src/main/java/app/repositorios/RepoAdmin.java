package app.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import app.dominio.Admin;

@RepositoryRestResource(path="administradores")
public interface RepoAdmin extends PagingAndSortingRepository<Admin, Integer> {

	
}