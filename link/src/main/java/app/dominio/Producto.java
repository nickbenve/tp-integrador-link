package app.dominio;

import java.util.Objects;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import app.excepciones.FaltaStockException;
import app.precios.CotizacionDolar;



@Entity
public class Producto {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String nombre;
	private String descripcion;
	private Integer cantidadMinima;
	private Boolean esPesos;
	
	private Double precio;
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



	public Integer getCantMinSolicitud() {
		return  cantidadMinima;
	}

	public void setCantMinSolicitud(Integer cantMinSolicitud) {
		this.cantidadMinima = cantMinSolicitud;
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
		this.cantidadMinima = 0;	
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
	public void setProveedor(Optional<Proveedor> prov) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	


	
	
	
	
	
	
}
