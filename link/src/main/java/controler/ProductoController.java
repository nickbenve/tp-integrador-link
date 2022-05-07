package controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import repositorios.RepoProductosEnMemoria;

@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private RepoProductosEnMemoria repo;
	
}
