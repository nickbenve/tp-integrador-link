package app;

import java.time.LocalDate;
import java.util.ArrayList;

public class Orden {
	private Integer id;
	private LocalDate fecha_creacion;
	private ArrayList<Item_Orden> items;
	private MedioPago medioPago;
	private ArrayList<Promocion> promociones;
	private Boolean confirmada;
	private Double costoConDescuento;
	private Cliente cliente;
	
	
	public Cliente getCliente() {
		return cliente;
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

	public double costoTotal() {
		return items.stream().mapToDouble(x->x.calcularPrecioItem()).sum();
	 
	}

	public void agregarItem(Item_Orden itemNuevo) {
		if(items.contains(itemNuevo)) {
			items.stream().filter(x->x.getProducto().equals(itemNuevo.getProducto())).findFirst().get().agregarCantidad(itemNuevo.getCantidad());		
		}else {
			items.add(itemNuevo);
		}
	}
	
	public void aplicarDescuentos() {
		this.setCostoConDescuento(this.costoTotal()- promociones.stream().mapToDouble(x->x.descuento(this)).sum());
		
	}
	
	public Double costoEnProductosDe(Proveedor proveedor) {
		
		return items.stream().filter(x->x.getProducto().getProveedor().equals(proveedor)).mapToDouble(x->x.calcularPrecioItem()).sum();
	}
	
	public Double getCostoConDescuento() {
		return costoConDescuento;
	}

	public void setCostoConDescuento(Double costoConDescuento) {
		this.costoConDescuento = costoConDescuento;
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
