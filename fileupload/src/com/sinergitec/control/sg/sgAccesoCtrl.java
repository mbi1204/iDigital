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
		
	}
	
	/*Do post*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		String action = request.getParameter("action");
		if(action.equals("login")){
			System.out.println("Esta llegando hasta aqui");
			ctUsuario obj = new ctUsuario();
			obj.setcUsuario(request.getParameter("cUsuario"));
			obj.setcPassword(request.getParameter("cPassword"));
			
			try {
				sgAcceso_dao.acceso_sgAcceso(obj);
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
