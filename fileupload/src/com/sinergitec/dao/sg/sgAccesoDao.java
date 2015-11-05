package com.sinergitec.dao.sg;

import java.io.IOException;

import com.progress.open4gl.Open4GLException;
import com.sinergitec.model.ct.ctUsuario;

public interface sgAccesoDao {
	
	public String acceso_sgAcceso(ctUsuario objctUsuario) throws Open4GLException, IOException;
}
