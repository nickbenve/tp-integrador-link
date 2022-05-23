package app.dominio;

public class DescuentoMembrecia implements Promocion{
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
