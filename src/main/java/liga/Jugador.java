package liga;

import java.io.Serializable;

public class Jugador implements Serializable{

	private static final long serialVersionUID = 1L;
	private String codigo;
	private String nombre;
	private String fecha;
	private String posicion;
	private String codEquipo;
	
	
	public Jugador(String codigo, String nombre, String fecha, String posicion, String codEquipo) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.fecha = fecha;
		this.posicion = posicion;
		this.codEquipo = codEquipo;
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
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	public String getCodEquipo() {
		return codEquipo;
	}
	public void setCodEquipo(String codEquipo) {
		this.codEquipo = codEquipo;
	}
	
	
}
