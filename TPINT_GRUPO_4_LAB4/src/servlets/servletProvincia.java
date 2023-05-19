package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Provincia;
import negocio.ProvinciaNegocio;
import negocioImpl.ProvinciaNegocioImpl;

/**
 * Servlet implementation class servletProvincia
 */
@WebServlet("/servletProvincia")
public class servletProvincia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletProvincia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		if (request.getParameter("Param") != null) {
			if (request.getParameter("Param").equals("ListarProvincias")) {

				// OBTENGO LISTA DE PROVINCIAS
				ProvinciaNegocio negocioProvincia = new ProvinciaNegocioImpl();
				ArrayList<Provincia> ListaProvincia = negocioProvincia.listarProvincias();
				request.setAttribute("ListaProvincias", ListaProvincia);

//				// OBTENGO LISTA DE LOCALIDADES
//				NegocioLocalidad negocioLocalidad = new NegocioLocalidadImpl();
//				ArrayList<Localidad> ListaLocalidad = negocioLocalidad.listarLocalidades();
//				request.setAttribute("ListaLocalidad", ListaLocalidad);

				RequestDispatcher rd = request.getRequestDispatcher("/AltaCliente.jsp");
				rd.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
