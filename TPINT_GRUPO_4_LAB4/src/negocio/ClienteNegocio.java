package negocio;


import java.util.List;

import entidad.Cliente;

public interface ClienteNegocio {

	public boolean insert(Cliente cliente);
	public boolean delete (String dni);
	public boolean edit (String dni, String nuevoPassword);
	public boolean existeCliente(String dni);
	
	
	public Boolean ValidarAdministrador(String usuario, String password);
	public List<Cliente> listarClientes();
	public List<Cliente> buscarlistaClientes(String nombre);
	public Cliente buscarCliente(String dni);
	public Cliente traerCliente (String usuario);
	
	public int validarAdmin(String user, String pass);
	public int validarCliente(String user, String pass);
}
