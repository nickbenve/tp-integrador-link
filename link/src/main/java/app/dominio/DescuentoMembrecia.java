package app.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DescuentoMembrecia implements Promocion{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	
	@OneToOne
	private Membrecia membrecia;
	
	public Double descuento(Orden orden) {
		if(membrecia.estaAsociado(orden.getCliente())) {
			
			return membrecia.getDescuento()*orden.costoTotal();
		}else {
			return 0.0;
		}
	}

	@Override
	public void utilizar() {
		// TODO Auto-generated method stub
		
	}

	public DescuentoMembrecia(Membrecia membrecia) {
		super();
		this.membrecia = membrecia;
	}
	
}
