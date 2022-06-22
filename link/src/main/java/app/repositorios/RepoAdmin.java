package app.repositorios;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import app.dominio.Admin;
@CrossOrigin
@RepositoryRestResource(path="admins")
public interface RepoAdmin extends PagingAndSortingRepository<Admin, UUID> {

	
}
