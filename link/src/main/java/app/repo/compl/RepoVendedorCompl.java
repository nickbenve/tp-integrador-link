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
	
//PROVEEDORES
	@Transactional
	@RequestMapping(method = RequestMethod.POST,value="/vendedores/{vendedorId}/asociarProveedor")
	public @ResponseBody String asociarProveedor(@PathVariable("vendedorId") Integer vendedorId,@RequestBody Integer id_proveedor) {
	
		Optional<Vendedor> opcionalVendedor=repoVen.findById(vendedorId);
		if(opcionalVendedor.isEmpty()) {
			return "vendedor no encontrado";
		}
		Optional<Proveedor> opcionalProveedor=repoProv.findById(id_proveedor);
		if(opcionalProveedor.isEmpty()) {
			return "no existe un proveedor con ese id";
		}
		if(opcionalVendedor.get().getProveedores().contains(opcionalProveedor.get())) {
			return "ya se encuentra asociado a ese proveedor";
		}else {
			opcionalVendedor.get().agregarProveedor(opcionalProveedor.get());
			return "Se agrego el proveedor al vendedor";
		}		
	}
	@Transactional
	@RequestMapping(method = RequestMethod.DELETE,value="/vendedores/{vendedorId}/desAsociarProveedor")
	public @ResponseBody String desAsociarProveedor(@PathVariable("vendedorId") Integer vendedorId,@RequestBody Integer id_proveedor) {
	
		Optional<Vendedor> opcionalVendedor=repoVen.findById(vendedorId);
		if(opcionalVendedor.isEmpty()) {
			return "vendedor no encontrado";
		}
		Optional<Proveedor> opcionalProveedor=repoProv.findById(id_proveedor);
		if(opcionalProveedor.isEmpty()) {
			return "no existe un proveedor con ese id";
		}
		if(opcionalVendedor.get().getProveedores().contains(opcionalProveedor.get())) {
			opcionalVendedor.get().sacarProveedor(opcionalProveedor.get());
			return "se desasocio con el proveedor";
		}else {
			return "El vendedor no tiene asociado el proveedor enviado";
		}		
	}
	
	
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

//CREAR PRODUCTO	
	@Transactional
	@RequestMapping(method = RequestMethod.POST,value="/vendedores/{vendedorId}/crearProducto")
	public @ResponseBody String crearProducto(@PathVariable("vendedorId") Integer vendedorId,@RequestBody ProductoINPUT productoIN){
		
		
		Optional<Vendedor> opcionalVendedor=repoVen.findById(vendedorId);
		if(opcionalVendedor.isEmpty()) {
			return "vendedor no encontrado";
		}
		
		Producto producto= new Producto();
		this.machearProductoNuevo(producto,productoIN);
	
		Optional<Proveedor> opcionalProveedor=repoProv.findById(productoIN.getId_proveedor());
		if(opcionalProveedor.isEmpty()) {
			return "no existe un proveedor con ese id";
		}
		producto.setProveedor(opcionalProveedor.get());
		
		
		
		
		
		if(opcionalProveedor.isEmpty()) {
			return "proveedor no encontrado";
		}
		
		repoProductos.save(producto);
		return "se creo correctamente el producto";

	}

//SACAR PRODUCTO
	@Transactional
	@RequestMapping(method = RequestMethod.DELETE,value="/vendedores/{vendedorId}/eliminarProducto")
	public @ResponseBody String eliminarProducto(@PathVariable("vendedorId") Integer vendedorId,@RequestBody Integer id_producto){
		
		Optional<Vendedor> opcionalVendedor=repoVen.findById(vendedorId);
		if(opcionalVendedor.isEmpty()) {
			return "vendedor no encontrado";
		}
		
		Optional<Producto> opcionalProducto=repoProductos.findById(id_producto);

		if(opcionalProducto.isEmpty()) {
			return "no existe ese producto";
		}else{
//			:TODO ACA TENDRIA Q VER REALMENTE Q ESTE EN SU LISTA, tambien, aparte de existir
			repoProductos.delete(opcionalProducto.get());
			opcionalVendedor.get().sacarProducto(opcionalProducto.get());
			return "se elimino correctamente el producto";
		}

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
