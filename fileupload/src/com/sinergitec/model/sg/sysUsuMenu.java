package com.sinergitec.model.sg;

public class sysUsuMenu {

	private String cUsuario;
	private Integer iMenu;
	private Boolean lActivo;
	private String cObs;
	byte[] Id;
	
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
	
}
