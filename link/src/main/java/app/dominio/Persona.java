package app.dominio;



import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Persona {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false, unique=true, columnDefinition = "BINARY(16)")
	private UUID id;
	
	

	private String usuario;
	

	private String contrasenia;
	
	@JoinColumn(name="rol")
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

	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol roles) {
		this.rol = roles;
	}
	protected Persona() {
		super();	
	}

	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(id, other.id);
	}
	public Persona(String usuario, String contrasenia, Rol rol) {
		super();
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.rol = rol;
	}

	

	
	
}
