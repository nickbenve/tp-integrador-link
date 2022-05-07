package app;

import java.util.Objects;

public class Producto {
	
	private String nombre;
	private String descripcion;
	
	private String categoria;
	private Integer cantidad;
	private Precio Precio;
	private Vendedor vendedor;
	private Boolean activo;
	private Integer stock;
	
	
	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Precio getPrecio() {
		return Precio;
	}

	public void setPrecio(Precio precio) {
		Precio = precio;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descripcion, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(descripcion, other.descripcion) && Objects.equals(nombre, other.nombre);
	}

	public Producto(String nombre,Vendedor vendedor, String descripcion, String categoria, Integer cantMinSolicitud) {
		super();
		this.vendedor=vendedor;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.cantidad = cantMinSolicitud;
	}

	public String getNombre() {
		return nombre;
	}
	

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getCantMinSolicitud() {
		return cantidad;
	}

	public void setCantMinSolicitud(Integer cantMinSolicitud) {
		this.cantidad = cantMinSolicitud;
	}

	public String getNomYDesc() {
		return nombre+descripcion;
	}
	
	
	
	
	


	
	
	
	
	
	
}
