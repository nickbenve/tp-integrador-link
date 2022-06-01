package app.dominio;

import javax.persistence.Entity;
import javax.persistence.Enumerated;

@Entity
public enum MedioPago {
	
EFECTIVO,TARJETA,CHEQUE
}
