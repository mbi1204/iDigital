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

import sun.misc.Perf.GetPerfAction;


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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		String cCveCia = request.getParameter("cCveCia");
		String action = request.getParameter("action");

		if (action.equals("add") || action.equals("edit")) {

			System.out.println("doPost entro al add o update ");
			ctEmisor obj = new ctEmisor();
			
			System.out.println(request.getParameter("iEmisor"));

			
			obj.setiEmisor(Integer.parseInt(request.getParameter("iEmisor")));
			obj.setcCveCia(request.getParameter("cCveCia"));
			obj.setcRazonSocial(request.getParameter("cRazonSocial"));
			obj.setcRFC(request.getParameter("cRFC"));
			obj.setcCURP(request.getParameter("cCURP"));
			obj.setcCalle(request.getParameter("cCalle"));
			obj.setcNumeroInterior(request.getParameter("cNumeroInterior"));
			obj.setcNumeroExterior(request.getParameter("cNumeroExterior"));
			obj.setcMpioDelg(request.getParameter("cMpioDelg"));
			obj.setcEmail(request.getParameter("cEmail"));
			obj.setcPais(request.getParameter("cPais"));
			obj.setcEstado(request.getParameter("cEstado"));
			obj.setcCP(request.getParameter("cCP"));
			obj.setDtFechaAlta(request.getParameter("dtFechaAlta"));
			obj.setDtFechaCancel(request.getParameter("dtFechaCancel"));
			obj.setlActivo(Boolean.parseBoolean(request.getParameter("lActivo")));
			obj.setcAlias(request.getParameter("cAlias"));

			if (action.equals("add")) {

				try {
					ctEmisor_dao.add_ctEmisor("SISTEMAS", obj);
				} catch (Open4GLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (action.equals("edit")) {
					try {
						ctEmisor_dao.update_ctEmisor("SISTEMAS", obj);
					} catch (Open4GLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}
		}
		
		
		try {
			
			lista = ctEmisor_dao.list_ctEmisor(true);
		} catch (Open4GLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("pao por el do post");

		request.setAttribute("lista_ctEmisor", lista);
		request.getRequestDispatcher("/ctEmisor_List.jsp").forward(request, response);

		
	}
}
