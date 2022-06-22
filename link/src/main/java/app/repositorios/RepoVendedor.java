package app.repositorios;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import app.dominio.Vendedor;

@CrossOrigin
@RepositoryRestResource(path="vendedores")
public interface RepoVendedor extends PagingAndSortingRepository<Vendedor, UUID> {



}