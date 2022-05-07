package app;

import java.time.LocalDate;
import java.util.ArrayList;

import excepciones.ProductoExistenteExepction;
import excepciones.ProveedorExistenteException;
import excepciones.ProveedorInexistenteException;
import repositorios.RepoProductosEnMemoria;

public class Vendedor {
	private String nombre;
	private Integer legajo;
	private LocalDate fechaIngreso;
	private ArrayList<Proveedor> proveedores;
	private ArrayList<Producto> productos;
	
	

	public Vendedor(String nombre, Integer legajo) {
		super();
		this.nombre = nombre;
		this.legajo = legajo;
		this.fechaIngreso=LocalDate.now();
		this.proveedores=new ArrayList<>();
		this.productos=new ArrayList<>();
		
	}

	public void asociarProovedor(Proveedor proveedor) throws ProveedorExistenteException {
		
			if(!proveedores.contains(proveedor)) {
				proveedores.add(proveedor);
			}else {
				throw new ProveedorExistenteException("El empleado ya tiene a este proveedor");
			}
	
		
	}
	
	public void darDeBajaProveedor(Proveedor proveedor) throws ProveedorInexistenteException {
		if(proveedores.contains(proveedor)){
			proveedores.remove(proveedor);
		}else {
			throw new ProveedorInexistenteException("El empleado ya tiene a este proveedor");
		}
		proveedores.remove(proveedor);
	}
	
	public void actualizarStock(Producto producto,Integer cantidad) throws ProductoExistenteExepction {
		if(productos.contains(producto)) {
			
			//:TODO AGREGAR A REPO DE MEMORIA
			//RepoProductosEnMemoria.agregarStock(producto,cantidad);
		}else {
			throw new ProductoExistenteExepction("no existe el producto");
		}
		
	}
	
	public void agregarProducto(Producto producto,Proveedor proveedor) {
	producto.setProveedor(proveedor);
	if(productos.contains(producto)) {
		
	}else {
		productos.add(producto);
		//:TODO AGREGAR A REPO DE MEMORIA
	}
		//RepoProcuctosEnMemoraia.save(producto)
		productos.add(producto);
	}

}
