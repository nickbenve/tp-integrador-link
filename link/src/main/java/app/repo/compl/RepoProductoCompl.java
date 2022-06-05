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
import app.precios.CalculadorPrecioArgentino;
import app.precios.CalculadorPrecioDolar;
import app.repositorios.RepoCalculadorPrecioArgentino;
import app.repositorios.RepoCalculadorPrecioDolar;
import app.repositorios.RepoProducto;
import app.repositorios.RepoProveedor;


@RepositoryRestController
public class RepoProductoCompl {
	
	@Autowired
	RepoProducto repoProductos;
	
	@Autowired
	RepoCalculadorPrecioArgentino repoPesos;
	
	@Autowired
	RepoCalculadorPrecioDolar repoDolar;
	
	@Autowired
	RepoProveedor repoProv;
	
	@Transactional
	@RequestMapping(method = RequestMethod.POST,value="/productos")
	public @ResponseBody String crearProducto(@RequestBody Map<String, Object> body){
		
		
		String nombre=body.get("nombre").toString();
		String descripcion=body.get("descripcion").toString();
		String precioString=body.get("precio").toString();
		String stockString=body.get("stock").toString();
		
		String idProveedor= body.get("proveedor").toString();
		Integer proveedor=Integer.parseInt(idProveedor);
		Optional<Proveedor> prov=repoProv.findById(proveedor);
		
		
		Producto producto= new Producto();
		Integer stock=Integer.parseInt(stockString);
		Double precioNum=Double.parseDouble(precioString);
		String moneda=body.get("moneda").toString();
		
		producto.setNombre(nombre);

		producto.setDescripcion(descripcion);
		producto.setStock(stock);
	
		if(moneda.equals("$")) {
			CalculadorPrecioArgentino precio=new CalculadorPrecioArgentino(precioNum);
			producto.setPrecio(precio);	
			if(!prov.isEmpty()) {
				producto.setProveedor(prov);
				repoPesos.save(precio);
				repoProductos.save(producto);
				
				return "se guardo el producto";
			}
		}else {
			if(moneda.equals("USD")) {
				CalculadorPrecioDolar precio=new CalculadorPrecioDolar(precioNum);
				
				producto.setPrecio(precio);	
				producto.setProveedor(prov);
				repoDolar.save(precio);
				repoProductos.save(producto);
				return "se guardo el producto";	
				
				
			}
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
