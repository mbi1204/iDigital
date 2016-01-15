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
import com.sinergitec.dao.ct.ctPuestoDao;
import com.sinergitec.dao.ct.ctUsuarioDao;
import com.sinergitec.dao.ct.imp.ctPuestoDaoImp;
import com.sinergitec.dao.ct.imp.ctUsuarioDaoImp;
import com.sinergitec.dao.sy.syUsuCompaniaDao;
import com.sinergitec.model.ct.ctPuesto;
import com.sinergitec.model.ct.ctUsuario;
import com.sinergitec.model.sg.sysUsuCompania;
import com.sinergitec.mydigital.util.DBConexion;
import com.sinergitec.mydigital.util.VectorResultSet;

import mydigital.sinergitec.appserver.myDigital;

public class syUsuCompaniaDaoImp implements syUsuCompaniaDao {
	
	private ctUsuarioDao ctUsuarioDao;
	private ctPuestoDao DaoPuesto;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void add_sysUsuCompaniaDao(String cUsuario, sysUsuCompania obj_sysUsuCompania) throws Open4GLException, IOException{
		
		BooleanHolder ps_Resultado = new BooleanHolder();
		StringHolder ps_Texto = new StringHolder();
		
		List<sysUsuCompania> Lista = new ArrayList<sysUsuCompania>();
		Lista.add(obj_sysUsuCompania);
		
		Vector vecTabla1, vecRow1;
		vecTabla1 = new Vector();
		
		Connection conexion = DBConexion.getConnection();
		myDigital app = new myDigital(conexion);
		
		for (sysUsuCompania obj : Lista) {
			vecRow1 = obj.getVectorDatos();
			vecTabla1.add(vecRow1);
		}
		
		ResultSetHolder tt_sysUsuCompania = new ResultSetHolder(new VectorResultSet(vecTabla1));
		
		try {
			app.as_sysUsuCompania_Inserta(cUsuario, tt_sysUsuCompania, ps_Resultado, ps_Texto);
			System.out.println(ps_Texto.getStringValue());
		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println(ex);
		} finally{
			app._release();
			DBConexion.closeConnection(conexion);
		}
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void update_sysUsuCompaniaDao(String cUsuario, sysUsuCompania obj_sysUsuCompania) throws Open4GLException, IOException{
		
		BooleanHolder ps_Resultado = new BooleanHolder();
		StringHolder ps_Texto = new StringHolder();
		
		List<sysUsuCompania> Lista = new ArrayList<sysUsuCompania>();
		Lista.add(obj_sysUsuCompania);
		
		Vector vecTabla1, vecRow1;
		vecTabla1 = new Vector();
		
		Connection conexion = DBConexion.getConnection();
		myDigital app = new myDigital(conexion);
		
		for (sysUsuCompania obj : Lista) {
			vecRow1 = obj.getVectorDatos();
			vecTabla1.add(vecRow1);
		}
		
		ResultSet sysUsuCompaniaModificados = new VectorResultSet(vecTabla1);
		
		try {
			app.as_sysUsuCompania_Actualiza(cUsuario, sysUsuCompaniaModificados, ps_Resultado, ps_Texto);
			System.out.println(ps_Texto.getStringValue());
		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println(ex);
		} finally{
			app._release();
			DBConexion.closeConnection(conexion);
		}
		
	}
	
	public void remove_sysUsuCompaniaDao(String cUsuario, String cCveCia, String cUsuario2) throws Open4GLException, IOException{
		
		BooleanHolder ps_Resultado = new BooleanHolder();
		StringHolder ps_Texto = new StringHolder();

		Connection conexion = DBConexion.getConnection();
		myDigital app = new myDigital(conexion);
		
		try {
			
			app.as_sysUsuCompania_Borra(cUsuario, cCveCia, cUsuario2, ps_Resultado, ps_Texto);

			System.err.println(ps_Texto.getValue());

		} finally {
			app._release();
			DBConexion.closeConnection(conexion);
		}
	}
	
	public List<sysUsuCompania> list_sysUsuCompania(boolean bTodos) throws Open4GLException, IOException{
		
		ctUsuarioDao = new ctUsuarioDaoImp();
		
		BooleanHolder ps_Resultado = new BooleanHolder();
		StringHolder ps_Texto = new StringHolder();
		
		List<sysUsuCompania> Lista = new ArrayList<sysUsuCompania>();
		List<ctUsuario> ListaUsu = new ArrayList<ctUsuario>();
		ListaUsu = ctUsuarioDao.list_ctUsuario(true);
		
		ResultSetHolder tt_sysUsuCompania = new ResultSetHolder();
		Connection conexion = DBConexion.getConnection();
		
		myDigital app = new myDigital(conexion);
		
		try {
			app.as_sysUsuCompania_Carga(bTodos, tt_sysUsuCompania, ps_Resultado, ps_Texto);
			ResultSet rs_tt_sysUsuCompania = tt_sysUsuCompania.getResultSetValue();
			
			while(rs_tt_sysUsuCompania.next()){
				
				sysUsuCompania obj = new sysUsuCompania();
				
				obj.setcCveCia(rs_tt_sysUsuCompania.getString("cCveCia"));
				obj.setcUsuario(rs_tt_sysUsuCompania.getString("cUsuario"));
				obj.setlActivo(rs_tt_sysUsuCompania.getBoolean("lActivo"));
				obj.setId(rs_tt_sysUsuCompania.getBytes("id"));
				
				for(ctUsuario obj_Usuario : ListaUsu){
					if(obj_Usuario.getcUsuario().equals(obj.getcUsuario())){
						ctUsuario obj_nUsuario = new ctUsuario();
						obj_nUsuario.setcNombre(obj_Usuario.getcNombre());
						obj.setCtUsu(obj_nUsuario);
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

	public List<sysUsuCompania> list_sysUsuConCompania(String cCveCia, boolean bTodos) throws Open4GLException, IOException{
		
		System.out.println("Este es el valor en el dao: "+cCveCia);
		ctUsuarioDao = new ctUsuarioDaoImp();
		
		BooleanHolder ps_Resultado = new BooleanHolder();
		StringHolder ps_Texto = new StringHolder();
		
		List<sysUsuCompania> Lista = new ArrayList<sysUsuCompania>();
		List<ctUsuario> ListaUsu = new ArrayList<ctUsuario>();
		ListaUsu = ctUsuarioDao.list_ctUsuario(true);
		
		ResultSetHolder tt_sysUsuCompania = new ResultSetHolder();
		Connection conexion = DBConexion.getConnection();
		
		myDigital app = new myDigital(conexion);
		
		try {
			app.as_sysUsuConCompania_Carga(cCveCia,bTodos, tt_sysUsuCompania, ps_Resultado, ps_Texto);
			ResultSet rs_tt_sysUsuCompania = tt_sysUsuCompania.getResultSetValue();
			System.err.println("Este es un error: "+ps_Texto.getValue());
			
			while(rs_tt_sysUsuCompania.next()){
				
				sysUsuCompania obj = new sysUsuCompania();
				
				obj.setcCveCia(rs_tt_sysUsuCompania.getString("cCveCia"));
				obj.setcUsuario(rs_tt_sysUsuCompania.getString("cUsuario"));
				obj.setlActivo(rs_tt_sysUsuCompania.getBoolean("lActivo"));
				obj.setId(rs_tt_sysUsuCompania.getBytes("id"));
				
				for(ctUsuario obj_Usuario : ListaUsu){
					if(obj_Usuario.getcUsuario().equals(obj.getcUsuario())){
						ctUsuario obj_nUsuario = new ctUsuario();
						obj_nUsuario.setcNombre(obj_Usuario.getcNombre());
						obj.setCtUsu(obj_nUsuario);
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
	
	public List<ctUsuario> list_sysUsuSinCompania(String cCveCia, boolean bTodos) throws Open4GLException, IOException{
		DaoPuesto = new ctPuestoDaoImp();
		
		BooleanHolder ps_Resultado = new BooleanHolder();
		StringHolder ps_Texto = new StringHolder();
		
		List<ctUsuario> Lista = new ArrayList<ctUsuario>();
		List<ctPuesto> Lista_ctPuesto = new ArrayList<ctPuesto>();
		Lista_ctPuesto = DaoPuesto.list_ctPuesto(true);
		
		ResultSetHolder tt_sysUsuSinCompania = new ResultSetHolder();
		Connection conexion = DBConexion.getConnection();
		
		myDigital app = new myDigital(conexion);
		
		try {
			app.as_sysUsuSinCompania_Carga(cCveCia, bTodos, tt_sysUsuSinCompania, ps_Resultado, ps_Texto);
			ResultSet rs_tt_sysUsuSinCompania = tt_sysUsuSinCompania.getResultSetValue();
			
			while(rs_tt_sysUsuSinCompania.next()){
				
				ctUsuario obj = new ctUsuario();
				
				obj.setcUsuario(rs_tt_sysUsuSinCompania.getString("cUsuario"));
				obj.setcNombre(rs_tt_sysUsuSinCompania.getString("cNombre"));
				obj.setcPassword(rs_tt_sysUsuSinCompania.getString("cPassword"));
				obj.setlActivo(rs_tt_sysUsuSinCompania.getBoolean("lActivo"));
				obj.setDtFechaAlta(rs_tt_sysUsuSinCompania.getString("dtFechaAlta"));
				obj.setiPuesto(rs_tt_sysUsuSinCompania.getInt("iPuesto"));
				
				for (ctPuesto ctPuesto : Lista_ctPuesto) {
					if(obj.getiPuesto().equals(ctPuesto.getiPuesto())){
						
						ctPuesto obj_nctPuesto = new ctPuesto();
						obj_nctPuesto.setiPuesto(ctPuesto.getiPuesto());
						obj_nctPuesto.setcPuesto(ctPuesto.getcPuesto());
						obj.setPuesto(obj_nctPuesto);
						
					}
				}
				
				obj.setId(rs_tt_sysUsuSinCompania.getBytes("id"));
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
	
	public sysUsuCompania get_sysUsuCompania(String cUsuario, String cCveCia, String cUsuario2) throws Open4GLException, IOException{
		
		ctUsuarioDao = new ctUsuarioDaoImp();
		DaoPuesto = new ctPuestoDaoImp();
		
		BooleanHolder ps_Resultado = new BooleanHolder();
		StringHolder ps_Texto = new StringHolder();
		
		List<ctUsuario> ListaUsu = new ArrayList<ctUsuario>();
		ListaUsu = ctUsuarioDao.list_ctUsuario(true);
		List<ctPuesto> Lista_ctPuesto = new ArrayList<ctPuesto>();
		Lista_ctPuesto = DaoPuesto.list_ctPuesto(true);
		sysUsuCompania obj = new sysUsuCompania();
		
		ResultSetHolder tt_sysUsuCompania = new ResultSetHolder();
		Connection conexion = DBConexion.getConnection();
		
		myDigital app = new myDigital(conexion);
		
		try {
					
					app.as_sysUsuCompania_get(cUsuario, cCveCia, cUsuario2, tt_sysUsuCompania, ps_Resultado, ps_Texto);
					ResultSet rs_tt_sysUsuCompania = tt_sysUsuCompania.getResultSetValue();
					
					while(rs_tt_sysUsuCompania.next()){
						
						obj.setcCveCia(rs_tt_sysUsuCompania.getString("cCveCia"));
						obj.setcUsuario(rs_tt_sysUsuCompania.getString("cUsuario"));
						obj.setlActivo(rs_tt_sysUsuCompania.getBoolean("lActivo"));
						
						
						for(ctUsuario obj_Usuario : ListaUsu){
							if(obj_Usuario.getcUsuario().equals(obj.getcUsuario())){
								ctUsuario obj_nUsuario = new ctUsuario();
								obj_nUsuario.setcNombre(obj_Usuario.getcNombre());
								obj_nUsuario.setiPuesto(obj_Usuario.getiPuesto());
								for(ctPuesto obj_ctPuesto : Lista_ctPuesto){
									
									if(obj_ctPuesto.getiPuesto().equals(obj_nUsuario.getiPuesto())){
										
										ctPuesto obj_nctPuesto = new ctPuesto();
										
										obj_nctPuesto.setiPuesto(obj_ctPuesto.getiPuesto());
										obj_nctPuesto.setcPuesto(obj_ctPuesto.getcPuesto());
										obj_nUsuario.setPuesto(obj_nctPuesto);
										obj.setCtUsu(obj_nUsuario);
										}
									}
								}
							}
						}
		}
		catch (Exception e) {
			// TODO: handle exception
		} finally{
			app._release();
			DBConexion.closeConnection(conexion);
		}
		
		return obj;
		
	}
	
}
