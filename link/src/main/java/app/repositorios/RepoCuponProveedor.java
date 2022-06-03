package app.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;

import app.dominio.descuentos.CuponProveedor;

public interface RepoCuponProveedor extends PagingAndSortingRepository<CuponProveedor, Integer> {

}
