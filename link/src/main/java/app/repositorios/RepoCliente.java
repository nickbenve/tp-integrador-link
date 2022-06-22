package app.repositorios;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import app.dominio.Cliente;


@CrossOrigin
@RepositoryRestResource(path="clientes")
public interface RepoCliente extends PagingAndSortingRepository<Cliente, UUID>{
	

}
