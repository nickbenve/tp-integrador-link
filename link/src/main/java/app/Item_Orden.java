package app;

public class Item_Orden {
	private Integer cantidad;
	private Float precio;
	private Producto producto;
	
	public float calcularPrecioItem() {
		return cantidad*(producto.getPrecio()).calcularPrecio(precio);
	}

	public Item_Orden(Integer cantidad, Float precio, Producto producto) {
		super();
		this.cantidad = cantidad;
		this.precio = precio;
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
}
