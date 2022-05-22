package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cliente implements Rol{
	private String nombre;
	private String dni;
	private List<Orden> compras;
	
	public Cliente(String nombre, String dni) {
		this.nombre = nombre;
		this.dni = dni;
		compras= new ArrayList<Orden>();
	}



	@Override
	public int hashCode() {
		return Objects.hash(dni);
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
		return Objects.equals(dni, other.dni);
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
