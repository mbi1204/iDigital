package com.sinergitec.dao.sy.imp;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.progress.open4gl.BooleanHolder;
import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.ResultSetHolder;
import com.progress.open4gl.StringHolder;
import com.progress.open4gl.javaproxy.Connection;
import com.sinergitec.dao.sy.syUsuMenuDao;
import com.sinergitec.model.ct.ctUsuario;
import com.sinergitec.model.sg.sysUsuCompania;
import com.sinergitec.model.sg.sysUsuMenu;
import com.sinergitec.mydigital.util.DBConexion;

import mydigital.sinergitec.appserver.myDigital;

public class syUsuMenuDaoImp implements syUsuMenuDao {

	public void add_syUsuMenuDao(String cUsuario, sysUsuMenu obj_sysUsuCompania) throws Open4GLException, IOException{
		
	}
	
	public void update_syUsuMenuDao(String cUsuario, sysUsuMenu obj_sysUsuCompania) throws Open4GLException, IOException{
		
	}
	
	public void remove_syUsuMenuDao(String cUsuario, String cCveCia, String cUsuario2) throws Open4GLException, IOException{
		
	}
	
	public List<sysUsuMenu> list_syUsuMenuDao(boolean bTodos) throws Open4GLException, IOException{
		
		BooleanHolder ps_Resultado = new BooleanHolder();
		StringHolder ps_Texto = new StringHolder();
		
		List<sysUsuMenu> Lista = new ArrayList<sysUsuMenu>();
		
		ResultSetHolder tt_sysUsuMenu = new ResultSetHolder();
		Connection conexion = DBConexion.getConnection();
		
		myDigital app = new myDigital(conexion);
		
		try {
			
			app.as_sysUsuMenu_Carga(bTodos, tt_sysUsuMenu, ps_Resultado, ps_Texto);
			ResultSet rs_tt_sysUsuMenu = tt_sysUsuMenu.getResultSetValue();
			
			while(rs_tt_sysUsuMenu.next()){
				
				sysUsuMenu obj = new sysUsuMenu();
			
				obj.setcUsuario(rs_tt_sysUsuMenu.getString("cUsuario"));
				obj.setlActivo(rs_tt_sysUsuMenu.getBoolean("lActivo"));
				obj.setcObs(rs_tt_sysUsuMenu.getString("cObs"));
				obj.setId(rs_tt_sysUsuMenu.getBytes("id"));
				
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
