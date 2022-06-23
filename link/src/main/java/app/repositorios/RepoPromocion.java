package app.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import app.dominio.Admin;
import app.dominio.Promocion;
@CrossOrigin
@RepositoryRestResource(path="promociones")
public interface RepoPromocion extends PagingAndSortingRepository<Promocion, Integer>{

}
