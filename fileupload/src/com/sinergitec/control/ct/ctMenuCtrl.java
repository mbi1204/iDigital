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
import com.sinergitec.dao.ct.imp.ctMenuDaoImp;
import com.sinergitec.model.ct.ctMenu;

public class ctMenuCtrl extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ctMenuDao ctMenu_dao;
	private List<ctMenu> lista = new ArrayList<ctMenu>();
	private static String INSERT_OR_EDIT = "/ctMenu_Add.jsp";
	private static String LIST_CTMENU = "/ctMenu_List.jsp";
	
	public ctMenuCtrl() {
		super();
		ctMenu_dao = new ctMenuDaoImp();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String forward = "";
		String action = request.getParameter("action");
		Integer iMenu = null;
		/*Misma situacion que el emisor*/
		if(action.equals("list") || action.equals("add")){
			iMenu = null;
		}
		else{
			iMenu = Integer.parseInt(request.getParameter("iMenu"));
		}
		
		if (action.equals("delete")) {
			
			try {
				ctMenu_dao.remove_ctMenu("SISIMB", iMenu);
				lista = ctMenu_dao.list_ctMenu(true);
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("lista_ctMenu", lista);
			forward = LIST_CTMENU;

		} else if (action.equals("add")) {
			ctMenu obj = new ctMenu();		
			request.setAttribute("ctMenu", obj);
			forward = INSERT_OR_EDIT;
		} else if (action.equals("update")) {
			ctMenu obj = new ctMenu();
			try {

				obj = ctMenu_dao.get_ctMenu("SISIMB", iMenu);
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("ctMenu", obj);
			forward = INSERT_OR_EDIT;

		} else if (action.equals("list")) {
			try {
				lista = ctMenu_dao.list_ctMenu(true);
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("lista_ctMenu", lista);
			forward = LIST_CTMENU;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		Integer iMenu = Integer.parseInt(request.getParameter("iMenu"));
		String action = request.getParameter("action");

		System.out.println("accion  " + action);
		System.out.println("menu " + iMenu);

		if (action.equals("add") || action.equals("edit")) {
			ctMenu obj = new ctMenu();

			obj.setiMenu(Integer.parseInt(request.getParameter("iMenu")));
			obj.setcMenu(request.getParameter("cMenu"));
			obj.setlActivo( (action.equals("add")) ? true : Boolean.parseBoolean(request.getParameter("lActivo")));

			if (action.equals("add")) {

				try {
					ctMenu_dao.add_ctMenu("SISTEMAS", obj);
				} catch (Open4GLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (action.equals("update")) {
				try {
					ctMenu_dao.update_ctMenu("SISTEMAS", obj);
				} catch (Open4GLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
			try {
				lista = ctMenu_dao.list_ctMenu(true);
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("lista_ctMenu", lista);
		} 
		 request.getRequestDispatcher("/ctMenu_List.jsp").forward(request, response);	 
	}
	
}
