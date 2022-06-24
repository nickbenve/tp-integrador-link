package app.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Orden {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private LocalDate fecha_creacion;
	
	@OneToMany
	private List<Item_Orden> items;

	public Orden(Double valorVendido,List<Item_Orden> items, MedioPago medioPago, List<Promocion> promociones,
			Cliente cliente) {
		super();
		this.valorVendido=valorVendido;
		this.fecha_creacion = LocalDate.now();
		this.items = items;
		this.medioPago = medioPago;
		this.promociones = promociones;
		this.cliente = cliente;
	}

	@Enumerated(EnumType.STRING)
	private MedioPago medioPago;
	
	@ManyToMany
	private List<Promocion> promociones;
	

	


	public Double getValorVendido() {
		return valorVendido;
	}

	public void setValorVendido(Double valorVendido) {
		this.valorVendido = valorVendido;
	}

	private Double valorVendido;
	
	@ManyToOne
	private Cliente cliente;
	

	public Cliente getCliente() {
		return cliente;
	}
	
	public void agregarPromo(Promocion promocion) {
		promociones.add(promocion);
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
	
	public Orden(Cliente cliente) {
		super();
		this.cliente=cliente;
		this.fecha_creacion= LocalDate.now();
		this.items=new ArrayList<Item_Orden>();
		this.promociones=new ArrayList<Promocion>();
	}

	
	protected Orden() {
		super();
		this.fecha_creacion= LocalDate.now();
		this.items=new ArrayList<Item_Orden>();
		this.promociones=new ArrayList<Promocion>();
		// TODO Auto-generated constructor stub
	}

	public Double costoTotal() {
		return items.stream().mapToDouble(x->x.calcularPrecioItem()).sum();
	 
	}

	public void agregarItem(Item_Orden itemNuevo) {
		items.add(itemNuevo);
	}
	
	
	public Double costoEnProductosDe(Proveedor proveedor) {
		
		return items.stream().filter(x->x.getProducto().getProveedor().equals(proveedor)).mapToDouble(x->x.calcularPrecioItem()).sum();
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(LocalDate fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public List<Item_Orden> getItems() {
		return items;
	}

	public void setItems(List<Item_Orden> items) {
		this.items = items;
	}

	public MedioPago getMedioPago() {
		return medioPago;
	}

	public void setMedioPago(MedioPago medioPago) {
		this.medioPago = medioPago;
	}

	public List<Promocion> getPromociones() {
		return promociones;
	}

	public void setPromociones(List<Promocion> promociones) {
		this.promociones = promociones;
	}
	
	
	
}
