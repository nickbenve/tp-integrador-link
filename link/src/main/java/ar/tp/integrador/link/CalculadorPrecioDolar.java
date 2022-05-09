package ar.tp.integrador.link;




import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import app.Precio;


public class CalculadorPrecioDolar implements Precio{

	private Double precio;
	
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	public PrecioDolar run(RestTemplate restTemplate) throws Exception {
		PrecioDolar precio = restTemplate.getForObject(
				"http://api-dolar-argentina.herokuapp.com/api/dolaroficial", PrecioDolar.class);
		return precio;
	}
	
	public CalculadorPrecioDolar(Double precio) {
		super();
		this.precio = precio;
	}

	//	("http://api-dolar-argentina.herokuapp.com/api/dolaroficial");
	@Override
	public double calcularPrecio() {
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
