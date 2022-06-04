package app.dominio;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Persona {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String usuario;
	
	@JsonIgnore
	private String contrasenia;
	
	@OneToMany 
	private List<Rol> roles;

	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public Persona(String usuario, String contrasenia,List<Rol> roles) {
		super();
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.roles=new ArrayList<Rol>();
		this.roles=roles;
	}
	public List<Rol> getRoles() {
		return roles;
	}
	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
	protected Persona() {
		super();
		this.roles=new ArrayList<Rol>();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	

	
	
}
