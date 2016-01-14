package com.sinergitec.dao.sy.imp;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.progress.open4gl.BooleanHolder;
import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.ResultSetHolder;
import com.progress.open4gl.StringHolder;
import com.progress.open4gl.javaproxy.Connection;
import com.sinergitec.dao.ct.ctMenuDao;
import com.sinergitec.dao.ct.imp.ctMenuDaoImp;
import com.sinergitec.dao.sy.syUsuMenuDao;
import com.sinergitec.model.ct.ctMenu;
import com.sinergitec.model.sg.sysUsuCompania;
import com.sinergitec.model.sg.sysUsuMenu;
import com.sinergitec.mydigital.util.DBConexion;
import com.sinergitec.mydigital.util.VectorResultSet;

import mydigital.sinergitec.appserver.myDigital;

public class syUsuMenuDaoImp implements syUsuMenuDao {
	
	private ctMenuDao ctMenu_Dao;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void add_syUsuMenuDao(String cUsuario, sysUsuMenu obj_sysUsuMenu) throws Open4GLException, IOException{
		
		BooleanHolder ps_Resultado = new BooleanHolder();
		StringHolder ps_Texto = new StringHolder();
		
		List<sysUsuMenu> Lista = new ArrayList<sysUsuMenu>();
		Lista.add(obj_sysUsuMenu);
		
		Vector vecTabla1, vecRow1;
		vecTabla1 = new Vector();
		
		Connection conexion = DBConexion.getConnection();
		myDigital app = new myDigital(conexion);
		
		for (sysUsuMenu obj : Lista) {
			vecRow1 = obj.getVectorDatos();
			vecTabla1.add(vecRow1);
		}
		
		ResultSetHolder tt_sysUsuMenu = new ResultSetHolder(new VectorResultSet(vecTabla1));
		
		try {
			app.as_sysUsuMenu_Inserta(cUsuario, tt_sysUsuMenu, ps_Resultado, ps_Texto);
			System.out.println(ps_Texto.getStringValue());
		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println(ex);
		} finally{
			app._release();
			DBConexion.closeConnection(conexion);
		}
		
	}
	
	public void update_syUsuMenuDao(String cUsuario, sysUsuMenu obj_sysUsuMenu) throws Open4GLException, IOException{
		
	}
	
	public void remove_syUsuMenuDao(String cUsuario, String cCveCia, String cUsuario2) throws Open4GLException, IOException{
		
	}
	
	public List<sysUsuMenu> list_syUsuMenuDao(boolean bTodos) throws Open4GLException, IOException{
		
		ctMenu_Dao = new ctMenuDaoImp();
		
		BooleanHolder ps_Resultado = new BooleanHolder();
		StringHolder ps_Texto = new StringHolder();
		
		List<sysUsuMenu> Lista = new ArrayList<sysUsuMenu>();
		List<ctMenu> listaMenu = new ArrayList<ctMenu>();
		listaMenu = ctMenu_Dao.list_ctMenu(true);
		
		ResultSetHolder tt_sysUsuMenu = new ResultSetHolder();
		Connection conexion = DBConexion.getConnection();
		
		myDigital app = new myDigital(conexion);
		
		try {
			
			app.as_sysUsuMenu_Carga(bTodos, tt_sysUsuMenu, ps_Resultado, ps_Texto);
			ResultSet rs_tt_sysUsuMenu = tt_sysUsuMenu.getResultSetValue();
			
			while(rs_tt_sysUsuMenu.next()){
				
				sysUsuMenu obj = new sysUsuMenu();
			
				obj.setcUsuario(rs_tt_sysUsuMenu.getString("cUsuario"));
				obj.setiMenu(rs_tt_sysUsuMenu.getInt("iMenu"));
				obj.setlActivo(rs_tt_sysUsuMenu.getBoolean("lActivo"));
				obj.setcObs(rs_tt_sysUsuMenu.getString("cObs"));
				obj.setId(rs_tt_sysUsuMenu.getBytes("id"));
				
				for (ctMenu menu : listaMenu) {
					if(menu.getiMenu().equals(obj.getiMenu())){
						ctMenu obj_ctMenu = new ctMenu();
						obj_ctMenu.setiMenu(menu.getiMenu());
						obj_ctMenu.setcMenu(menu.getcMenu());
						obj_ctMenu.setlActivo(menu.getlActivo());
						obj_ctMenu.setId(menu.getId());
						obj.setMenu(obj_ctMenu);
					}
				}
				
				Lista.add(obj);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
			app._release();
			DBConexion.closeConnection(conexion);
		}

		return Lista;
	}
	
	public sysUsuMenu get_syUsuMenuDao(String cUsuario, String cCveCia, String cUsuario2) throws Open4GLException, IOException{
		return null;
	}
}
