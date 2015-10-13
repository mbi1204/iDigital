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
import com.sinergitec.dao.ct.ctCompaniaDao;
import com.sinergitec.dao.ct.imp.ctCompaniaDaoImp;
import com.sinergitec.model.ct.ctCompania;

/**
 * Servlet implementation class ctCompaniaCtrl
 */
public class ctCompaniaCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ctCompaniaDao ctCompania_dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ctCompaniaCtrl() {
        super();
        
        ctCompania_dao = new ctCompaniaDaoImp();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		System.out.println("entro al doGet");
		String action=request.getParameter("action");
		 
		 List<ctCompania> lista = new ArrayList<ctCompania>(); 
		 
		 if(action.equals("list")){
			 
			 System.out.println("entro al list");	 
			 
			 
			 try {
				 lista = ctCompania_dao.list_ctCompania(true);
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 request.setAttribute("lista_ctCompania", lista);
		 
		 }
		 
		 RequestDispatcher view = request.getRequestDispatcher("/ctCompania_List.jsp");
		 view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		System.out.println("entro al doPost");
		
		
	}

}
