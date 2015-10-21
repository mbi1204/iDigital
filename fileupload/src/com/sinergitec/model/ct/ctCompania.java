package com.sinergitec.model.ct;


import java.util.Arrays;
import java.util.Vector;

public class ctCompania {
	
	private String cCveCia;
	private String cRazonS;
	private String cRFC;
	private String cCalle;
	private String cNExterior;
	private String cNInterior;
	private String cColonia;
	private String cMpioDeleg;
	private Integer iCP;
	private String cCiudad;
	private String cEstado;
	private String cTelefono;
	private String cEmail;
	private String cContacto;
	private String cPais;
	private Boolean lActivo;
	byte[] id;
	
	
	public String getcCveCia() {
		return cCveCia;
	}
	public void setcCveCia(String cCveCia) {
		this.cCveCia = cCveCia;
	}
	public String getcRazonS() {
		return cRazonS;
	}
	public void setcRazonS(String cRazonS) {
		this.cRazonS = cRazonS;
	}
	public String getcRFC() {
		return cRFC;
	}
	public void setcRFC(String cRFC) {
		this.cRFC = cRFC;
	}
	public String getcCalle() {
		return cCalle;
	}
	public void setcCalle(String cCalle) {
		this.cCalle = cCalle;
	}
	public String getcNExterior() {
		return cNExterior;
	}
	public void setcNExterior(String cNExterior) {
		this.cNExterior = cNExterior;
	}
	public String getcNInterior() {
		return cNInterior;
	}
	public void setcNInterior(String cNInterior) {
		this.cNInterior = cNInterior;
	}
	public String getcColonia() {
		return cColonia;
	}
	public void setcColonia(String cColonia) {
		this.cColonia = cColonia;
	}
	public String getcMpioDeleg() {
		return cMpioDeleg;
	}
	public void setcMpioDeleg(String cMpioDeleg) {
		this.cMpioDeleg = cMpioDeleg;
	}
	public Integer getiCP() {
		return iCP;
	}
	public void setiCP(Integer iCP) {
		this.iCP = iCP;
	}
	public String getcCiudad() {
		return cCiudad;
	}
	public void setcCiudad(String cCiudad) {
		this.cCiudad = cCiudad;
	}
	public String getcEstado() {
		return cEstado;
	}
	public void setcEstado(String cEstado) {
		this.cEstado = cEstado;
	}
	public String getcTelefono() {
		return cTelefono;
	}
	public void setcTelefono(String cTelefono) {
		this.cTelefono = cTelefono;
	}
	public String getcEmail() {
		return cEmail;
	}
	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}
	public String getcContacto() {
		return cContacto;
	}
	public void setcContacto(String cContacto) {
		this.cContacto = cContacto;
	}
	public String getcPais() {
		return cPais;
	}
	public void setcPais(String cPais) {
		this.cPais = cPais;
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

		vector.add(this.getcCveCia());
		vector.add(this.getcRazonS());
		vector.add(this.getcRFC());
		vector.add(this.getcCalle());
		vector.add(this.getcNExterior());
		vector.add(this.getcNInterior());
		vector.add(this.getcColonia());
		vector.add(this.getcMpioDeleg());
		vector.add(this.getiCP());
		vector.add(this.getcCiudad());
		vector.add(this.getcEstado());
		vector.add(this.getcTelefono());
		vector.add(this.getcEmail());
		vector.add(this.getcContacto());
		vector.add(this.getcPais());
		vector.add(this.getlActivo());
		vector.add(this.getId());

		return vector;
	}
	@Override
	public String toString() {
		return "ctCompania [cCveCia=" + cCveCia + ", cRazonS=" + cRazonS + ", cRFC=" + cRFC + ", cCalle=" + cCalle
				+ ", cNExterior=" + cNExterior + ", cNInterior=" + cNInterior + ", cColonia=" + cColonia
				+ ", cMpioDeleg=" + cMpioDeleg + ", iCP=" + iCP + ", cCiudad=" + cCiudad + ", cEstado=" + cEstado
				+ ", cTelefono=" + cTelefono + ", cEmail=" + cEmail + ", cContacto=" + cContacto + ", cPais=" + cPais
				+ ", lActivo=" + lActivo + ", id=" + Arrays.toString(id) + "]";
	}	
	
	
	
}
