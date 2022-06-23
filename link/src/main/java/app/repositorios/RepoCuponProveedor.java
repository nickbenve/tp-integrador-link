package app.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import app.dominio.descuentos.CuponProveedor;
@CrossOrigin
@RepositoryRestResource(path="cuponesProveedorees")
public interface RepoCuponProveedor extends PagingAndSortingRepository<CuponProveedor, Integer> {

}
