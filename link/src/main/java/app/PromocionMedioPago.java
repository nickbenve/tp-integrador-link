package app;

public class PromocionMedioPago implements Promocion {
	private String descripcion;
	private MedioPago metodoPago;
	private Float porcentaje;
	private Boolean utilizado;
	public PromocionMedioPago(String descripcion, MedioPago metodoPago, Float descuentos) {
		super();
		this.descripcion = descripcion;
		this.metodoPago = metodoPago;
		this.porcentaje = descuentos;
		this.utilizado=false;
	}
	@Override
	public float descuento(Orden orden) {
		return (1-this.getPorcentaje())*orden.costoTotal();

	}
	@Override
	public void utilizar() {
		this.utilizado=true;
		
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
	public Float getPorcentaje() {
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
