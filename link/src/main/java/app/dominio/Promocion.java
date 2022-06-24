package app.dominio;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "categoria",discriminatorType = DiscriminatorType.INTEGER)
public abstract class Promocion {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	public abstract Double descuento(Carrito carrito);
	public abstract void utilizar();

}
