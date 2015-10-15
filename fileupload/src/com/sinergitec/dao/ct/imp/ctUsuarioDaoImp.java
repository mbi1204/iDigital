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
import com.sinergitec.dao.ct.ctUsuarioDao;
import com.sinergitec.model.ct.ctUsuario;
import com.sinergitec.mydigital.util.DBConexion;
import com.sinergitec.mydigital.util.VectorResultSet;

public class ctUsuarioDaoImp implements ctUsuarioDao{
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void add_ctUsuario(String cUsuario, ctUsuario obj_ctUsuario) throws Open4GLException, IOException{
		
		
		List<ctUsuario> Lista = new ArrayList<ctUsuario>();

		Lista.add(obj_ctUsuario);

		
		Vector vecTabla1, vecRow1;
		vecTabla1 = new Vector();
		
		BooleanHolder ps_Resultado = new BooleanHolder();
		StringHolder ps_Texto = new StringHolder();

		Connection conexion = DBConexion.getConnection();
		myDigital app = new myDigital(conexion);
		
		for (ctUsuario obj : Lista) {
			vecRow1 = obj.getVectorDatos();
			vecTabla1.add(vecRow1);
		}
		
		ResultSetHolder ttUsuario = new ResultSetHolder(new VectorResultSet(vecTabla1));
		
		try {		
			
		 	app.as_ctUsuario_Inserta(cUsuario, ttUsuario, ps_Resultado, ps_Texto);
			
			System.out.println(ps_Texto.getStringValue());

			

		} catch (Exception ex) {
			System.out.println(ex);
			
			
		} finally {
			app._release();
			DBConexion.closeConnection(conexion);

		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void update_ctUsuario(String cUsuario, ctUsuario obj_ctUsuario) throws Open4GLException, IOException{
		
		List<ctUsuario> Lista = new ArrayList<ctUsuario>();
		Lista.add(obj_ctUsuario);

		BooleanHolder ps_Resultado = new BooleanHolder();
		StringHolder ps_Texto = new StringHolder();
		Connection conexion = DBConexion.getConnection();
		myDigital app = new myDigital(conexion);

		Vector vecTabla1, vecRow1;
		vecTabla1 = new Vector();

		for (ctUsuario obj : Lista) {
			vecRow1 = obj.getVectorDatos();
			vecTabla1.add(vecRow1);
		}

		ResultSet UsuarioModificado = new VectorResultSet(vecTabla1);

		try {

			app.as_ctUsuario_Actualiza(cUsuario, UsuarioModificado, ps_Resultado, ps_Texto);

		} finally {
			// TODO: handle finally clause
			app._release();
			DBConexion.closeConnection(conexion);
		}
	}
	
	public void remove_ctUsuario(String cUsuario) throws Open4GLException, IOException{
		
		BooleanHolder ps_Resultado = new BooleanHolder();
		StringHolder ps_Texto = new StringHolder();

		Connection conexion = DBConexion.getConnection();
		myDigital app = new myDigital(conexion);

		try {
			
			
			//app.as_ctUsuario_Borra(pe_CveUsuario, ipcUsuario, ps_Resultado, ps_Texto);
					
			System.err.println(ps_Texto.getValue());
			
		} finally {
			app._release();
			DBConexion.closeConnection(conexion);
		}
	}
	
	public List<ctUsuario> list_ctUsuario() throws Open4GLException, IOException{
		
		ResultSetHolder tt_ctUsuario = new ResultSetHolder();
		
		StringHolder opcError = new StringHolder();
		BooleanHolder oplError = new BooleanHolder();
				
		List<ctUsuario> Lista = new ArrayList<ctUsuario>();
		
		Connection conexion = DBConexion.getConnection();
		myDigital app = new myDigital(conexion);
		
		try {
			
			app.as_ctUsuario_Carga(true, tt_ctUsuario, oplError, opcError);
			
			ResultSet rs_tt_ctUsuario = tt_ctUsuario.getResultSetValue();
			
			while (rs_tt_ctUsuario.next()) {
				
				ctUsuario obj = new ctUsuario();				
			
				
				obj.setcUsuario(rs_tt_ctUsuario.getString("cUsuario"));
				obj.setcNombre(rs_tt_ctUsuario.getString("cNombre"));
				obj.setcPassword(rs_tt_ctUsuario.getString("cPassword"));
				obj.setlActivo(rs_tt_ctUsuario.getBoolean("lActivo"));
				obj.setDtFechaAlta(rs_tt_ctUsuario.getTimestamp("dtFechaAlta"));
				obj.setiPuesto(rs_tt_ctUsuario.getInt("iPuesto"));
				obj.setId(rs_tt_ctUsuario.getBytes("id"));				
				
		
			
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
	
	public ctUsuario get_ctUsuario(String CveUsuario, String cUsuario) throws Open4GLException, IOException{
		
		BooleanHolder ps_Resultado = new BooleanHolder();
		StringHolder ps_Texto = new StringHolder();

		ResultSetHolder tt_ctUsuario = new ResultSetHolder();
		Connection conexion = DBConexion.getConnection();
		myDigital app = new myDigital(conexion);
		ctUsuario obj = new ctUsuario();
		
		try {
			
			app.as_ctUsuario_get(CveUsuario, cUsuario, tt_ctUsuario, ps_Resultado, ps_Texto);
			
			ResultSet rs_tt_ctUsuario = tt_ctUsuario.getResultSetValue();
			

			while (rs_tt_ctUsuario.next()) {
											
				obj.setcUsuario(rs_tt_ctUsuario.getString("cUsuario"));
				obj.setcNombre(rs_tt_ctUsuario.getString("cNombre"));
				obj.setcPassword(rs_tt_ctUsuario.getString("cPassword"));
				obj.setlActivo(rs_tt_ctUsuario.getBoolean("lActivo"));
				obj.setDtFechaAlta(rs_tt_ctUsuario.getTimestamp("dtFechaAlta"));
				obj.setiPuesto(rs_tt_ctUsuario.getInt("iPuesto"));
				obj.setId(rs_tt_ctUsuario.getBytes("id"));


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
