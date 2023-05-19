package negocio;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import entidad.Cuenta;
import entidad.Movimiento;

public interface CuentaNegocio {
public int CuentaAgregar(Cuenta cuenta);
public List<Cuenta> ListarCuentas();
public int EliminarCuenta(String NroCuenta);
public int ModificarCuenta(String NroCuenta, String TipoCuenta, float Saldo);
public boolean MovimientoAgregar(Movimiento movimiento);
public List<Movimiento> ListarMovimientos(String NroCliente);
public int transferirDinero(String CBU, float importeTransferencia);
public int actualizarSaldo(float cambioSaldo, String NroCuenta);
public List<Cuenta> ListarNroCuentas(String Dni);
public String verificarIngresosTransferencia(int verifi,int verifi2);
public String devuelveDNI(String NroCuenta);
public float devuelveSaldo(String NroCuenta);
public String verificarCBU(String CBU);
public List<Cuenta> ListarCuentasFiltrar(Date fechaDesde, Date fechaHasta);
public int validarCantCuentas(String DniCliente);
}
