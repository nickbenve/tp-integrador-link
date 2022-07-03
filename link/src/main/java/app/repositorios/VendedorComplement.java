package app.repositorios;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.DTO.ProductoDTO;
import app.dominio.Producto;
import app.dominio.Proveedor;
import app.dominio.Vendedor;

@CrossOrigin
@RestController
@RequestMapping("/vendedor")
public class VendedorComplement {
	
	@Autowired
	RepoVendedor repoVen;
	
	@Autowired
	RepoProducto repoProd;
	@Autowired
	RepoProveedor repoProv;

	@Transactional
	@RequestMapping(method = RequestMethod.POST,value="/{vendedorID}/productos")
	public @ResponseBody void registrarProducto(@PathVariable("vendedorID") UUID vendedorID,
			@RequestBody ProductoDTO productoIn) {
		
		Optional<Vendedor> vendedorOp=repoVen.findById(vendedorID);
		
		Producto producto= new Producto();
		
		producto.setNombre(productoIn.getNombre());
		producto.setDescripcion(productoIn.getDescripcion());
		producto.setFoto(productoIn.getFoto());
		producto.setEsPesos(productoIn.getEsPesos());
		producto.setPrecio(productoIn.getPrecio());
		producto.setStock(productoIn.getStock());
		Integer id=productoIn.getIdProveedor();
		Optional<Proveedor> proveedorOp=repoProv.findById(id);
		producto.setProveedor(proveedorOp.get());
		
		repoProd.save(producto);
		vendedorOp.get().agregarProducto(producto);
				
		
		
		
	}
	@Transactional
	@RequestMapping(method = RequestMethod.GET,value="/{vendedorID}/productos/page")
	public @ResponseBody Page<Producto> get(@PathVariable("vendedorID") UUID vendedorID,Pageable pageable) {
		
		Optional<Vendedor> vendedorOp=repoVen.findById(vendedorID);
		
		Vendedor vendedor = vendedorOp.get();
		

		
		final int start = (int)pageable.getOffset();
		final int end = Math.min((start + pageable.getPageSize()), vendedor.getProductos().size());
		if(start<end) {
			final Page<Producto> page = new PageImpl<>(vendedor.getProductos().subList(start, end), pageable,vendedor.getProductos().size());
			return page;
		}
		else {
			final Page<Producto> page = new PageImpl<>(List.of(), pageable,vendedor.getProductos().size());
			return page;
		}
		

		
		
		
	}
	
}
