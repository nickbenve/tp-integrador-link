package app.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import app.dominio.Cliente;
import app.dominio.CuponProveedor;
import app.dominio.DescuentoMembrecia;
import app.dominio.Item_Orden;
import app.dominio.MedioPago;
import app.dominio.Membrecia;
import app.dominio.Orden;
import app.dominio.Producto;
import app.dominio.PromocionMedioPago;
import app.dominio.Proveedor;
import app.excepciones.FaltaStockException;
import app.precios.CalculadorPrecioArgentino;



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
	public void calculoCostoOrdenSinDesc()throws Exception{
		Proveedor proveedor=new Proveedor("nick", "11111");
		Producto producto=new Producto("Arroz","1kg",new CalculadorPrecioArgentino(50),20,proveedor);
		Producto producto2=new Producto("Leche","1 litro",new CalculadorPrecioArgentino(100),25,new Proveedor("Serenicima","1111111"));
		
		Orden orden= new Orden(new Cliente("nick","1"));
		Item_Orden i1= new Item_Orden(2, producto);
		Item_Orden i2= new Item_Orden(3,producto2);
		
		orden.agregarItem(i2);
		orden.agregarItem(i1);
			
		assertEquals(400,orden.costoTotal());
		
	}
	
	@Test
	public void calculoCostoOrdenConDesc() throws Exception{
		
		Proveedor proveedor=new Proveedor("nick", "11111");
		Producto producto=new Producto("Arroz","1kg",new CalculadorPrecioArgentino(50),20,proveedor);
	
		Cliente nick= new Cliente("nick","1");
		Orden orden= new Orden(nick);
		
		Item_Orden i1= new Item_Orden(2, producto);
			
		orden.agregarItem(i1);
		orden.setMedioPago(MedioPago.EFECTIVO);
		CuponProveedor cupon=new CuponProveedor(10.0, proveedor);
		PromocionMedioPago promoEfectivo= new PromocionMedioPago("10% en efectivo", MedioPago.EFECTIVO, 0.10);
		
		Membrecia membre=new Membrecia("banco frances", 0.1);
		membre.agregarMiembro(nick);
		DescuentoMembrecia promo= new DescuentoMembrecia(membre);
		orden.agregarPromo(promoEfectivo);
		orden.agregarPromo(cupon);
		orden.agregarPromo(promo);
		assertEquals(70,orden.aplicarDescuentos());
	}
}