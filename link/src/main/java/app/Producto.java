package app;

import java.util.Objects;

import excepciones.FaltaStockException;

public class Producto {
	
	private String nombre;
	private String descripcion;
	private Integer cantidadMinima;
	private Precio Precio;
	private Boolean activo;
	private Integer stock;
	
	private Proveedor proveedor;
	
	public void consumir(Integer cantidad) throws FaltaStockException {
		if(this.getStock()>=cantidad) {
			this.setStock(this.getStock()-cantidad);
		}else {
			throw new FaltaStockException("Falta stock de",nombre);
		}
	
	}
	public Integer getCantidad() {
		return  cantidadMinima;
	}

	public Integer getCantidadMinima() {
		return cantidadMinima;
	}

	public void setCantidadMinima(Integer cantidadMinima) {
		this.cantidadMinima = cantidadMinima;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public void setCantidad(Integer cantidad) {
		this. cantidadMinima = cantidad;
	}

	public Double getPrecio() {
		return Precio.calcularPrecio();
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




	

	public String getNombre() {
		return nombre;
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



	public Integer getCantMinSolicitud() {
		return  cantidadMinima;
	}

	public void setCantMinSolicitud(Integer cantMinSolicitud) {
		this.cantidadMinima = cantMinSolicitud;
	}


	public Producto(String nombre, String descripcion, app.Precio precio, Integer stock,
			Proveedor proveedor) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cantidadMinima = 0;
		Precio = precio;
		this.stock = stock;
		this.proveedor = proveedor;
		if(this.stock>0) {
			this.activo=true;
		}else {
			this.activo=false;
		}
	}

	public String getNomYProv() {
		return nombre+proveedor.getNombre();
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, proveedor);
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
		return Objects.equals(nombre, other.nombre) && Objects.equals(proveedor, other.proveedor);
	}

	public void agregarStock(Integer cantidad) {
		this.stock=this.getStock() + cantidad;
		
	}
	
	
	
	
	
	


	
	
	
	
	
	
}
