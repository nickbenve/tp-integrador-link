package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import app.repositorios.RepoOrden;

@RepositoryRestController
public class ClienteControllerComplement {
	
	
	@Autowired
	RepoOrden repoOrden;
	

}
