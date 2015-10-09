package com.sinergitec.model.ct;

import java.util.Vector;

public class ctMenu {
	
	private Integer iMenu;
	private String cMenu;
	private Boolean lActivo;
	byte[] id;
	
	
	public Integer getiMenu() {
		return iMenu;
	}
	public void setiMenu(Integer iMenu) {
		this.iMenu = iMenu;
	}
	public String getcMenu() {
		return cMenu;
	}
	public void setcMenu(String cMenu) {
		this.cMenu = cMenu;
	}
	public Boolean getlActivo() {
		return lActivo;
	}
	public void setlActivo(Boolean lActivo) {
		this.lActivo = lActivo;
	}
	public byte[] getId() {
		return id;
	}
	public void setId(byte[] id) {
		this.id = id;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getVectorDatos() {
		
		Vector vector = new Vector();

		vector.add(this.getiMenu());
		vector.add(this.getcMenu());
		vector.add(this.getlActivo());
		vector.add(this.getId());

		return vector;
	}
}
