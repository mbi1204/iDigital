package com.sinergitec.control.ct;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.progress.open4gl.Open4GLException;
import com.sinergitec.dao.ct.ctCompaniaDao;
import com.sinergitec.dao.ct.imp.ctCompaniaDaoImp;
import com.sinergitec.model.ct.ctCompania;

/**
 * Servlet implementation class ctCompaniaCtrl
 */
public class ctCompaniaCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ctCompaniaDao ctCompania_dao;
	private List<ctCompania> lista = new ArrayList<ctCompania>();
	private static String INSERT_OR_EDIT = "/ctCompania_Add.jsp";
	private static String LIST_CTCOMPANIA = "/ctCompania_List.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ctCompaniaCtrl() {
		super();
		ctCompania_dao = new ctCompaniaDaoImp();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String forward = "";
		String action = request.getParameter("action");
		String cCveCia = request.getParameter("cCveCia");

		if (action.equals("delete")) {
			
			try {
				ctCompania_dao.remove_ctCompania("SISIMB", cCveCia);
				lista = ctCompania_dao.list_ctCompania(true);
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("lista_ctCompania", lista);
			forward = LIST_CTCOMPANIA;

		} else if (action.equals("add")) {
			ctCompania obj = new ctCompania();		
			request.setAttribute("ctCompania", obj);
			forward = INSERT_OR_EDIT;
		} else if (action.equals("update")) {
			ctCompania obj = new ctCompania();
			try {

				obj = ctCompania_dao.get_ctCompania("SISIMB", cCveCia);
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("ctCompania", obj);
			forward = INSERT_OR_EDIT;

		} else if (action.equals("list")) {
			try {
				lista = ctCompania_dao.list_ctCompania(true);
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("lista_ctCompania", lista);
			forward = LIST_CTCOMPANIA;

		}

		RequestDispatcher view = request.getRequestDispatcher(forward);

		view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// Agregar <------------
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		
		System.out.println("activo? doPost->" + request.getParameter("lActivo"));
		
		String action = request.getParameter("action");		

		if (action.equals("add") || action.equals("update")) {

			ctCompania obj = new ctCompania();
			obj.setcCveCia(request.getParameter("cCveCia"));
			obj.setcRazonS(request.getParameter("cRazonS"));
			obj.setcRFC(request.getParameter("cRFC"));
			obj.setcCalle(request.getParameter("cCalle"));
			obj.setcNExterior(request.getParameter("cNExterior"));
			obj.setcNInterior(request.getParameter("cNInterior"));
			obj.setcColonia(request.getParameter("cColonia"));
			obj.setcMpioDeleg(request.getParameter("cMpioDeleg"));
			obj.setiCP(Integer.parseInt(request.getParameter("iCP")));
			obj.setcCiudad(request.getParameter("cCiudad"));
			obj.setcEstado(request.getParameter("cEstado"));
			obj.setcTelefono(request.getParameter("cTelefono"));
			obj.setcEmail(request.getParameter("cEmail"));
			obj.setcContacto(request.getParameter("cContacto"));
			obj.setcPais(request.getParameter("cPais"));			
			obj.setlActivo( (action.equals("add")) ? true : Boolean.parseBoolean(request.getParameter("lActivo")));

			if (action.equals("add")) {

				try {
					ctCompania_dao.add_ctCompania("SISTEMAS", obj);
				} catch (Open4GLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (action.equals("update")) {

				System.out.println("ento ctrl update");
				try {
					ctCompania_dao.update_ctCompania("SISTEMAS", obj);
				} catch (Open4GLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			try {
				lista = ctCompania_dao.list_ctCompania(true);
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("lista_ctCompania", lista);
		}

		request.getRequestDispatcher("/ctCompania_List.jsp").forward(request, response);

	}

}
