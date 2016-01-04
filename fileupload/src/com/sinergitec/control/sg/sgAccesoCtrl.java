package com.sinergitec.control.sg;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.progress.open4gl.Open4GLException;
import com.sinergitec.dao.sg.sgAccesoDao;
import com.sinergitec.dao.sg.imp.sgAccesoDaoImp;
import com.sinergitec.model.ct.ctUsuario;

public class sgAccesoCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private sgAccesoDao sgAcceso_dao;
	
	public sgAccesoCtrl(){
		super();
		sgAcceso_dao = new sgAccesoDaoImp();
	}
	
	/*Do get*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("entro doGet");
		
	}
	
	/*Do post*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		
		String vcResultado = null;		
		String action = request.getParameter("action");
		
		if(action.equals("login")){		
			ctUsuario obj = new ctUsuario();
			obj.setcUsuario(request.getParameter("cUsuario"));
			obj.setcPassword(request.getParameter("cPassword"));
			
			try {
				vcResultado = sgAcceso_dao.acceso_sgAcceso(obj);
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}	
		
		if (vcResultado == null ){
			request.setAttribute("vcResultado", vcResultado);
			request.getRequestDispatcher("/sysMenuUsuario.jsp").forward(request, response);					
		}else {
			request.getRequestDispatcher("/index.jsp").forward(request, response);				
		}
			 
		
		
		
	}
}
