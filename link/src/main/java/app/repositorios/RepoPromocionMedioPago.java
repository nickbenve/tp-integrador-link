package app.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;

import app.dominio.descuentos.PromocionMedioPago;

public interface RepoPromocionMedioPago extends PagingAndSortingRepository<PromocionMedioPago, Integer> {

}
