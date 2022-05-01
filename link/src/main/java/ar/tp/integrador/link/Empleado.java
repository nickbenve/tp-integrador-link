package ar.tp.integrador.link;

import java.time.LocalDate;
import java.time.LocalTime;

public class Empleado extends Persona {
	private LocalDate fechaIngreso;
	private Integer Lejago;
	
	public Empleado(Integer idPersona, String nombre, Integer dni) {
		super(idPersona, nombre, dni);
		
		this.fechaIngreso=LocalDate.now();
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Integer getLejago() {
		return Lejago;
	}

	public void setLejago(Integer lejago) {
		Lejago = lejago;
	}

		


}
