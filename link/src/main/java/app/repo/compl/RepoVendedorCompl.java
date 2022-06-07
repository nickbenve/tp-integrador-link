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
	

	
	@Transactional
	@RequestMapping(method = RequestMethod.POST,value="/vendedores/{vendedorId}/crearProducto")
	public @ResponseBody String crearProducto(@PathVariable("vendedorId") Integer vendedorId,@RequestBody ProductoINPUT productoIN){
		

		
		Producto producto= new Producto();
		this.machear(producto,productoIN);

		
		Optional<Proveedor> opcionalProveedor=repoProv.findById(productoIN.getId_proveedor());
		if(opcionalProveedor.isEmpty()) {
			return "no existe un proveedor con ese id";
		}
		producto.setProveedor(opcionalProveedor.get());
		
		
		Optional<Vendedor> opcionalVendedor=repoVen.findById(vendedorId);
		if(opcionalVendedor.isEmpty()) {
			return "vendedor no encontrado";
		}
		
		
		if(opcionalProveedor.isEmpty()) {
			return "proveedor no encontrado";
		}
		
		
		if(producto.getEsPesos()) {
			repoProductos.save(producto);
			return "se guardo el producto";

		}else {
				repoProductos.save(producto);
				return "se guardo el producto";				
		}
	}



	private void machear(Producto producto, ProductoINPUT productoIN) {
		producto.setDescripcion(productoIN.getDescripcion());
		producto.setEsPesos(productoIN.getEsPesos());
		producto.setNombre(productoIN.getNombre());
		producto.setPrecio(productoIN.getPrecio());
		producto.setStock(productoIN.getStock());

	}
}
