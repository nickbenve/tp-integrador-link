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
public class Carrito {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@OneToMany
	private List<Item_Orden> items;
	
	@Enumerated(EnumType.STRING)
	private MedioPago medioPago;
	
	@ManyToMany
	private List<Promocion> promociones;
	
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

	public Carrito(Cliente cliente) {
		super();
		this.cliente=cliente;
		this.items=new ArrayList<Item_Orden>();
		this.promociones=new ArrayList<Promocion>();
	}

	
	protected Carrito() {
		super();
		this.items=new ArrayList<Item_Orden>();
		this.promociones=new ArrayList<Promocion>();
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
