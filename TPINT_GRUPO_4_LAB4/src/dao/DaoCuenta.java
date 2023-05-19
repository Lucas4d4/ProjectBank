package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import entidad.Cuenta;
import entidad.Movimiento;
import exceptions.CuentaException;

public interface DaoCuenta {
public int AgregarCuenta(Cuenta cuentaCliente) ;
public List<Cuenta> ListarCuentas();
public int EliminarCuenta(String NroCuenta);
public int ModificarCuenta(String NroCuenta, String TipoCuenta, float Saldo);
public boolean insertMovimiento(Movimiento movimiento);
public List<Movimiento> ListarMovimientos(String NroCliente);
public int validarInsert(int insert) throws CuentaException;
public int transferirDinero(String CBU, float ImporteTransferencia);
public int actualizarSaldoCuenta(float cambioSaldo, String NroCuenta);
public List<Cuenta> ListarNroCuentas(String Dni);
public String devuelveDNI(String NroCuenta);
public float devuelveSaldo(String NroCuenta);
public String verificarCBU(String CBU);
public List<Cuenta> ListarCuentasFiltrar(Date fechaDesde, Date fechaHasta);
public int validarCantidadCuentas(String DniCliente);
}
