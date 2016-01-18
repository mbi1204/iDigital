package com.sinergitec.model.sg;

public class sysUsuPrograma {

	private String cUsuario;
	private Integer iMenu;
	private Integer iPrograma;
	private Boolean lActivo;
	private String cObs;
	
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
	public Integer getiPrograma() {
		return iPrograma;
	}
	public void setiPrograma(Integer iPrograma) {
		this.iPrograma = iPrograma;
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
	
}
