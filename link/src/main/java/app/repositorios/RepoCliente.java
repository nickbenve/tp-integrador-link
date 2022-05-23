package app.repositorios;

import java.util.Collection;

import app.dominio.Cliente;
import app.excepciones.ClienteRepetidoException;

public interface RepoCliente {

	public Collection<Cliente> all();

	public Cliente findByDni(Integer dni);

	public void save(Cliente cliente) throws ClienteRepetidoException ;
}
