package negocioImpl;

import java.util.List;
import daoImpl.DaoPrestamoImpl;
import entidad.Prestamo;
import negocio.PrestamoNegocio;

public class PrestamoNegocioImpl implements PrestamoNegocio {
	@Override
	public List<Prestamo> ListarPrestamos() {
		DaoPrestamoImpl listar=new DaoPrestamoImpl();
		return listar.ListarPrestamos();
	}
	public List<Prestamo> ListarPedidosPrestamos(){
		DaoPrestamoImpl listar=new DaoPrestamoImpl();
		return listar.ListarPedidosPrestamos();
	}
	public int AgregarPrestamo(Prestamo prestamo) {
		DaoPrestamoImpl agregar=new DaoPrestamoImpl();
		return agregar.AgregarPrestamo(prestamo);
	}
	public int EliminarPedidoPrestamo(String NroPedido) {
		DaoPrestamoImpl eliminar=new DaoPrestamoImpl();
		return eliminar.EliminarPedidoPrestamo(NroPedido);
	}
	@Override
	public String traerNroCuentaPedido(String NroPedido) {
		DaoPrestamoImpl prestamo=new DaoPrestamoImpl();
		return prestamo.traerNroCuenta(NroPedido);
	}
	@Override
	public float traerImporteSolicitado(String NroPedido) {
		DaoPrestamoImpl prestamo=new DaoPrestamoImpl();
		return prestamo.traerImporteSolicitado(NroPedido);
	}
	@Override
	public int traerCantCuotasSolicitado(String NroPedido) {
		DaoPrestamoImpl prestamo=new DaoPrestamoImpl();
		return prestamo.traerCantCuotasSolicitado(NroPedido);
	}
	@Override
	public String verificarCampos(String Fecha, String Intereses, String Plazos, String MontoMes) {
		String Mensaje="";
		if(Fecha==""&&Intereses!=""&&Plazos!=""&&MontoMes!="") {
		Mensaje="Error. NO ingresó Fecha";
		return Mensaje;
		}
		if(Fecha==""&&Intereses==""&&Plazos!=""&&MontoMes!="") {
			Mensaje="Error. NO ingresó Fecha e Intereses";
			return Mensaje;	
		}
		if(Fecha==""&&Intereses!=""&&Plazos==""&&MontoMes!="") {
			Mensaje="Error. NO ingresó Fecha y Plazos";
			return Mensaje;
		}
		if(Fecha==""&&Intereses!=""&&Plazos!=""&&MontoMes=="") {
			Mensaje="Error. NO ingresó Fecha y Monto Mes";
			return Mensaje;
		}
		if(Fecha==""&&Intereses==""&&Plazos==""&&MontoMes!="") {
			Mensaje="Error. NO ingresó Fecha, Intereses y Plazos";
			return Mensaje;
		}
		if(Fecha==""&&Intereses!=""&&Plazos==""&&MontoMes=="") {
			Mensaje="Error. NO ingresó Fecha, Plazos y Monto Mes";
			return Mensaje;
		}
		if(Fecha!=""&&Intereses==""&&Plazos!=""&&MontoMes!="") {
			Mensaje="Error. NO ingresó Intereses";
			return Mensaje;
		}
		if(Fecha!=""&&Intereses==""&&Plazos==""&&MontoMes!="") {
			Mensaje="Error. NO ingresó Intereses y Plazos";
			return Mensaje;
		}
		if(Fecha!=""&&Intereses==""&&Plazos!=""&&MontoMes=="") {
			Mensaje="Error. NO ingresó Intereses y Monto Mes";
			return Mensaje;
		}
		if(Fecha!=""&&Intereses==""&&Plazos==""&&MontoMes=="") {
			Mensaje="Error. NO ingresó Intereses, Plazos y Monto Mes";
			return Mensaje;
		}
		if(Fecha!=""&&Intereses!=""&&Plazos==""&&MontoMes=="") {
			Mensaje="Error. NO ingresó Plazos y Monto Mes";
			return Mensaje;
		}
		if(Fecha!=""&&Intereses!=""&&Plazos==""&&MontoMes!="") {
			Mensaje="Error. NO ingresó Plazos";
			return Mensaje;
		}
		if(Fecha!=""&&Intereses!=""&&Plazos!=""&&MontoMes=="") {
			Mensaje="Error. NO ingresó Monto Mes";
			return Mensaje;
		}
		if(Fecha==""&&Intereses==""&&Plazos==""&&MontoMes=="") {
			Mensaje="Error. NO ingresó Fecha, Intereses, Plazos y Monto Mes";
			return Mensaje;
		}
		if(Fecha==""&&Intereses==""&&Plazos!=""&&MontoMes=="") {
			Mensaje="Error. NO ingresó Fecha, Intereses y Monto Mes";
			return Mensaje;
			}
		
		return Mensaje;
	}
	@Override
	public int insertPedidoPrestamo(Prestamo prestamo) {
		DaoPrestamoImpl pedido=new DaoPrestamoImpl();
		return pedido.insertPedidoPrestamo(prestamo);
	}
	@Override
	public Prestamo buscarPrestamo(String dni) {
		DaoPrestamoImpl prestamo= new DaoPrestamoImpl();
		return prestamo.buscarPrestamo(dni); 
	}
}
