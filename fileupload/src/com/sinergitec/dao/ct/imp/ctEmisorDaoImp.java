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
import com.sinergitec.dao.ct.ctEmisorDao;
import com.sinergitec.model.ct.ctEmisor;
import com.sinergitec.mydigital.util.DBConexion;
import com.sinergitec.mydigital.util.VectorResultSet;
import com.sinergitec.progress.myDigital;

public class ctEmisorDaoImp implements ctEmisorDao {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void add_ctEmisor(String cUsuario, ctEmisor obj_ctEmisor) throws Open4GLException, IOException{
		
		
		List<ctEmisor> Lista = new ArrayList<ctEmisor>();

		Lista.add(obj_ctEmisor);

		
		Vector vecTabla1, vecRow1;
		vecTabla1 = new Vector();
		
		BooleanHolder ps_Resultado = new BooleanHolder();
		StringHolder ps_Texto = new StringHolder();

		Connection conexion = DBConexion.getConnection();
		myDigital app = new myDigital(conexion);
		
		for (ctEmisor obj : Lista) {
			vecRow1 = obj.getVectorDatos();
			vecTabla1.add(vecRow1);
		}
		
		ResultSetHolder ttEmisor = new ResultSetHolder(new VectorResultSet(vecTabla1));
		
		try {		
			
			app.as_ctEmisor_Inserta(cUsuario,ttEmisor, ps_Resultado, ps_Texto);
			
			System.out.println(ps_Texto.getStringValue());

			

		} catch (Exception ex) {
			System.out.println(ex);
			
			
		} finally {
			app._release();
			DBConexion.closeConnection(conexion);

		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void update_ctEmisor(String cUsuario, ctEmisor obj_ctEmisor) throws Open4GLException, IOException{
		
		List<ctEmisor> Lista = new ArrayList<ctEmisor>();
		Lista.add(obj_ctEmisor);

		BooleanHolder ps_Resultado = new BooleanHolder();
		StringHolder ps_Texto = new StringHolder();
		Connection conexion = DBConexion.getConnection();
		myDigital app = new myDigital(conexion);

		Vector vecTabla1, vecRow1;
		vecTabla1 = new Vector();

		for (ctEmisor obj : Lista) {
			vecRow1 = obj.getVectorDatos();
			vecTabla1.add(vecRow1);
		}

		ResultSet emisorModificados = new VectorResultSet(vecTabla1);

		try {
			app.as_ctEmisor_Actualiza(cUsuario , emisorModificados, ps_Resultado, ps_Texto);

		} finally {
			// TODO: handle finally clause
			app._release();
			DBConexion.closeConnection(conexion);
		}
	}
	
	public void remove_ctEmisor(String cUsuario, int iEmisor, String cCveCia) throws Open4GLException, IOException{
		
		BooleanHolder ps_Resultado = new BooleanHolder();
		StringHolder ps_Texto = new StringHolder();

		Connection conexion = DBConexion.getConnection();
		myDigital app = new myDigital(conexion);

		try {
			
			app.as_ctEmisor_Borra(cUsuario, iEmisor , ps_Resultado, ps_Texto);
					
			System.err.println(ps_Texto.getValue());
			
		} finally {
			app._release();
			DBConexion.closeConnection(conexion);
		}
	}
	
	public List<ctEmisor> list_ctEmisor() throws Open4GLException, IOException{
		
		ResultSetHolder tt_ctEmisor = new ResultSetHolder();
		
		BooleanHolder ps_Resultado = new BooleanHolder();
		StringHolder ps_Texto = new StringHolder();
		
		List<ctEmisor> Lista = new ArrayList<ctEmisor>();
		
		Connection conexion = DBConexion.getConnection();
		myDigital app = new myDigital(conexion);		
		return null;
	}
	
	public ctEmisor get_ctEmisor(String cUsuario, int iEmisor, String cCveCia) throws Open4GLException, IOException{
		
		BooleanHolder ps_Resultado = new BooleanHolder();
		StringHolder ps_Texto = new StringHolder();

		ResultSetHolder tt_ctEmisor = new ResultSetHolder();
		Connection conexion = DBConexion.getConnection();
		myDigital app = new myDigital(conexion);
		ctEmisor obj = new ctEmisor();
		
		try {
			
		
			app.as_ctEmisor_get(cUsuario, iEmisor , tt_ctEmisor, ps_Resultado, ps_Texto);
			
			ResultSet rs_tt_ctEmisor = tt_ctEmisor.getResultSetValue();
			

			while (rs_tt_ctEmisor.next()) {
											
				obj.setiEmisor(rs_tt_ctEmisor.getInt("iEmisor"));
				obj.setcCveCia(rs_tt_ctEmisor.getString("cCveCia"));
				obj.setcRazonSocial(rs_tt_ctEmisor.getString("cRazonSocial"));
				obj.setcRFC(rs_tt_ctEmisor.getString("cRFC"));
				obj.setcCURP(rs_tt_ctEmisor.getString("cCURP"));
				obj.setcCalle(rs_tt_ctEmisor.getString("cCalle"));
				obj.setcNumeroExterior(rs_tt_ctEmisor.getString("cNumeroExterior"));
				obj.setcNumeroInterior(rs_tt_ctEmisor.getString("cNumeroInterior"));
				obj.setcMpioDelg(rs_tt_ctEmisor.getString("cMpioDelg"));
				obj.setcEmail(rs_tt_ctEmisor.getString("cEmail"));
				obj.setcPais(rs_tt_ctEmisor.getString("cPais"));
				obj.setcEstado(rs_tt_ctEmisor.getString("cEstado"));
				obj.setcCP(rs_tt_ctEmisor.getString("cCP"));
				obj.setDtFechaAlta(rs_tt_ctEmisor.getTimestamp("dtFechaAlta"));
				obj.setDtFechaAlta(rs_tt_ctEmisor.getTimestamp("dtFechaCancela"));
				obj.setlActivo(rs_tt_ctEmisor.getBoolean("lActivo"));
				obj.setcAlias(rs_tt_ctEmisor.getString("cAlias"));
				obj.setId(rs_tt_ctEmisor.getBytes("id"));
				//obj.setcColonia(rs_tt_ctCompania.getString("cColonia"));
				//obj.setcCiudad(rs_tt_ctCompania.getString("cCiudad"));
				//obj.setcTelefono(rs_tt_ctCompania.getString("cTelefono"));
				//obj.setcContacto(rs_tt_ctCompania.getString("cContacto"));

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
