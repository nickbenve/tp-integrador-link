package ar.tp.integrador.link;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DolarTest {
//	@Test
	public void precioDolar() {
		CalculadorPrecioDolar dolarActual= new CalculadorPrecioDolar(2.0);
		double costoFinal=dolarActual.calcularPrecio();
		assertEquals(costoFinal,231.94);
	}
}
