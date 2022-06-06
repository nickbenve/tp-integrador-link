package app.precios;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
@Entity
public class CotizacionDolar{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	public Double valor;
	
	private static CotizacionDolar cotizadorDolar;
	
	
	public CotizacionDolar() {
		this.actualizar();
	}
	
	
	public static CotizacionDolar getCotizadorDolar() {

		if (cotizadorDolar==null) {

			cotizadorDolar = new CotizacionDolar();
		}
			return cotizadorDolar;
	}

	public Double calcularPrecio(Double valor) {
		return 	this.calcularPrecio()*valor;		
	}
	
	@Scheduled(fixedRate = 1000*60*30)
	public void actualizar() {
		RestTemplate nuevo= new RestTemplate();
		try {
			this.valor=this.run(nuevo).getCompra();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	public Double getValor() {
		return valor;
	}



	public void setValor(Double valor) {
		this.valor = valor;
	}




	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	public PrecioDolar run(RestTemplate restTemplate) throws Exception {
		PrecioDolar precioActual = restTemplate.getForObject(
				"http://api-dolar-argentina.herokuapp.com/api/dolaroficial", PrecioDolar.class);
		return precioActual;
	}
	
	public Double calcularPrecio() {
		return valor;
		
	}

}
