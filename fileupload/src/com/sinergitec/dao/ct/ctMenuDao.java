package com.sinergitec.dao.ct;

import java.io.IOException;
import java.util.List;

import com.progress.open4gl.Open4GLException;
import com.sinergitec.model.ct.ctMenu;


public interface ctMenuDao {
	
public void add_ctMenu(ctMenu obj_ctMenu) throws Open4GLException, IOException;
	
	public void update_ctMenu(ctMenu obj_ctMenu) throws Open4GLException, IOException;
	
	public void remove_ctMenu(int iMenu) throws Open4GLException, IOException;
	
	public List<ctMenu> list_ctMenu() throws Open4GLException, IOException;
	
	public ctMenu get_ctMenu(int iMenu) throws Open4GLException, IOException;

}

