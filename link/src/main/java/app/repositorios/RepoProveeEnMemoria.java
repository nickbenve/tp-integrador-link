package app.repositorios;

import java.util.ArrayList;
import java.util.Collection;

import app.dominio.Producto;
import app.dominio.Proveedor;
import app.excepciones.CuilRepetidoExepction;
import app.excepciones.ProductoExistenteExepction;

/*
public class RepoProveeEnMemoria implements RepoProveedor{

	
	private Collection<Proveedor> proveedores;
	public RepoProveeEnMemoria(Collection<Proveedor> proveedores) {
		super();
		this.proveedores =new ArrayList<Proveedor>();
	}

	
	
	
	
	@Override
	public Collection<Proveedor> all() {
		// TODO Auto-generated method stub
		return proveedores;
	}

	@Override
	public Proveedor findByCuil(String cuil) {
		// TODO Auto-generated method stub
		return proveedores.stream().filter(x->x.getCuit().equals(cuil)).findFirst().get();
	}

	@Override
	public void save(Proveedor proveedor) throws CuilRepetidoExepction {
		if(proveedores.contains(proveedor)) {
			throw new CuilRepetidoExepction("Ya se encuentra en el sistema el cuil "+proveedor.getNombre());
		}else {
			proveedores.add(proveedor);
		}
		
	}

}
*/
