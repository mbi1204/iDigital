package com.sinergitec.dao.ct;

import java.io.IOException;
import java.util.List;

import com.progress.open4gl.Open4GLException;
import com.sinergitec.model.ct.ctEmisor;

public interface ctEmisorDao {
	
public void add_ctEmisor(ctEmisor obj_ctEmisor) throws Open4GLException, IOException;
	
	public void update_ctEmisor(ctEmisor obj_ctEmisor) throws Open4GLException, IOException;
	
	public void remove_ctEmisor(int iEmisor, String cCveCia) throws Open4GLException, IOException;
	
	public List<ctEmisor> list_ctEmisor() throws Open4GLException, IOException;
	
	public ctEmisor get_ctEmisor(int iEmisor, String cCveCia) throws Open4GLException, IOException;

}
