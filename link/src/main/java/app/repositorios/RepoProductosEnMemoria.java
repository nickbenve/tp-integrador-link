package app.repositorios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import app.dominio.Producto;
import app.dominio.Proveedor;
import app.excepciones.ProductoExistenteExepction;
import app.excepciones.ProductoInexistenteExepction;
import app.precios.CalculadorPrecioArgentino;

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
			throw new ProductoExistenteExepction(producto);
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
