package negocioImpl;


import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import daoImpl.DaoCuentaImpl;
import entidad.Cuenta;
import entidad.Movimiento;
import exceptions.CuentaException;
import negocio.CuentaNegocio;

public class CuentaNegocioImpl implements CuentaNegocio{

	@Override
	public int CuentaAgregar(Cuenta cuenta){
		DaoCuentaImpl agregar=new DaoCuentaImpl();
		int extra=0;
		try {

			extra=agregar.validarInsert(agregar.AgregarCuenta(cuenta));
			
		}
		catch(CuentaException e){
			e.printStackTrace();
		}
		return extra;
	}

	@Override
	public List<Cuenta> ListarCuentas() {
		DaoCuentaImpl listar=new DaoCuentaImpl();
		return listar.ListarCuentas();
	}

	@Override
	public int EliminarCuenta(String NroCuenta) {
		DaoCuentaImpl Eliminar=new DaoCuentaImpl();
		return Eliminar.EliminarCuenta(NroCuenta);
	}

	@Override
	public int ModificarCuenta(String NroCuenta, String TipoCuenta, float Saldo) {
		DaoCuentaImpl Modificar=new DaoCuentaImpl();
		return Modificar.ModificarCuenta(NroCuenta, TipoCuenta, Saldo);
	}

	@Override
	public boolean MovimientoAgregar(Movimiento movimiento) {
		DaoCuentaImpl agregar=new DaoCuentaImpl();
		return agregar.insertMovimiento(movimiento);
	}

	@Override
	public List<Movimiento> ListarMovimientos(String NroCliente) {
		DaoCuentaImpl listar=new DaoCuentaImpl();
		return listar.ListarMovimientos(NroCliente);
	}

	@Override
	public int transferirDinero(String CBU, float importeTransferencia) {
		DaoCuentaImpl transferir=new DaoCuentaImpl();
		return transferir.transferirDinero(CBU, importeTransferencia);
	}

	@Override
	public int actualizarSaldo(float cambioSaldo, String NroCuenta) {
		DaoCuentaImpl actualizar=new DaoCuentaImpl();
		return actualizar.actualizarSaldoCuenta(cambioSaldo, NroCuenta);
	}

	@Override
	public List<Cuenta> ListarNroCuentas(String Dni) {
		DaoCuentaImpl listar=new DaoCuentaImpl();
		return listar.ListarNroCuentas(Dni);
	}

	@Override
	public String verificarIngresosTransferencia(int verifi, int verifi2) {
		String mensaje="";
		
		if(verifi!=1&&verifi2==1) {
			mensaje="ERROR. Transferencia NO realizada";
			return mensaje;
		}
		if(verifi==1&&verifi2!=1) {
			mensaje="ERROR. Transferencia NO realizada";
			return mensaje;
		}
		if(verifi!=1&&verifi2!=1) {
			mensaje="ERROR. Transferencia NO realizada";
			return mensaje;
		}
		return mensaje;
	}

	@Override
	public String devuelveDNI(String NroCuenta) {
		DaoCuentaImpl devuelve=new DaoCuentaImpl();
		return devuelve.devuelveDNI(NroCuenta);
	}

	@Override
	public float devuelveSaldo(String NroCuenta) {
		DaoCuentaImpl Saldo=new DaoCuentaImpl();
		return Saldo.devuelveSaldo(NroCuenta);
	}

	@Override
	public String verificarCBU(String CBU) {
		DaoCuentaImpl verifiCBU=new DaoCuentaImpl();
		return verifiCBU.verificarCBU(CBU);
	}

	@Override
	public List<Cuenta> ListarCuentasFiltrar(Date fechaDesde, Date fechaHasta) {
		DaoCuentaImpl filtrar=new DaoCuentaImpl();
		return filtrar.ListarCuentasFiltrar(fechaDesde, fechaHasta);
	}

	@Override
	public int validarCantCuentas(String DniCliente) {
		DaoCuentaImpl validar=new DaoCuentaImpl();
		return validar.validarCantidadCuentas(DniCliente);
	}

	

	



}
