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
import entidad.Cliente;
import entidad.Cuenta;
import entidad.Movimiento;
import exceptions.CuentaException;

public class DaoCuentaImpl implements DaoCuenta {
	private static final String insertarCuenta = "INSERT INTO cuentas(NroCuenta,Dni_C,FechaCreacion,TipoCuenta,CBU,Saldo,estadoCuenta)VALUES(?,?,?,?,?,10000,?)";
	private static final String traerCuentas = "SELECT * FROM cuentas WHERE estadoCuenta=1";	
	private static final String EliminarCuenta="UPDATE cuentas SET estadoCuenta=0 WHERE NroCuenta=?";
	private static final String ModificarCuenta="UPDATE cuentas SET TipoCuenta=?, Saldo=? WHERE NroCuenta=?";
	private static final String insertarMovimiento="INSERT INTO movimientos (NroCuenta_M, FechaMovimiento, DetalleMovimiento, TipoMovimiento, ImporteMovimiento, estadoMovimiento) VALUES(?,?,?,?,?,1)";
	private static final String ListarMovimientos="SELECT Nro_Movimiento, NroCuenta_M, FechaMovimiento, DetalleMovimiento, TipoMovimiento, ImporteMovimiento, estadoMovimiento FROM movimientos INNER JOIN cuentas INNER JOIN clientes ON movimientos.NroCuenta_M=cuentas.NroCuenta AND cuentas.Dni_C=clientes.Dni WHERE cuentas.Dni_C=?";
	private static final String transferirDinero="UPDATE cuentas SET Saldo=Saldo+? WHERE CBU=?";
	private static final String actualizarSaldo="UPDATE cuentas SET Saldo=Saldo-? WHERE NroCuenta=?";
	private static final String verificarCBU="SELECT * FROM cuentas WHERE CBU=? AND estadoCuenta=1";
	private static final String traerNroCuentas="SELECT * FROM cuentas WHERE Dni_C=? AND estadoCuenta=1";
	private static final String traerDNI="SELECT Dni_C FROM cuentas WHERE NroCuenta=?";
	private static final String traerSaldo="SELECT Saldo FROM cuentas WHERE NroCuenta=?";
	private static final String filtrarFecha="SELECT * FROM cuentas WHERE estadoCuenta=1 AND FechaCreacion BETWEEN ? AND ?";
	
	//SELECT Nro_Movimiento, NroCuenta_M, FechaMovimiento, DetalleMovimiento, TipoMovimiento, ImporteMovimiento, estadoMovimiento FROM movimientos INNER JOIN cuentas INNER JOIN clientes ON movimientos.NroCuenta_M=cuentas.NroCuenta AND cuentas.Dni_C=clientes.Dni WHERE cuentas.Dni_C='23567876';
	
	
	//SELECT @Resultado = COUNT(*) FROM TBL_DOC_APRO
	
	@Override
	public int AgregarCuenta(Cuenta cuentaCliente)  {
		
		 PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		int isInsertExitoso = 0;
		try
		{
			statement = conexion.prepareStatement(insertarCuenta);
			statement.setString(1, cuentaCliente.getNroCuenta());
			statement.setString(2, cuentaCliente.getDNI());
			statement.setDate(3, cuentaCliente.getFechaCreacion());
			statement.setString(4, cuentaCliente.getTipoCuenta());
			statement.setString(5, cuentaCliente.getCBU());
			statement.setInt(6, cuentaCliente.isEstado());

			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = 1;
			}
		} 
		
