package app.precios;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import app.dominio.Precio;

@Entity
public class CalculadorPrecioDolar extends Precio{


	private double precio;
	
	@ManyToOne
	private CotizacionDolar cotizador;
	
	
	public CalculadorPrecioDolar(double precio) {
		super();
		cotizador=new CotizacionDolar();
		this.precio = precio;
	}
	protected CalculadorPrecioDolar() {
		super();
	}
	

	@Override
	public Double calcularPrecio() {
		return precio*cotizador.calcularPrecio();
	
		
	}
}
