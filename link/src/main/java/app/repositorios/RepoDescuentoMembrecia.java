package app.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import app.dominio.descuentos.DescuentoMembrecia;

@RepositoryRestResource(path="descuentosMembrecias")
public interface RepoDescuentoMembrecia extends PagingAndSortingRepository<DescuentoMembrecia, Integer> {

}
