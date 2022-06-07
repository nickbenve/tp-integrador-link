package app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.stereotype.Component;

import app.dominio.Producto;
import app.dominio.Proveedor;
import app.precios.CotizacionDolar;
import app.repositorios.RepoCotizacionDolar;


@Component
public class InitData implements CommandLineRunner {
 
	@Autowired
	RepoCotizacionDolar repo; 
	
	@Autowired
	RepositoryRestConfiguration config;
	
	@Override
	public void run(String... args) throws Exception {
		config.exposeIdsFor(Producto.class,Proveedor.class);
		
		if(repo.count() == 0) {
			CotizacionDolar cotizacion= new CotizacionDolar();
			repo.save(cotizacion);
		}
		

	}

}
