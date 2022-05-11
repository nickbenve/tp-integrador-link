package ar.tp.integrador.link;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import app.Item_Orden;
import app.Orden;
import app.Producto;
import app.Proveedor;

public class CostoOrdenTest {
	
	@Test
	public void costoOrdenProductosPesos() {
		Orden orden1= new Orden();
		Producto producto1= new Producto("Azucar", "1 kg", 5, new CalculadorPrecioArgentino(150.00),50, new Proveedor("Arcor", "123"));
		Item_Orden item= new Item_Orden(5, producto1.getPrecio().calcularPrecio(), producto1);
		Item_Orden item2= new Item_Orden(5, producto1.getPrecio().calcularPrecio(), producto1);
		orden1.agregarItem(item);
		orden1.agregarItem(item2);
		assertEquals(orden1.costoTotal(),1500.00);
		
	}
}
