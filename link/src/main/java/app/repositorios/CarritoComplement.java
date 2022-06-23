package app.repositorios;

import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.DTO.CarritoDTO;
import app.DTO.LoginDTO;
import app.dominio.Carrito;
import app.dominio.Cliente;
import app.dominio.Item_Orden;
import app.dominio.Persona;
import app.dominio.Producto;
import app.excepciones.FaltaStockException;

@CrossOrigin
@RestController
@RequestMapping("/carrito")
public class CarritoComplement {

	@Autowired
	RepoCliente clientes;
	
	@Autowired
	RepoCarrito carritos;	
	
	@Autowired
	RepoItem_Orden items;
	
	@Autowired
	RepoProducto productos;
	
	@Transactional
	@GetMapping("")
	public  CarritoDTO get(@RequestParam(value="id",required=false) UUID usuario) {
		
		Optional<Cliente> opcionalPersona= clientes.findById(usuario);
		
	
		Cliente cliente=opcionalPersona.get();

		Optional<Carrito> opcionalCarrito=carritos.findByCliente(cliente);
		
		Carrito carrito=opcionalCarrito.get();
		
		CarritoDTO carritoDTO=new CarritoDTO();
		carritoDTO.setCliente(carrito.getCliente());
		carritoDTO.setItems(carrito.getItems());
		carritoDTO.setMedioPago(carrito.getMedioPago());
		carritoDTO.setPromociones(carrito.getPromociones());
		carritoDTO.setPrecioTotalSinDescuento(carrito.costoTotal());
		carritoDTO.setPrecioTotalConDescuento(carrito.aplicarDescuentos());
		return carritoDTO;

	}
	

	@Transactional
	@PostMapping("/{cliente}/carritoDeCompras/items/{producto}/{cantidad}")
	public void post(@PathVariable(value="cliente") UUID cliente,
			@PathVariable(value="producto") Integer idProd,
			@PathVariable(value="cantidad") Integer cantidad
			
			) throws FaltaStockException {
		
		Optional<Cliente> opcionalPersona= clientes.findById(cliente);
		Cliente clienteE=opcionalPersona.get();

		
		Optional<Carrito> opcionalCarrito=carritos.findByCliente(clienteE);
		
		Carrito carrito=opcionalCarrito.get();
		
		Optional<Producto> opcionalProducto=productos.findById(idProd);
		
		Producto producto=opcionalProducto.get();
		
		Item_Orden itemNuevo=new Item_Orden(cantidad,producto);

		
		carrito.agregarItem(itemNuevo);
		
		items.save(itemNuevo);
	}
	

}
