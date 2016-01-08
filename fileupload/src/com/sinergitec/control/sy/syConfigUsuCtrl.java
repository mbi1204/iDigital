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
import com.sinergitec.dao.sy.syUsuCompaniaDao;
import com.sinergitec.dao.sy.imp.syUsuCompaniaDaoImp;
import com.sinergitec.model.ct.ctCompania;
import com.sinergitec.model.ct.ctUsuario;
import com.sinergitec.model.sg.sysUsuCompania;

/**
 * Servlet implementation class syConfigUsu
 */
public class syConfigUsuCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ctCompaniaDao ctCompania_Dao;
	private ctUsuarioDao  ctUsuario_Dao;
	private syUsuCompaniaDao syUsuCompania_Dao;
	private List<ctCompania> list_Compania = new ArrayList<ctCompania>();
	private List<ctUsuario>  list_Usuario = new ArrayList<ctUsuario>();
	private List<sysUsuCompania> list_UsuCompania = new ArrayList<sysUsuCompania>();
	
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
		syUsuCompania_Dao = new syUsuCompaniaDaoImp();
		
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
		String sUsuario;
		String sCompania;
		String sAction;
		List<ctUsuario> Lista = new ArrayList<ctUsuario>();
		ctUsuario obj_nuevo = new ctUsuario();
		

		sAction = request.getParameter("action");
		
		System.out.println("ENTRO -->"+ sAction);
		if (sAction.equalsIgnoreCase("inicial")) {

			try {
				list_Compania = ctCompania_Dao.list_ctCompania(true);
				list_UsuCompania = syUsuCompania_Dao.list_sysUsuCompania(true);
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			request.setAttribute("list_ctCompania", list_Compania);
			request.setAttribute("list_syUsuCompania", list_UsuCompania);
			forward = PRINCIPAL;

		}else if (sAction.equalsIgnoreCase("list_Usu")){
			sCompania = request.getParameter("cCveCia");
			try {
				list_Usuario = ctUsuario_Dao.list_ctUsuario(true);
				list_UsuCompania = syUsuCompania_Dao.list_sysUsuCompania(true);
				
				for (ctUsuario usuario : list_Usuario) {
						for (sysUsuCompania usuCompany : list_UsuCompania) {
							if (!usuCompany.getcCveCia().equalsIgnoreCase(sCompania)){
								if(usuario.getlActivo().equals(true)){
									obj_nuevo.setcUsuario(usuario.getcUsuario());
									obj_nuevo.setcNombre(usuario.getcNombre());
									obj_nuevo.setcPassword(usuario.getcPassword());
									obj_nuevo.setlActivo(usuario.getlActivo());
									obj_nuevo.setDtFechaAlta(usuario.getDtFechaAlta());
									obj_nuevo.setiPuesto(usuario.getiPuesto());
									obj_nuevo.setPuesto(usuario.getPuesto());
									obj_nuevo.setId(usuario.getId());
									}
								Lista.add(obj_nuevo);
								}
							}
						}
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("list_UsuCompania", Lista);
			forward = ADDUSER;			
		}else if (sAction.equalsIgnoreCase("delete")){
			/*Por el momento se borra unicamente con el cUsuario 
			 * esto no debe de ser se debe de borrar con cUsuario y cCveCia*/
			System.out.println("Cachorros estoy dentro del delete");
			sUsuario = request.getParameter("cUsuario");
			System.out.println(sUsuario);
			try {
				syUsuCompania_Dao.remove_sysUsuCompaniaDao("SISIMB", "SINERGIT", sUsuario);
				list_UsuCompania = syUsuCompania_Dao.list_sysUsuCompania(true);
				list_Compania = ctCompania_Dao.list_ctCompania(true);
				
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("list_syUsuCompania", list_UsuCompania);
			request.setAttribute("list_ctCompania", list_Compania);
			forward = PRINCIPAL;
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
		//doGet(request, response);
		String action = request.getParameter("action");		

		if (action.equals("add") || action.equals("update")) {
			
			sysUsuCompania obj = new sysUsuCompania();
			
			obj.setcCveCia(request.getParameter("cCveCia"));
			obj.setcUsuario(request.getParameter("cUsuario"));
			obj.setlActivo(Boolean.parseBoolean(request.getParameter("lActivo")));
			
			/*obj.setcCveCia("SINERGIT");
			obj.setcUsuario("EMA");
			obj.setlActivo(true);*/
			
			if(action.equals("add")){
				try {
					syUsuCompania_Dao.add_sysUsuCompaniaDao("SISIMB", obj);
				} catch (Open4GLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if(action.equals("update")){
				/*try {
				syUsuCompania_Dao.update_sysUsuCompaniaDao("SISTEMAS", obj);
				} catch (Open4GLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			}
			
		}
	}

}
