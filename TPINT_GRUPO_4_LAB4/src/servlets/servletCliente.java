package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import entidad.Cliente;
import entidad.Provincia;
import negocio.ClienteNegocio;
import negocio.ProvinciaNegocio;
import negocioImpl.ClienteNegocioImpl;
import negocioImpl.ProvinciaNegocioImpl;
import sun.rmi.server.Dispatcher;

/**
 * Servlet implementation class servletCliente
 */
@WebServlet("/servletCliente")
public class servletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//// LISTA DE TODOS LOS CLIENTES
		if (request.getParameter("Param") != null) {
			if (request.getParameter("Param").equals("ListarClientes")) {
				ClienteNegocioImpl cli = new ClienteNegocioImpl();
				List<Cliente>lista = cli.listarClientes();
				
				request.setAttribute("ListaClientesB", lista);

				RequestDispatcher rd = request.getRequestDispatcher("/Cliente.jsp");
				rd.forward(request, response);
			}	
		}
	
		if (request.getParameter("Param22") != null) {
			if (request.getParameter("Param22").equals("ListarClientes")) {
				ClienteNegocioImpl cli = new ClienteNegocioImpl();
				List<Cliente>lista = cli.listarClientes();
				
				request.setAttribute("ListaClientesB", lista);

				RequestDispatcher rd = request.getRequestDispatcher("/ListarClientes.jsp");
				rd.forward(request, response);
			}	
		}
		
		if (request.getParameter("Param33") != null) {
			if (request.getParameter("Param33").equals("ListarClientes")) {
				ClienteNegocioImpl cli = new ClienteNegocioImpl();
				List<Cliente>lista = cli.listarClientes();
				
				request.setAttribute("ListaClientesB", lista);

				RequestDispatcher rd = request.getRequestDispatcher("/BajaCliente.jsp");
				rd.forward(request, response);
			}	
		}
		
		if (request.getParameter("Param44") != null) {
			if (request.getParameter("Param44").equals("ListarClientes")) {
				ClienteNegocioImpl cli = new ClienteNegocioImpl();
				List<Cliente>lista = cli.listarClientes();
				
				request.setAttribute("ListaClientesB", lista);

				RequestDispatcher rd = request.getRequestDispatcher("/ModificarCliente.jsp");
				rd.forward(request, response);
			}	
		}
	
		///LLenar datos del cliente a Modificar
	
		else if(request.getParameter("dniE")!=null) {
			String dnic = request.getParameter("dniE");
			ClienteNegocioImpl cliNeg = new ClienteNegocioImpl();
			Cliente auxCliente = cliNeg.buscarCliente(dnic);
			
			request.setAttribute("Cliente", auxCliente);
			RequestDispatcher rd = request.getRequestDispatcher("/ModificarCliente.jsp");
			rd.forward(request, response);
			}
				
			
			///LLenar datos del cliente a Eliminar
			
		else if(request.getParameter("dniD")!=null) {
				String dnic = request.getParameter("dniD");
				ClienteNegocioImpl cliNeg = new ClienteNegocioImpl();
				Cliente auxCliente = cliNeg.buscarCliente(dnic);
				
				request.setAttribute("Cliente", auxCliente);
				RequestDispatcher rd = request.getRequestDispatcher("/BajaCliente.jsp");
				rd.forward(request, response);
					
			}	
		
		if(request.getParameter("btnBajasCliente")!=null) {
			ClienteNegocioImpl negocio=new ClienteNegocioImpl();
			String DniCliente=request.getParameter("ParamBaja2");
			negocio.delete(DniCliente);               
			List<Cliente> lista=negocio.listarClientes();
			request.setAttribute("ListaClientesB", lista);
			RequestDispatcher rd=request.getRequestDispatcher("/BajaCliente.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnModificarCliente2")!=null) {
			ClienteNegocioImpl negocio=new ClienteNegocioImpl();
			String Dni=request.getParameter("ParamModificar");
			String Password=request.getParameter("txtContraseniaCliente2");
			boolean Mensaje=false;
			if(negocio.edit(Dni, Password)==true) {
				Mensaje=true;
			}
			
			List<Cliente> lista=negocio.listarClientes();
			request.setAttribute("Mensaje", Mensaje);
			request.setAttribute("ListaClientesB", lista);
			RequestDispatcher rd=request.getRequestDispatcher("/ModificarCliente.jsp");
			rd.forward(request, response);
		}
		
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		/* MOSTRAR CLIENTES*/
		if(request.getParameter("btnMostrarClientes")!=null ) {
			ClienteNegocioImpl cli = new ClienteNegocioImpl();
			List<Cliente>lista = cli.listarClientes();
			
			request.setAttribute("listaC", lista);
			
//			RequestDispatcher rd = request.getRequestDispatcher("/Cliente.jsp");
			RequestDispatcher rd = request.getRequestDispatcher("/ListarClientes.jsp");
			
			rd.forward(request, response);
		}
		
		/* BAJA CLIENTES*/
		
		
		if(request.getParameter("btnEliminar")!=null){
			
			String dniCliente = request.getParameter("dniCliente");
			ClienteNegocioImpl cli = new ClienteNegocioImpl();
			boolean flag = false;
			flag = cli.delete(dniCliente);
			
			if(flag) {
					request.setAttribute("clienteDelete", flag);
					RequestDispatcher rd = request.getRequestDispatcher("/BajaCliente.jsp");
					rd.forward(request, response);
			}	
		}
		
		
		
		/* BUSCAR CLIENTES*/
		else if(request.getParameter("btnBuscar")!=null) {
			String nombre = request.getParameter("txtbuscar");
			if(nombre!=null) {
				ClienteNegocioImpl cli = new ClienteNegocioImpl();
				
				List<Cliente>lista = cli.buscarlistaClientes(nombre);
				request.setAttribute("ListaClientesB", lista);
				
				RequestDispatcher rd = request.getRequestDispatcher("/Cliente.jsp");
				rd.forward(request, response);
				
			}
		}
		
		/* AGREGAR CLIENTE */
		if(request.getParameter("agregarCliente")!=null) {
			String dniCliente = request.getParameter("txtDni");
			String cuil=request.getParameter("txtCuil");
			String usuario=request.getParameter("txtUsuario");
			ClienteNegocioImpl cli = new ClienteNegocioImpl();
			ProvinciaNegocioImpl prov=new ProvinciaNegocioImpl();
			List<Cliente> lista=cli.listarClientes();
			List<Provincia> listaProvincia=prov.listarProvincias();
			String mensajeDni="";
			String mensajeCuil="";
			String mensajeUsuario="";
			
			for(int i=0;i<lista.size();i++) {
				if(dniCliente.equals(lista.get(i).getDni())) {
				mensajeDni="Ya existe el DNI ingresado";
				}
				
				
				if(cuil.equals(lista.get(i).getCuil_c())) {
				mensajeCuil="Ya existe el Cuil ingresado";
				}
				
				
				if(usuario.equals(lista.get(i).getUsuario())) {
				mensajeUsuario="Ya existe el Usuario ingresado";
				}
				
				
			}
					
			
			if(mensajeDni==""&&mensajeCuil==""&&mensajeUsuario=="") {
				Cliente cliente=new Cliente();
				cliente.setDni(dniCliente);
				cliente.setCuil_c(cuil);
				cliente.setNombre(request.getParameter("txtNombre"));
				cliente.setApellido(request.getParameter("txtApellido"));
				cliente.setSexo(request.getParameter("ddlSexo"));
				cliente.setNacionalidad(request.getParameter("txtNacionalidad"));
				cliente.setFechaNacimiento(request.getParameter("FechaNacimiento"));
				cliente.setDireccion(request.getParameter("txtDireccion"));
				cliente.setLocalidad(request.getParameter("txtLocalidad"));
				cliente.setProvincia(request.getParameter("ddlProvincia"));
				cliente.setMail(request.getParameter("txtCorreoElectronico"));
				cliente.setTelefono(request.getParameter("txtTelefono"));
				cliente.setUsuario(usuario);
				cliente.setPassword(request.getParameter("txtPassword"));
				cliente.setEstado(true);
				boolean flag=cli.insert(cliente);
				if(flag) {
					request.setAttribute("exito", flag);
					request.setAttribute("ListaProvincias", listaProvincia);
					RequestDispatcher rd=request.getRequestDispatcher("/AltaCliente.jsp");
					rd.forward(request, response);
				}
			}
			else {
				if(mensajeDni!="") {
					request.setAttribute("MensajeDni", mensajeDni);
					request.setAttribute("ListaProvincias", listaProvincia);
				}
				
				if(mensajeCuil!="") {
					request.setAttribute("MensajeCuil", mensajeCuil);
					request.setAttribute("ListaProvincias", listaProvincia);
				}
				
				if(mensajeUsuario!="") {
					request.setAttribute("MensajeUsuario", mensajeUsuario);
					request.setAttribute("ListaProvincias", listaProvincia);
				}
				
				RequestDispatcher rd=request.getRequestDispatcher("/AltaCliente.jsp");
				rd.forward(request, response);	
			}
			
			
				
		
			
			
			
			
			
						

				

			
			
		
			
				
			
		}
		
		/* ACTUALIZAR CLIENTE*/		
		
		
		
	}

}
