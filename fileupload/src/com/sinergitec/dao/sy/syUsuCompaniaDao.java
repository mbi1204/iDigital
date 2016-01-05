package com.sinergitec.dao.sy;

import java.io.IOException;
import java.util.List;

import com.progress.open4gl.Open4GLException;
import com.sinergitec.model.sg.sysUsuCompania;

public interface syUsuCompaniaDao {

	public void add_sysUsuCompaniaDao(String cUsuario, sysUsuCompania obj_sysUsuCompania) throws Open4GLException, IOException;
	
	public void update_sysUsuCompaniaDao(String cUsuario, sysUsuCompania obj_sysUsuCompania);
	
	public void remove_sysUsuCompaniaDao(String cUsuario, sysUsuCompania obj_sysUsuCompania);
	
	public List<sysUsuCompania> list_sysUsuCompania(boolean bTodos) throws Open4GLException, IOException;
}
