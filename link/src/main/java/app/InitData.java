package app;



import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.stereotype.Component;

import app.dominio.Carrito;
import app.dominio.Cliente;
import app.dominio.MedioPago;
import app.dominio.Membrecia;
import app.dominio.Persona;
import app.dominio.Producto;
import app.dominio.Promocion;
import app.dominio.Proveedor;
import app.dominio.Vendedor;
import app.dominio.descuentos.CuponProveedor;
import app.dominio.descuentos.DescuentoMembrecia;
import app.dominio.descuentos.PromocionMedioPago;
import app.repositorios.RepoCarrito;
import app.repositorios.RepoCliente;
import app.repositorios.RepoMembrecia;
import app.repositorios.RepoPersona;
import app.repositorios.RepoProducto;
import app.repositorios.RepoPromocion;
import app.repositorios.RepoProveedor;
import app.repositorios.RepoVendedor;


@Component
public class InitData implements CommandLineRunner  {
	
	@Autowired
	RepositoryRestConfiguration config;
	

	@Autowired
	RepoPersona repoPersonas;
	
	@Autowired
	RepoVendedor repoVendedores;
	
	@Autowired
	RepoCliente repoClientes;
	
	@Autowired
	RepoProveedor repoProveedores;
	
	@Autowired
	RepoProducto repoProd;
	
	@Autowired
	RepoCarrito repoCarrito;
	
	@Autowired
	RepoMembrecia repoMembrecia;
	
	@Autowired
	RepoPromocion repoPromo;
	
	@Override
	public void run(String... args) throws Exception {
		config.exposeIdsFor(Producto.class,Carrito.class,Proveedor.class,Promocion.class,Cliente.class);
		
		if(repoPersonas.count()==0) {
			Cliente cliente1=new Cliente("Juanito","33333");
			Cliente cliente2=new Cliente("Albert","4444");
			
			
			repoClientes.save(cliente1);
			repoClientes.save(cliente2);
			
			
			
			
			Proveedor proveedor1=new Proveedor("Dia","aaaaaa");
			Proveedor proveedor2=new Proveedor("Diarco","bbbbb");
			repoProveedores.save(proveedor1);
			repoProveedores.save(proveedor2);
			
			
			Producto producto1=new Producto("Remera" , "Color negro",true,"https://sublitextil.com.ar/wp-content/uploads/2019/01/Remera-sublimar-hombre-.jpg",200.0,5000,proveedor1);
			Producto producto2=new Producto("Pantalon negro","Talle m",true,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTpe-lszpHSJetmVqGxvlN0RX0SiWhS4Fyc9w&usqp=CAU",1.0,5000,proveedor2);
			Producto producto3=new Producto("Heladera ","Alta",false,"https://www.lg.com/ar/images/heladeras/md06176357/gallery/1100_1.jpg",2000.0,5000,proveedor1);
			Producto producto4=new Producto("Auto","Alta gama",false,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTpe-lszpHSJetmVqGxvlN0RX0SiWhS4Fyc9w&usqp=CAU",1.0,5000,proveedor2);
			Producto producto5=new Producto("Mesa" , "Madera",true,"https://i.ytimg.com/vi/d_zHVhzzPI4/maxresdefault.jpg",300.0,5000,proveedor1);
			Producto producto6=new Producto("Televisor","40 pulgadas",false,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSSGf03zoJZSZ-r2wZs_PI1v4aTacBIX-6VdQ&usqp=CAU",1.0,5000,proveedor2);
			Producto producto7=new Producto("Pc" , "16 de ram",true,"https://sublitextil.com.ar/wp-content/uploads/2019/01/Remera-sublimar-hombre-.jpg",200.0,5000,proveedor1);
			Producto producto8=new Producto("Jean","azul",true,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTpe-lszpHSJetmVqGxvlN0RX0SiWhS4Fyc9w&usqp=CAU",1.0,5000,proveedor2);
			
			List<Producto> productosIniciales=List.of(producto1,producto2,producto1,producto3,producto4,producto5,producto6,producto7,producto8);
			productosIniciales.stream().forEach(producto -> {
			repoProd.save(producto);
			});
			

			
			Vendedor vendedor1= new Vendedor("Carlos",11111,Arrays.asList(proveedor1),Arrays.asList(producto1,producto2,producto3,producto4));
			Vendedor vendedor2= new Vendedor("Juan",12222,Arrays.asList(proveedor2),Arrays.asList(producto5,producto6,producto7,producto8));
			repoVendedores.save(vendedor1);
			repoVendedores.save(vendedor2);
		
			Persona persona1=new Persona("v","v",vendedor1);
			Persona persona2=new Persona("v","v",vendedor2);
			Persona persona3=new Persona("c","c",cliente1);
			Persona persona4=new Persona("c2","c2",cliente2);
			
			repoPersonas.save(persona1);
			repoPersonas.save(persona2);
			repoPersonas.save(persona3);
			repoPersonas.save(persona4);
			
			Carrito carritoc1=new Carrito();
			Carrito carritoc2=new Carrito();
			carritoc1.setCliente(cliente1);
			carritoc2.setCliente(cliente2);
			
			
		
				
			
		
			PromocionMedioPago promoMedioDePago = new PromocionMedioPago("Descuento en efectivo",MedioPago.EFECTIVO, 0.1);
			CuponProveedor cuponProveedor = new CuponProveedor(700.0,proveedor1,false);
			Membrecia membrecia = new Membrecia(Arrays.asList(cliente2));
			
			repoMembrecia.save(membrecia);
			
			DescuentoMembrecia desmembre=new DescuentoMembrecia(membrecia,0.5);
			carritoc2.agregarPromo(desmembre);		
			List<Promocion> promocionesIniciales=List.of(promoMedioDePago,cuponProveedor,desmembre);
			promocionesIniciales.stream().forEach(promocion -> {
			repoPromo.save(promocion);
			});

			
			carritoc1.agregarPromo(promoMedioDePago);
			carritoc2.agregarPromo(promoMedioDePago);

			repoCarrito.save(carritoc1);
			repoCarrito.save(carritoc2);
			

		}
		
	}
		

}


