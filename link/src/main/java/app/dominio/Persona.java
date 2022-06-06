package app.dominio;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Persona {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String usuario;
	
	@JsonIgnore
	private String contrasenia;
	
	@OneToOne
	private Rol rol;

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
	public Persona(String usuario, String contrasenia,Rol roles) {
		super();
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.rol=roles;
	}
	public Rol getRoles() {
		return rol;
	}
	public void setRoles(Rol roles) {
		this.rol = roles;
	}
	protected Persona() {
		super();	
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	

	
	
}
