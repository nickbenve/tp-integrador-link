package app.dominio;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Admin extends Rol{
		
	private String nombre;
	private String mail;
	private LocalDate fechaIngreso;
	private String rol="admin";

	public Admin(String nombre,String mail) {
		this.nombre=nombre;
		this.mail=mail;
		this.rol="admin";
	}
	
	protected Admin() {
		super();
		this.fechaIngreso=LocalDate.now();
		// TODO Auto-generated constructor stub
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
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

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	


}
