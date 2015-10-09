package com.sinergitec.dao.ct;

import java.io.IOException;
import java.util.List;
import com.progress.open4gl.Open4GLException;
import com.sinergitec.model.ct.ctPrograma;

public interface ctProgramaDao {
	
public void add_ctPrograma(ctPrograma obj_ctPrograma) throws Open4GLException, IOException;
	
	public void update_ctPrograma(ctPrograma obj_ctPrograma) throws Open4GLException, IOException;
	
	public void remove_ctPrograma(int iPrograma, int iMenu) throws Open4GLException, IOException;
	
	public List<ctPrograma> list_ctPrograma() throws Open4GLException, IOException;
	
	public ctPrograma get_ctPrograma(int iPrograma , int iMenu) throws Open4GLException, IOException;


}
