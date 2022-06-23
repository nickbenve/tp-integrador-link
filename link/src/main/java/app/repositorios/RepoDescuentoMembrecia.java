package app.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import app.dominio.descuentos.DescuentoMembrecia;
@CrossOrigin
@RepositoryRestResource(path="descuentosMembrecias")
public interface RepoDescuentoMembrecia extends PagingAndSortingRepository<DescuentoMembrecia, Integer> {

}
