package app.dominio;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Orden {
	private Integer id;
	private LocalDate fecha_creacion;
	
	@OneToMany
	private ArrayList<Item_Orden> items;
	@ManyToOne
	private MedioPago medioPago;
	@ManyToMany
	private ArrayList<Promocion> promociones;
	private Boolean confirmada;
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
		this.promociones = new ArrayList<Promocion>();
		this.items=new ArrayList<Item_Orden>();
		this.confirmada=false;
	}

	public Double costoTotal() {
		return items.stream().mapToDouble(x->x.calcularPrecioItem()).sum();
	 
	}

	public void agregarItem(Item_Orden itemNuevo) {
		items.add(itemNuevo);
	}
	
	public Double aplicarDescuentos() {
		return this.costoTotal()- promociones.stream().mapToDouble(x->x.descuento(this)).sum();
		
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

	public ArrayList<Item_Orden> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item_Orden> items) {
		this.items = items;
	}

	public MedioPago getMedioPago() {
		return medioPago;
	}

	public void setMedioPago(MedioPago medioPago) {
		this.medioPago = medioPago;
	}

	public ArrayList<Promocion> getPromociones() {
		return promociones;
	}

	public void setPromociones(ArrayList<Promocion> promociones) {
		this.promociones = promociones;
	}
	
	
	
}
