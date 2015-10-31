package com.sinergitec.model.ct;



import java.util.Vector;


public class ctUsuario {
	
	private String 	cUsuario;
	private String 	cNombre;
	private String 	cPassword;
	private Boolean lActivo;
	private String dtFechaAlta;
	private Integer iPuesto;
	private ctPuesto puesto;
	byte[] id;
	
	/*public ctPuesto getPuesto() {
		return puesto;
	}
	public void setPuesto(ctPuesto puesto) {
		this.puesto = puesto;
	}*/
	
	public String getcUsuario() {
		return cUsuario;
	}
	public void setcUsuario(String cUsuario) {
		this.cUsuario = cUsuario;
	}
	public String getcNombre() {
		return cNombre;
	}
	public void setcNombre(String cNombre) {
		this.cNombre = cNombre;
	}
	public String getcPassword() {
		return cPassword;
	}
	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}
	public Boolean getlActivo() {
		return lActivo;
	}
	public void setlActivo(Boolean lActivo) {
		this.lActivo = lActivo;
	}
	public String getDtFechaAlta() {
		return dtFechaAlta;
	}
	public void setDtFechaAlta(String dtFechaAlta) {
		this.dtFechaAlta = dtFechaAlta;
	}
	public Integer getiPuesto() {
		return iPuesto;
	}
	public void setiPuesto(Integer iPuesto) {
		this.iPuesto = iPuesto;
	}
	public byte[] getId() {
		return id;
	}
	public void setId(byte[] id) {
		this.id = id;
	}
	public ctPuesto getPuesto() {
		return puesto;
	}
	public void setPuesto(ctPuesto puesto) {
		this.puesto = puesto;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getVectorDatos() {
		
		Vector vector = new Vector();
		

		vector.add(this.getcUsuario());
		vector.add(this.getcNombre());
		vector.add(this.getcPassword());
		vector.add(this.getlActivo());
		vector.add(this.getDtFechaAlta());
		vector.add(this.getiPuesto());
		vector.add(this.getId());

		return vector;
	}
	
}
