package com.sinergitec.model.ct;


import java.util.Vector;

public class ctPrograma {
	
	private Integer iPrograma;
	private Integer iMenu;
	private String cPrograma;
	private Boolean lActivo;
	private String cNombre;
	byte[] id;
	private ctMenu menu;
	
	
	public Integer getiPrograma() {
		return iPrograma;
	}
	public void setiPrograma(Integer iPrograma) {
		this.iPrograma = iPrograma;
	}
	public Integer getiMenu() {
		return iMenu;
	}
	public void setiMenu(Integer iMenu) {
		this.iMenu = iMenu;
	}
	public String getcPrograma() {
		return cPrograma;
	}
	public void setcPrograma(String cPrograma) {
		this.cPrograma = cPrograma;
	}
	public Boolean getlActivo() {
		return lActivo;
	}
	public void setlActivo(Boolean lActivo) {
		this.lActivo = lActivo;
	}
	public String getcNombre() {
		return cNombre;
	}
	public void setcNombre(String cNombre) {
		this.cNombre = cNombre;
	}
	public byte[] getId() {
		return id;
	}
	public void setId(byte[] id) {
		this.id = id;
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

		vector.add(this.getiPrograma());
		vector.add(this.getiMenu());
		vector.add(this.getcPrograma());
		vector.add(this.getlActivo());
		vector.add(this.getcNombre());
		vector.add(this.getId());

		return vector;
	}

}
