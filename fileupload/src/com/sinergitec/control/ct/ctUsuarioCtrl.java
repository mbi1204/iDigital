package com.sinergitec.control.ct;

import java.io.IOException;
import java.sql.Timestamp;
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
import com.sinergitec.model.ct.ctPrograma;
import com.sinergitec.model.ct.ctUsuario;

public class ctUsuarioCtrl extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ctUsuarioDao ctUsuario_dao;
	private List<ctUsuario> lista = new ArrayList<ctUsuario>();
	
	public ctUsuarioCtrl() {
		super();
		ctUsuario_dao = new ctUsuarioDaoImp();
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
				lista = ctUsuario_dao.list_ctUsuario(true);
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			request.setAttribute("lista_ctUsuario", lista);

		}

		RequestDispatcher view = request.getRequestDispatcher("/ctUsuario_List.jsp");
		view.forward(request, response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		String cCveCia = request.getParameter("cCveCia");
		String action = request.getParameter("action");

		if (action.equals("add") || action.equals("edit")) {

			System.out.println("doPost entro al add o update ");
			ctUsuario obj = new ctUsuario();

			obj.setcUsuario(request.getParameter("cUsuario"));
			obj.setcNombre(request.getParameter("cNombre"));
			obj.setcPassword(request.getParameter("cPassword"));
			obj.setlActivo(Boolean.parseBoolean(request.getParameter("lActivo")));
			obj.setDtFechaAlta(Timestamp.valueOf(request.getParameter("dtFechaAlta")));
			obj.setiPuesto(Integer.parseInt(request.getParameter("cNombre")));

			if (action.equals("add")) {

				try {
					ctUsuario_dao.add_ctUsuario("SISTEMAS", obj);
				} catch (Open4GLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (action.equals("edit")) {
					try {
						ctUsuario_dao.update_ctUsuario("SISTEMAS", obj);
					} catch (Open4GLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}
		}
		

		
		try {
			lista = ctUsuario_dao.list_ctUsuario(true);
		} catch (Open4GLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("pao por el do post");

		request.setAttribute("lista_ctUsuario", lista);
		request.getRequestDispatcher("/ctUsuario_List.jsp").forward(request, response);

		
	}
}
