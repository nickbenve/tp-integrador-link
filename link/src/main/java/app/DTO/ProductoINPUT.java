package app.DTO;

public class ProductoINPUT {
	private String nombre;
	private String descripcion;
	private Boolean esPesos;
	
	private Double precio;
	private Integer stock;
	
	private Integer id_proveedor;

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

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}


	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getId_proveedor() {
		return id_proveedor;
	}

	public void setId_proveedor(Integer id_proveedor) {
		this.id_proveedor = id_proveedor;
	}

	public ProductoINPUT() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductoINPUT(String nombre, String descripcion, Boolean esPesos, Double precio,
			Integer stock, Integer id_proveedor) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.esPesos = esPesos;
		this.precio = precio;
		this.stock = stock;
		this.id_proveedor = id_proveedor;
	}
	
}
