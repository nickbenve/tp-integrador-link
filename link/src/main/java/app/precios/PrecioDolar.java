package app.precios;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class PrecioDolar {
	private double compra;
	
	public double getCompra() {
		return compra;
	}

	public void setCompra(double compra) {
		this.compra = compra;
	}

	public PrecioDolar() {	
	}
}
