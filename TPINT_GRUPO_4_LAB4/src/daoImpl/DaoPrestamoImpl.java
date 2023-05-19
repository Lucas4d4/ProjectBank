package daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.DaoCuenta;
import dao.DaoPrestamo;
import entidad.Cuenta;
import entidad.Prestamo;


public class DaoPrestamoImpl implements DaoPrestamo{
	private static final String traerPrestamos = "SELECT * FROM prestamos";
	private static final String adminPrestamos = "SELECT * FROM pedidoprestamos where EstadoPedido=1";
	private static final String eliminarPrestamos="UPDATE pedidoprestamos SET EstadoPedido=0 WHERE NroPedido=?";
	private static final String insertarPrestamo = "INSERT INTO prestamos(NroPrestamo, NroCuenta_P, FechaVencimiento, ImporteaPagarInt, ImporteSolicitado, PlazoDePago, MontoAPagarPorMes, Cuotas, EstadoPrestamo) values (?, ?, ?, ?, ?, ?, ?, ?, 1)";
	private static final String traerNroCuenta="SELECT NroCuenta FROM pedidoprestamos WHERE NroPedido=?";
	private static final String traerImporteSolicitado="SELECT ImportePedido FROM pedidoprestamos WHERE NroPedido=?";
	private static final String traerCantCuotas="SELECT CantCuotasPedido FROM pedidoprestamos WHERE NroPedido=?";
	private static final String insertPedidoPrestamo="INSERT INTO pedidoprestamos (NroCuenta, ImportePedido, CantCuotasPedido, EstadoPedido) values(?,?,?,1)";
	private static final String traerPrestamo = "select * from prestamos where dniCliente = ?";
	private ResultSet resulSet;
	
	@Override
	public int AgregarPrestamo(Prestamo prestamo) {
		
		 PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		int isInsertExitoso = 0;
		try
		{
			statement = conexion.prepareStatement(insertarPrestamo);
			statement.setString(1, Integer.toString(NumeroDePrestamo()));
			statement.setString(2, prestamo.getNroCuenta_P());
			statement.setDate(3, prestamo.getFechaVencimiento());
			statement.setFloat(4, prestamo.getImporteaPagar());
			statement.setFloat(5, prestamo.getImporteSolicitado());
			statement.setFloat(6, prestamo.getPlazoDePago());
			statement.setFloat(7, prestamo.getMontoAPagarPorMes());
			statement.setInt(8, prestamo.getCuotas());

			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = 1;
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
	public List<Prestamo> ListarPrestamos() {
		PreparedStatement statement;
		ResultSet resulSet;
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(traerPrestamos);
			resulSet = statement.executeQuery();
			while(resulSet.next()) {
				Prestamo p = new Prestamo();
				p.setNroPrestamo(resulSet.getString("NroPrestamo"));
				p.setNroCuenta_P(resulSet.getString("NroCuenta_P"));
				p.setFechaVencimiento(resulSet.getDate("FechaVencimiento"));
				p.setImporteaPagar(resulSet.getFloat("ImporteaPagarInt"));
				p.setImporteSolicitado(resulSet.getFloat("ImporteSolicitado"));
				p.setPlazoDePago(resulSet.getInt("PlazoDePago"));
				p.setMontoAPagarPorMes(resulSet.getFloat("MontoAPagarPorMes"));
				p.setCuotas(resulSet.getInt("Cuotas"));
				p.setEstadoPrestamo(resulSet.getInt("EstadoPrestamo"));
				prestamos.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prestamos;
	}
	@Override
	public List<Prestamo> ListarPedidosPrestamos(){
		PreparedStatement statement;
		ResultSet resulSet;
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(adminPrestamos);
			resulSet = statement.executeQuery();
			while(resulSet.next()) {
				Prestamo p = new Prestamo();
				p.setNroPrestamo(resulSet.getString("NroPedido"));
				p.setNroCuenta_P(resulSet.getString("NroCuenta"));
				p.setImporteSolicitado(resulSet.getFloat("ImportePedido"));
				p.setCuotas(resulSet.getInt("CantCuotasPedido"));
				p.setEstadoPrestamo(resulSet.getInt("EstadoPedido"));
				if(p.getEstadoPrestamo()==1)
				{prestamos.add(p);}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prestamos;
	}
	@Override
	public int EliminarPedidoPrestamo(String NroPedido) {
		
		 PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		int isUpdateExitoso = 0;
		try
		{
			statement = conexion.prepareStatement(eliminarPrestamos);
			statement.setString(1, NroPedido);

			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isUpdateExitoso = 1;
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
		
		return isUpdateExitoso; 
		 
		 
	}
	public int NumeroDePrestamo() {
		List<Prestamo> prestamos = ListarPrestamos();
		int size = prestamos.size() + 1;
		return size;
	}

	@Override
	public String traerNroCuenta(String NroPedido) {
		
		PreparedStatement statement;
		ResultSet resulSet;
		String NroCuentaPedido=null;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(traerNroCuenta);
			statement.setString(1, NroPedido);
			resulSet = statement.executeQuery();
			while(resulSet.next()) {
				NroCuentaPedido=resulSet.getString("NroCuenta");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return NroCuentaPedido; 
		 
	}

	@Override
	public float traerImporteSolicitado(String NroPedido) {
		
		PreparedStatement statement;
		ResultSet resulSet;
		float ImporteSolicitado = 0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(traerImporteSolicitado);
			statement.setString(1, NroPedido);
			resulSet = statement.executeQuery();
			while(resulSet.next()) {
				ImporteSolicitado=resulSet.getFloat("ImportePedido");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ImporteSolicitado;  
		 
	}

	@Override
	public int traerCantCuotasSolicitado(String NroPedido) {
		PreparedStatement statement;
		ResultSet resulSet;
		int CantCuotas=0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(traerCantCuotas);
			statement.setString(1, NroPedido);
			resulSet = statement.executeQuery();
			while(resulSet.next()) {
				CantCuotas=resulSet.getInt("CantCuotasPedido");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CantCuotas; 
	}

	@Override
	public int insertPedidoPrestamo(Prestamo prestamo) {
				 PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		int isInsertExitoso = 0;
		try
		{
			statement = conexion.prepareStatement(insertPedidoPrestamo);
			statement.setString(1, prestamo.getNroCuenta_P());
			statement.setFloat(2, prestamo.getImporteSolicitado());
			statement.setInt(3, prestamo.getCuotas());


			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = 1;
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
	public Prestamo buscarPrestamo(String dni) {
		PreparedStatement statement;
		
		Prestamo prest = new Prestamo();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(traerPrestamo);
			statement.setString(1, dni);
			resulSet = statement.executeQuery();
			while(resulSet.next()) {
				prest.setNroPrestamo(resulSet.getString(1));
				prest.setNroCuenta_P(resulSet.getString(2));
				prest.setFechaVencimiento(resulSet.getDate(3));
				prest.setImporteaPagar(resulSet.getFloat(4));
				prest.setImporteSolicitado(resulSet.getFloat(5));
				prest.setPlazoDePago(resulSet.getInt(6));
				prest.setMontoAPagarPorMes(resulSet.getFloat(7));
				prest.setCuotas(resulSet.getInt(8));
				prest.setEstadoPrestamo(resulSet.getInt(9));
				prest.setDniCliente(resulSet.getString(10));

				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prest; 
	}
}
	

