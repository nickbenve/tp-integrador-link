package app.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import org.junit.jupiter.api.Test;


import app.precios.CotizacionDolar;

public class DolarTest {
//	@Test
	public void precioDolar() {
		CotizacionDolar dolarActual= new CotizacionDolar();
		double costoFinal=dolarActual.calcularPrecio(1.0);
		assertEquals(costoFinal,231.94);
	}
}