		catch (SQLException e) 
		{
			System.out.println("ERROR EN BASE DE DATOS");
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				System.out.println("ERROR EN BASE DE DATOS");
			}
		}
		
		return isInsertExitoso; 
		 
		 //o DE Cuentacom.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException:
	}

	@Override
	public List<Cuenta> ListarCuentas() {
 PreparedStatement statement;
		ResultSet resulSet;
		ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(traerCuentas);
			resulSet = statement.executeQuery();
			while(resulSet.next()) {
				Cuenta cuenta=new Cuenta();
				cuenta.setNroCuenta(resulSet.getString("NroCuenta"));
				cuenta.setDNI(resulSet.getString("Dni_C"));
				cuenta.setFechaCreacion(resulSet.getDate("FechaCreacion"));
				cuenta.setTipoCuenta(resulSet.getString("TipoCuenta"));
				cuenta.setCBU(resulSet.getString("CBU"));
				cuenta.setSaldo(resulSet.getFloat("Saldo"));
//				cuenta.setEstado(resulSet.getInt("estadoCuenta"));
				cuentas.add(cuenta);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cuentas;
		 

	}

	@Override
	public int EliminarCuenta(String NroCuenta) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		int isUpdateExitoso = 0;
		try
		{
			statement = conexion.prepareStatement(EliminarCuenta);
			statement.setString(1, NroCuenta);

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



	@Override
	public int ModificarCuenta(String NroCuenta, String TipoCuenta, float Saldo) {
		
		PreparedStatement statement;
				Connection conexion = Conexion.getConexion().getSQLConexion();
				int isUpdateExitoso = 0;
				try
				{
					statement = conexion.prepareStatement(ModificarCuenta);
					statement.setString(1, TipoCuenta);
					statement.setFloat(2, Saldo);
					statement.setString(3, NroCuenta);

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


	@Override
	public boolean insertMovimiento(Movimiento movimiento) {
		
		 		 PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insertarMovimiento);
			//statement.setString(1, cuentaCliente.getNroCuenta());
			statement.setString(1, movimiento.getNroCuentaM());
			statement.setDate(2, movimiento.getFechaMovimiento());
			statement.setString(3, movimiento.getDetalleMovimiento());
			statement.setString(4, movimiento.getTipoMovimiento());
			statement.setFloat(5, movimiento.getImporteMovimiento());

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
	public List<Movimiento> ListarMovimientos(String NroCliente) {
		
	PreparedStatement statement;
		ResultSet resulSet;
		ArrayList<Movimiento> movimientos = new ArrayList<Movimiento>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(ListarMovimientos);
			statement.setString(1, NroCliente);
			resulSet = statement.executeQuery();
			while(resulSet.next()) {
				Movimiento movimiento=new Movimiento();
				movimiento.setNroMovimiento(resulSet.getString("Nro_Movimiento"));
				movimiento.setNroCuentaM(resulSet.getString("NroCuenta_M"));
				movimiento.setFechaMovimiento(resulSet.getDate("FechaMovimiento"));
				movimiento.setDetalleMovimiento(resulSet.getString("DetalleMovimiento"));
				movimiento.setTipoMovimiento(resulSet.getString("TipoMovimiento"));
				movimiento.setImporteMovimiento(resulSet.getFloat("ImporteMovimiento"));
				movimiento.setEstadoMovimiento(resulSet.getBoolean("estadoMovimiento"));

				movimientos.add(movimiento);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movimientos;
		 
	}

	@Override
	public int validarInsert(int insert) throws CuentaException{
		if(insert==0) {
			CuentaException ex1=new CuentaException();
			throw ex1;
		}
		
		return insert;
	}

	@Override
	public int transferirDinero(String CBU, float ImporteTransferencia) {
		
		PreparedStatement statement;
				Connection conexion = Conexion.getConexion().getSQLConexion();
				int isUpdateExitoso = 0;
				try
				{
					statement = conexion.prepareStatement(transferirDinero);
					statement.setFloat(1, ImporteTransferencia);
					statement.setString(2, CBU);

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

	@Override
	public int actualizarSaldoCuenta(float cambioSaldo, String NroCuenta) {
		
				PreparedStatement statement;
				Connection conexion = Conexion.getConexion().getSQLConexion();
				int isUpdateExitoso = 0;
				try
				{
					statement = conexion.prepareStatement(actualizarSaldo);
					statement.setFloat(1, cambioSaldo);
					statement.setString(2, NroCuenta);

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

	@Override
	public List<Cuenta> ListarNroCuentas(String Dni) {
		PreparedStatement statement;
		ResultSet resulSet;
		ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(traerNroCuentas);
			statement.setString(1, Dni);
			resulSet = statement.executeQuery();
			while(resulSet.next()) {
				Cuenta cuenta=new Cuenta();
				cuenta.setNroCuenta(resulSet.getString("NroCuenta"));
				cuenta.setDNI(resulSet.getString("Dni_C"));
				cuenta.setFechaCreacion(resulSet.getDate("FechaCreacion"));
				cuenta.setTipoCuenta(resulSet.getString("TipoCuenta"));
				cuenta.setCBU(resulSet.getString("CBU"));
				cuenta.setSaldo(resulSet.getFloat("Saldo"));
				cuenta.setEstado(resulSet.getInt("estadoCuenta"));
				cuentas.add(cuenta);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cuentas;

	}

	@Override
	public String devuelveDNI(String NroCuenta) {
			PreparedStatement statement;
		ResultSet resulSet;
		String Dni="";
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(traerDNI);
			statement.setString(1, NroCuenta);
			resulSet = statement.executeQuery();
			while(resulSet.next()) {
			  	Dni=resulSet.getString("Dni_C");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Dni;
	}

	@Override
	public float devuelveSaldo(String NroCuenta) {
		 	PreparedStatement statement;
		ResultSet resulSet;
		float Saldo=0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(traerSaldo);
			statement.setString(1, NroCuenta);
			resulSet = statement.executeQuery();
			while(resulSet.next()) {
			  	Saldo=resulSet.getFloat("Saldo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Saldo;
	}

	@Override
	public String verificarCBU(String CBU) {
		 	PreparedStatement statement;
		ResultSet resulSet;
		String verifiCBU="";
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(verificarCBU);
			statement.setString(1, CBU);
			resulSet = statement.executeQuery();
			while(resulSet.next()) {
			  	verifiCBU=resulSet.getString("CBU");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return verifiCBU;
	}

	@Override
	public List<Cuenta> ListarCuentasFiltrar(Date fechaDesde, Date fechaHasta) {
		PreparedStatement statement;
		ResultSet resulSet;
		ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(filtrarFecha);
			statement.setDate(1, fechaDesde);
			statement.setDate(2, fechaHasta);
			resulSet = statement.executeQuery();
			while(resulSet.next()) {
				Cuenta cuenta=new Cuenta();
				cuenta.setNroCuenta(resulSet.getString("NroCuenta"));
				cuenta.setDNI(resulSet.getString("Dni_C"));
				cuenta.setFechaCreacion(resulSet.getDate("FechaCreacion"));
				cuenta.setTipoCuenta(resulSet.getString("TipoCuenta"));
				cuenta.setCBU(resulSet.getString("CBU"));
				cuenta.setSaldo(resulSet.getFloat("Saldo"));
				cuenta.setEstado(resulSet.getInt("estadoCuenta"));
				cuentas.add(cuenta);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cuentas;
	}

	@Override
	public int validarCantidadCuentas(String DniCliente) {
		PreparedStatement statement;
		ResultSet resulSet;
		int cont=0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(traerNroCuentas);
			statement.setString(1, DniCliente);
			resulSet = statement.executeQuery();
			while(resulSet.next()) {
			cont=cont+1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cont;

	}





	
	
	
	/*
	INSERT INTO cuentas(
	NroCuenta,
	Dni_C,
	FechaCreacion,
	TipoCuenta,
	CBU,
	Saldo,
	estadoCuenta
	)
	VALUES('001','35456741',23/10/2012,'Cuenta Corriente', '1234567', 13578.23,1);
	 */
}
