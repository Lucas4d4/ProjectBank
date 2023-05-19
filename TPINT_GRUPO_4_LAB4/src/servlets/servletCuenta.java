package servlets;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoCuenta;
import daoImpl.DaoCuentaImpl;
import entidad.Cuenta;
import entidad.Movimiento;
import exceptions.CuentaException;
import negocioImpl.CuentaNegocioImpl;


@WebServlet("/servletCuenta")
public class servletCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public servletCuenta() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("Param")!=null) {
			CuentaNegocioImpl cuentaNegocio=new CuentaNegocioImpl();
			List<Cuenta> Lista=cuentaNegocio.ListarCuentas();
			request.setAttribute("ListaCuentas", Lista);
			RequestDispatcher rd=request.getRequestDispatcher("/BajaCuentas.jsp");
			rd.forward(request, response);
		}
		
		
		if(request.getParameter("btnEliminarCuenta")!=null) {
			String NroCuenta=request.getParameter("NroCuentaBaja");
			CuentaNegocioImpl cuenta=new CuentaNegocioImpl();
			cuenta.EliminarCuenta(NroCuenta);
			List<Cuenta> ListaCuenta=cuenta.ListarCuentas();
			request.setAttribute("ListaCuentas", ListaCuenta);
			RequestDispatcher rd=request.getRequestDispatcher("/BajaCuentas.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnModificarCuenta")!=null) {
			String NroCuenta=request.getParameter("NroCuentaModificar");
			String TipoCuenta=request.getParameter("opcTipo");
			float Saldo=Float.parseFloat(request.getParameter("txtSaldoModificar"));
			CuentaNegocioImpl cuenta=new CuentaNegocioImpl();
			cuenta.ModificarCuenta(NroCuenta, TipoCuenta, Saldo);
			List<Cuenta> ListaCuenta=cuenta.ListarCuentas();
			request.setAttribute("ListaCuentas", ListaCuenta);
			RequestDispatcher rd=request.getRequestDispatcher("/ModificarCuentas.jsp");
			rd.forward(request, response);
		}
		
		
		
		
		if(request.getParameter("Param2")!=null) {
			CuentaNegocioImpl cuentaNegocio=new CuentaNegocioImpl();
			List<Cuenta> Lista=cuentaNegocio.ListarCuentas();
			request.setAttribute("ListaCuentas", Lista);
			RequestDispatcher rd=request.getRequestDispatcher("/ModificarCuentas.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("Param6")!=null) {
			CuentaNegocioImpl cuentaNegocio=new CuentaNegocioImpl();
			List<Cuenta> Lista=cuentaNegocio.ListarCuentas();
			request.setAttribute("ListaCuentas", Lista);
			RequestDispatcher rd=request.getRequestDispatcher("/ListarCuentas.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("Param7")!=null) {
			CuentaNegocioImpl negocio=new CuentaNegocioImpl();
			String devuelvo;
			devuelvo=request.getParameter("Param7");
			List<Movimiento> lista=negocio.ListarMovimientos(devuelvo);
			request.setAttribute("ListaMovimientos", lista);
			RequestDispatcher rd=request.getRequestDispatcher("/ListarHistorialCuenta.jsp");
			rd.forward(request, response);
		}
		
		
		if(request.getParameter("Param4")!=null) {
			CuentaNegocioImpl cuentaNegocio=new CuentaNegocioImpl();
			List<Cuenta> Lista=cuentaNegocio.ListarNroCuentas(request.getParameter("Param4"));
			request.setAttribute("ListaNroCuentas", Lista);
			RequestDispatcher rd=request.getRequestDispatcher("/Transferencias.jsp");
			rd.forward(request, response);
		}
		
		
		
		
		if(request.getParameter("btnBuscarCuentas")!=null)
		{
			DaoCuentaImpl cuenta = new DaoCuentaImpl();
			List<Cuenta> lista = cuenta.ListarCuentas();
			if(request.getParameter("txtDniCuenta").equals("")){request.setAttribute("listaCuentas", lista);}else {
			List<Cuenta> listaC = new ArrayList<Cuenta>();
			for(Cuenta c: lista) {
				if(c.getDNI().equals(request.getParameter("txtDniCuenta"))) {
					listaC.add(c);
				}
				
			}
			request.setAttribute("listaCuentas", listaC);
			}
			RequestDispatcher rd = request.getRequestDispatcher("/ListarCuentas.jsp");   
	        rd.forward(request, response);
			}
		if(request.getParameter("btnBuscarCuentasMod")!=null)
		{
			DaoCuentaImpl sdao = new DaoCuentaImpl();
			List<Cuenta> lista = sdao.ListarCuentas();
			if(request.getParameter("txtDniCuenta").equals("")){request.setAttribute("ListaCuentas", lista);
			}else {
			List<Cuenta> listaC = new ArrayList<Cuenta>();
			for(Cuenta c: lista) {
				if(c.getDNI().equals(request.getParameter("txtDniCuenta"))) {
					listaC.add(c);
				}
				
			}
			request.setAttribute("ListaCuentas", listaC);
			}
			RequestDispatcher rd = request.getRequestDispatcher("/ModificarCuentas.jsp");   
	        rd.forward(request, response);
			}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnAltaCliente")!=null) {
			
				CuentaNegocioImpl cuentaNegocio=new CuentaNegocioImpl();

				Cuenta cuenta=new Cuenta();
				int filas = 0, cantcuentas=0;
				String verifiCBU;
				cuenta.setNroCuenta(request.getParameter("txtNumCli"));
				cuenta.setDNI(request.getParameter("txtDNICli"));
				cuenta.setTipoCuenta(request.getParameter("opcTipo"));
				String fecha=request.getParameter("fecha");
				Date data=Date.valueOf(fecha);
				cuenta.setFechaCreacion(data);
				cuenta.setCBU(request.getParameter("txtCBU"));
				cuenta.setEstado(1);
				verifiCBU=cuentaNegocio.verificarCBU(request.getParameter("txtCBU"));
				cantcuentas=cuentaNegocio.validarCantCuentas(request.getParameter("txtDNICli"));
				if(verifiCBU!="") {
					filas=2;
					request.setAttribute("filasAfectadas", filas);
					RequestDispatcher rd=request.getRequestDispatcher("/AltaCuentas.jsp");
					rd.forward(request, response);
				}
				else {
					if(cantcuentas>=3) {
						filas=3;
						request.setAttribute("filasAfectadas", filas);
						RequestDispatcher rd=request.getRequestDispatcher("/AltaCuentas.jsp");
						rd.forward(request, response);
					}
					else {
					filas=cuentaNegocio.CuentaAgregar(cuenta);
					Movimiento movimiento=new Movimiento();
					movimiento.setNroCuentaM(request.getParameter("txtNumCli"));
					movimiento.setDetalleMovimiento("Alta de cuenta");
					movimiento.setFechaMovimiento(data);
					movimiento.setImporteMovimiento(10000);
					movimiento.setTipoMovimiento("Alta cuenta");
					cuentaNegocio.MovimientoAgregar(movimiento);
					request.setAttribute("filasAfectadas", filas);
					RequestDispatcher rd=request.getRequestDispatcher("/AltaCuentas.jsp");
					rd.forward(request, response);
					}
				}
				

				
				
				
				
			

				
					
				
					/*
					request.setAttribute("VerificacionNroCuenta", verifi);
					RequestDispatcher rd=request.getRequestDispatcher("/AltaCuentas.jsp");
					rd.forward(request, response);
					*/
					
				
		
		}

		if(request.getParameter("btnTransferir")!=null) {
			CuentaNegocioImpl negocio=new CuentaNegocioImpl();
			int verifi=0, verifi2=0;
			String mensaje, dni, verifiCBU;
			float diferencia, saldoNroCuenta, importe;
			importe=Float.parseFloat(request.getParameter("txtImporteTransferencia"));
			saldoNroCuenta=negocio.devuelveSaldo(request.getParameter("CuentasTransferencia"));
			diferencia=saldoNroCuenta-importe;
			verifiCBU=negocio.verificarCBU(request.getParameter("txtCBU"));
			if(diferencia>=0) {
			if(verifiCBU!="") {
			verifi=negocio.transferirDinero(request.getParameter("txtCBU"), importe);
			verifi2=negocio.actualizarSaldo(importe, request.getParameter("CuentasTransferencia"));
			mensaje=negocio.verificarIngresosTransferencia(verifi, verifi2);
			Movimiento movimiento=new Movimiento();
			movimiento.setNroCuentaM(request.getParameter("CuentasTransferencia"));
			String fecha=request.getParameter("FechaTransferencia");
			Date data=Date.valueOf(fecha);
			movimiento.setFechaMovimiento(data);
			movimiento.setDetalleMovimiento("Transferencia dinero");
			movimiento.setTipoMovimiento("Transferencia");
			float ImporteTransferencia=Float.parseFloat(request.getParameter("txtImporteTransferencia"));
			movimiento.setImporteMovimiento(ImporteTransferencia);
			negocio.MovimientoAgregar(movimiento);	
			dni=negocio.devuelveDNI(request.getParameter("CuentasTransferencia"));
			List<Cuenta> Lista=negocio.ListarNroCuentas(dni);
			mensaje="Transferencia exitosa";
			request.setAttribute("Mensaje", mensaje);
			request.setAttribute("ListaNroCuentas", Lista);
			RequestDispatcher rd=request.getRequestDispatcher("/Transferencias.jsp");
			rd.forward(request, response);
			}
			else {
				mensaje="ERROR. NO existe CBU";
				dni=negocio.devuelveDNI(request.getParameter("CuentasTransferencia"));
				List<Cuenta> Lista=negocio.ListarNroCuentas(dni);
				request.setAttribute("Mensaje", mensaje);
				request.setAttribute("ListaNroCuentas", Lista);
				RequestDispatcher rd=request.getRequestDispatcher("/Transferencias.jsp");
				rd.forward(request, response);
			}
			}
			else {
			
			mensaje="ERROR. Sin saldo disponible";
				dni=negocio.devuelveDNI(request.getParameter("CuentasTransferencia"));
				List<Cuenta> Lista=negocio.ListarNroCuentas(dni);
				request.setAttribute("Mensaje", mensaje);
				request.setAttribute("ListaNroCuentas", Lista);
				RequestDispatcher rd=request.getRequestDispatcher("/Transferencias.jsp");
				rd.forward(request, response);
			}
			}
		
		
		
		
		if(request.getParameter("btnMostrar")!=null) {
			CuentaNegocioImpl negocio=new CuentaNegocioImpl();
			String devuelvo;
			devuelvo=request.getParameter("NroCliente22");
			List<Movimiento> lista=negocio.ListarMovimientos(devuelvo);
			request.setAttribute("ListaMovimientos", lista);
			RequestDispatcher rd=request.getRequestDispatcher("/ListarHistorialCuenta.jsp");
			rd.forward(request, response);
		}
		
		
		/*
		if(request.getParameter("btnTransferir")!=null) {
			CuentaNegocioImpl negocio=new CuentaNegocioImpl();
			Movimiento movimiento=new Movimiento();
			movimiento.setNroCuentaM(request.getParameter("CuentasTransferencia"));
			String fecha=request.getParameter("FechaTransferencia");
			Date data=Date.valueOf(fecha);
			movimiento.setFechaMovimiento(data);
			movimiento.setDetalleMovimiento("Se realizó una transferencia de dinero por medio de CBU");
			movimiento.setTipoMovimiento("Transferencia");
			float ImporteTransferencia=Float.parseFloat(request.getParameter("txtImporteTransferencia"));
			movimiento.setImporteMovimiento(ImporteTransferencia);
			negocio.MovimientoAgregar(movimiento);
		}
		*/
		
		
		 if(request.getParameter("btnEnviarPrestamo")!=null) {
			CuentaNegocioImpl negocio=new CuentaNegocioImpl();
			Movimiento movimiento=new Movimiento();
			movimiento.setNroCuentaM(request.getParameter("Cuentas"));
			String fecha=request.getParameter("FechaPedidoPrestamo");
			Date data=Date.valueOf(fecha);
			movimiento.setFechaMovimiento(data);
			movimiento.setDetalleMovimiento("Pedido prestamo");
			movimiento.setTipoMovimiento("Pedido Prestamo");
			float ImportePedido=Float.parseFloat(request.getParameter("txtDinero"));
			movimiento.setImporteMovimiento(ImportePedido);
			negocio.MovimientoAgregar(movimiento);
		}
		 
		 
		 if(request.getParameter("btnPagarCuota")!=null) {
			CuentaNegocioImpl negocio=new CuentaNegocioImpl();
			Movimiento movimiento=new Movimiento();
			movimiento.setNroCuentaM(request.getParameter("TipoCuentav2"));
			String fecha=request.getParameter("FechaPagoPrestamo");
			Date data=Date.valueOf(fecha);
			movimiento.setFechaMovimiento(data);
			movimiento.setDetalleMovimiento("Se realizó un pago de la cuota");
			movimiento.setTipoMovimiento("Pago prestamo cuota");
			float ImportePago=Float.parseFloat(request.getParameter(""));
			movimiento.setImporteMovimiento(ImportePago);
			negocio.MovimientoAgregar(movimiento);
		}  
		
		if(request.getParameter("btnFiltrar")!=null) {
			String mensaje="";
			CuentaNegocioImpl cuentaNegocio=new CuentaNegocioImpl();
			if(request.getParameter("FechaDesde")!="") {
				if(request.getParameter("FechaHasta")!="") {
			Date fechadesde, fechahasta;
			fechadesde=Date.valueOf(request.getParameter("FechaDesde"));
			fechahasta=Date.valueOf(request.getParameter("FechaHasta"));
			List<Cuenta> Lista=cuentaNegocio.ListarCuentasFiltrar(fechadesde, fechahasta);
			request.setAttribute("ListaCuentas", Lista);
			RequestDispatcher rd=request.getRequestDispatcher("/ListarCuentas.jsp");
			rd.forward(request, response);
				}
				else {
					mensaje="ERROR. NO ingresó Fecha Hasta";
					List<Cuenta> Lista=cuentaNegocio.ListarCuentas();
					request.setAttribute("Mensaje", mensaje);
					request.setAttribute("ListaCuentas", Lista);
					RequestDispatcher rd=request.getRequestDispatcher("/ListarCuentas.jsp");
					rd.forward(request, response);
				}
			
			}
			
			else {
				if(request.getParameter("FechaDesde")!=""&&request.getParameter("FechaHasta")!="") {
					mensaje="ERROR. NO ingresó Fecha Desde y Fecha Hasta";
					List<Cuenta> Lista=cuentaNegocio.ListarCuentas();
					request.setAttribute("Mensaje", mensaje);
					request.setAttribute("ListaCuentas", Lista);
					RequestDispatcher rd=request.getRequestDispatcher("/ListarCuentas.jsp");
					rd.forward(request, response);
				}
				else {
					mensaje="ERROR. NO ingresó Fecha Desde";
					List<Cuenta> Lista=cuentaNegocio.ListarCuentas();
					request.setAttribute("Mensaje", mensaje);
					request.setAttribute("ListaCuentas", Lista);
					RequestDispatcher rd=request.getRequestDispatcher("/ListarCuentas.jsp");
					rd.forward(request, response);
				}
				}
		}
		
		if(request.getParameter("btnMostrarTodo")!=null) {
			CuentaNegocioImpl cuentaNegocio=new CuentaNegocioImpl();
			List<Cuenta> Lista=cuentaNegocio.ListarCuentas();
			request.setAttribute("ListaCuentas", Lista);
			RequestDispatcher rd=request.getRequestDispatcher("/ListarCuentas.jsp");
			rd.forward(request, response);
		}
		
		
		}
	}

