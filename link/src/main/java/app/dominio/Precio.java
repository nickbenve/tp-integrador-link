package app.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class Precio {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	public abstract Double calcularPrecio();

}
