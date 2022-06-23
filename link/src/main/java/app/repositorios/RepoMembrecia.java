package app.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import app.dominio.Membrecia;
@CrossOrigin
@RepositoryRestResource(path="membrecias")
public interface RepoMembrecia extends PagingAndSortingRepository<Membrecia, Integer>{

}
