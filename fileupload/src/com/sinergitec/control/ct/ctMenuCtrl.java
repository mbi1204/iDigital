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
	
	public ctMenuCtrl() {
		super();
		ctMenu_dao = new ctMenuDaoImp();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("entro al doGet");
		String action = request.getParameter("action");
		//String cCveCia = request.getParameter("cCveCia");

		if (action.equals("list")) {
			try {
				lista = ctMenu_dao.list_ctMenu(true);
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			request.setAttribute("lista_ctMenu", lista);

		}

		RequestDispatcher view = request.getRequestDispatcher("/ctMenu_List.jsp");
		view.forward(request, response);

	}

	
	
	
}
