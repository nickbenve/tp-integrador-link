package app;

import java.time.LocalDate;
import java.util.ArrayList;

public class Vendedor {
	private String nombre;
	private Integer legajo;
	private LocalDate fechaIngreso;
	private ArrayList<Proveedor> proveedores;
	
	

	public Vendedor(String nombre, Integer legajo) {
		super();
		this.nombre = nombre;
		this.legajo = legajo;
		this.fechaIngreso=LocalDate.now();
	}

	public void asociarProovedor(Proveedor proveedor) {
		proveedores.add(proveedor);
	}
	
	public void darDeBajaProveedor(Proveedor proveedor) {
		proveedores.remove(proveedor);
	}
	
	public void actualizarStock(Producto producto,Integer cantidad) {
		
	}
	

}
