package repositorios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import app.Producto;
import app.Proveedor;
import ar.tp.integrador.link.CalculadorPrecioArgentino;
import excepciones.ProductoExistenteExepction;
import excepciones.ProductoInexistenteExepction;

@Repository
public class RepoProductosEnMemoria implements RepoProductos{
private List<Producto> productos;
	
	public void RepoProductosEnMem() {
		productos= new ArrayList<Producto>();
		productos.add(new Producto("arroz","1kg", new CalculadorPrecioArgentino(50), 50, new Proveedor("Nick","111")));
	}
	
	public List<Producto> all() {
		return this.productos;
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
			throw new ProductoInexistenteExepction("No existe el producto "+ producto.getNombre());
		}
	}
	
	
}
