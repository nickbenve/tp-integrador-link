package app.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import app.dominio.Vendedor;

@RepositoryRestResource(path="vendedores")
public interface RepoVendedor extends PagingAndSortingRepository<Vendedor, Integer> {



}