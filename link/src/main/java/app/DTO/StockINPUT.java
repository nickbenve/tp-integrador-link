package app.DTO;

public class StockINPUT {

	private Integer id_producto;
	private Integer cantidad;
	public StockINPUT(Integer id_producto, Integer cantidad) {
		super();
		this.id_producto = id_producto;
		this.cantidad = cantidad;
	}
	public StockINPUT() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId_producto() {
		return id_producto;
	}
	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
