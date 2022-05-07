package repositorios;

import java.util.ArrayList;
import java.util.List;


import ar.tp.integrador.link.Usuario;
import excepciones.UsuarioRepetidoException;

public class repoUsuarios {
	private List<Usuario> usuarios;

	
	public void RepoUsuariosEnMem() {
		usuarios= new ArrayList<Usuario>();
	}
	
	
	public void save(Usuario usuario) throws UsuarioRepetidoException{
		if(usuarios.contains(usuario)) {
			throw new UsuarioRepetidoException("El usuario ya esta creado");
			
		}else {
			this.usuarios.add(usuario);
		}
		
		
	}
}
