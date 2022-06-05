package app.repo.compl;

import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import app.dominio.MedioPago;
import app.dominio.Producto;
import app.dominio.Proveedor;
import app.dominio.descuentos.PromocionMedioPago;
import app.precios.CotizacionDolar;
import app.precios.CotizacionPesos;

import app.repositorios.RepoCotizacionDolar;
import app.repositorios.RepoCotizacionPesos;
import app.repositorios.RepoProducto;
import app.repositorios.RepoProveedor;


@RepositoryRestController
public class RepoProductoCompl {
	
	@Autowired
	RepoProducto repoProductos;
	
	@Autowired
	RepoCotizacionDolar repoDolar;
		
	@Autowired
	RepoProveedor repoProv;
	
	@Transactional
	@RequestMapping(method = RequestMethod.POST,value="/productos")
	public @ResponseBody String crearProducto(@RequestBody Producto producto){
		
		if(producto.getEsPesos()) {
			repoProductos.save(producto);

		}else {
			
				repoProductos.save(producto);
				return "se guardo el producto";	
				
				
			
		}

		return "hubo un error";
	}
	/*
	 * 
	 * 
	 * 
	 * @Transactional
	@RequestMapping(method = RequestMethod.POST,value="/promocionesMediosDePago")
	public @ResponseBody String crearPromo(@RequestBody Map<String, Object> body){
		
		String descrip=body.get("descripcion").toString();
		String stringPorcentaje=body.get("porcentaje").toString();
		Double valorPorcentaje=Double.parseDouble(stringPorcentaje);
		String medio=body.get("medioPago").toString();
		

		PromocionMedioPago promocion= new PromocionMedioPago();
		promocion.setDescripcion(descrip);
		promocion.setPorcentaje(valorPorcentaje);
		
		for(MedioPago medioi : MedioPago.values())
	      {     
			  if(medioi.name().equals(medio)) {
				 promocion.setMetodoPago(medioi); 
				 repoPromMedio.save(promocion);
				 return "se creo la promocion";
			  }
	      }
		  return "hubo un error";	  		
		}
	 */

}
