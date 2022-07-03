package app.repositorios;

import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import app.DTO.LoginDTO;
import app.dominio.Persona;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginControllerComplement {

	
	@Autowired
	RepoPersona repoPersonas;
	
	@Transactional
	@GetMapping("")
	public  LoginDTO get(@RequestParam(value="usuario",required=false) String usuario,@RequestParam(value="contrasenia",required=false) String contrasenia) {
		
		Optional<Persona> opcionalPersona= repoPersonas.findByUsuarioAndContrasenia(usuario, contrasenia);
		
	
		Persona persona=opcionalPersona.get();

		
		LoginDTO login= new LoginDTO();
		login.setRol(persona.getRol().getRol());
		login.setId(persona.getRol().getId());
		
		return login;

	}

	
}
