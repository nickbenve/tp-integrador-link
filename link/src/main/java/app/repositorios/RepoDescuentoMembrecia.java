package app.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;

import app.dominio.descuentos.DescuentoMembrecia;

public interface RepoDescuentoMembrecia extends PagingAndSortingRepository<DescuentoMembrecia, Integer> {

}
