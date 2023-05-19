package daoImpl;

import dao.DaoCliente;
import entidad.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;




public class DaoClienteImpl implements DaoCliente {

	private static final String consultarAdministrador = "select * from admin where nombre = ? AND password = ? ";
	private static final String consultarCliente = "select * from clientes where Usuario = ? and password = ? and estado=1";
	
	private static final String traerCliente = "select * from clientes where Dni = ? ";
	private static final String buscarCliente = "select * from clientes where Usuario = ? ";
	
	private static final String modificarCliente = "UPDATE clientes SET password=? WHERE Dni=?";
	
	private static final String traerTodosClientes = "SELECT * FROM clientes WHERE estado=1";
	private static final String insertarCliente = "INSERT INTO clientes(Dni,Cuil_c,Nombre,Apellido,Sexo,Nacionalidad,FechaNacimiento,Direccion,Localidad,Provincia,Mail,Telefono,Usuario,password,estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "UPDATE clientes set estado = 0 where Dni = ? ";

	private ResultSet resulSet;
	


	@Override
	public List<Cliente> listarClientes() 
	{
		PreparedStatement statement;
		ResultSet resulSet;
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(traerTodosClientes);
			resulSet = statement.executeQuery();
			while(resulSet.next()) {
				clientes.add(getCliente(resulSet));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clientes;
	}
	
	
	private Cliente getCliente (ResultSet rs) throws SQLException
	{
		Cliente c = new Cliente();
		
		c.setDni(rs.getString("Dni"));
		c.setCuil_c(rs.getString("Cuil_c"));
		c.setNombre(rs.getString("Nombre"));
		c.setApellido(rs.getString("Apellido"));
		c.setSexo(rs.getString("Sexo"));
		c.setNacionalidad(rs.getString("Nacionalidad"));
		c.setFechaNacimiento( (rs.getString("FechaNacimiento")));
		c.setDireccion(rs.getString("Direccion"));
		c.setLocalidad(rs.getString("Localidad"));
		c.setProvincia(rs.getString("Provincia"));
		c.setMail(rs.getString("Mail"));
		c.setTelefono(rs.getString("Telefono"));
		c.setUsuario(rs.getString("Usuario"));
		c.setPassword(rs.getString("password"));
		c.setEstado(rs.getBoolean("estado"));
		
		return c;
		
	}
		
	
	


	@Override
	public boolean insert(Cliente cliente) {
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insertarCliente);
			
			statement.setString(1, cliente.getDni());
			statement.setString(2, cliente.getCuil_c());
			statement.setString(3, cliente.getNombre());
			statement.setString(4, cliente.getApellido());
			statement.setString(5, cliente.getSexo());
			statement.setString(6, cliente.getNacionalidad());
			statement.setString(7, cliente.getFechaNacimiento());
			statement.setString(8, cliente.getDireccion());
			statement.setString(9, cliente.getLocalidad());
			statement.setString(10, cliente.getProvincia());
			statement.setString(11, cliente.getMail());
			statement.setString(12, cliente.getTelefono());
			statement.setString(13, cliente.getUsuario());
			statement.setString(14, cliente.getPassword());
			statement.setBoolean(15, cliente.getEstado());
			
			
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}


