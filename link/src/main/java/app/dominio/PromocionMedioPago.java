package app.dominio;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class PromocionMedioPago implements Promocion {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String descripcion;
	
	@OneToOne
	private MedioPago metodoPago;
	private double porcentaje;
	private Boolean utilizado;
	
	public PromocionMedioPago(String descripcion, MedioPago metodoPago, double descuentos) {
		super();
		this.descripcion = descripcion;
		this.metodoPago = metodoPago;
		this.porcentaje = descuentos;
		this.utilizado=false;
	}
	@Override
	public Double descuento(Orden orden) {
		if(orden.getMedioPago()==this.getMetodoPago()) {
			return this.getPorcentaje()*orden.costoTotal();
		}else {
			return 0.0;
		}
	}
	
	@Override
	public void utilizar() {
		this.utilizado=true;
		
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
	public void setPorcentaje(Float porcentaje) {
		this.porcentaje = porcentaje;
	}
	public Boolean getUtilizado() {
		return utilizado;
	}
	public void setUtilizado(Boolean utilizado) {
		this.utilizado = utilizado;
	}
	
	
	
}
