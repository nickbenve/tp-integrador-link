package app.dominio;

import java.util.ArrayList;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Membrecia  {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String nombre;
	
	@Transient
	private  ArrayList<Cliente> miembros;
	private Double descuento;
	

	public void utilizar() {
	};

	
	public Membrecia(String nombre, Double descuento) {
		super();
		this.nombre = nombre;
		this.descuento = descuento;
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
	public Double getDescuento() {
		return descuento;
	}
	public void setDescuento(Double descuento) {
		this.descuento = descuento;
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
