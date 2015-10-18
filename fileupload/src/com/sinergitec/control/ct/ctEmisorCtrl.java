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
import com.sinergitec.dao.ct.ctEmisorDao;
import com.sinergitec.dao.ct.imp.ctEmisorDaoImp;
import com.sinergitec.model.ct.ctEmisor;

public class ctEmisorCtrl extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ctEmisorDao ctEmisor_dao;
	private List<ctEmisor> lista = new ArrayList<ctEmisor>();
	
	public ctEmisorCtrl() {
		super();
		ctEmisor_dao =  new ctEmisorDaoImp();
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
				lista = ctEmisor_dao.list_ctEmisor(true);
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			request.setAttribute("lista_ctEmisor", lista);

		}

		RequestDispatcher view = request.getRequestDispatcher("/ctEmisor_List.jsp");
		view.forward(request, response);

	}
}
