package com.sinergitec.dao.ct;

import java.io.IOException;
import java.util.List;

import com.progress.open4gl.Open4GLException;
import com.sinergitec.model.ct.ctCompania;

public interface ctCompaniaDao {

	public void add_ctCompania(String cUsuario ,ctCompania obj_ctCompania) throws Open4GLException, IOException;
	
	public void update_ctCompania(String cUsuario ,ctCompania obj_ctCompania) throws Open4GLException, IOException;
	
	public void remove_ctCompania(String cUsuario  ,String cCveCia) throws Open4GLException, IOException;
	
	public List<ctCompania> list_ctCompania() throws Open4GLException, IOException;
	
	public ctCompania get_ctCompania(String cUsuario,String cCveCia) throws Open4GLException, IOException;
}
