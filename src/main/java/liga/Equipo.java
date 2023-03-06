package liga;

import java.io.Serializable;

public class Equipo implements Serializable{

	private static final long serialVersionUID = 1L;
	private String codigo;
	private String nombre;
	private String estadio;
	private int aforo;
	private String fundacion;
	private String ciudad;
	private String presidente;
	
	
	public Equipo(String codigo, String nombre, String estadio, int aforo, String fundacion, String ciudad,
			String presidente) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.estadio = estadio;
		this.aforo = aforo;
		this.fundacion = fundacion;
		this.ciudad = ciudad;
		this.presidente = presidente;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEstadio() {
		return estadio;
	}
	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}
	public int getAforo() {
		return aforo;
	}
	public void setAforo(int aforo) {
		this.aforo = aforo;
	}
	public String getFundacion() {
		return fundacion;
	}
	public void setFundacion(String fundacion) {
		this.fundacion = fundacion;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getPresidente() {
		return presidente;
	}
	public void setPresidente(String presidente) {
		this.presidente = presidente;
	}
	
	
}
