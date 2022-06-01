package app.dominio;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin implements Rol{
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String nombre;
	private String mail;
	private LocalDate fechaIngreso;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Admin(String nombre,String mail) {
		this.nombre=nombre;
		this.mail=mail;
		this.fechaIngreso=LocalDate.now();
	}
	
	protected Admin() {
		super();
		// TODO Auto-generated constructor stub
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
