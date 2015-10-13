package com.sinergitec.dao.ct;

import java.io.IOException;
import java.util.List;
import com.progress.open4gl.Open4GLException;
import com.sinergitec.model.ct.ctPuesto;

public interface ctPuestoDao {
	
	public void add_ctPuesto(String cUsuario, ctPuesto obj_ctPuesto) throws Open4GLException, IOException;
	
	public void update_ctPuesto(String cUsuario, ctPuesto obj_ctPuesto) throws Open4GLException, IOException;
	
	public void remove_ctPuesto(String cUsuario, int iPuesto) throws Open4GLException, IOException;
	
	public List<ctPuesto> list_ctPuesto(boolean bTodos) throws Open4GLException, IOException;
	
	public ctPuesto get_ctPuesto(String cUsuario, int iPuesto) throws Open4GLException, IOException;

}
