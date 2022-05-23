package app.repositorios;

import java.util.Collection;


import app.dominio.Proveedor;
import app.excepciones.CuilRepetidoExepction;



public interface RepoProveedor {

	public Collection<Proveedor> all();
	
	public Proveedor findByCuil(String cuil);
	public void save(Proveedor proveedor) throws CuilRepetidoExepction;
}
