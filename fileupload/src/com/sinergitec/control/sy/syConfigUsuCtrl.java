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
import com.sinergitec.dao.ct.ctMenuDao;
import com.sinergitec.dao.ct.imp.ctCompaniaDaoImp;
import com.sinergitec.dao.ct.imp.ctMenuDaoImp;
import com.sinergitec.dao.sy.syUsuCompaniaDao;
import com.sinergitec.dao.sy.syUsuMenuDao;
import com.sinergitec.dao.sy.imp.syUsuCompaniaDaoImp;
import com.sinergitec.dao.sy.imp.syUsuMenuDaoImp;
import com.sinergitec.model.ct.ctCompania;
import com.sinergitec.model.ct.ctMenu;
import com.sinergitec.model.ct.ctUsuario;
import com.sinergitec.model.sg.sysUsuCompania;
import com.sinergitec.model.sg.sysUsuMenu;

/**
 * Servlet implementation class syConfigUsu
 */
public class syConfigUsuCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ctCompaniaDao ctCompania_Dao;
	private syUsuCompaniaDao syUsuCompania_Dao;
	private ctMenuDao ctMenu_Dao;
	private syUsuMenuDao syUsuMenu_Dao;
	private List<ctMenu> list_Menu = new ArrayList<ctMenu>();
	private List<ctCompania> list_Compania = new ArrayList<ctCompania>();
	private List<ctUsuario>  list_Usuario = new ArrayList<ctUsuario>();
	private List<sysUsuCompania> list_UsuCompania = new ArrayList<sysUsuCompania>();
	private List<sysUsuMenu> list_UsuMenu = new ArrayList<sysUsuMenu>();
	
	private static String PRINCIPAL = "/sysConfigUsu.jsp";
	private static String ADDUSER   = "/sysConfigUsu_Add_UsuComp.jsp";
	private static String ADDMENU   = "/sysConfigUsu_Add_UsuMenu.jsp";
	private static String ADDPROGRAMA = "/sysConfigUsu_Add_UsuPrograma.jsp";
	private String forward = "";
	private String vUsuario;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public syConfigUsuCtrl() {
		super();
		ctCompania_Dao = new ctCompaniaDaoImp();
		ctMenu_Dao = new ctMenuDaoImp();
		syUsuCompania_Dao = new syUsuCompaniaDaoImp();
		syUsuMenu_Dao = new syUsuMenuDaoImp();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		String sUsuario;
		String sCompania;
		String sAction;
		
		
		sAction = request.getParameter("action");		
		System.out.println("ENTRO -->"+ sAction);
		if (sAction.equalsIgnoreCase("inicial")) {
			
			sCompania = request.getParameter("cCveCia");
			System.out.println("compañia -->"+ sCompania);
			sUsuario = request.getParameter("cUsuario");
			vUsuario = request.getParameter("cUsuario");
			System.out.println("Este es el usuario se toma del js: "+vUsuario);
			try {
				list_Menu = ctMenu_Dao.list_ctMenu(true);
				list_Compania = ctCompania_Dao.list_ctCompania(true);
				list_UsuMenu = syUsuMenu_Dao.list_syUsuMenuDao(true);
				list_UsuCompania = syUsuCompania_Dao.list_sysUsuConCompania(sCompania,true);
			} catch (Open4GLException e) {
				e.printStackTrace();
			}
			request.setAttribute("list_syUsuMenu", list_UsuMenu);
			request.setAttribute("list_ctMenu", list_Menu);
			request.setAttribute("list_ctCompania", list_Compania);
			request.setAttribute("list_syUsuCompania", list_UsuCompania);
			forward = PRINCIPAL;
		

		}else if (sAction.equalsIgnoreCase("list_Usu")){
			
			/*Este opcion permite cargar la lista de usuarios que no estan
			 * en una determinada compania, es decir filtra a los usuarios*/
			
			sCompania = request.getParameter("cCveCia");// Esta variable rescata a la compañia
			
			try {
				
				/*Nos traen los datos de la BD de los usuarios ya filtrados pertenecienes o no
				 * a alguna compañia NOTA: Parametro FALSE: trae usuarios no pertenecientes a la compañia seleccionada
				 * 								     TRUE : trae a los usuarios pertenecientes a la compañia seleccionada*/
				list_Usuario = syUsuCompania_Dao.list_sysUsuSinCompania(sCompania, false);
				
				
			} catch (Open4GLException e) {
				e.printStackTrace();
			}
			request.setAttribute("list_UsuCompania", list_Usuario);
			forward = ADDUSER;
			
		}else if(sAction.equalsIgnoreCase("list_Menu")){
			
			/*Aqui se va a cargara la lista de los menus*/
			try {
				list_Menu = ctMenu_Dao.list_ctMenu(true);				
			} catch (Open4GLException e) {
				e.printStackTrace();
			}
			request.setAttribute("list_UsuMenu", list_Menu);
			forward = ADDMENU;
			
		}else if(sAction.equalsIgnoreCase("list_Programa")){
			forward = ADDPROGRAMA;
		}else if (sAction.equalsIgnoreCase("delete")){
			
			/*Por se borra  
			 * con cCveCia y cUsuario*/
			
			sCompania = request.getParameter("cCveCia");
			sUsuario = request.getParameter("cUsuario");
			
			try {
				
				syUsuCompania_Dao.remove_sysUsuCompaniaDao("SISIMB", sCompania, sUsuario);
				list_UsuCompania = syUsuCompania_Dao.list_sysUsuConCompania(sCompania,true);
				list_Compania = ctCompania_Dao.list_ctCompania(true);
				list_UsuMenu = syUsuMenu_Dao.list_syUsuMenuDao(true);
				
			} catch (Open4GLException e) {
				e.printStackTrace();
			}
			
			request.setAttribute("list_syUsuCompania", list_UsuCompania);
			request.setAttribute("list_ctCompania", list_Compania);
			request.setAttribute("list_syUsuMenu", list_UsuMenu);
			forward = PRINCIPAL;
			
		}else if(sAction.equalsIgnoreCase("update")){
			
			sCompania = request.getParameter("cCveCia");
			sUsuario = request.getParameter("cUsuario");
			List<ctUsuario> lista_ctUsuario = new ArrayList<ctUsuario>();
			List<sysUsuCompania> lista_sysUsuCompania = new ArrayList<sysUsuCompania>();
			
			try {
								
				lista_sysUsuCompania.add(syUsuCompania_Dao.get_sysUsuCompania("SISIMB",sCompania, sUsuario));
				
				for (sysUsuCompania sysUsuCompania : lista_sysUsuCompania) {
					
					ctUsuario obj = new ctUsuario();
					
					obj.setcUsuario(sysUsuCompania.getcUsuario());
					obj.setcNombre(sysUsuCompania.getCtUsu().getcNombre());
					obj.setPuesto(sysUsuCompania.getCtUsu().getPuesto());
					obj.setlActivo(sysUsuCompania.getlActivo());
					
					lista_ctUsuario.add(obj);
					}
				}
			 catch (Open4GLException e) {
				e.printStackTrace();
			}
			
			request.setAttribute("list_UsuCompania", lista_ctUsuario);
			forward = ADDUSER;
			
		}else if(sAction.equals("deleteMenu")){
			
			String sUsuarioMenu = request.getParameter("cUsuario");
			Integer iMenu = Integer.parseInt(request.getParameter("iMenu"));
			
			try {
				syUsuMenu_Dao.remove_syUsuMenuDao("SISIMB", sUsuarioMenu, iMenu);
			} catch (Open4GLException e) {
				e.printStackTrace();
			}
			
			request.setAttribute("list_syUsuCompania", list_UsuCompania);
			request.setAttribute("list_ctCompania", list_Compania);
			request.setAttribute("list_syUsuMenu", list_UsuMenu);
			forward = PRINCIPAL;
			
		}else if(sAction.equals("updateMenu")){
			
			String sUsuarioMenu = request.getParameter("cUsuario");
			Integer iMenu = Integer.parseInt(request.getParameter("iMenu"));
			List<sysUsuMenu> listaUpdateMenu = new ArrayList<sysUsuMenu>();
			List<ctMenu> listaUpdateCtMenu = new ArrayList<ctMenu>();
			
			try {
				listaUpdateMenu.add(syUsuMenu_Dao.get_syUsuMenuDao("SISIMB", sUsuarioMenu, iMenu));
				for (sysUsuMenu listaUMenu : listaUpdateMenu) {
					ctMenu obj = new ctMenu();
					obj.setiMenu(listaUMenu.getiMenu());
					obj.setcMenu(listaUMenu.getMenu().getcMenu());
					obj.setlActivo(listaUMenu.getlActivo());
					
					listaUpdateCtMenu.add(obj);
					
				}
			} catch (Open4GLException e) {
				e.printStackTrace();
			}
			
			request.setAttribute("list_UsuMenu", listaUpdateCtMenu);
			forward = ADDMENU;
		}else if(sAction.equalsIgnoreCase("deletePrograma")){
			
		}else if(sAction.equalsIgnoreCase("updatePrograma")){
			
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
		//doGet(request, response);
		
		String action = request.getParameter("action");
		
		//Recibe la compañia a la que seran ingresado los usuarios
		String sCompania = request.getParameter("cCveCia");
		
		/*Esta arreglo va almacenar los usuarios que
		 * se van agregar como nuevos a determinada empresa*/
		String[] operaciones=request.getParameterValues("cUsuarios");
		

		if (action.equals("add") || action.equals("update")) {
			
			//Creacion del objeto usuario-compañia
			sysUsuCompania obj = new sysUsuCompania();
			
			if(action.equals("add")){
				
				// Este for recorrera el arreglo operaciones
				for (String string : operaciones) {
					
					obj.setcCveCia(sCompania);
					obj.setcUsuario(string);
					obj.setlActivo(true);
					
					try {
						syUsuCompania_Dao.add_sysUsuCompaniaDao("SISIMB", obj);
						} catch (Open4GLException e) {
							e.printStackTrace();
							}
					}
				
				
				
			} else if(action.equals("update")){
				
				Boolean lEstatus = Boolean.parseBoolean(request.getParameter("lActivo"));
				for (String string : operaciones) {
					obj.setcCveCia(sCompania);
					obj.setcUsuario(string);
					obj.setlActivo(lEstatus);
					
					try {
						syUsuCompania_Dao.update_sysUsuCompaniaDao("SISIMB", obj);
					} catch (Open4GLException e) {
						e.printStackTrace();
					}
				}
				
			}
			
			try {
				list_UsuCompania = syUsuCompania_Dao.list_sysUsuConCompania(sCompania,true);
				list_Compania = ctCompania_Dao.list_ctCompania(true);
			} catch (Open4GLException e) {
				e.printStackTrace();
			}
			
			request.setAttribute("list_syUsuCompania", list_UsuCompania);
			request.setAttribute("list_ctCompania", list_Compania);
			forward = PRINCIPAL;
			
		}else if(action.equals("addMenu")){
			
			/*Accion Agregar Menu*/
			String [] menus = request.getParameterValues("iMenus");			
			
			for (String string : menus) {
				sysUsuMenu obj = new sysUsuMenu();
				obj.setcUsuario(vUsuario);
				obj.setiMenu(Integer.parseInt(string));
				obj.setlActivo(true);
				obj.setcObs("");
				
				try {
					syUsuMenu_Dao.add_syUsuMenuDao("SISIMB", obj);
				} catch (Open4GLException e) {
					e.printStackTrace();
				}
			}
			
			try {
				list_UsuCompania = syUsuCompania_Dao.list_sysUsuCompania(true);
				list_Compania = ctCompania_Dao.list_ctCompania(true);
				list_UsuMenu = syUsuMenu_Dao.list_syUsuMenuDao(true);
			} catch (Open4GLException e) {
				e.printStackTrace();
			}
			
			request.setAttribute("list_syUsuCompania", list_UsuCompania);
			request.setAttribute("list_ctCompania", list_Compania);
			request.setAttribute("list_syUsuMenu", list_UsuMenu);
			forward = PRINCIPAL;
			
		}else if(action.equals("updateMenu")){
			/*Accion Actualizar Menu*/
			
			sysUsuMenu obj = new sysUsuMenu();
			obj.setcUsuario(vUsuario);
			obj.setiMenu(Integer.parseInt(request.getParameter("iMenu")));
			obj.setlActivo(Boolean.parseBoolean(request.getParameter("lActivo")));
			
			try {
				syUsuMenu_Dao.update_syUsuMenuDao("SISIMB", obj);
				list_UsuCompania = syUsuCompania_Dao.list_sysUsuCompania(true);
				list_Compania = ctCompania_Dao.list_ctCompania(true);
				list_UsuMenu = syUsuMenu_Dao.list_syUsuMenuDao(true);
			} catch (Open4GLException e) {
				e.printStackTrace();
			}
			request.setAttribute("list_syUsuCompania", list_UsuCompania);
			request.setAttribute("list_ctCompania", list_Compania);
			request.setAttribute("list_syUsuMenu", list_UsuMenu);
			forward = PRINCIPAL;
			
		}else if(action.equals("addPrograma")){
			
		}else if(action.equals("updatePrograma")){
			
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

}
