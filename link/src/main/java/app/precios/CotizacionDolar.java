package app.precios;





import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CotizacionDolar {

	private static CotizacionDolar cotizacionDolar;

	
	public Double valor;

	public CotizacionDolar() {
		this.actualizar();
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


	public static CotizacionDolar getCotizacionDolar() {
		if (cotizacionDolar==null) {

			cotizacionDolar = new CotizacionDolar();
		}

		return cotizacionDolar;

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
