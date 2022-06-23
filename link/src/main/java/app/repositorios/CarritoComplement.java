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
import app.dominio.Carrito;
import app.dominio.Cliente;
import app.dominio.Persona;

@CrossOrigin
@RestController
@RequestMapping("/carrito")
public class CarritoComplement {

	@Autowired
	RepoCliente clientes;
	
	@Autowired
	RepoCarrito carritos;	
	
	@Transactional
	@GetMapping("")
	public  Carrito get(@RequestParam(value="id",required=false) UUID usuario) {
		
		Optional<Cliente> opcionalPersona= clientes.findById(usuario);
		
	
		Cliente cliente=opcionalPersona.get();

		Optional<Carrito> opcionalCarrito=carritos.findByCliente(cliente);
		
		Carrito carrito=opcionalCarrito.get();
		
		return carrito;

	}

}
