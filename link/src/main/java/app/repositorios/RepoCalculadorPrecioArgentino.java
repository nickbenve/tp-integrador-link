package app.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;

import app.precios.CalculadorPrecioArgentino;

public interface RepoCalculadorPrecioArgentino extends PagingAndSortingRepository<CalculadorPrecioArgentino, Integer> {

}
