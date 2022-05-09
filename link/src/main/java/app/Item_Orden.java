package app;

public class Item_Orden {
	private int cantidad;
	private double precio;
	private Producto producto;
	
	public Double calcularPrecioItem() {
		return cantidad*(producto.getPrecio().calcularPrecio());
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
}
