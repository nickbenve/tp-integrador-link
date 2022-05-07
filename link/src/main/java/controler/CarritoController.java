package controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import repositorios.RepoCarrito;

@RestController
@RequestMapping("/productos")
public class CarritoController {

	@Autowired
	private RepoCarrito repo;
	
	
}