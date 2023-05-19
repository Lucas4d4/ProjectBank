package entidad;

import java.sql.Date;

public class Movimiento {
private String NroMovimiento;
private String NroCuentaM;
private Date FechaMovimiento;
private String DetalleMovimiento;
private String TipoMovimiento;
private float ImporteMovimiento;
private boolean estadoMovimiento;

public Movimiento() {
	
}

public Movimiento(String nroCuentaM, Date fechaMovimiento, String detalleMovimiento,
		String tipoMovimiento, float importeMovimiento, boolean estadoMovimiento) {
	NroCuentaM = nroCuentaM;
	FechaMovimiento = fechaMovimiento;
	DetalleMovimiento = detalleMovimiento;
	TipoMovimiento = tipoMovimiento;
	ImporteMovimiento = importeMovimiento;
	this.estadoMovimiento = estadoMovimiento;
}



public String getNroMovimiento() {
	return NroMovimiento;
}

public void setNroMovimiento(String nroMovimiento) {
	NroMovimiento = nroMovimiento;
}

public String getNroCuentaM() {
	return NroCuentaM;
}

public void setNroCuentaM(String nroCuentaM) {
	NroCuentaM = nroCuentaM;
}

public Date getFechaMovimiento() {
	return FechaMovimiento;
}

public void setFechaMovimiento(Date fechaMovimiento) {
	FechaMovimiento = fechaMovimiento;
}

public String getDetalleMovimiento() {
	return DetalleMovimiento;
}

public void setDetalleMovimiento(String detalleMovimiento) {
	DetalleMovimiento = detalleMovimiento;
}

public String getTipoMovimiento() {
	return TipoMovimiento;
}

public void setTipoMovimiento(String tipoMovimiento) {
	TipoMovimiento = tipoMovimiento;
}

public float getImporteMovimiento() {
	return ImporteMovimiento;
}

public void setImporteMovimiento(float importeMovimiento) {
	ImporteMovimiento = importeMovimiento;
}

public boolean isEstadoMovimiento() {
	return estadoMovimiento;
}

public void setEstadoMovimiento(boolean estadoMovimiento) {
	this.estadoMovimiento = estadoMovimiento;
}



}
