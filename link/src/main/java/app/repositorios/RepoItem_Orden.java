package app.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import app.dominio.Item_Orden;

@RepositoryRestResource(path="itemsOrdenes")
public interface RepoItem_Orden extends PagingAndSortingRepository<Item_Orden, Integer> {

}
