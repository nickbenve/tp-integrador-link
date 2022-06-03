package app.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import app.dominio.descuentos.PromocionMedioPago;

@RepositoryRestResource(path="promocionesMediosDePago")
public interface RepoPromocionMedioPago extends PagingAndSortingRepository<PromocionMedioPago, Integer> {

}
