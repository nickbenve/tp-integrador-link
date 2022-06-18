package app.DTO;

public class CuponMedioINPUT {
	String descrip;
	String medio;
	Double porcentaje;
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	public String getMedio() {
		return medio;
	}
	public void setMedio(String medio) {
		this.medio = medio;
	}
	public Double getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}
	public CuponMedioINPUT(String descrip, String medio, Double porcentaje) {
		super();
		this.descrip = descrip;
		this.medio = medio;
		this.porcentaje = porcentaje;
	}
	public CuponMedioINPUT() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
