package app.repositorios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;


import app.dominio.Item_Orden;

@RepositoryRestResource(path="itemsOrdenes")
public interface RepoItem_Orden extends PagingAndSortingRepository<Item_Orden, Integer> {
	
	
	@Override	
	@RestResource(exported = false)
	void deleteById(Integer id) ;
	
	@Override
	@RestResource(exported = false)
	void delete(Item_Orden entity) ;

}
