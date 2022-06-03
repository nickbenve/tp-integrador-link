package app.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;

import app.dominio.Item_Orden;

public interface RepoItem_Orden extends PagingAndSortingRepository<Item_Orden, Integer> {

}
