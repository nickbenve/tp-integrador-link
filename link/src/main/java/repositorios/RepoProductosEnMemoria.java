package repositorios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import app.Producto;
import excepciones.ProductoExistenteExepction;

@Repository
public class RepoProductosEnMemoria {
private List<Producto> productos;
	
	public void RepoProductosEnMem() {
		productos= new ArrayList<Producto>();
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
		}
	}
	
	
}
