package app.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import app.dominio.Producto;

@RepositoryRestResource(path="productos")
public interface RepoProducto extends PagingAndSortingRepository<Producto, Integer> {
	
	@Override	
	@RestResource(exported = false)
	void deleteById(Integer id) ;
	
	@Override
	@RestResource(exported = false)
	void delete(Producto entity) ;


}
/*
@Repository
public class RepoProductosEnMemoria implements RepoProducto{
	
	private Collection<Producto> productos;
		
	public RepoProductosEnMemoria() {
		super();
		List<Producto> of = List.of( new Producto("arroz", "1kg", new CalculadorPrecioArgentino(5.0), 50, new Proveedor("nicklandia", "4545")), new Producto("fideos", "0.5kg", new CalculadorPrecioArgentino(10.0), 50, new Proveedor("robert", "445")));
		productos = new ArrayList<Producto>(of);
	}
	
	public Collection<Producto> all() {
		return productos;
	}
	
	public Producto findByNombreYProv(String nombreYProv) {
		return productos.stream().filter(x->x.getNomYProv().equals(nombreYProv)).findFirst().get();
	}
	
	public void save(Producto producto) throws ProductoExistenteExepction {
		if(productos.contains(producto)) {
			throw new ProductoExistenteExepction("El proveedor "+producto.getProveedor().getNombre()+"ya entrega al producto"+producto.getNombre());
		}else {
			productos.add(producto);
		}
	}
	
	public void agregarStock(Producto producto,Integer cantidad) throws ProductoInexistenteExepction {
		if(productos.contains(producto)) {
			producto.agregarStock(cantidad);
		}else {
			throw new ProductoInexistenteExepction("El producto al cual se quiere agregar stock no existe");
		}
	}
	
}	
*/