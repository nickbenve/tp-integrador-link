package app.DTO;

public class Item_orden_INPUT {

	private Integer cantidad;
	private Integer id_producto;
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getId_producto() {
		return id_producto;
	}
	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
	}
	public Item_orden_INPUT(Integer cantidad, Integer id_producto) {
		super();
		this.cantidad = cantidad;
		this.id_producto = id_producto;
	}
	public Item_orden_INPUT() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
