package com.sinergitec.dao.ct;

import java.io.IOException;
import java.util.List;
import com.progress.open4gl.Open4GLException;
import com.sinergitec.model.ct.ctPrograma;

public interface ctProgramaDao {
	
public void add_ctPrograma(String cUsuario , ctPrograma obj_ctPrograma) throws Open4GLException, IOException;
	
	public void update_ctPrograma(String cUsuario ,ctPrograma obj_ctPrograma) throws Open4GLException, IOException;
	
	public void remove_ctPrograma(String cUsuario,  int iMenu, int iPrograma) throws Open4GLException, IOException;
	
	public List<ctPrograma> list_ctPrograma() throws Open4GLException, IOException;
	
	public ctPrograma get_ctPrograma(String cUsuario, int iMenu, int iPrograma) throws Open4GLException, IOException;


}
