package app;

import java.util.Objects;

public class Item_Orden {
	private double cantidad;
	private Double precio;
	private Producto producto;
	
	public Double calcularPrecioItem(){
		return cantidad*(producto.getPrecio());
	}

	public Item_Orden(Integer cantidad,Producto producto) throws FaltaStockException {
		super();
		producto.consumir(cantidad);
		this.setPrecio(producto.getPrecio());
		this.cantidad = cantidad;
		this.producto = producto;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void agregarCantidad(double cantidad) {
		this.cantidad=this.cantidad+cantidad;
	}
	@Override
	public int hashCode() {
		return Objects.hash(producto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item_Orden other = (Item_Orden) obj;
		return Objects.equals(producto, other.producto);
	}

	public double getCantidad() {
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
