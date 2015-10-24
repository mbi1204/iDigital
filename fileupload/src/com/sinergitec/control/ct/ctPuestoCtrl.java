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
import com.sinergitec.dao.ct.ctPuestoDao;
import com.sinergitec.dao.ct.imp.ctPuestoDaoImp;
import com.sinergitec.model.ct.ctPuesto;

public class ctPuestoCtrl extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ctPuestoDao ctPuesto_dao;
	private List<ctPuesto> lista = new ArrayList<ctPuesto>();
	private static String INSERT_OR_EDIT = "/ctPuesto_Add.jsp";
	private static String LIST_CTPROGRAMA = "/ctPuesto_List.jsp";
	
	public ctPuestoCtrl() {
		super();
		ctPuesto_dao =  new ctPuestoDaoImp();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String forward = "";
		String action = request.getParameter("action");
		Integer iPuesto = null;
		
		/*Misma situacion que el emisor*/
		if(action.equals("update") || action.equals("delete")){
			iPuesto = Integer.parseInt(request.getParameter("iPuesto"));
			System.out.println(iPuesto);
		}
		
		if (action.equals("delete")) {
			
			try {
				ctPuesto_dao.remove_ctPuesto("SISIMB", iPuesto);
				lista = ctPuesto_dao.list_ctPuesto(true);
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("lista_ctPuesto", lista);
			forward = LIST_CTPROGRAMA;

		} else if (action.equals("add")) {
			ctPuesto obj = new ctPuesto();		
			request.setAttribute("ctPuesto", obj);
			forward = INSERT_OR_EDIT;
		} else if (action.equals("update")) {
			ctPuesto obj = new ctPuesto();
			try {

				obj = ctPuesto_dao.get_ctPuesto("SISIMB", iPuesto);
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("ctPuesto", obj);
			forward = INSERT_OR_EDIT;

		} else if (action.equals("list")) {
			try {
				lista = ctPuesto_dao.list_ctPuesto(true);
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("lista_ctPuesto", lista);
			forward = LIST_CTPROGRAMA;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");

		if (action.equals("add") || action.equals("update")) {
			ctPuesto obj = new ctPuesto();
			obj.setiPuesto(Integer.parseInt(request.getParameter("iPuesto")));
			obj.setcPuesto(request.getParameter("cPuesto"));
			obj.setlActivo((action.equals("add")) ? true : Boolean.parseBoolean(request.getParameter("lActivo")));
			
			if (action.equals("add")) {
				
				try {
					ctPuesto_dao.add_ctPuesto("SISTEMAS", obj);
				} catch (Open4GLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (action.equals("update")) {
				try {
					ctPuesto_dao.update_ctPuesto("SISTEMAS", obj);
				} catch (Open4GLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
			try {
				lista = ctPuesto_dao.list_ctPuesto(true);
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("lista_ctPuesto", lista);
		} 
		 request.getRequestDispatcher("/ctPuesto_List.jsp").forward(request, response);	 
	}
	
}
