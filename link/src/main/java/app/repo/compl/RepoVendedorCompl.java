package app.repo.compl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import app.dominio.Producto;
import app.dominio.Proveedor;
import app.dominio.Vendedor;
import app.precios.CotizacionDolar;
import app.repositorios.RepoCotizacionDolar;
import app.repositorios.RepoProducto;
import app.repositorios.RepoProveedor;
import app.repositorios.RepoVendedor;
@RepositoryRestController
public class RepoVendedorCompl {
	@Autowired
	RepoProducto repoProductos;
	
	@Autowired
	RepoProveedor repoProv;
		
	@Autowired
	RepoVendedor repoVen;
	
	@Autowired
	RepoCotizacionDolar repoDolar;
	

	
	@Transactional
	@RequestMapping(method = RequestMethod.POST,value="/vendedores/{vendedorId}/crearProducto")
	public @ResponseBody String crearProducto(@PathVariable("vendedorId") Integer vendedorId,@RequestBody Producto producto){
		
		Optional<CotizacionDolar> cotizacion=repoDolar.findById(1);
		
		CotizacionDolar dolar= cotizacion.get();
		Optional<Vendedor> opcionalVendedor=repoVen.findById(vendedorId);
		if(opcionalVendedor.isEmpty()) {
			return "vendedor no encontrado";
		}
		
		Optional<Proveedor> opcionalProveedor=repoProv.findById(producto.getProveedor().getId());
		
		if(opcionalProveedor.isEmpty()) {
			return "proveedor no encontrado";
		}
		
		
		if(producto.getEsPesos()) {
			repoProductos.save(producto);
			return "se guardo el producto";

		}else {
				producto.setCotizador(dolar);
				repoProductos.save(producto);
				return "se guardo el producto";				
		}
	}
}
