package app.precios;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import app.dominio.Precio;

@Entity
public class CalculadorPrecioArgentino extends Precio{

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private double precio;
	
	
	public CalculadorPrecioArgentino(double precio) {
		this.precio = precio;
	}

	protected CalculadorPrecioArgentino() {
		super();
	}
	@Override
	public Double calcularPrecio() {
		return precio;
	}
}
