package com.sinergitec.model.sg;

import java.util.Vector;

public class sysUsuCompania {
	 String cCveCia;
     String cUsuario;
     Boolean lActivo;
     byte[] Id;
     
	public String getcCveCia() {
		return cCveCia;
	}
	public void setcCveCia(String cCveCia) {
		this.cCveCia = cCveCia;
	}
	public String getcUsuario() {
		return cUsuario;
	}
	public void setcUsuario(String cUsuario) {
		this.cUsuario = cUsuario;
	}
	public Boolean getlActivo() {
		return lActivo;
	}
	public void setlActivo(Boolean lActivo) {
		this.lActivo = lActivo;
	}
	public byte[] getId() {
		return Id;
	}
	public void setId(byte[] id) {
		Id = id;
	}
     
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getVectorDatos() {
		
		Vector vector = new Vector();
		
		vector.add(this.getcCveCia());
		vector.add(this.getcUsuario());
		vector.add(this.getlActivo());
		vector.add(this.getId());	

		return vector;
	}
     
	

}
