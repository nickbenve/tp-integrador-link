package app.dominio;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Cliente extends Rol{
	

	
	private String nombre;
	private String dni;
	private String rol="cliente";
	
	@OneToMany
	private List<Orden> compras;

	public Cliente(String nombre, String dni) {
		this.nombre = nombre;
		this.dni = dni;
	}


	public String getRol() {
		return rol;
	}


	public void setRol(String rol) {
		this.rol = rol;
	}


	public void setCompras(List<Orden> compras) {
		this.compras = compras;
	}


	protected Cliente() {
		super();
		this.rol="cliente";
		// TODO Auto-generated constructor stub
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public List<Orden> getCompras() {
		return compras;
	}

	public void agregarCompra(Orden orden) {
		compras.add(orden);
	}
	
}