	@Override
	public boolean edit(String dni, String nuevoPassword) {
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean modificarExitoso = false;
		try {
			
			statement = conexion.prepareStatement(modificarCliente);
			
			statement.setString(1, nuevoPassword);
			
			statement.setString(2, dni);
			
			
			
			if(statement.executeUpdate() > 0 ) {
				conexion.commit();
				modificarExitoso = true;
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return modificarExitoso;
	}


	@Override
	public Boolean ValidarAdministrador(String password, String usuario) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int validarAdmin(String user, String pass) {
		
		int adm = 0;
		PreparedStatement statement;
		ResultSet resulSet;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(consultarAdministrador);
			statement.setString(1, user);
			statement.setString(2, pass);
			resulSet = statement.executeQuery();
			while(resulSet.next()) {
				adm = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return adm;
	}
	
	@Override
	public int validarCliente(String user, String pass) {
		int cl = 0;
		PreparedStatement statement;
		ResultSet resulSet;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(consultarCliente);
			statement.setString(1, user);
			statement.setString(2, pass);
			resulSet = statement.executeQuery();
			while(resulSet.next()) {
				cl = 2;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cl;
	}	


	

	@Override
	public List<Cliente> buscarlistaClientes(String nombre) {
		PreparedStatement statement;
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		String sql;
		sql = "select * from clientes where Nombre like '%"+nombre+"%'";
		
		try {
			Conexion conexion = Conexion.getConexion();
			statement = conexion.getSQLConexion().prepareStatement(sql);
			resulSet = statement.executeQuery();
			while(resulSet.next()) {
				clientes.add(getCliente(resulSet));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clientes;
		
	}


	@Override
	public Cliente buscarCliente(String dni) {
		PreparedStatement statement;
		Cliente persona = new Cliente();
		try {
			Conexion conexion = Conexion.getConexion();
			statement = conexion.getSQLConexion().prepareStatement(traerCliente);
			statement.setString(1, dni);
			resulSet = statement.executeQuery();
			while(resulSet.next()) {
				persona.setDni(resulSet.getString(1));
				persona.setCuil_c(resulSet.getString(2));
				persona.setNombre(resulSet.getString(3));
				persona.setApellido(resulSet.getString(4));
				persona.setSexo(resulSet.getString(5));
				persona.setNacionalidad(resulSet.getString(6));
				persona.setFechaNacimiento(resulSet.getDate(7).toString());
				persona.setDireccion(resulSet.getString(8));
				persona.setLocalidad(resulSet.getString(9));
				persona.setProvincia(resulSet.getString(10));
				persona.setMail(resulSet.getString(11));
				persona.setTelefono(resulSet.getString(12));
				persona.setUsuario(resulSet.getString(13));
				persona.setPassword(resulSet.getString(14));
				persona.setEstado(resulSet.getBoolean(15));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return persona;
	}


	@Override
	public boolean delete(String dni) {
		
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean rowDeleted = false;
		
		try {
			statement = conexion.prepareStatement(delete);
			statement.setString(1, dni);
			
			if(statement.executeUpdate() >0) {
				conexion.commit();
				rowDeleted = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return rowDeleted;
		
	}


	
	@Override
	public Cliente traerCliente(String usuario) {
		PreparedStatement statement;
		Cliente persona = new Cliente();
		try {
			Conexion conexion = Conexion.getConexion();
			statement = conexion.getSQLConexion().prepareStatement(buscarCliente);
			statement.setString(1, usuario);
			resulSet = statement.executeQuery();
			while(resulSet.next()) {
				persona.setDni(resulSet.getString(1));
				persona.setCuil_c(resulSet.getString(2));
				persona.setNombre(resulSet.getString(3));
				persona.setApellido(resulSet.getString(4));
				persona.setSexo(resulSet.getString(5));
				persona.setNacionalidad(resulSet.getString(6));
				persona.setFechaNacimiento(resulSet.getDate(7).toString());
				persona.setDireccion(resulSet.getString(8));
				persona.setLocalidad(resulSet.getString(9));
				persona.setProvincia(resulSet.getString(10));
				persona.setMail(resulSet.getString(11));
				persona.setTelefono(resulSet.getString(12));
				persona.setUsuario(resulSet.getString(13));
				persona.setPassword(resulSet.getString(14));
				persona.setEstado(resulSet.getBoolean(15));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return persona;

	}


	@Override
	public boolean existeCliente(String dni) {
		
		boolean existe = false;
		
		PreparedStatement statement;
		ResultSet resulSet;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(traerCliente);
			statement.setString(1, dni);
			resulSet = statement.executeQuery();
			while(resulSet.next()) {
				existe=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return existe;
	}


	

}
