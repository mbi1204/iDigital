package com.sinergitec.control.sy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.progress.open4gl.Open4GLException;
import com.sinergitec.dao.ct.ctCompaniaDao;
import com.sinergitec.dao.ct.ctPuestoDao;
import com.sinergitec.dao.ct.ctUsuarioDao;
import com.sinergitec.dao.ct.imp.ctCompaniaDaoImp;
import com.sinergitec.dao.ct.imp.ctUsuarioDaoImp;
import com.sinergitec.dao.sg.sysUsuCompaniaDao;
import com.sinergitec.dao.sy.syUsuCompaniaDao;
import com.sinergitec.dao.sy.imp.syUsuCompaniaDaoImp;
import com.sinergitec.model.ct.ctCompania;
import com.sinergitec.model.ct.ctPuesto;
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
		
		/*ATENCION SE ENCONTRO UN BUG :S
		 *El problema: se muestran los usuarios que esten
		 * en mas de una empresa al mismo tiempo :V*/
		

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
			
			/*Este opcion permite cargar la lista de usuarios que no estan
			 * en una determinada compania, es decir filtra a los usuarios*/
			
			sCompania = request.getParameter("cCveCia");// Esta variable rescata a la compañia
			
			List<ctUsuario> Lista_nueva = new ArrayList<ctUsuario>();
			List<String> catUsuarios = new ArrayList<String>();
			List<String> catUsuEmpresa = new ArrayList<String>();
			// Lista para almacenar a los usuarios filtrados
			
			try {
				
				//Nos traen los datos de la BD de los usuarios y las compañias
				list_Usuario = ctUsuario_Dao.list_ctUsuario(true);
				list_Compania = ctCompania_Dao.list_ctCompania(true);
				list_UsuCompania = syUsuCompania_Dao.list_sysUsuCompania(true);
				
				
				for (ctUsuario usuario_filtro : list_Usuario) {
					
					/*Primer for que va a recorrer a todos los usuarios
					 * este for no termina hasta que todo el codigo dentro de el termine*/
					
					//Nos permite almacenar los usuarios en una lista para compararlos
					catUsuarios.add(usuario_filtro.getcUsuario());
					
						for (ctCompania Company : list_Compania) {
							
							/*Segundo For que va a recorrer a todas las compañias
							 * no termina hasta que se completen los if*/
							
							for (sysUsuCompania usuCompany : list_UsuCompania) {
								
								/*Tercer For va a recorrer a todos los usuarios que ya 
								 * cuentan con compañia*/
								
								//Nos permite almacenar los usuarios en una lista para compararlos
								catUsuEmpresa.add(usuCompany.getcUsuario());
								
								if(!usuCompany.getcCveCia().equals(sCompania) &&
										
										usuCompany.getcUsuario().equals(usuario_filtro.getcUsuario()) &&

										usuario_filtro.getlActivo().equals(true) && Company.getcCveCia().equals(sCompania)){
									
									System.out.println("Esta entrando al primer if");

									/*Este if tiene por objetivo descartar a los usuarios
									 * que ya estuviesen inscritos dentro de la empresa
									 * seleccionada*/

									//Creacion del objeto usuario
									ctUsuario obj_nuevo = new ctUsuario();

									obj_nuevo.setcUsuario(usuario_filtro.getcUsuario());
									obj_nuevo.setcNombre(usuario_filtro.getcNombre());
									obj_nuevo.setcPassword(usuario_filtro.getcPassword());
									obj_nuevo.setlActivo(usuario_filtro.getlActivo());
									obj_nuevo.setDtFechaAlta(usuario_filtro.getDtFechaAlta());
									obj_nuevo.setiPuesto(usuario_filtro.getiPuesto());
									obj_nuevo.setPuesto(usuario_filtro.getPuesto());
									obj_nuevo.setId(usuario_filtro.getId());
									Lista_nueva.add(obj_nuevo);
									
									}
								}
							}
						}
				
				
				/*Esta seccion nos permite filtar a los usuarios que no estan con una 
				 * compañia es decir es la primera vez que los van agregar*/
				Collection<String> similar = new HashSet<String>( catUsuarios );
		        Collection<String> different = new HashSet<String>();
		        different.addAll( catUsuarios );
		        different.addAll( catUsuEmpresa );
		        
		        similar.retainAll( catUsuEmpresa );
		        different.removeAll( similar );
		        
		        
		        //Recorremos la lista original de usuarios
		        for (ctUsuario usuario_filtro : list_Usuario) {
		        	
		        	//Recorremos la lista con los usuarios que no tienen empresa
		        	for (String string : different) {
		        		
		        		/*Verificamos que sea igual el usuario existente en la base con
		        		 * el usuario que no tiene empresa*/
						if(usuario_filtro.getcUsuario().equals(string)){
							
							System.out.println("Usuario no existente en sysUsuCompania: "+string);
							//Creacion del objeto usuario
							ctUsuario obj_nuevo = new ctUsuario();

							obj_nuevo.setcUsuario(usuario_filtro.getcUsuario());
							obj_nuevo.setcNombre(usuario_filtro.getcNombre());
							obj_nuevo.setcPassword(usuario_filtro.getcPassword());
							obj_nuevo.setlActivo(usuario_filtro.getlActivo());
							obj_nuevo.setDtFechaAlta(usuario_filtro.getDtFechaAlta());
							obj_nuevo.setiPuesto(usuario_filtro.getiPuesto());
							obj_nuevo.setPuesto(usuario_filtro.getPuesto());
							obj_nuevo.setId(usuario_filtro.getId());
							Lista_nueva.add(obj_nuevo);
						}
					}
				}
				
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("list_UsuCompania", Lista_nueva);
			forward = ADDUSER;			
		}else if (sAction.equalsIgnoreCase("delete")){
			/*Por el momento se borra  
			 * con cCveCia y cUsuario*/
			System.out.println("Cachorros estoy dentro del delete");
			sCompania = request.getParameter("cCveCia");
			sUsuario = request.getParameter("cUsuario");
			System.out.println(sUsuario);
			try {
				syUsuCompania_Dao.remove_sysUsuCompaniaDao("SISIMB", sCompania, sUsuario);
				list_UsuCompania = syUsuCompania_Dao.list_sysUsuCompania(true);
				list_Compania = ctCompania_Dao.list_ctCompania(true);
				
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("list_syUsuCompania", list_UsuCompania);
			request.setAttribute("list_ctCompania", list_Compania);
			forward = PRINCIPAL;
		}else if(sAction.equalsIgnoreCase("update")){
			
			/*ATENCION METODO NO TERMINADO AUN :V
			 * Error: Tipo de dato*/
			
			sCompania = request.getParameter("cCveCia");
			sUsuario = request.getParameter("cUsuario");
			List<ctUsuario> lista_ctUsuario = new ArrayList<ctUsuario>();
			List<sysUsuCompania> lista_sysUsuCompania = new ArrayList<sysUsuCompania>();

			System.out.println("Este es el valor de la compañia en update: "+sCompania);
			System.out.println("Este es el valor del usuario en update: "+sUsuario);
			
			try {
								
				lista_sysUsuCompania.add(syUsuCompania_Dao.get_sysUsuCompania("SISIMB",sCompania, sUsuario));
				
				for (sysUsuCompania sysUsuCompania : lista_sysUsuCompania) {
					
					ctUsuario obj = new ctUsuario();
					
					obj.setcUsuario(sysUsuCompania.getcUsuario());
					obj.setcNombre(sysUsuCompania.getCtUsu().getcNombre());
					obj.setPuesto(sysUsuCompania.getCtUsu().getPuesto());
					obj.setlActivo(sysUsuCompania.getlActivo());
					
					System.out.println("Este es el valor del  puesto: "+obj.getPuesto().getcPuesto());
					
					lista_ctUsuario.add(obj);
					}
				}
			 catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("list_UsuCompania", lista_ctUsuario);
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
							//TODO Auto-generated catch block
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
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
			try {
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

}
