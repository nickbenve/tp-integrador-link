package app.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Promocion {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	public abstract Double descuento(Carrito carrito);
	public abstract void utilizar();

}
