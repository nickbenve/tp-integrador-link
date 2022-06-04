package app.repo.compl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import app.dominio.MedioPago;
import app.dominio.descuentos.PromocionMedioPago;
import app.repositorios.RepoPromocionMedioPago;


@RepositoryRestController
public class RepoDescMedPagoCompl {

	@Autowired
	RepoPromocionMedioPago repoPromMedio;
	
	@Transactional
	@RequestMapping(method = RequestMethod.POST,value="/promocionesMediosDePago")
	public @ResponseBody String crearPromo(
			@RequestBody String descripcion,@RequestBody Double porcentaje,@RequestBody String medio) {
		
		
		  PromocionMedioPago promocion= new PromocionMedioPago();
		  promocion.setDescripcion(descripcion);
		  promocion.setPorcentaje(porcentaje);
		
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
}


