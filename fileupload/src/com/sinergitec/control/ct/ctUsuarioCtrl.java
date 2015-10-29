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
import com.sinergitec.dao.ct.ctUsuarioDao;
import com.sinergitec.dao.ct.imp.ctUsuarioDaoImp;
import com.sinergitec.model.ct.ctUsuario;
import com.sun.jmx.snmp.Timestamp;

public class ctUsuarioCtrl extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ctUsuarioDao ctUsuario_dao;
	private List<ctUsuario> lista = new ArrayList<ctUsuario>();
	private static String INSERT_OR_EDIT = "/ctUsuario_Add.jsp";
	private static String LIST_CTUSUARIO = "/ctUsuario_List.jsp";
	
	public ctUsuarioCtrl() {
		super();
		ctUsuario_dao = new ctUsuarioDaoImp();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String forward = "";
		String action = request.getParameter("action");
		String cUsuario = request.getParameter("cUsuario");
		System.out.println(cUsuario);
		System.out.println(action);
		
		if (action.equals("delete")) {
			
			try {
				ctUsuario_dao.remove_ctUsuario("SISTEMAS", cUsuario);
				lista = ctUsuario_dao.list_ctUsuario(true);
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("lista_ctUsuario", lista);
			forward = LIST_CTUSUARIO;

		} else if (action.equals("add")) {
			ctUsuario obj = new ctUsuario();		
			request.setAttribute("ctUsuario", obj);
			forward = INSERT_OR_EDIT;
		} else if (action.equals("update")) {
			ctUsuario obj = new ctUsuario();
			try {

				obj = ctUsuario_dao.get_ctUsuario("SISTEMAS", cUsuario);
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("ctUsuario", obj);
			forward = INSERT_OR_EDIT;

		} else if (action.equals("list")) {
			try {
				lista = ctUsuario_dao.list_ctUsuario(true);
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("lista_ctUsuario", lista);
			forward = LIST_CTUSUARIO;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");

		if (action.equals("add") || action.equals("update")) {
			
			ctUsuario obj = new ctUsuario();
			
			obj.setcUsuario(request.getParameter("cUsuario"));
			obj.setcNombre(request.getParameter("cNombre"));
			obj.setcPassword(request.getParameter("cPassword"));
			obj.setlActivo((action.equals("add")) ? true : Boolean.parseBoolean(request.getParameter("lActivo")));
			obj.setDtFechaAlta(request.getParameter("dtFechaAlta"));
			obj.setiPuesto(Integer.parseInt(request.getParameter("iPuesto")));
			
			if (action.equals("add")) {
				
				try {
					ctUsuario_dao.add_ctUsuario("SISTEMAS", obj);
				} catch (Open4GLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (action.equals("update")) {
				try {
					ctUsuario_dao.update_ctUsuario("SISTEMAS", obj);
				} catch (Open4GLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
			try {
				lista = ctUsuario_dao.list_ctUsuario(true);
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("lista_ctUsuario", lista);
		} 
		 request.getRequestDispatcher("/ctUsuario_List.jsp").forward(request, response);	 
	}
}
