package app.dominio.descuentos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import app.dominio.Carrito;
import app.dominio.Membrecia;
import app.dominio.Orden;
import app.dominio.Promocion;

@Entity
@DiscriminatorValue("3")
public class DescuentoMembrecia  extends Promocion{

	


	@OneToOne
	private Membrecia membrecia;
	
	private Double descuento;
	
	public Double descuento(Carrito carrito) {
		if(membrecia.estaAsociado(carrito.getCliente())) {
			return this.getDescuento()*carrito.costoTotal();
		}else {
			return 0.0;
		}
	}

	
	protected DescuentoMembrecia() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Membrecia getMembrecia() {
		return membrecia;
	}


	public void setMembrecia(Membrecia membrecia) {
		this.membrecia = membrecia;
	}


	public Double getDescuento() {
		return descuento;
	}


	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}


	@Override
	public void utilizar() {
		// TODO Auto-generated method stub
		
	}

	public DescuentoMembrecia(Membrecia membrecia,Double descuento) {
		super();
		this.descuento=descuento;
		this.membrecia = membrecia;
	}
	
	
}
