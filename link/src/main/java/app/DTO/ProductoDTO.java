package app.DTO;

public class ProductoDTO {

	
	private String nombre;
	private String descripcion;
	private Double precio;
	private Integer stock;
	private Boolean esPesos;
	private Integer idProveedor;
	private String foto;
	public ProductoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductoDTO(String nombre, String descripcion, Double precio, Integer stock, Boolean esPesos,
			Integer idProveedor, String foto) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.esPesos = esPesos;
		this.idProveedor = idProveedor;
		this.foto = foto;
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
	public Boolean getEsPesos() {
		return esPesos;
	}
	public void setEsPesos(Boolean esPesos) {
		this.esPesos = esPesos;
	}
	public Integer getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
}
