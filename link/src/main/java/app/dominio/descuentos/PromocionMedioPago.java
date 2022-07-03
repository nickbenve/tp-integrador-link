package app.dominio.descuentos;

import java.util.Objects;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import app.dominio.Carrito;
import app.dominio.MedioPago;
import app.dominio.Orden;
import app.dominio.Promocion;


@Entity
@DiscriminatorValue("1")
public class PromocionMedioPago  extends Promocion{

	private String descripcion;
	
	@Enumerated(EnumType.STRING)
	private MedioPago metodoPago;
	
	private double porcentaje;

	
	public PromocionMedioPago(String descripcion, MedioPago metodoPago, double descuento) {
		super();
		this.descripcion = descripcion;
		this.metodoPago = metodoPago;
		this.porcentaje = descuento;
	}
	
	@Override
	public Double descuento(Carrito carrito) {
		if(carrito.getMedioPago()==this.getMetodoPago()) {
			return this.getPorcentaje()*carrito.costoTotal();
		}else {
			return 0.0;
		}
	}
	
	
	
	public PromocionMedioPago() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public void utilizar() {
		
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(descripcion, metodoPago);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PromocionMedioPago other = (PromocionMedioPago) obj;
		return Objects.equals(descripcion, other.descripcion) && metodoPago == other.metodoPago;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public MedioPago getMetodoPago() {
		return metodoPago;
	}
	public void setMetodoPago(MedioPago metodoPago) {
		this.metodoPago = metodoPago;
	}
	public double getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}

	
	
}
