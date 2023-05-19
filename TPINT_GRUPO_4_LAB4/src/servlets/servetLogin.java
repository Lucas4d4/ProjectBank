package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import daoImpl.DaoClienteImpl;
import entidad.Cliente;
import entidad.administrador;
import negocioImpl.ClienteNegocioImpl;


/**
 * Servlet implementation class servetLogin
 */
@WebServlet("/servetLogin")
public class servetLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servetLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		
		
		if(request.getParameter("loguear")!=null) {

			String usuario = null;
			String password= null;
			usuario=request.getParameter("txtusuario");
			password=request.getParameter("txtpassword");
			
			HttpSession sesion = request.getSession(); 
			 
			 ClienteNegocioImpl cl = new ClienteNegocioImpl();
			 if(cl.validarAdmin(usuario, password) == 1) {
				 
				 sesion.setAttribute("user", usuario);
				 request.getRequestDispatcher("HomeAdministrador.jsp").forward(request, response);
			 
			 }else if (cl.validarCliente(usuario, password) == 2) {
				 Cliente c = new Cliente();
				 c = cl.traerCliente(usuario);
				
				 sesion.setAttribute("user", c);
				 request.getRequestDispatcher("Home.jsp").forward(request, response);
			 }else {
				 request.setAttribute("mensaje", "Error nombre de usuario y/o password");
				 request.getRequestDispatcher("login.jsp").forward(request, response);
			 }
 
			}
		
		
	
	
	}
}
