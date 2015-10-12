package com.sinergitec.dao.ct.imp;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.sinergitec.progress.*;
import com.progress.open4gl.BooleanHolder;
import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.ResultSetHolder;
import com.progress.open4gl.StringHolder;
import com.progress.open4gl.javaproxy.Connection;
import com.sinergitec.dao.ct.ctCompaniaDao;
import com.sinergitec.model.ct.ctCompania;
import com.sinergitec.mydigital.util.DBConexion;
import com.sinergitec.mydigital.util.VectorResultSet;

public class ctCompaniaDaoImp implements ctCompaniaDao {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void add_ctCompania(String cUsuario, ctCompania obj_ctCompania) throws Open4GLException, IOException {
		// TODO Auto-generated method stub

		List<ctCompania> Lista = new ArrayList<ctCompania>();

		Lista.add(obj_ctCompania);

		Vector vecTabla1, vecRow1;
		vecTabla1 = new Vector();

		BooleanHolder ps_Resultado = new BooleanHolder();
		StringHolder ps_Texto = new StringHolder();

		Connection conexion = DBConexion.getConnection();
		myDigital app = new myDigital(conexion);

		for (ctCompania obj : Lista) {
			vecRow1 = obj.getVectorDatos();
			vecTabla1.add(vecRow1);
		}

		ResultSetHolder ttCompania = new ResultSetHolder(new VectorResultSet(vecTabla1));

		try {

			app.as_ctCompañia_Inserta(cUsuario, ttCompania, ps_Resultado, ps_Texto);

			System.out.println(ps_Texto.getStringValue());

		} catch (Exception ex) {
			System.out.println(ex);

		} finally {
			app._release();
			DBConexion.closeConnection(conexion);

		}

	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void update_ctCompania(String cUsuario, ctCompania obj_ctCompania) throws Open4GLException, IOException {
		// TODO Auto-generated method stub

		List<ctCompania> Lista = new ArrayList<ctCompania>();
		Lista.add(obj_ctCompania);

		BooleanHolder ps_Resultado = new BooleanHolder();
		StringHolder ps_Texto = new StringHolder();
		Connection conexion = DBConexion.getConnection();
		myDigital app = new myDigital(conexion);

		Vector vecTabla1, vecRow1;
		vecTabla1 = new Vector();

		for (ctCompania obj : Lista) {
			vecRow1 = obj.getVectorDatos();
			vecTabla1.add(vecRow1);
		}

		ResultSet companiaModificados = new VectorResultSet(vecTabla1);

		try {
			app.as_ctCompañia_Actualiza(cUsuario, companiaModificados, ps_Resultado, ps_Texto);

		} finally {
			// TODO: handle finally clause
			app._release();
			DBConexion.closeConnection(conexion);
		}
	}

	@Override
	public void remove_ctCompania(String cUsuario, String cCveCia) throws Open4GLException, IOException {
		// TODO Auto-generated method stub

		BooleanHolder ps_Resultado = new BooleanHolder();
		StringHolder ps_Texto = new StringHolder();

		Connection conexion = DBConexion.getConnection();
		myDigital app = new myDigital(conexion);

		try {

			app.as_ctCompañia_Borra(cUsuario, cCveCia, ps_Resultado, ps_Texto);

			System.err.println(ps_Texto.getValue());

		} finally {
			app._release();
			DBConexion.closeConnection(conexion);
		}
	}

	@Override
	public List<ctCompania> list_ctCompania() throws Open4GLException, IOException {
		// TODO Auto-generated method stub
		
		

		return null;
	}

	@Override
	public ctCompania get_ctCompania(String cUsuario, String cCveCia) throws Open4GLException, IOException {
		// TODO Auto-generated method stub
		
		
		BooleanHolder ps_Resultado = new BooleanHolder();
		StringHolder ps_Texto = new StringHolder();

		ResultSetHolder tt_ctCompania = new ResultSetHolder();
		Connection conexion = DBConexion.getConnection();
		myDigital app = new myDigital(conexion);
		ctCompania obj = new ctCompania();
		
		try {
			
		
			app.as_ctCompañia_get(cUsuario, cCveCia , tt_ctCompania, ps_Resultado, ps_Texto);
		
			
			ResultSet rs_tt_ctCompania = tt_ctCompania.getResultSetValue();
			

			while (rs_tt_ctCompania.next()) {
											
				obj.setcCveCia(rs_tt_ctCompania.getString("cCveCia"));
				obj.setcRazonS(rs_tt_ctCompania.getString("cRazonS"));
				obj.setcRFC(rs_tt_ctCompania.getString("cRFC"));
				obj.setcCalle(rs_tt_ctCompania.getString("cCalle"));
				obj.setcNExterior(rs_tt_ctCompania.getString("cNExterior"));
				obj.setcNInterior(rs_tt_ctCompania.getString("cNInterior"));
				obj.setcColonia(rs_tt_ctCompania.getString("cColonia"));
				obj.setcMpioDeleg(rs_tt_ctCompania.getString("cMpioDeleg"));
				obj.setiCP(rs_tt_ctCompania.getInt("iCP"));
				obj.setcCiudad(rs_tt_ctCompania.getString("cCiudad"));
				obj.setcEstado(rs_tt_ctCompania.getString("cEstado"));
				obj.setcTelefono(rs_tt_ctCompania.getString("cTelefono"));
				obj.setcEmail(rs_tt_ctCompania.getString("cEmail"));
				obj.setcContacto(rs_tt_ctCompania.getString("cContacto"));
				obj.setcPais(rs_tt_ctCompania.getString("cPais"));
				obj.setlActivo(rs_tt_ctCompania.getBoolean("lActivo"));;
				obj.setId(rs_tt_ctCompania.getBytes("id"));	

			}
			
		} catch (Exception ex) {
			System.err.println(ex);

			
		} finally {
			app._release();
			DBConexion.closeConnection(conexion);
		}
		
		return null;
	}

}
