package entidad;

import java.sql.Date;

public class Cuenta {
private String NroCuenta;
private String DNI;
private Date FechaCreacion;
private String TipoCuenta;
private String CBU;
private float Saldo;
private int Estado;

public Cuenta() {
	
}

public Cuenta(String numCuenta, String Dni, Date FCreacion, String tipoCuenta, String cbu, float saldo, int estado) {
	this.NroCuenta=numCuenta;
	this.DNI=Dni;
	this.FechaCreacion=FCreacion;
	this.TipoCuenta=tipoCuenta;
	this.CBU=cbu;
	this.Saldo=saldo;
	this.Estado=estado;
}

public String getNroCuenta() {
	return NroCuenta;
}

public void setNroCuenta(String nroCuenta) {
	NroCuenta = nroCuenta;
}

public String getDNI() {
	return DNI;
}

public void setDNI(String dNI) {
	DNI = dNI;
}

public Date getFechaCreacion() {
	return FechaCreacion;
}

public void setFechaCreacion(Date fechaCreacion) {
	FechaCreacion = fechaCreacion;
}

public String getTipoCuenta() {
	return TipoCuenta;
}

public void setTipoCuenta(String tipoCuenta) {
	TipoCuenta = tipoCuenta;
}

public String getCBU() {
	return CBU;
}

public void setCBU(String cBU) {
	CBU = cBU;
}

public int isEstado() {
	return Estado;
}

public void setEstado(int estado) {
	Estado = estado;
}

public float getSaldo() {
	return Saldo;
}

public void setSaldo(float saldo) {
	Saldo = saldo;
}




}
