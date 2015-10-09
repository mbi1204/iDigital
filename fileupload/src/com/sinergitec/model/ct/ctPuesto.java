package com.sinergitec.model.ct;

import java.util.Vector;

public class ctPuesto {
	
	private Integer iPuesto;
	private String cPuesto;
	private Boolean lActivo;
	byte[] id;
	
	
	public Integer getiPuesto() {
		return iPuesto;
	}
	public void setiPuesto(Integer iPuesto) {
		this.iPuesto = iPuesto;
	}
	public String getcPuesto() {
		return cPuesto;
	}
	public void setcPuesto(String cPuesto) {
		this.cPuesto = cPuesto;
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

		vector.add(this.getiPuesto());
		vector.add(this.getcPuesto());
		vector.add(this.getlActivo());
		vector.add(this.getId());

		return vector;
	}
}
