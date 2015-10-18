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
import com.sinergitec.dao.ct.ctProgramaDao;
import com.sinergitec.dao.ct.imp.ctProgramaDaoImp;
import com.sinergitec.model.ct.ctPrograma;

public class ctProgramaCtrl extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ctProgramaDao ctPrograma_dao;
	private List<ctPrograma> lista = new ArrayList<ctPrograma>();
	
	public ctProgramaCtrl() {
		super();
		ctPrograma_dao = new ctProgramaDaoImp();
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
				lista = ctPrograma_dao.list_ctPrograma(true);
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			request.setAttribute("lista_ctPrograma", lista);

		}

		RequestDispatcher view = request.getRequestDispatcher("/ctPrograma_List.jsp");
		view.forward(request, response);

	}
}
