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
import com.sinergitec.model.ct.ctPuesto;
import com.sinergitec.mydigital.util.DBConexion;
import com.sinergitec.mydigital.util.VectorResultSet;



public class ctPuestoDaoImp {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void add_ctPuesto(String cUsuario, ctPuesto obj_ctPuesto) throws Open4GLException, IOException{
		
		List<ctPuesto> Lista = new ArrayList<ctPuesto>();

		Lista.add(obj_ctPuesto);

		Vector vecTabla1, vecRow1;
		vecTabla1 = new Vector();

		BooleanHolder ps_Resultado = new BooleanHolder();
		StringHolder ps_Texto = new StringHolder();

		Connection conexion = DBConexion.getConnection();
		myDigital app = new myDigital(conexion);

		for (ctPuesto obj : Lista) {
			vecRow1 = obj.getVectorDatos();
			vecTabla1.add(vecRow1);
		}

		ResultSetHolder ttPuesto = new ResultSetHolder(new VectorResultSet(vecTabla1));

		try {

			app.as_ctPuesto_Inserta(cUsuario, ttPuesto, ps_Resultado, ps_Texto);

			System.out.println(ps_Texto.getStringValue());

		} catch (Exception ex) {
			System.out.println(ex);

		} finally {
			app._release();
			DBConexion.closeConnection(conexion);

		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void update_ctPuesto(String cUsuario, ctPuesto obj_ctPuesto) throws Open4GLException, IOException{
		
		List<ctPuesto> Lista = new ArrayList<ctPuesto>();
		Lista.add(obj_ctPuesto);

		BooleanHolder ps_Resultado = new BooleanHolder();
		StringHolder ps_Texto = new StringHolder();
		Connection conexion = DBConexion.getConnection();
		myDigital app = new myDigital(conexion);

		Vector vecTabla1, vecRow1;
		vecTabla1 = new Vector();

		for (ctPuesto obj : Lista) {
			vecRow1 = obj.getVectorDatos();
			vecTabla1.add(vecRow1);
		}

		ResultSet puestoModificados = new VectorResultSet(vecTabla1);

		try {
			app.as_ctPuesto_Actualiza(cUsuario, puestoModificados, ps_Resultado, ps_Texto);

		} finally {
			app._release();
			DBConexion.closeConnection(conexion);
		}
	}
	
	public void remove_ctPuesto(String cUsuario, int iPuesto) throws Open4GLException, IOException{
		
		BooleanHolder ps_Resultado = new BooleanHolder();
		StringHolder ps_Texto = new StringHolder();

		Connection conexion = DBConexion.getConnection();
		myDigital app = new myDigital(conexion);

		try {

			app.as_ctPuesto_Borra(cUsuario, iPuesto, ps_Resultado, ps_Texto);

			System.err.println(ps_Texto.getValue());

		} finally {
			app._release();
			DBConexion.closeConnection(conexion);
		}
	}
	
	public List<ctPuesto> list_ctPuesto(boolean bTodos) throws Open4GLException, IOException{
		
		BooleanHolder ps_Resultado = new BooleanHolder();
		StringHolder ps_Texto = new StringHolder();

		List<ctPuesto> Lista = new ArrayList<ctPuesto>();

		ResultSetHolder tt_ctPuesto = new ResultSetHolder();
		Connection conexion = DBConexion.getConnection();
		myDigital app = new myDigital(conexion);
	try {

			app.as_ctPuesto_Carga(bTodos, tt_ctPuesto, ps_Resultado, ps_Texto);
			ResultSet rs_tt_ctPuesto = tt_ctPuesto.getResultSetValue();

			while (rs_tt_ctPuesto.next()) {

				ctPuesto obj = new ctPuesto();

				obj.setiPuesto(rs_tt_ctPuesto.getInt("iPuesto"));
				obj.setcPuesto(rs_tt_ctPuesto.getString("cPuesto"));
				obj.setlActivo(rs_tt_ctPuesto.getBoolean("lActivo"));				
				obj.setId(rs_tt_ctPuesto.getBytes("id"));
				Lista.add(obj);

			}
		} catch (Exception ex) {
			System.err.println(ex);

		} finally {
			app._release();
			DBConexion.closeConnection(conexion);
		}
		
		System.out.println("salio del dao");

		return Lista;
	}
	
	public ctPuesto get_ctPuesto(String cUsuario, int iPuesto) throws Open4GLException, IOException{
		
		BooleanHolder ps_Resultado = new BooleanHolder();
		StringHolder ps_Texto = new StringHolder();

		ResultSetHolder tt_ctPuesto = new ResultSetHolder();
		Connection conexion = DBConexion.getConnection();
		myDigital app = new myDigital(conexion);
		ctPuesto obj = new ctPuesto();

		try {

			app.as_ctPuesto_get(cUsuario, iPuesto, tt_ctPuesto, ps_Resultado, ps_Texto);

			ResultSet rs_tt_ctPuesto = tt_ctPuesto.getResultSetValue();

			while (rs_tt_ctPuesto.next()) {

				obj.setiPuesto(rs_tt_ctPuesto.getInt("iPuesto"));
				obj.setcPuesto(rs_tt_ctPuesto.getString("cPuesto"));
				obj.setlActivo(rs_tt_ctPuesto.getBoolean("lActivo"));
				obj.setId(rs_tt_ctPuesto.getBytes("id"));

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
