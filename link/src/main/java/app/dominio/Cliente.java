package app.dominio;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Cliente extends Rol{
	

	
	private String nombre;
	private String dni;
	private String rol="cliente";
	

	
	@Override
	public int hashCode() {
		return Objects.hash(dni, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(dni, other.dni) && Objects.equals(nombre, other.nombre);
	}

	@OneToMany
	private List<Orden> compras;

	public Cliente(String nombre, String dni) {
		this.nombre = nombre;
		this.dni = dni;
	}

	public Cliente(String nombre, String dni, List<Orden> compras) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.compras = compras;
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
