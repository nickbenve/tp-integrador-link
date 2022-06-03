package app.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import app.dominio.descuentos.CuponProveedor;

@RepositoryRestResource(path="cuponesProveedorees")
public interface RepoCuponProveedor extends PagingAndSortingRepository<CuponProveedor, Integer> {

}
