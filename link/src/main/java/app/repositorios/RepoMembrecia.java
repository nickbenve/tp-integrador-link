package app.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import app.dominio.Membrecia;

@RepositoryRestResource(path="membrecias")
public interface RepoMembrecia extends PagingAndSortingRepository<Membrecia, Integer>{

}
