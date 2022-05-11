package ar.tp.integrador.link;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import app.Cliente;
import app.FaltaStockException;
import app.Item_Orden;
import app.Orden;
import app.Producto;
import app.Proveedor;



public class OrdenTest {
/*
 * crear test crear orden y calcular costo
 * crear orden con descuentos y ver que funcionen todos los tipos de descuentos
 * 
 * 
 * 
 * 
 * 
 * 
 */
	
	
	@Test
	public void faltaStock() throws Exception{
			Producto producto=new Producto("Arroz","nick",new CalculadorPrecioArgentino(5.0),4,new Proveedor("hola","hola"));
		    assertThrows(FaltaStockException.class,
		    		()->{
		    			Item_Orden item1=new Item_Orden(2,producto);
		    			Item_Orden item2=new Item_Orden(5,producto);
		    		});
		  
	}
	
	@Test
	public void calculoCostoOrden()throws Exception{
		Producto producto=new Producto("Arroz","1kg",new CalculadorPrecioArgentino(50),20,new Proveedor("Marolio","22222222"));
		Producto producto2=new Producto("Leche","1 litro",new CalculadorPrecioArgentino(100),25,new Proveedor("Serenicima","1111111"));
		
		Orden orden= new Orden(new Cliente("nick","1"));
		Item_Orden i1= new Item_Orden(2, producto);
		Item_Orden i2= new Item_Orden(3,producto2);
		
		orden.agregarItem(i2);
		orden.agregarItem(i1);
		assertEquals(400,orden.costoTotal());
		
	}
	
}