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
	private static String INSERT_OR_EDIT  = "/ctCompania_Add.jsp";
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
		
		String action = request.getParameter("action");
		String cCveCia = request.getParameter("cCveCia");
		
		System.out.println(action);
		System.out.println(cCveCia);
		

	
		if (action.equals("delete")) {
			System.out.println("entro al delete do get");
			try {
				ctCompania_dao.remove_ctCompania("SISIMB", cCveCia);
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		else if (action.equals("update")){
			ctCompania obj = new ctCompania();
			try {
				
			
				obj = 	ctCompania_dao.get_ctCompania("SISIMB", cCveCia);
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("ctCompania", obj);	
			
			
			
		}else if  (action.equals("list")) {
			try {
				lista = ctCompania_dao.list_ctCompania(true);
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("lista_ctCompania", lista);		
			
			
			
			
		}
		
		 RequestDispatcher view = request.getRequestDispatcher("/ctCompania_List.jsp");
	
	     view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		String cCveCia = request.getParameter("cCveCia");
		String action = request.getParameter("action");

		if (action.equals("add") || action.equals("edit")) {

			System.out.println("doPost entro al add o update ");
			ctCompania obj = new ctCompania();

			System.out.println(request.getParameter("cCveCia"));
			System.out.println(request.getParameter("cRazonS"));
			System.out.println(request.getParameter("cRFC"));
			System.out.println(request.getParameter("cCalle"));
			System.out.println(request.getParameter("cNExterior"));
			System.out.println(request.getParameter("cNInterior"));

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
			obj.setlActivo(Boolean.parseBoolean(request.getParameter("lActivo")));

			if (action.equals("add")) {

				try {
					ctCompania_dao.add_ctCompania("SISTEMAS", obj);
				} catch (Open4GLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (action.equals("edit")) {
					try {
						ctCompania_dao.update_ctCompania("SISTEMAS", obj);
					} catch (Open4GLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}
		}
		

		
		try {
			lista = ctCompania_dao.list_ctCompania(true);
		} catch (Open4GLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("pao por el do post");

		request.setAttribute("lista_ctCompania", lista);
		request.getRequestDispatcher("/ctCompania_List.jsp").forward(request, response);

		
	}

}
