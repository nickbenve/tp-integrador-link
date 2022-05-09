package app;

import java.util.ArrayList;
import java.util.Objects;

public class Membrecia implements Promocion  {
	private String nombre;
	private  ArrayList<Cliente> miembros;
	private Float descuento;
	
	public Double descuento(Orden orden) {
		return (1-this.getDescuento())*orden.costoTotal();
	}
	
	public void utilizar() {
	};

	
	public Membrecia(String nombre, Float descuento) {
		super();
		this.nombre = nombre;
		this.descuento = descuento;
		miembros= new ArrayList<Cliente>();
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
	public Float getDescuento() {
		return descuento;
	}
	public void setDescuento(Float descuento) {
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
	
	
	
	
}
