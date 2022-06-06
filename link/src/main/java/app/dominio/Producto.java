package app.dominio;


import java.util.Objects;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.Transient;

import app.excepciones.FaltaStockException;
import app.precios.CotizacionDolar;



@Entity
public class Producto {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String nombre;
	private String descripcion;
	private Boolean esPesos;
	
	private Double precio;
	
	@ManyToOne
	private CotizacionDolar cotizador;
	
	public CotizacionDolar getCotizador() {
		return cotizador;
	}
	public void setCotizador(CotizacionDolar optional) {
		this.cotizador = optional;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}


	private Boolean activo;
	private Integer stock;
	
	@ManyToOne
	private Proveedor proveedor;

	public Producto() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void consumir(Integer cantidad) throws FaltaStockException {
		if(this.getStock()>=cantidad) {
			this.setStock(this.getStock()-cantidad);
		}else {
			throw new FaltaStockException("Falta stock de",nombre);
		}
	
	}



	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}


	
	public Double getPrecio() {
		if(esPesos) {
			return this.precio;
		}else {
			return cotizador.calcularPrecio(this.precio);
		}
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





	public Boolean getEsPesos() {
		return esPesos;
	}
	public void setEsPesos(Boolean esPesos) {
		this.esPesos = esPesos;
	}
	public Producto(String nombre, String descripcion,Double precio, Integer stock,
			Proveedor proveedor,Boolean esPesos) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;	
		this.precio=precio;
		this.esPesos=esPesos;
		this.stock = stock;
		this.proveedor = proveedor;
		if(this.stock>0) {
			this.activo=true;
		}else {
			this.activo=false;
		}
	}


	@Override
	public int hashCode() {
		return Objects.hash(nombre, proveedor);
	}



	public void agregarStock(Integer cantidad) {
		this.stock=this.getStock() + cantidad;
		
	}

	
	
	
	
	
	


	
	
	
	
	
	
}
