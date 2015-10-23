package com.sinergitec.model.ct;

import java.sql.Timestamp;
import java.util.Vector;

public class ctEmisor {
	
	private Integer iEmisor;
	private String cCveCia;
	private String cRazonSocial;
	private String cRFC;
	private String cCURP;
	private String cCalle;
	private String cNumeroInterior;
	private String cNumeroExterior;
	private String cMpioDelg;
	private String cEmail;
	private String cPais;
	private String cEstado;
	private String cCP;
	private String dtFechaAlta;
	private String dtFechaCancel;
	private Boolean lActivo;
	private String cAlias;
	byte[] id;
	
	
	public Integer getiEmisor() {
		return iEmisor;
	}
	public void setiEmisor(Integer iEmisor) {
		this.iEmisor = iEmisor;
	}
	public String getcCveCia() {
		return cCveCia;
	}
	public void setcCveCia(String cCveCia) {
		this.cCveCia = cCveCia;
	}
	public String getcRazonSocial() {
		return cRazonSocial;
	}
	public void setcRazonSocial(String cRazonSocial) {
		this.cRazonSocial = cRazonSocial;
	}
	public String getcRFC() {
		return cRFC;
	}
	public void setcRFC(String cRFC) {
		this.cRFC = cRFC;
	}
	public String getcCURP() {
		return cCURP;
	}
	public void setcCURP(String cCURP) {
		this.cCURP = cCURP;
	}
	public String getcCalle() {
		return cCalle;
	}
	public void setcCalle(String cCalle) {
		this.cCalle = cCalle;
	}
	public String getcNumeroInterior() {
		return cNumeroInterior;
	}
	public void setcNumeroInterior(String cNumeroInterior) {
		this.cNumeroInterior = cNumeroInterior;
	}
	public String getcNumeroExterior() {
		return cNumeroExterior;
	}
	public void setcNumeroExterior(String cNumeroExterior) {
		this.cNumeroExterior = cNumeroExterior;
	}
	public String getcMpioDelg() {
		return cMpioDelg;
	}
	public void setcMpioDelg(String cMpioDelg) {
		this.cMpioDelg = cMpioDelg;
	}
	public String getcEmail() {
		return cEmail;
	}
	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}
	public String getcPais() {
		return cPais;
	}
	public void setcPais(String cPais) {
		this.cPais = cPais;
	}
	public String getcEstado() {
		return cEstado;
	}
	public void setcEstado(String cEstado) {
		this.cEstado = cEstado;
	}
	public String getcCP() {
		return cCP;
	}
	public void setcCP(String cCP) {
		this.cCP = cCP;
	}
	
	public String getDtFechaAlta() {
		return dtFechaAlta;
	}
	public void setDtFechaAlta(String dtFechaAlta) {
		this.dtFechaAlta = dtFechaAlta;
	}
	public String getDtFechaCancel() {
		return dtFechaCancel;
	}
	public void setDtFechaCancel(String dtFechaCancel) {
		this.dtFechaCancel = dtFechaCancel;
	}
	
	public Boolean getlActivo() {
		return lActivo;
	}
	public void setlActivo(Boolean lActivo) {
		this.lActivo = lActivo;
	}
	public String getcAlias() {
		return cAlias;
	}
	public void setcAlias(String cAlias) {
		this.cAlias = cAlias;
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

		
		/*Date date = new java.util.Date();
		this.setDtFechaAlta(new Timestamp(date.getTime()));
		
		Date dat = new java.util.Date();
		this.setDtFechaCancel(new Timestamp(dat.getTime()));*/
		
		System.out.println("Conversion"+this.getDtFechaAlta());
		System.out.println("Conversion"+this.getDtFechaCancel());
		
		Timestamp dtFechaAlta = Timestamp.valueOf(this.getDtFechaAlta() + " 00:00:00.000000" );
		Timestamp dtFechaCancel = Timestamp.valueOf(this.getDtFechaCancel() + " 00:00:00.000000");
		Timestamp prueba = Timestamp.valueOf("2015/01/23"+" 00:00:00.000000");
		System.out.println(dtFechaAlta);
		System.out.println(dtFechaCancel);
		System.out.println(prueba);

		vector.add(this.getiEmisor());
		vector.add(this.getcCveCia());
		vector.add(this.getcRazonSocial());
		vector.add(this.getcRFC());
		vector.add(this.getcCURP());
		vector.add(this.getcCalle());
		vector.add(this.getcNumeroInterior());
		vector.add(this.getcNumeroExterior());
		vector.add(this.getcMpioDelg());
		vector.add(this.getcEmail());
		vector.add(this.getcPais());
		vector.add(this.getcEstado());
		vector.add(this.getcCP());
		vector.add(dtFechaAlta);
		vector.add(dtFechaCancel);
		vector.add(this.getlActivo());
		vector.add(this.getcAlias());
		vector.add(this.getId());

		return vector;
	}

}
