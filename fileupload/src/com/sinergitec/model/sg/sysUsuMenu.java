package com.sinergitec.model.sg;

import java.util.Vector;

import com.sinergitec.model.ct.ctMenu;

public class sysUsuMenu {

	private String cUsuario;
	private Integer iMenu;
	private Boolean lActivo;
	private String cObs;
	byte[] Id;
	
	private ctMenu menu;
	
	public String getcUsuario() {
		return cUsuario;
	}
	public void setcUsuario(String cUsuario) {
		this.cUsuario = cUsuario;
	}
	public Integer getiMenu() {
		return iMenu;
	}
	public void setiMenu(Integer iMenu) {
		this.iMenu = iMenu;
	}
	public Boolean getlActivo() {
		return lActivo;
	}
	public void setlActivo(Boolean lActivo) {
		this.lActivo = lActivo;
	}
	public String getcObs() {
		return cObs;
	}
	public void setcObs(String cObs) {
		this.cObs = cObs;
	}
	public byte[] getId() {
		return Id;
	}
	public void setId(byte[] id) {
		Id = id;
	}
	public ctMenu getMenu() {
		return menu;
	}
	public void setMenu(ctMenu menu) {
		this.menu = menu;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getVectorDatos() {
		
		Vector vector = new Vector();
		
		vector.add(this.getcUsuario());
		vector.add(this.getiMenu());
		vector.add(this.getlActivo());
		vector.add(this.getcObs());
		vector.add(this.getId());	

		return vector;
	}
	
}
