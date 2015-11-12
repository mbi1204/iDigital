package com.sinergitec.dao.sg;

import java.io.IOException;

import com.progress.open4gl.Open4GLException;
import com.sinergitec.model.sg.sysUsuCompania;;

public interface sysUsuCompaniaDao {
	public void add_sysUsuCompaniaDao(String cUsuario, sysUsuCompania obj_sysUsuCompania) throws Open4GLException, IOException;
}
