package app.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import app.dominio.Admin;
import app.dominio.Promocion;

@RepositoryRestResource(path="promociones")
public interface RepoPromocion extends PagingAndSortingRepository<Promocion, Integer>{

}
