package app;

import java.time.LocalDate;

public class Admin implements Rol{
	private String nombre;
	private String mail;
	private String direccion;
	private LocalDate fechaIngreso;
	
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
