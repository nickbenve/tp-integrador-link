package app.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import app.precios.CalculadorPrecioArgentino;

@RepositoryRestResource(path="preciosArgentinos")
public interface RepoCalculadorPrecioArgentino extends PagingAndSortingRepository<CalculadorPrecioArgentino, Integer> {

}
