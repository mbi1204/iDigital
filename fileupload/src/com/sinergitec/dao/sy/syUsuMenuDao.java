package com.sinergitec.dao.sy;

import java.io.IOException;
import java.util.List;

import com.progress.open4gl.Open4GLException;
import com.sinergitec.model.sg.sysUsuMenu;

public interface syUsuMenuDao {

	public void add_syUsuMenuDao(String cUsuario, sysUsuMenu obj_sysUsuCompania) throws Open4GLException, IOException;
	
	public void update_syUsuMenuDao(String cUsuario, sysUsuMenu obj_sysUsuCompania) throws Open4GLException, IOException;
	
	public void remove_syUsuMenuDao(String cUsuario, String cCveCia, String cUsuario2) throws Open4GLException, IOException;
	
	public List<sysUsuMenu> list_syUsuMenuDao(boolean bTodos) throws Open4GLException, IOException;
	
	public sysUsuMenu get_syUsuMenuDao(String cUsuario, String cCveCia, String cUsuario2) throws Open4GLException, IOException;
}
