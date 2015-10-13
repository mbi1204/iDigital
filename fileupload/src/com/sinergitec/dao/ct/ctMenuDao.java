package com.sinergitec.dao.ct;

import java.io.IOException;
import java.util.List;

import com.progress.open4gl.Open4GLException;
import com.sinergitec.model.ct.ctMenu;


public interface ctMenuDao {
	
	public void add_ctMenu(String cUsuario, ctMenu obj_ctMenu) throws Open4GLException, IOException;
	
	public void update_ctMenu(String cUsuario, ctMenu obj_ctMenu) throws Open4GLException, IOException;
	
	public void remove_ctMenu(String cUsuario, int iMenu) throws Open4GLException, IOException;
	
	public List<ctMenu> list_ctMenu(boolean bTodos) throws Open4GLException, IOException;
	
	public ctMenu get_ctMenu(String cUsuario ,int iMenu) throws Open4GLException, IOException;

}

