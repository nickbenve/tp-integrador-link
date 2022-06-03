package app.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import app.dominio.Proveedor;


@RepositoryRestResource(path="proveedores")
public interface RepoProveedor extends PagingAndSortingRepository<Proveedor, Integer>{

}
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