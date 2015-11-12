package com.sinergitec.control.sy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.progress.open4gl.Open4GLException;
import com.sinergitec.dao.ct.ctCompaniaDao;
import com.sinergitec.dao.ct.ctUsuarioDao;
import com.sinergitec.dao.ct.imp.ctCompaniaDaoImp;
import com.sinergitec.dao.ct.imp.ctUsuarioDaoImp;
import com.sinergitec.model.ct.ctCompania;
import com.sinergitec.model.ct.ctUsuario;

/**
 * Servlet implementation class syConfigUsu
 */
public class syConfigUsuCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ctCompaniaDao ctCompania_Dao;
	private ctUsuarioDao  ctUsuario_Dao;
	private List<ctCompania> list_Compania = new ArrayList<ctCompania>();
	private List<ctUsuario>  list_Usuario = new ArrayList<ctUsuario>();
	
	private static String PRINCIPAL = "/sysConfigUsu.jsp";
	private static String ADDUSER   = "/sysConfigUsu_Add_UsuComp.jsp";
	private String forward = "";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public syConfigUsuCtrl() {
		super();
		ctCompania_Dao = new ctCompaniaDaoImp();
		ctUsuario_Dao  = new ctUsuarioDaoImp();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.getWriter().append("Served at: ").append(request.getContextPath());

		String sAction;

		sAction = request.getParameter("action");
		
		System.out.println("ENTRO -->"+ sAction);
		if (sAction.equalsIgnoreCase("inicial")) {

			try {
				list_Compania = ctCompania_Dao.list_ctCompania(true);
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			request.setAttribute("list_ctCompania", list_Compania);
			forward = PRINCIPAL;

		}else if (sAction.equalsIgnoreCase("list_Usu")){
			try {
				list_Usuario = ctUsuario_Dao.list_ctUsuario(true);
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("list_Usuario", list_Usuario);
			forward = ADDUSER;			
		}
		

		RequestDispatcher view = request.getRequestDispatcher(forward);

		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
