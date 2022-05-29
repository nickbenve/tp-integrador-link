package app.dominio;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin extends Persona{
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String nombre;
	private String mail;
	private String direccion;
	private LocalDate fechaIngreso;

	
	public Admin(String usuario, String contrasenia,String nombre) {
		super(usuario, contrasenia);
		fechaIngreso=LocalDate.now();
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
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	
	public void crearMembrecia(Membrecia membrecia) {
//		:TODO
		
//		if(RepoMembreciaEnMemoria.contains(membrecia)) {
//			tirar esepctionj
//		}else {
//			agregarmembrecia
//		}
	}
	public void darDeBajaMiembrecia(Membrecia membrecia) {
//		if(RepoMembreciaEnMemoria.contains(membrecia)) {
//		dar de baja
//	}else {
//		tirar exception
//	}		
	}

}
