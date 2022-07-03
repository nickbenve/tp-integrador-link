package app.DTO;

import java.util.Collection;
import java.util.List;

import app.dominio.Cliente;
import app.dominio.Item_Orden;
import app.dominio.MedioPago;
import app.dominio.Promocion;

public class CarritoDTO {
	
	private List<Item_Orden> items;
	private List<Promocion> promociones;
	private MedioPago medioPago;
	private Cliente cliente;
	private double precioTotalSinDescuento;
	private double precioTotalConDescuento;
	public List<Item_Orden> getItems() {
		return items;
	}
	public void setItems(List<Item_Orden> items) {
		this.items = items;
	}
	public List<Promocion> getPromociones() {
		return promociones;
	}
	public void setPromociones(List<Promocion> promociones) {
		this.promociones = promociones;
	}
	public MedioPago getMedioPago() {
		return medioPago;
	}
	public void setMedioPago(MedioPago medioPago) {
		this.medioPago = medioPago;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public double getPrecioTotalSinDescuento() {
		return precioTotalSinDescuento;
	}
	public void setPrecioTotalSinDescuento(double precioTotalSinDescuento) {
		this.precioTotalSinDescuento = precioTotalSinDescuento;
	}
	public double getPrecioTotalConDescuento() {
		return precioTotalConDescuento;
	}
	public void setPrecioTotalConDescuento(double precioTotalConDescuento) {
		this.precioTotalConDescuento = precioTotalConDescuento;
	}
	public CarritoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CarritoDTO(List<Item_Orden> items, List<Promocion> promociones, MedioPago medioPago, Cliente cliente,
			double precioTotalSinDescuento, double precioTotalConDescuento) {
		super();
		this.items = items;
		this.promociones = promociones;
		this.medioPago = medioPago;
		this.cliente = cliente;
		this.precioTotalSinDescuento = precioTotalSinDescuento;
		this.precioTotalConDescuento = precioTotalConDescuento;
	}



}
