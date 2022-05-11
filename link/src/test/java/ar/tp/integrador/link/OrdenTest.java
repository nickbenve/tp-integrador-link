package ar.tp.integrador.link;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import app.FaltaStockException;
import app.Item_Orden;
import app.Producto;
import app.Proveedor;



public class OrdenTest {

	@Test
	public void faltaStock() throws Exception{
			Producto producto=new Producto("Arroz","nick",new CalculadorPrecioArgentino(5.0),4,new Proveedor("hola","hola"));
		    assertThrows(FaltaStockException.class,
		    		()->{
		    			Item_Orden item1=new Item_Orden(2,producto.getPrecio().calcularPrecio(), producto);
		    			Item_Orden item2=new Item_Orden(5,producto.getPrecio().calcularPrecio(), producto);
		    		});
		  
	}
}