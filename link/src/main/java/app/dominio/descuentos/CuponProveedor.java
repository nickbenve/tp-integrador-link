package app.dominio.descuentos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import app.dominio.Orden;
import app.dominio.Promocion;
import app.dominio.Proveedor;

@Entity
public class CuponProveedor extends Promocion {

	private Double valor;
	
	@ManyToOne
	private Proveedor proveedor;
	
	private boolean utilizado;

	
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public boolean getUtilizado() {
		return utilizado;
	}
	public void setUtilizado(boolean utilizado) {
		this.utilizado = utilizado;
	}
	
	@Override
	public Double descuento(Orden orden) {
		if(this.getUtilizado()) {
			return 0.0;
		}else {
			if(this.getValor()<=orden.costoEnProductosDe(proveedor)) {
				this.utilizar();
				return this.getValor();
			}else {
				this.utilizar();
				return orden.costoEnProductosDe(proveedor);
			}
		}
	}
	
	public CuponProveedor(Double valor, Proveedor proveedor) {
		super();
		this.valor = valor;
		this.proveedor = proveedor;
		this.utilizado=false;
	}
	
	
	protected CuponProveedor() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public void utilizar() {
		utilizado=true;
		
	}
	
	
	
}
