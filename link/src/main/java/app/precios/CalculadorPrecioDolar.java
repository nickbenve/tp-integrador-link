package app.precios;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import app.dominio.Precio;

@Entity
public class CalculadorPrecioDolar implements Precio{

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private double precio;
	
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	public PrecioDolar run(RestTemplate restTemplate) throws Exception {
		PrecioDolar precioActual = restTemplate.getForObject(
				"http://api-dolar-argentina.herokuapp.com/api/dolaroficial", PrecioDolar.class);
		return precioActual;
	}
	
	public CalculadorPrecioDolar(double precio) {
		super();
		this.precio = precio;
	}

	@Override
	public Double calcularPrecio() {
		RestTemplate nuevo= new RestTemplate();
		try {
			double valor=this.run(nuevo).getCompra();
			return valor*precio;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0.0;
		
	}
}
