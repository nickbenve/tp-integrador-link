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

import app.DTO.ProductoINPUT;
import app.DTO.StockINPUT;
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
	

//	ACTUALIZAR STOCK
	
	@Transactional
	@RequestMapping(method = RequestMethod.POST,value="/vendedores/{vendedorId}/agregarStock")
	public @ResponseBody String agregarStock(@PathVariable("vendedorId") Integer vendedorId,@RequestBody StockINPUT stockCarga) {
		
		Optional<Vendedor> opcionalVendedor=repoVen.findById(vendedorId);
		if(opcionalVendedor.isEmpty()) {
			return "vendedor no encontrado";
		}
		
		
		Optional<Producto> opcionalProducto=repoProductos.findById(stockCarga.getId_producto());
		if(opcionalProducto.isEmpty()) {
			return "no existe el producto";
		}
//		if(!opcionalVendedor.get().getProductos().contains(opcionalProducto.get())) {
//			return "El vendedor no contiene al producto";
//		}else {
			opcionalProducto.get().agregarStock(stockCarga.getCantidad());
			return "se actualizo el stock";
//		}:TODO ACA tendria q ver solo sus productos?
	}

	
	@Transactional
	@RequestMapping(method = RequestMethod.POST,value="/vendedores/{vendedorId}/crearProducto")
	public @ResponseBody String crearProducto(@PathVariable("vendedorId") Integer vendedorId,@RequestBody ProductoINPUT productoIN){
		
		Producto producto= new Producto();
		this.machearProductoNuevo(producto,productoIN);
	
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
		
		repoProductos.save(producto);
		return "se creo correctamente el producto";

	}


	
//	MACHEADORES

	private void machearProductoNuevo(Producto producto, ProductoINPUT productoIN) {
		producto.setDescripcion(productoIN.getDescripcion());
		producto.setEsPesos(productoIN.getEsPesos());
		producto.setNombre(productoIN.getNombre());
		producto.setPrecio(productoIN.getPrecio());
		producto.setStock(productoIN.getStock());

	}
}
