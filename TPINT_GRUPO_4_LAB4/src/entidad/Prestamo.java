package entidad;

import java.sql.Date;

public class Prestamo {
	private String NroPrestamo;
	private String NroCuenta_P;
	private Date FechaVencimiento;
	private float ImporteaPagar;
	private float ImporteSolicitado;
	private int PlazoDePago;
	private float MontoAPagarPorMes;
	private int Cuotas;
	private int EstadoPrestamo;
	private String dniCliente;
	
	public Prestamo() {
	}
	public Prestamo(String nroPrestamo, String nroCuenta_P, Date fechaVencimiento, float importeaPagar,
			float importeSolicitado, int plazoDePago, float montoAPagarPorMes, int cuotas, int estadoPrestamo, String dniCliente_ ) {
		super();
		NroPrestamo = nroPrestamo;
		NroCuenta_P = nroCuenta_P;
		FechaVencimiento = fechaVencimiento;
		ImporteaPagar = importeaPagar;
		ImporteSolicitado = importeSolicitado;
		PlazoDePago = plazoDePago;
		MontoAPagarPorMes = montoAPagarPorMes;
		Cuotas = cuotas;
		EstadoPrestamo = estadoPrestamo;
		dniCliente = dniCliente_;
	}
	public String getNroPrestamo() {
		return NroPrestamo;
	}
	public void setNroPrestamo(String nroPrestamo) {
		NroPrestamo = nroPrestamo;
	}
	public String getNroCuenta_P() {
		return NroCuenta_P;
	}
	public void setNroCuenta_P(String nroCuenta_P) {
		NroCuenta_P = nroCuenta_P;
	}
	public Date getFechaVencimiento() {
		return FechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		FechaVencimiento = fechaVencimiento;
	}
	public float getImporteaPagar() {
		return ImporteaPagar;
	}
	public void setImporteaPagar(float importeaPagar) {
		ImporteaPagar = importeaPagar;
	}
	public float getImporteSolicitado() {
		return ImporteSolicitado;
	}
	public void setImporteSolicitado(float importeSolicitado) {
		ImporteSolicitado = importeSolicitado;
	}
	public int getPlazoDePago() {
		return PlazoDePago;
	}
	public void setPlazoDePago(int plazoDePago) {
		PlazoDePago = plazoDePago;
	}
	public float getMontoAPagarPorMes() {
		return MontoAPagarPorMes;
	}
	public void setMontoAPagarPorMes(float montoAPagarPorMes) {
		MontoAPagarPorMes = montoAPagarPorMes;
	}
	public int getCuotas() {
		return Cuotas;
	}
	public void setCuotas(int cuotas) {
		Cuotas = cuotas;
	}
	public int getEstadoPrestamo() {
		return EstadoPrestamo;
	}
	public void setEstadoPrestamo(int estadoPrestamo) {
		EstadoPrestamo = estadoPrestamo;
	}
	public static void add(Prestamo prestamo) {
		// TODO Auto-generated method stub
		
	}
	public String getDniCliente() {
		return dniCliente;
	}
	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}
	
	
}
