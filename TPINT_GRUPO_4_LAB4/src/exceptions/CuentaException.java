package exceptions;

import java.io.IOException;
import java.sql.SQLException;

public class CuentaException extends SQLException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	public String getMessage(){
		return "ERROR. YA EXISTE EL NRO DE CUENTA EN LA BASE DE DATOS/NO EXISTE EL DNI EN LA BASE DE DATOS";
	}
}
