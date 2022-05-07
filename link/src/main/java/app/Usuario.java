package app;

import excepciones.ContraseniaIncorrectaException;

public class Usuario {
	private String usuario;
	private String contrasenia;
	private Rol rol;
	
	public Usuario(String usuario, String contrasenia, Rol rol) {
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.rol = rol;
	}
	
	public void validarContrasenia(String contraseniaLocal) throws ContraseniaIncorrectaException {
		if(contrasenia==contraseniaLocal) {
			throw new ContraseniaIncorrectaException("la contrasenia es incorrecta");
			
		}
	
	}
	
	
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

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	
}
