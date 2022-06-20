package app.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Vendedor extends Rol{

	
	private String nombre;
	private Integer legajo;
	private String rol;
	
	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@ManyToMany
	private List<Proveedor> proveedores;
	

	@OneToMany
	@JoinColumn(name="id_vendedor")
	private List<Producto> productos;
	


	public Vendedor(String nombre, Integer legajo, List<Proveedor> proveedores, List<Producto> productos) {
		super();
		this.nombre = nombre;
		this.legajo = legajo;
		this.proveedores = proveedores;
		this.productos = productos;
		this.rol="vendedor";
	}

	protected Vendedor() {
		super();
		
		proveedores=new ArrayList<Proveedor>();
		productos=new ArrayList<Producto>();

	}

	public Vendedor(String nombre, Integer legajo) {
		this.nombre = nombre;
		this.legajo = legajo;	
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getLegajo() {
		return legajo;
	}

	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}

	public List<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}



	public void agregarProveedor(Proveedor proveedor) {
		proveedores.add(proveedor);
	}
	public void sacarProveedor(Proveedor proveedor)
	{
		proveedores.remove(proveedor);
	}

	public void agregarProducto(Producto producto) {
		productos.add(producto);
	}
	
	public void sacarProducto(Producto producto) {
		productos.remove(producto);
	}
}
