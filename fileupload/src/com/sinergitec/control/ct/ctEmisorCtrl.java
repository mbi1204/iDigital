package com.sinergitec.control.ct;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	private static String INSERT_OR_EDIT = "/ctEmisor_Add.jsp";
	private static String LIST_CTEMISOR = "/ctEmisor_List.jsp";
	
	public ctEmisorCtrl() {
		super();
		ctEmisor_dao =  new ctEmisorDaoImp();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String forward = "";
		String action = request.getParameter("action");
		String cCveCia = request.getParameter("cCveCia");
		Integer iEmisor = null;
		/*Aqui tuve que realizar este cambio puesto que iEmisor es el que se utiliza
		 * para identificar el registro, por lo cual solo leo el parametro de iEmisor
		 * cuando se envia por la url y en la lista pues no leo nada :S*/
		if(action.equals("list") || action.equals("add")){
			iEmisor = null; //Aqui no lleva valor el iEmisor
		}
		else{
			iEmisor = Integer.parseInt(request.getParameter("iEmisor"));
		}
		
		
		if (action.equals("delete")) {
			//iEmisor = Integer.parseInt(request.getParameter("iEmisor"));
			System.out.println(iEmisor);
			try {
				ctEmisor_dao.remove_ctEmisor("SISTEMAS", iEmisor);
				lista = ctEmisor_dao.list_ctEmisor(true);
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("lista_ctEmisor", lista);
			forward = LIST_CTEMISOR;

		} else if (action.equals("add")) {
			ctEmisor obj = new ctEmisor();		
			request.setAttribute("ctEmisor", obj);
			forward = INSERT_OR_EDIT;
		} else if (action.equals("update")) {
			ctEmisor obj = new ctEmisor();
			try {

				obj = ctEmisor_dao.get_ctEmisor("SISTEMAS", iEmisor);
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("ctEmisor", obj);
			forward = INSERT_OR_EDIT;
			
		}else if (action.equals("list")) {
			try {
				lista = ctEmisor_dao.list_ctEmisor(true);
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			request.setAttribute("lista_ctEmisor", lista);
			forward = LIST_CTEMISOR;

		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		String cCveCia = request.getParameter("cCveCia");
		String action = request.getParameter("action");

		if (action.equals("add") || action.equals("update")) {

			System.out.println("doPost entro al add o update ");
			ctEmisor obj = new ctEmisor();
			
			/*Date now = new Date(System.currentTimeMillis());
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat hour = new SimpleDateFormat("HH:mm:ss.ssssss");
			System.out.println(date.format(now)+" "+hour.format(now));
			
			System.out.println(request.getParameter("iEmisor"));*/

			
			//obj.setiEmisor(Integer.parseInt(request.getParameter("iEmisor")));
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
			obj.setlActivo( (action.equals("add")) ? true : Boolean.parseBoolean(request.getParameter("lActivo")));
			obj.setcAlias(request.getParameter("cAlias"));

			if (action.equals("add")) {

				try {
					System.out.println("Esta es la fecha"+obj.getDtFechaAlta());
					ctEmisor_dao.add_ctEmisor("SISTEMAS", obj);
				} catch (Open4GLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (action.equals("update")) {
				try {
					System.out.println("Pasa por aqui");
					ctEmisor_dao.update_ctEmisor("SISTEMAS", obj);
					} catch (Open4GLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				
			try {
				lista = ctEmisor_dao.list_ctEmisor(true);
				} catch (Open4GLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
				}
				request.setAttribute("lista_ctEmisor", lista);
				}
		request.getRequestDispatcher("/ctEmisor_List.jsp").forward(request, response);
		}
}

