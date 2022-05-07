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
	
	public Orden(Integer id) {
		super();
		this.id = id;
		this.promociones = new ArrayList<Promocion>();
		this.items=new ArrayList<Item_Orden>();
		this.confirmada=false;
	}

	public Float costoTotal() {
		return null;
		
//		return 
	}
	public void agregarItem(Item_Orden item) {
//		si ya lo compro le agregas la cantidads		
//		
//		
//
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
