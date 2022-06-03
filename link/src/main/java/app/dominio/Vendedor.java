package app.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Vendedor extends Rol{

	
	private String nombre;
	private Integer legajo;
	@ManyToMany
	private List<Proveedor> proveedores;
	@OneToMany
	private List<Producto> productos;
	
	public Integer getId() {
		return id;
	}

	protected Vendedor() {
		super();
		// TODO Auto-generated constructor stub
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

	public void setId(Integer id) {
		this.id = id;
	}

	

}
