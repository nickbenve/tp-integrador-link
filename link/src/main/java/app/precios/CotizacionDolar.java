package app.precios;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;


@Entity 
public class CotizacionDolar{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	public Double valor;
	public LocalDateTime ultimaActualizacion;
	
	
	public CotizacionDolar() {
		LocalDate hoy = LocalDate.now();
        LocalTime ahora = LocalTime.now();
      
    	this.ultimaActualizacion = LocalDateTime.of(hoy,ahora);
		this.valor = this.inicializar();
		
	}

	public Double calcularPrecio(Double valor) {
		return 	this.calcularPrecio()*valor;		
	}
	
	
	public Double inicializar() {
		RestTemplate nuevo= new RestTemplate();
		try {
			LocalDate hoy = LocalDate.now();
	        LocalTime ahora = LocalTime.now();
	    	this.ultimaActualizacion = LocalDateTime.of(hoy,ahora);
			double valor=this.run(nuevo).getCompra();
			return valor;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0.0;
		
	}
	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}


	public LocalDateTime getUltimaActualizacion() {
		return ultimaActualizacion;
	}


	public void setUltimaActualizacion(LocalDateTime ultimaActualizacion) {
		this.ultimaActualizacion = ultimaActualizacion;
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
		LocalDateTime horaActual=LocalDateTime.now();
		if(ultimaActualizacion.isAfter(horaActual.minusMinutes(30))) {
			return valor;
		}else {
		RestTemplate nuevo= new RestTemplate();
		try {
			LocalDate hoy = LocalDate.now();
	        LocalTime ahora = LocalTime.now();
	    	this.ultimaActualizacion = LocalDateTime.of(hoy,ahora);
			double valor=this.run(nuevo).getCompra();
			return valor;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0.0;
		}
	}
}
