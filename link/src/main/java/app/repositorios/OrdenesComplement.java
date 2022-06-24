package app.repositorios;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.dominio.Carrito;
import app.dominio.Cliente;
import app.dominio.Item_Orden;
import app.dominio.MedioPago;
import app.dominio.Orden;
import app.dominio.Promocion;

@CrossOrigin
@RestController
@RequestMapping("/orden")
public class OrdenesComplement {
	@Autowired
	RepoCliente clientes;
	
	@Autowired
	RepoCarrito carritos;	
	
	@Autowired
	RepoOrden repoOrden;
	
	@Transactional
	@PostMapping("/{cliente}")
	public void metodoPago(@PathVariable(value="cliente") UUID clienteid) {
		Optional<Cliente> opcionalPersona= clientes.findById(clienteid);
		Cliente cliente=opcionalPersona.get();
		
		Optional<Carrito> opcionalCarrito=carritos.findByCliente(cliente);
		Carrito carrito=opcionalCarrito.get();
		
	
		
		Orden orden= new Orden(carrito.aplicarDescuentos(),carrito.getItems(),carrito.getMedioPago(),carrito.getPromociones(),carrito.getCliente());
		cliente.agregarCompra(orden);
		carrito.vaciar();
		
		repoOrden.save(orden);
		
	}
	
	

}
