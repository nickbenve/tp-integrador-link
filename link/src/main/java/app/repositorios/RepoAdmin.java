package app.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;

import app.dominio.Admin;

public interface RepoAdmin extends PagingAndSortingRepository<Admin, Integer> {

}
