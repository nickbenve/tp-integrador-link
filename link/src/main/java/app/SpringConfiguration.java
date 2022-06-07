package app;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.EnableScheduling;


import app.precios.CotizacionDolar;

@Configuration
@EnableScheduling
public class SpringConfiguration {
	
//	 @Bean
//	 @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
//	 public CotizacionDolar getCotizacionDolar() {
//	  return new CotizacionDolar();
//	 }
	 
}
