package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.DaoPrestamoImpl;
import entidad.Cuenta;
import entidad.Movimiento;
import entidad.Prestamo;
import negocioImpl.CuentaNegocioImpl;
import negocioImpl.PrestamoNegocioImpl;

@WebServlet("/servletPrestamo")
public class servletPrestamo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public servletPrestamo() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*PAGO DE PRESTAMO*/
		
		if(request.getParameter("Param6")!=null) {
			String dni = request.getParameter("Param6");
			PrestamoNegocioImpl negocio=new PrestamoNegocioImpl();
			
			
			Prestamo auxPrestamo = new Prestamo();
			auxPrestamo =negocio.buscarPrestamo(dni);
			
			request.setAttribute("Prestamo", auxPrestamo);
			RequestDispatcher rd=request.getRequestDispatcher("/PagoPrestamos.jsp");
			rd.forward(request, response);
		}
		/*-------------------------*/
		
		if(request.getParameter("Param3")!=null) {
			PrestamoNegocioImpl negocio=new PrestamoNegocioImpl();
			List<Prestamo> lista;
			lista=negocio.ListarPedidosPrestamos();
			request.setAttribute("ListaPedidosPrestamos", lista);
			RequestDispatcher rd=request.getRequestDispatcher("/AutorizarPrestamos.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("Param5")!=null) {
			CuentaNegocioImpl cuentaNegocio=new CuentaNegocioImpl();
			List<Cuenta> Lista=cuentaNegocio.ListarNroCuentas(request.getParameter("Param5"));
			request.setAttribute("ListaNroCuentas2", Lista);
			RequestDispatcher rd=request.getRequestDispatcher("/PedidosPrestamos.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnRechazar")!=null) {
			String nroPedido=request.getParameter("NroPedido");
			PrestamoNegocioImpl negocio=new PrestamoNegocioImpl();
			negocio.EliminarPedidoPrestamo(nroPedido);
			List<Prestamo> lista;
			lista=negocio.ListarPedidosPrestamos();
			request.setAttribute("ListaPedidosPrestamos", lista);
			RequestDispatcher rd=request.getRequestDispatcher("/AutorizarPrestamos.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("btnAutorizar")!=null) {
			PrestamoNegocioImpl negocio=new PrestamoNegocioImpl();
			Prestamo prestamo=new Prestamo();
			String MensajeError;
			//VALIDACIONES CONTROLES VACIOS
			
			MensajeError=negocio.verificarCampos(request.getParameter("FechaVencimiento"), request.getParameter("txtIntereses"), request.getParameter("txtPlazos"), request.getParameter("txtMontoMes"));
			if(MensajeError!="") {
				request.setAttribute("MensajeError", MensajeError);
				List<Prestamo> lista;
				lista=negocio.ListarPedidosPrestamos();
				request.setAttribute("ListaPedidosPrestamos", lista);
				RequestDispatcher rd=request.getRequestDispatcher("/AutorizarPrestamos.jsp");
				rd.forward(request, response);
			}
			else {
			/*
			if(request.getParameter("FechaVencimiento").length()!=0&&request.getParameter("txtIntereses").length()!=0&&request.getParameter("txtPlazos").isEmpty()&&request.getParameter("txtMontoMes").isEmpty()) {
				request.setAttribute("MensajeError", "Error. NO Ingresó Plazos y Monto Mes");
				List<Prestamo> lista;
				lista=negocio.ListarPedidosPrestamos();
				request.setAttribute("ListaPedidosPrestamos", lista);
				RequestDispatcher rd=request.getRequestDispatcher("/AutorizarPrestamos.jsp");
				rd.forward(request, response);
			}
			*/
			
			
			
						
			
			String nroPedido=request.getParameter("NroPedido");

			String NroCuenta= negocio.traerNroCuentaPedido(nroPedido);
			prestamo.setNroCuenta_P(NroCuenta);
			Movimiento movimiento=new Movimiento();
			 String fecha=request.getParameter("FechaVencimiento");
				Date data=Date.valueOf(fecha); 
			prestamo.setFechaVencimiento(data);
			float intereses=Float.parseFloat(request.getParameter("txtIntereses"));
			float importesolicitado=negocio.traerImporteSolicitado(request.getParameter("NroPedido"));
			int cantcuotas=negocio.traerCantCuotasSolicitado(request.getParameter("NroPedido"));
			float total=intereses+importesolicitado;
			prestamo.setImporteaPagar(total);
			prestamo.setImporteSolicitado(importesolicitado);
			prestamo.setPlazoDePago(Integer.parseInt(request.getParameter("txtPlazos")));
			prestamo.setMontoAPagarPorMes(Float.parseFloat(request.getParameter("txtMontoMes")));
			prestamo.setCuotas(cantcuotas);
			movimiento.setNroCuentaM(NroCuenta);
			movimiento.setDetalleMovimiento("Autorizar prestamo");
			movimiento.setFechaMovimiento(data);
			movimiento.setImporteMovimiento(total);
			movimiento.setTipoMovimiento("Autorizar prestamo");
			CuentaNegocioImpl negocio2=new CuentaNegocioImpl();
			negocio2.MovimientoAgregar(movimiento);
			negocio.AgregarPrestamo(prestamo);
			negocio.EliminarPedidoPrestamo(nroPedido);
			List<Prestamo> lista;
			lista=negocio.ListarPedidosPrestamos();
			request.setAttribute("ListaPedidosPrestamos", lista);
			RequestDispatcher rd=request.getRequestDispatcher("/AutorizarPrestamos.jsp");
			rd.forward(request, response);
			}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnEnviarPrestamo")!=null) {
			int cuotas;
			float importedinero;
			PrestamoNegocioImpl negocio=new PrestamoNegocioImpl();
			CuentaNegocioImpl negocio2=new CuentaNegocioImpl();
			String mensaje, dni;
			cuotas=Integer.parseInt(request.getParameter("txtCuotas"));
			importedinero=Float.parseFloat(request.getParameter("txtDinero"));
			
			if(cuotas>0) {
				if(importedinero>0) {
			Prestamo prestamo=new Prestamo();
			prestamo.setNroCuenta_P(request.getParameter("Cuentas"));
			prestamo.setImporteSolicitado(importedinero);
			prestamo.setCuotas(cuotas);
			negocio.insertPedidoPrestamo(prestamo);
			mensaje="Pedido prestamo realizado";
			dni=negocio2.devuelveDNI(request.getParameter("Cuentas"));
			List<Cuenta> Lista=negocio2.ListarNroCuentas(dni);
			Movimiento movimiento=new Movimiento();
			movimiento.setNroCuentaM(request.getParameter("Cuentas"));
			String fecha=request.getParameter("FechaPedidoPrestamo");
			Date data=Date.valueOf(fecha);
			movimiento.setFechaMovimiento(data);
			movimiento.setDetalleMovimiento("Pedido prestamo");
			movimiento.setTipoMovimiento("Pedido Prestamo");
			float ImportePedido=Float.parseFloat(request.getParameter("txtDinero"));
			movimiento.setImporteMovimiento(ImportePedido);
			negocio2.MovimientoAgregar(movimiento);
			request.setAttribute("Mensaje", mensaje);
			request.setAttribute("ListaNroCuentas2", Lista);
			RequestDispatcher rd=request.getRequestDispatcher("/PedidosPrestamos.jsp");
			rd.forward(request, response);
			}
				else {
					mensaje="ERROR. Importe de pedido no válido";
					dni=negocio2.devuelveDNI(request.getParameter("Cuentas"));
					List<Cuenta> Lista=negocio2.ListarNroCuentas(dni);
					request.setAttribute("Mensaje", mensaje);
					request.setAttribute("ListaNroCuentas2", Lista);
					RequestDispatcher rd=request.getRequestDispatcher("/PedidosPrestamos.jsp");
					rd.forward(request, response);	
				}
			}
			else {
				mensaje="ERROR. Cantidad de cuotas no válida";
				dni=negocio2.devuelveDNI(request.getParameter("Cuentas"));
				List<Cuenta> Lista=negocio2.ListarNroCuentas(dni);
				request.setAttribute("Mensaje", mensaje);
				request.setAttribute("ListaNroCuentas2", Lista);
				RequestDispatcher rd=request.getRequestDispatcher("/PedidosPrestamos.jsp");
				rd.forward(request, response);
			}
		}
				
	}
}
