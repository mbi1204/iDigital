package com.sinergitec.mydigital.util;

import java.io.IOException;

import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.javaproxy.Connection;

public class DBConexion {
	
	 static String cURL = "AppServer://192.168.2.30:5162/asdigital";
	 
	 static Connection conexion;
	
	public static Connection getConnection() throws Open4GLException, IOException {
		conexion = new Connection(cURL,"", "",null);
		return conexion;
			
	}
	
	public static void closeConnection(Connection conexion) throws Open4GLException, IOException {
		conexion.finalize();
		conexion.releaseConnection();
		
	}	
	
}
