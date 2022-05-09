package app;

import java.util.Objects;

public class Proveedor {
	private String nombre;
	private String mail;
	private String direccion;
	private String cuit;
	

	public Proveedor(String nombre, String cuit) {
		super();
		this.nombre = nombre;
		this.cuit = cuit;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cuit);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proveedor other = (Proveedor) obj;
		return Objects.equals(cuit, other.cuit);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
}
