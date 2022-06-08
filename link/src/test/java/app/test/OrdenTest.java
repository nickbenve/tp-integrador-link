package app.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import app.dominio.Cliente;
import app.dominio.Item_Orden;
import app.dominio.MedioPago;
import app.dominio.Membrecia;
import app.dominio.Orden;
import app.dominio.Producto;
import app.dominio.Proveedor;
import app.dominio.descuentos.CuponProveedor;
import app.dominio.descuentos.DescuentoMembrecia;
import app.dominio.descuentos.PromocionMedioPago;
import app.excepciones.FaltaStockException;


public class OrdenTest {

 
	@Test
	public void faltaStock() throws Exception{

			Double precio=3.0;
			Producto producto=new Producto("a","b",precio,5, new Proveedor("a","b"),true);
		    
			assertThrows(FaltaStockException.class,
		    		()->{
		    			Item_Orden item1=new Item_Orden(2,producto);
		    			Item_Orden item2=new Item_Orden(5,producto);
		    		});
		  
	}
	
	@Test
	public void calculoCostoOrdenSinDesc() throws Exception{
		Proveedor proveedor=new Proveedor("nick", "11111");
		Producto producto=new Producto("Arroz","1kg",50.0,100, proveedor,true);
		Producto producto2=new Producto("Leche","1 litro",100.0,25,new Proveedor("Serenicima","1111111"),true);
		
		Orden orden= new Orden(new Cliente("nick","1"));
		Item_Orden i1= new Item_Orden(2, producto);
		Item_Orden i2= new Item_Orden(3,producto2);
		
		orden.agregarItem(i2);
		orden.agregarItem(i1);
			
		assertEquals(400,orden.costoTotal());
		
	}
	
	
	@Test
	public void calculoCostoOrdenSinDescDolar() throws Exception{
		Proveedor proveedor=new Proveedor("nick", "11111");
		Producto producto=new Producto("Arroz","1kg",1.0,20,proveedor,true);
	
		
		Orden orden= new Orden(new Cliente("nick","1"));
		Item_Orden i1= new Item_Orden(1, producto);
		
		orden.agregarItem(i1);
			
		assertEquals(1.0,orden.costoTotal());
		
	}
	
	@Test
	public void calculoCostoOrdenConDesc() throws Exception{
		
		Proveedor proveedor=new Proveedor("nick", "11111");
		Producto producto=new Producto("Arroz","1kg",50.0,20,proveedor,true);
	
		Cliente nick= new Cliente("nick","1");
		Orden orden= new Orden(nick);
		
		Item_Orden i1= new Item_Orden(2, producto);
			
		orden.agregarItem(i1);
		orden.setMedioPago(MedioPago.EFECTIVO);
		CuponProveedor cupon=new CuponProveedor(10.0, proveedor);
		PromocionMedioPago promoEfectivo= new PromocionMedioPago("10% en efectivo", MedioPago.EFECTIVO, 0.10);
		
		Membrecia membre=new Membrecia("banco frances");
		membre.agregarMiembro(nick);
		DescuentoMembrecia promo= new DescuentoMembrecia(membre,0.1);
		orden.agregarPromo(promoEfectivo);
		orden.agregarPromo(cupon);
		orden.agregarPromo(promo);
		assertEquals(70,orden.aplicarDescuentos());
	}
}