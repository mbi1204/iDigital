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
import com.sinergitec.dao.ct.ctMenuDao;
import com.sinergitec.model.ct.ctMenu;
import com.sinergitec.mydigital.util.DBConexion;
import com.sinergitec.mydigital.util.VectorResultSet;
import com.sinergitec.progress.myDigital;

public class ctMenuDaoImp implements ctMenuDao {

	public void add_ctMenu(String cUsuario, ctMenu obj_ctMenu) throws Open4GLException, IOException{
		
		List<ctMenu> Lista = new ArrayList<ctMenu>();

		Lista.add(obj_ctMenu);

		Vector vecTabla1, vecRow1;
		vecTabla1 = new Vector();

		BooleanHolder ps_Resultado = new BooleanHolder();
		StringHolder ps_Texto = new StringHolder();

		Connection conexion = DBConexion.getConnection();
		myDigital app = new myDigital(conexion);

		for (ctMenu obj : Lista) {
			vecRow1 = obj.getVectorDatos();
			vecTabla1.add(vecRow1);
		}

		ResultSetHolder ttMenu = new ResultSetHolder(new VectorResultSet(vecTabla1));

		try {

			app.as_ctMenu_Inserta(cUsuario, ttMenu, ps_Resultado, ps_Texto);

			System.out.println(ps_Texto.getStringValue());

		} catch (Exception ex) {
			System.out.println(ex);

		} finally {
			app._release();
			DBConexion.closeConnection(conexion);

		}
	}
	
	public void update_ctMenu(String cUsuario, ctMenu obj_ctMenu) throws Open4GLException, IOException{
		
		List<ctMenu> Lista = new ArrayList<ctMenu>();
		Lista.add(obj_ctMenu);

		BooleanHolder ps_Resultado = new BooleanHolder();
		StringHolder ps_Texto = new StringHolder();
		Connection conexion = DBConexion.getConnection();
		myDigital app = new myDigital(conexion);

		Vector vecTabla1, vecRow1;
		vecTabla1 = new Vector();

		for (ctMenu obj : Lista) {
			vecRow1 = obj.getVectorDatos();
			vecTabla1.add(vecRow1);
		}

		ResultSet menuModificados = new VectorResultSet(vecTabla1);

		try {
			app.as_ctMenu_Actualiza(cUsuario, menuModificados, ps_Resultado, ps_Texto);

		} finally {
			// TODO: handle finally clause
			app._release();
			DBConexion.closeConnection(conexion);
		}
	}
	
	public void remove_ctMenu(String cUsuario, int iMenu) throws Open4GLException, IOException{
		
		BooleanHolder ps_Resultado = new BooleanHolder();
		StringHolder ps_Texto = new StringHolder();

		Connection conexion = DBConexion.getConnection();
		myDigital app = new myDigital(conexion);

		try {

			app.as_ctMenu_Borra(cUsuario, iMenu, ps_Resultado, ps_Texto);

			System.err.println(ps_Texto.getValue());

		} finally {
			app._release();
			DBConexion.closeConnection(conexion);
		}
	}
	
	public List<ctMenu> list_ctMenu(boolean bTodos) throws Open4GLException, IOException{
		
		BooleanHolder ps_Resultado = new BooleanHolder();
		StringHolder ps_Texto = new StringHolder();

		List<ctMenu> Lista = new ArrayList<ctMenu>();

		ResultSetHolder tt_ctMenu = new ResultSetHolder();
		Connection conexion = DBConexion.getConnection();
		myDigital app = new myDigital(conexion);
	try {

			app.as_ctMenu_Carga(bTodos, tt_ctMenu, ps_Resultado, ps_Texto);
			ResultSet rs_tt_ctMenu = tt_ctMenu.getResultSetValue();

			/*while (rs_tt_ctCompania.next()) {

				ctCompania obj = new ctCompania();

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
				obj.setlActivo(rs_tt_ctCompania.getBoolean("lActivo"));				
				obj.setId(rs_tt_ctCompania.getBytes("id"));
				Lista.add(obj);

			}*/
		} catch (Exception ex) {
			System.err.println(ex);

		} finally {
			app._release();
			DBConexion.closeConnection(conexion);
		}
		
		System.out.println("salio del dao");

		return Lista;
	}
	
	public ctMenu get_ctMenu(String cUsuario, int iMenu) throws Open4GLException, IOException{
		
		BooleanHolder ps_Resultado = new BooleanHolder();
		StringHolder ps_Texto = new StringHolder();

		ResultSetHolder tt_ctMenu = new ResultSetHolder();
		Connection conexion = DBConexion.getConnection();
		myDigital app = new myDigital(conexion);
		ctMenu obj = new ctMenu();

		try {

			app.as_ctMenu_get(cUsuario, iMenu, tt_ctMenu, ps_Resultado, ps_Texto);

			ResultSet rs_tt_ctMenu = tt_ctMenu.getResultSetValue();

			while (rs_tt_ctMenu.next()) {

				obj.setiMenu(rs_tt_ctMenu.getInt("iMenu"));
				obj.setcMenu(rs_tt_ctMenu.getString("cMenu"));
				obj.setlActivo(rs_tt_ctMenu.getBoolean("lActivo"));
				obj.setId(rs_tt_ctMenu.getBytes("id"));

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
