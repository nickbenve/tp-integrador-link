package app.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import app.precios.CotizacionDolar;

@RepositoryRestResource(path="cotizacionDolar")
public interface RepoCotizacionDolar extends PagingAndSortingRepository<CotizacionDolar, Integer>{

}
