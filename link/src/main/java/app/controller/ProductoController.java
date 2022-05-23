package app.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.dominio.Producto;
import app.repositorios.RepoProducto;


@RestController
@RequestMapping("/producto")
public class ProductoController {
	@Autowired
	private RepoProducto repo;
	
	@GetMapping("")

	public Page<Producto> list(@RequestParam(value = "nombre", required = false) String nombre,@RequestParam(value = "proveedor", required = false) String proveedor, Pageable page) {
		if (nombre == null || proveedor == null) {
			List<Producto> all = new ArrayList<>(repo.all());
			int fromIndex = page.getPageNumber() * page.getPageSize();
			return new PageImpl<Producto>(all.subList(fromIndex, fromIndex + page.getPageSize()), page, all.size());
		} else {
			ArrayList<Producto> producto= new ArrayList<Producto>();
			producto.add(repo.findByNombreYProv(nombre+proveedor));
			return new PageImpl<Producto>(producto);
		}
	}
	
}