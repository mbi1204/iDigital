package com.sinergitec.dao.ct.imp;

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
import com.sinergitec.appserver.myDigital;
import com.sinergitec.dao.ct.ctProgramaDao;
import com.sinergitec.model.ct.ctPrograma;
import com.sinergitec.mydigital.util.DBConexion;
import com.sinergitec.mydigital.util.VectorResultSet;

public class ctProgramaDaoImp implements ctProgramaDao{
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void add_ctPrograma(String cUsuario, ctPrograma obj_ctPrograma) throws Open4GLException, IOException{
		
		
		List<ctPrograma> Lista = new ArrayList<ctPrograma>();

		Lista.add(obj_ctPrograma);

		
		Vector vecTabla1, vecRow1;
		vecTabla1 = new Vector();
		
		BooleanHolder ps_Resultado = new BooleanHolder();
		StringHolder ps_Texto = new StringHolder();

		Connection conexion = DBConexion.getConnection();
		myDigital app = new myDigital(conexion);
		
		for (ctPrograma obj : Lista) {
			vecRow1 = obj.getVectorDatos();
			vecTabla1.add(vecRow1);
		}
		
		ResultSetHolder ttPrograma = new ResultSetHolder(new VectorResultSet(vecTabla1));
		
		try {		
			
		 	app.as_ctPrograma_Inserta(cUsuario, ttPrograma , ps_Resultado, ps_Texto);
			
			System.out.println(ps_Texto.getStringValue());

			

		} catch (Exception ex) {
			System.out.println(ex);
			
			
		} finally {
			app._release();
			DBConexion.closeConnection(conexion);

		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void update_ctPrograma(String cUsuario, ctPrograma obj_ctPrograma) throws Open4GLException, IOException{
		
		List<ctPrograma> Lista = new ArrayList<ctPrograma>();
		Lista.add(obj_ctPrograma);

		BooleanHolder ps_Resultado = new BooleanHolder();
		StringHolder ps_Texto = new StringHolder();
		Connection conexion = DBConexion.getConnection();
		myDigital app = new myDigital(conexion);

		Vector vecTabla1, vecRow1;
		vecTabla1 = new Vector();

		for (ctPrograma obj : Lista) {
			vecRow1 = obj.getVectorDatos();
			vecTabla1.add(vecRow1);
		}

		ResultSet ProgramModificados = new VectorResultSet(vecTabla1);

		try {

			app.as_ctPrograma_Actualiza(cUsuario, ProgramModificados, ps_Resultado, ps_Texto);

		} finally {
			// TODO: handle finally clause
			app._release();
			DBConexion.closeConnection(conexion);
		}
	}
	
	public void remove_ctPrograma(String cUsuario, int iMenu, int iPrograma) throws Open4GLException, IOException{
		
		BooleanHolder ps_Resultado = new BooleanHolder();
		StringHolder ps_Texto = new StringHolder();

		Connection conexion = DBConexion.getConnection();
		myDigital app = new myDigital(conexion);

		try {
			
			app.as_ctPrograma_Borra(cUsuario, iMenu, iPrograma, ps_Resultado, ps_Texto);
					
			System.err.println(ps_Texto.getValue());
			
		} finally {
			app._release();
			DBConexion.closeConnection(conexion);
		}
	}
	
	public List<ctPrograma> list_ctPrograma() throws Open4GLException, IOException{
		
				
		StringHolder opcError = new StringHolder();
		BooleanHolder oplError = new BooleanHolder();
		List<ctPrograma> Lista = new ArrayList<ctPrograma>();
		ResultSetHolder tt_ctPrograma = new ResultSetHolder();
		
		Connection conexion = DBConexion.getConnection();
		myDigital app = new myDigital(conexion);
		
		try {
			
			app.as_ctPrograma_Carga(true, tt_ctPrograma, oplError, opcError);

			ResultSet rs_tt_ctPrograma = tt_ctPrograma.getResultSetValue();
			
			while (rs_tt_ctPrograma.next()) {
				
				ctPrograma obj = new ctPrograma();				
			
				
				obj.setiPrograma(rs_tt_ctPrograma.getInt("iPrograma"));
				obj.setiMenu(rs_tt_ctPrograma.getInt("iMenu"));
				obj.setcPrograma(rs_tt_ctPrograma.getString("cPrograma"));
				obj.setlActivo(rs_tt_ctPrograma.getBoolean("lActivo"));
				obj.setcNombre(rs_tt_ctPrograma.getString("cNombre"));
				obj.setId(rs_tt_ctPrograma.getBytes("id"));				
				

				Lista.add(obj);
			}
			
		} catch (Exception ex) {
			System.out.println(ex);
			
			Lista = null;
		} finally {
			app._release();
			DBConexion.closeConnection(conexion);
		}
		
		return Lista;
	}
	
	public ctPrograma get_ctPrograma(String cUsuario, int iMenu, int iPrograma) throws Open4GLException, IOException{
		
		BooleanHolder ps_Resultado = new BooleanHolder();
		StringHolder ps_Texto = new StringHolder();

		ResultSetHolder tt_ctPrograma = new ResultSetHolder();
		Connection conexion = DBConexion.getConnection();
		myDigital app = new myDigital(conexion);
		ctPrograma obj = new ctPrograma();
		
		try {
			
			app.as_ctPrograma_get(cUsuario, iMenu, iPrograma, tt_ctPrograma, ps_Resultado, ps_Texto);
			
			ResultSet rs_tt_ctPrograma = tt_ctPrograma.getResultSetValue();
			

			while (rs_tt_ctPrograma.next()) {
											
				obj.setiPrograma(rs_tt_ctPrograma.getInt("iPrograma"));
				obj.setiMenu(rs_tt_ctPrograma.getInt("iMenu"));
				obj.setcPrograma(rs_tt_ctPrograma.getString("cPrograma"));
				obj.setlActivo(rs_tt_ctPrograma.getBoolean("lActivo"));
				obj.setcNombre(rs_tt_ctPrograma.getString("cNombre"));
				obj.setId(rs_tt_ctPrograma.getBytes("id"));


			}
			
		} catch (Exception ex) {
			System.err.println(ex);

			
		} finally {
			app._release();
			DBConexion.closeConnection(conexion);
		}
		return obj;
		
	}

}
