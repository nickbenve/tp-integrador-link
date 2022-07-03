package app.dominio;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Rol {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false, unique=true, columnDefinition = "BINARY(16)")
	private UUID id;

	public abstract String getRol();
	
	public UUID getId() {
		return this.id;
	};
//
//	@Id @GeneratedValue(strategy = GenerationType.AUTO)
//	private Integer id;


	
	
}
