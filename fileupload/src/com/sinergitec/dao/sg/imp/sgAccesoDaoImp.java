package com.sinergitec.dao.sg.imp;

import java.io.IOException;
import java.sql.ResultSet;

import com.progress.open4gl.BooleanHolder;
import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.ResultSetHolder;
import com.progress.open4gl.StringHolder;
import com.progress.open4gl.javaproxy.Connection;
import com.sinergitec.appserver.myDigital;
import com.sinergitec.dao.sg.sgAccesoDao;
import com.sinergitec.model.ct.ctMenu;
import com.sinergitec.model.ct.ctPrograma;
import com.sinergitec.model.ct.ctUsuario;
import com.sinergitec.mydigital.util.DBConexion;

public class sgAccesoDaoImp implements sgAccesoDao {

	public String acceso_sgAcceso(ctUsuario objctUsuario) throws Open4GLException, IOException{
		
		System.out.println(objctUsuario.getcUsuario());
		System.out.println(objctUsuario.getcPassword());

		BooleanHolder ps_Resultado = new BooleanHolder();
		StringHolder ps_Texto = new StringHolder();
		ResultSetHolder tt_ctMenu = new ResultSetHolder();
		ResultSetHolder tt_ctPrograma = new ResultSetHolder();

		Connection conexion = DBConexion.getConnection();
		myDigital app = new myDigital(conexion);
		ctPrograma obj_programa = new ctPrograma();
		ctMenu obj_menu = new ctMenu();
		
		try {
			
			app.as_getAcesso_carga(objctUsuario.getcUsuario(), objctUsuario.getcPassword(), tt_ctMenu, tt_ctPrograma, ps_Resultado, ps_Texto);
			
			ResultSet rs_tt_ctPrograma = tt_ctPrograma.getResultSetValue();
			ResultSet rs_tt_ctMenu = tt_ctMenu.getResultSetValue();
			System.out.println("Impresion sin metodo: "+ps_Texto);
			System.out.println(ps_Texto.getValue());
			
			while(rs_tt_ctPrograma.next()){
				obj_programa.setiPrograma(rs_tt_ctPrograma.getInt("iPrograma"));
				obj_programa.setiMenu(rs_tt_ctPrograma.getInt("iMenu"));
				obj_programa.setcPrograma(rs_tt_ctPrograma.getString("cPrograma"));
				obj_programa.setlActivo(rs_tt_ctPrograma.getBoolean("lActivo"));
				obj_programa.setcNombre(rs_tt_ctPrograma.getString("cNombre"));
				obj_programa.setId(rs_tt_ctPrograma.getBytes("id"));
			}
			
		}catch(Exception ex){
			
		} finally {
			app._release();
			DBConexion.closeConnection(conexion);
		}

		return null;
	}
}
