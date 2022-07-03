package app.dominio;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;


@Entity 
public class Proveedor {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String nombre;
	private String mail;
	private String direccion;
	private String cuit;
	

	public Proveedor(String nombre, String mail, String direccion, String cuit) {
		super();
		this.nombre = nombre;
		this.mail = mail;
		this.direccion = direccion;
		this.cuit = cuit;
	}
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	
	public Integer getId() {
		return id;
	}
	protected Proveedor() {
		super();
		// TODO Auto-generated constructor stub
	}
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
