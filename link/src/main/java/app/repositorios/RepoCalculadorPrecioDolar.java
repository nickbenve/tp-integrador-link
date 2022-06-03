package app.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;

import app.precios.CalculadorPrecioDolar;

public interface RepoCalculadorPrecioDolar extends PagingAndSortingRepository<CalculadorPrecioDolar, Integer> {

}
