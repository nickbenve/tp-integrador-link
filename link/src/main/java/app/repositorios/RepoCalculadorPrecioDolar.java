package app.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import app.precios.CalculadorPrecioDolar;

@RepositoryRestResource(path="preciosDolares")
public interface RepoCalculadorPrecioDolar extends PagingAndSortingRepository<CalculadorPrecioDolar, Integer> {

}
