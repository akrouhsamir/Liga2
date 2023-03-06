package liga;

import java.io.Serializable;

public class JugadorGol implements Serializable{
	

	private static final long serialVersionUID = 1L;

	public JugadorGol(String local, String visitante, int minuto, String descripcion) {
		super();
		this.local = local;
		this.visitante = visitante;
		this.minuto = minuto;
		this.descripcion = descripcion;
	}
	private String local;
	private String visitante;
	private int minuto;
	
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getVisitante() {
		return visitante;
	}
	public void setVisitante(String visitante) {
		this.visitante = visitante;
	}
	public int getMinuto() {
		return minuto;
	}
	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	private String descripcion;
}
