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
import com.sinergitec.dao.ct.ctMenuDao;
import com.sinergitec.dao.ct.ctProgramaDao;
import com.sinergitec.dao.ct.imp.ctMenuDaoImp;
import com.sinergitec.dao.ct.imp.ctProgramaDaoImp;
import com.sinergitec.model.ct.ctMenu;
import com.sinergitec.model.ct.ctPrograma;

public class ctProgramaCtrl extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ctProgramaDao ctPrograma_dao;
	private ctMenuDao ctMenu_dao;
	private List<ctPrograma> lista = new ArrayList<ctPrograma>();
	private List<ctMenu> lista_menu = new ArrayList<ctMenu>();
	private static String INSERT_OR_EDIT = "/ctPrograma_Add.jsp";
	private static String LIST_CTPROGRAMA = "/ctPrograma_List.jsp";
	
	public ctProgramaCtrl() {
		super();
		ctPrograma_dao = new ctProgramaDaoImp();
		ctMenu_dao = new ctMenuDaoImp();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String forward = "";
		String action = request.getParameter("action");
		Integer iPrograma = null;
		Integer iMenu = null;
		
		if(action.equals("update") || action.equals("delete")){
			iMenu = Integer.parseInt(request.getParameter("iMenu"));
			iPrograma = Integer.parseInt(request.getParameter("iPrograma"));
			System.out.println("Encontrado");
			System.out.println(iMenu);
			System.out.println(iPrograma);
		}
		
		if (action.equals("delete")) {
			
			try {
				ctPrograma_dao.remove_ctPrograma("SISIMB", iMenu, iPrograma);
				lista = ctPrograma_dao.list_ctPrograma(true);
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("lista_ctPrograma", lista);
			forward = LIST_CTPROGRAMA;

		} else if (action.equals("add")) {
			ctPrograma obj = new ctPrograma();
			try {
				lista_menu = ctMenu_dao.list_ctMenu(true);
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("lista_ctMenu", lista_menu);
			request.setAttribute("ctPrograma", obj);
			forward = INSERT_OR_EDIT;
		} else if (action.equals("update")) {
			ctPrograma obj = new ctPrograma();
			try {
				lista_menu = ctMenu_dao.list_ctMenu(true);
				obj = ctPrograma_dao.get_ctPrograma("SISIMB", iMenu, iPrograma);
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("lista_ctMenu", lista_menu);
			request.setAttribute("ctPrograma", obj);
			forward = INSERT_OR_EDIT;

		} else if (action.equals("list")) {
			try {
				lista = ctPrograma_dao.list_ctPrograma(true);
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("lista_ctPrograma", lista);
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
			ctPrograma obj = new ctPrograma();
			
			obj.setiMenu(Integer.parseInt(request.getParameter("iMenu")));
			obj.setcPrograma(request.getParameter("cPrograma"));
			obj.setlActivo((action.equals("add")) ? true : Boolean.parseBoolean(request.getParameter("lActivo")));
			obj.setcNombre(request.getParameter("cNombre"));
			
			if (action.equals("add")) {
				
				try {
					ctPrograma_dao.add_ctPrograma("SISIMB", obj);
				} catch (Open4GLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (action.equals("update")) {
				try {
					obj.setiPrograma(Integer.parseInt(request.getParameter("iPrograma")));
					ctPrograma_dao.update_ctPrograma("SISIMB", obj);
				} catch (Open4GLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
			try {
				lista = ctPrograma_dao.list_ctPrograma(true);
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("lista_ctPrograma", lista);
		} 
		 request.getRequestDispatcher("/ctPrograma_List.jsp").forward(request, response);	 
	}
}
