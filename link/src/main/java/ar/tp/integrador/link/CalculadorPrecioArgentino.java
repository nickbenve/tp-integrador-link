package ar.tp.integrador.link;

import app.Precio;

public class CalculadorPrecioArgentino implements Precio{

	private double precio;
	
	
	public CalculadorPrecioArgentino(double precio) {
		this.precio = precio;
	}


	@Override
	public Double calcularPrecio() {
		return precio;
	}
}
