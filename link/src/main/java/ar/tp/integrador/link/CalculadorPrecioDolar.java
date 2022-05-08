package ar.tp.integrador.link;



import java.net.URL;

import app.Precio;

public class CalculadorPrecioDolar implements Precio{
	URL url=new URL ("http://api-dolar-argentina.herokuapp.com/api/dolaroficial");
	@Override
	public Float calcularPrecio(Float a) {
		
		return a;
		
	}

	

    
   
    
//	@Override
//	public Float calcularPrecio(Float a) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
