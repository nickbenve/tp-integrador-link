package app.repo.compl;

import java.util.Map;
import java.util.Optional;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.PathVariable;
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
}


