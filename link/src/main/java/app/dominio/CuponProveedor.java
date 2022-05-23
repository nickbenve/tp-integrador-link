package app.dominio;

public class CuponProveedor implements Promocion {
	private Double valor;
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
			//TODO YA ESTA USADO
		}else {
			if(this.getValor()<=orden.costoEnProductosDe(proveedor)) {
				return this.getValor();
			}else {
				return orden.costoEnProductosDe(proveedor);
			}
		}
		// TODO Auto-generated method stub
		return null;
	}
	public CuponProveedor(Double valor, Proveedor proveedor) {
		super();
		this.valor = valor;
		this.proveedor = proveedor;
		this.utilizado=false;
	}
	@Override
	public void utilizar() {
		utilizado=true;
		
	}
	
	
	
}
