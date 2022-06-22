package app.dominio;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import app.excepciones.FaltaStockException;

@Entity
public class Item_Orden {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	


	private double cantidad;
	private Double precio;
	
	@ManyToOne
	private Producto producto;
	
	public Double calcularPrecioItem(){
		return cantidad*(producto.getPrecio());
	}

	public Item_Orden(Integer cantidad,Producto producto) throws FaltaStockException {
		super();
		producto.consumir(cantidad);
		this.precio=producto.getPrecio();
		this.cantidad = cantidad;
		this.producto = producto;
	}
	public Integer getId() {
		return id;
	}
	
	public Item_Orden( double cantidad, Double precio, Producto producto) {
	
		this.cantidad = cantidad;
		this.precio = precio;
		this.producto = producto;
	}

	protected Item_Orden() {
		super();
		
		// TODO Auto-generated constructor stub
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public void setPrecio(double precio) {
		
		this.precio = this.producto.getPrecio();
	}

	public void agregarCantidad(double cantidad) {
		this.cantidad=this.cantidad+cantidad;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(producto);
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return this.producto.getPrecio();
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
