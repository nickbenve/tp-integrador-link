package app;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.stereotype.Component;

import app.dominio.Carrito;
import app.dominio.Producto;


@Component
public class InitData implements CommandLineRunner  {
	
	@Autowired
	RepositoryRestConfiguration config;
	
	@Override
	public void run(String... args) throws Exception {
		config.exposeIdsFor(Producto.class,Carrito.class);
		
		}
		

}


