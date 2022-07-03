package app.DTO;

import java.util.UUID;

public class LoginDTO {
	private String rol;
	private UUID id;
	public LoginDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginDTO(String rol, UUID id) {
		super();
		this.rol = rol;
		this.id = id;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	
}
