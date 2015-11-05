package com.sinergitec.dao.sg.imp;

import java.io.IOException;

import com.progress.open4gl.BooleanHolder;
import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.StringHolder;
import com.progress.open4gl.javaproxy.Connection;
import com.sinergitec.appserver.myDigital;
import com.sinergitec.dao.sg.sgAccesoDao;
import com.sinergitec.model.ct.ctUsuario;
import com.sinergitec.mydigital.util.DBConexion;

public class sgAccesoDaoImp implements sgAccesoDao {

	public String acceso_sgAcceso(ctUsuario objctUsuario) throws Open4GLException, IOException{
		
		System.out.println(objctUsuario.getcUsuario());
		System.out.println(objctUsuario.getcPassword());
		
		
		/*conexion a la base */
		BooleanHolder ps_Resultado = new BooleanHolder();
		StringHolder ps_Texto = new StringHolder();

		Connection conexion = DBConexion.getConnection();
		myDigital app = new myDigital(conexion);

		/*Termina conexion a la base*/
		return null;
	}
}
