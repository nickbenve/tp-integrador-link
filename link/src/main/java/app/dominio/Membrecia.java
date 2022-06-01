package app.dominio;

import java.util.ArrayList;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

@Entity
public class Membrecia  {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String nombre;
	
	@ManyToMany
	private  ArrayList<Cliente> miembros;
	
		
	public Membrecia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public Membrecia(String nombre) {
		super();
		this.nombre = nombre;
		miembros= new ArrayList<Cliente>();
	}
	
	public void agregarMiembro(Cliente miembro) {
		if(miembros.contains(miembro)) {
			
		}else {
			miembros.add(miembro);
		}
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Cliente> getMiembros() {
		return miembros;
	}
	public void setMiembros(ArrayList<Cliente> miembros) {
		this.miembros = miembros;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Membrecia other = (Membrecia) obj;
		return Objects.equals(nombre, other.nombre);
	}

	public boolean estaAsociado(Cliente cliente) {
		if (miembros.contains(cliente)) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	
}
