package app.repo.compl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import app.repositorios.RepoCarrito;

@RepositoryRestController
public class RepoCarritoCompl {
	
	@Autowired 
	RepoCarrito repoCarritos;
	
	

}
