package negocioImpl;


import java.util.List;

import dao.DaoCliente;
import daoImpl.DaoClienteImpl;
import entidad.Cliente;
import negocio.ClienteNegocio;

public class ClienteNegocioImpl implements ClienteNegocio {

	DaoCliente daocli = new DaoClienteImpl();
	
	public Boolean ValidarAdministrador(String usuario, String password) {
		return daocli.ValidarAdministrador(usuario,password);
	}

	@Override
	public boolean insert(Cliente cliente) {
		return daocli.insert(cliente);
	}

	@Override
	public boolean delete(String dni) {
		return daocli.delete(dni);
	}

	@Override
	public List<Cliente> listarClientes() {
		return daocli.listarClientes();
	}

	public int validarAdmin(String user, String pass) {
		return daocli.validarAdmin(user, pass);
	}
	
	@Override
	public int validarCliente(String user, String pass) {
		return daocli.validarCliente(user, pass);
	}

	@Override
	public List<Cliente> buscarlistaClientes(String nombre) {
		return daocli.buscarlistaClientes(nombre);
	}

	@Override
	public Cliente buscarCliente(String dni) {
		return daocli.buscarCliente(dni);
	}

	@Override
	public boolean edit(String dni, String nuevoPassword) {
		return daocli.edit(dni, nuevoPassword);
	}

	@Override
	public Cliente traerCliente(String usuario) {
		return daocli.traerCliente(usuario);
	}

	@Override
	public boolean existeCliente(String dni) {
		return daocli.existeCliente(dni);
	}

	
}
