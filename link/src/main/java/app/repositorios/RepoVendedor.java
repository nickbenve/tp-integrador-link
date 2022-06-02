package app.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;

import app.dominio.Vendedor;


public interface RepoVendedor extends PagingAndSortingRepository<Vendedor, Integer> {

//	public void asociarProovedor(Proveedor proveedor) throws ProveedorExistenteException {
//		
//			if(!proveedores.contains(proveedor)) {
//				proveedores.add(proveedor);
//			}else {
//				throw new ProveedorExistenteException("El empleado ya tiene a este proveedor");
//			}
//	
//		
//	}
//	
//	public void darDeBajaProveedor(Proveedor proveedor) throws ProveedorInexistenteException {
//		if(proveedores.contains(proveedor)){
//			proveedores.remove(proveedor);
//		}else {
//			throw new ProveedorInexistenteException("El empleado ya tiene a este proveedor");
//		}
//		proveedores.remove(proveedor);
//	}
//	
//	public void actualizarStock(Producto producto,Integer cantidad) throws ProductoExistenteExepction {
//		if(productos.contains(producto)) {
//			
//			//:TODO AGREGAR A REPO DE MEMORIA
//			//RepoProductosEnMemoria.agregarStock(producto,cantidad);
//		}else {
//			throw new ProductoExistenteExepction("no existe el producto");
//		}
//		
//	}
//	
//	public static void agregarProducto(Producto producto,Proveedor proveedor) {
//	producto.setProveedor(proveedor);
//	if(productos.contains(producto)) {
//		
//	}else {
//		productos.add(producto);
//		//:TODO AGREGAR A REPO DE MEMORIA
//	}
//		//RepoProcuctosEnMemoraia.save(producto)
//		productos.add(producto);
//	}
}
