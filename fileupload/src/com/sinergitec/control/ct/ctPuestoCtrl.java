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
	
	public ctPuestoCtrl() {
		super();
		ctPuesto_dao =  new ctPuestoDaoImp();
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
				lista = ctPuesto_dao.list_ctPuesto(true);
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			request.setAttribute("lista_ctPuesto", lista);

		}

		RequestDispatcher view = request.getRequestDispatcher("/ctPuesto_List.jsp");
		view.forward(request, response);

	}
	
}
