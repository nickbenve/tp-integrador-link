package app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;


import ar.tp.integrador.link.Producto;

@Repository
public class RepoProductos {
	private List<Producto> productos;
	
	public void RepoProductosEnMem() {
		productos= new ArrayList<Producto>();
	}
	
	public List<Producto> all() {
		return this.productos;
	}
	
	public Producto findById(Integer codigo) {
		return productos.stream().filter(x->x.getId().equals(codigo)).findFirst().get();
	}
	
	public void save(Producto producto) throws ProductoExistenteExepction {
		if(productos.contains(producto)) {
			throw new ProductoExistenteExepction(producto);
		}else {
			productos.add(producto);
		}
	}
	
}
